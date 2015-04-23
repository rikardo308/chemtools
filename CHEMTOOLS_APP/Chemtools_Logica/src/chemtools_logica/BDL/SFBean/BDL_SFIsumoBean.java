package chemtools_logica.BDL.SFBean;

import chemtools_logica.BDL.IL.BDL_SFIsumoLocal;
import chemtools_logica.BDL.IR.BDL_SFIsumoRemote;

import chemtools_logica.Beans.InsumoBean;

import chemtools_logica.Entidades.Almacen;
import chemtools_logica.Entidades.Eventoxinsumo;
import chemtools_logica.Entidades.Insumo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "BDL_SFIsumo", mappedName = "map-BDL_SFIsumo")
public class BDL_SFIsumoBean implements BDL_SFIsumoRemote, BDL_SFIsumoLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Chemtools_Logica")
    private EntityManager em;

    public BDL_SFIsumoBean() {
    }

    public Insumo persistInsumo(Insumo insumo) {
        em.persist(insumo);
        return insumo;
    }

    public Insumo mergeInsumo(Insumo insumo) {
        return em.merge(insumo);
    }

    public void removeInsumo(Insumo insumo) {
        insumo = em.find(Insumo.class, insumo.getIdInsumo());
        em.remove(insumo);
    }

    /** <code>select o from Insumo o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Insumo> getInsumoFindAll() {
        return em.createNamedQuery("Insumo.findAll", Insumo.class).getResultList();
    }
    
    public List<Insumo> busquedaInsumo(InsumoBean bean){
        List<Insumo> listaInsumos = new ArrayList<Insumo>();

        List<Eventoxinsumo> evento = new ArrayList<Eventoxinsumo>();
        
        String ejbQuery1 ="SELECT ins.* "+
                            "FROM eventoxinsumo t1 " +
                          
                            "INNER JOIN insumo AS ins ON t1.idInsumo = ins.idInsumo " +
                            "INNER JOIN almacen AS alm ON t1.idAlmacen = alm.idAlmacen "+
                            "INNER JOIN tipoinsumo AS tins ON ins.idTipoInsumo = tins.idTipoInsumo "+
                            "INNER JOIN empresa AS emp ON ins.idEmpresa = emp.idEmpresa "+
                            "INNER JOIN medida AS med ON tins.idMedida = med.idMedida "+
                            "INNER JOIN contenedores AS cont ON tins.idContenedores = cont.idContenedores "+
                          
                            "INNER JOIN "+
                            "( "+
                              "SELECT MAX(Fecha_Evento) maxdate, idInsumo,idUsuario "+
                              "FROM eventoxinsumo "+
                              "GROUP BY idInsumo "+
                            ") t2 "+
                              "ON t1.idInsumo = t2.idInsumo "+
                              "AND t1.Fecha_Evento = t2.maxdate ";
            
                            if(bean.getIdInsumo() != null){
                                ejbQuery1 += "AND ins.idInsumo like '%"+bean.getIdInsumo()+"%' ";
                            }
                            if(bean.getComentario() != null){
                                ejbQuery1 += "AND ins.Comentario like '%"+bean.getComentario()+"%' ";
                            }
                            if(bean.getIdunidadMeidad() != 0){
                                ejbQuery1 += "AND med.idMedida = "+bean.getIdunidadMeidad()+" ";
                            }
                            if(bean.getIdtipoInsumo() != 0){
                                ejbQuery1 += "AND tins.idTipoInsumo = "+bean.getIdtipoInsumo()+" ";
                            }
                            if(bean.getIdcontenedor() != 0){
                                ejbQuery1 += "AND cont.idContenedores = "+bean.getIdcontenedor()+" ";
                            }
                            if(bean.getIdAlmacen() != 0){
                                ejbQuery1 += "AND alm.idAlmacen = "+bean.getIdAlmacen()+" ";
                            }
                            if(bean.getIdEmpresa() != 0){
                                ejbQuery1 += "AND emp.idEmpresa = "+bean.getIdEmpresa()+" ";
                            }
                            if(bean.getCalidad() != 0){
                                ejbQuery1 += "AND ins.Calidad = "+bean.getCalidad()+" ";
                            }
        
        
                            if(bean.getFechaCreaciondMin() != null || bean.getFechaCreaciondMax() != null){
                                
                                if(bean.getFechaCreaciondMax() != null){
                                    ejbQuery1 += "AND ins.Fecha_Creacion >= '"+bean.getFechaCreaciondMax()+"' ";
                                }
                                
                                if(bean.getFechaCreaciondMin() != null){
                                    ejbQuery1 += "AND ins.Fecha_Creacion <= '"+bean.getFechaCreaciondMin()+"' ";
                                }
                                
                            }
        
        
                            if(bean.getFechaCaducidadMin() != null || bean.getFechaCaducidadMax() != null){
                                    
                                    if(bean.getFechaCaducidadMax() != null){
                                        ejbQuery1 += "AND ins.Fecha_Caducacion <= '"+bean.getFechaCaducidadMax()+"' ";
                                    }
                                    
                                    if(bean.getFechaCaducidadMin() != null){
                                        ejbQuery1 += "AND ins.Fecha_Caducacion >= '"+bean.getFechaCaducidadMin()+"' ";
                                    }
                                    
                            }
        
        
        try{
            Query query = em.createNativeQuery(ejbQuery1, Insumo.class);            
            listaInsumos = query.getResultList();
        }catch(Exception e)
        {
            listaInsumos = null;
        }
        return listaInsumos;
    }
    
    public String updateInsumo(Insumo insumo){
        String resultado = "";
        try{                
            String ejbQuery = "UPDATE insumo " + 
                              " SET idTipoInsumo = "+insumo.getTipoinsumo().getIdTipoInsumo() +
                              " ,Estado = "+insumo.getEstado()+
                              " ,Calidad = "+insumo.getCalidad()+
                              " WHERE idInsumo = "+insumo.getIdInsumo();
            
            System.out.println(ejbQuery);
            
            Query query = em.createNativeQuery(ejbQuery);
            
            em.createNativeQuery(ejbQuery).executeUpdate();
            
            resultado = "Sin Novedad";
        }catch(Exception e){
            resultado = "Hubo un Problema al Actualizar Insumo"+"\n"+e;
        }
        return resultado;
    }
    
    public boolean existeCodigoInsump(String codigo){
        boolean exi = false;
     
        String ejb = "SELECT u FROM Insumo u WHERE u.idInsumo = '"+codigo+"'";
        
        List<Insumo> insumo = new ArrayList<Insumo>();
        Query query = em.createQuery(ejb);
        insumo = query.getResultList();
        
        if(insumo.size() == 0){
            exi = true;
        }
        
        return exi;
    }
}

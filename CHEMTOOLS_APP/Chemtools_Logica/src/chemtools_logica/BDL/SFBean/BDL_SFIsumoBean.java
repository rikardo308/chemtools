package chemtools_logica.BDL.SFBean;

import chemtools_logica.BDL.IL.BDL_SFIsumoLocal;
import chemtools_logica.BDL.IR.BDL_SFIsumoRemote;

import chemtools_logica.Beans.InsumoBean;

import chemtools_logica.Entidades.Almacen;
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
        String ejbQuery = "SELECT u.insumo FROM Eventoxinsumo u " +
                          "WHERE 1 = 1 ";
        if(bean.getIdInsumo() != null){
            ejbQuery += "AND u.insumo.idInsumo like :codigo";
        }
        if(bean.getComentario() != null){
            ejbQuery += "AND u.insumo.comentario like :nombre ";
        }
        if(bean.getIdunidadMeidad() != 0){
            ejbQuery += "AND u.insumo.tipoinsumo.medida.idMedida = :uMedida ";
        }
        if(bean.getIdtipoInsumo() != 0){
            ejbQuery += "AND u.insumo.tipoinsumo.idTipoInsumo = :tInsumo ";
        }
        if(bean.getIdcontenedor() != 0){
            ejbQuery += "AND u.insumo.tipoinsumo.contenedores.idContenedores = :contenedor ";
        }
        if(bean.getIdAlmacen() != 0){
            ejbQuery += "AND u.almacen.idAlmacen = :nidAlmacen ";
        }
        if(bean.getIdEmpresa() != 0){
            ejbQuery += "AND u.insumo.empresa.idEmpresa = :nidEmpresa ";
        }
        if(bean.getCalidad() != 0){
            ejbQuery += "AND u.insumo.calidad = :calidad ";
        }
        
        
        if(bean.getFechaCreaciondMin() != null || bean.getFechaCreaciondMax() != null){
            
            if(bean.getFechaCreaciondMin() == null && bean.getFechaCreaciondMax() != null){
                ejbQuery += "AND u.insumo.fecha_Creacion <= :fCreacionMax ";
            }
            
            else if(bean.getFechaCreaciondMin() != null && bean.getFechaCreaciondMax() == null){
                ejbQuery += "AND u.insumo.fecha_Creacion >= :fCreacionMin ";
            }
            
            else{
                ejbQuery += "AND u.insumo.fecha_Creacion BETWEEN :fCreacionMin AND :fCreacionMax ";
            } 
            
        }
        
        
        if(bean.getFechaCaducidadMin() != null || bean.getFechaCaducidadMax() != null){
                
                if(bean.getFechaCaducidadMin() == null && bean.getFechaCaducidadMax() != null){
                    ejbQuery += "AND u.insumo.fecha_Caducacion <= :fCaducacionMax ";
                }
                
                else if(bean.getFechaCaducidadMin() != null && bean.getFechaCaducidadMax() == null){
                    ejbQuery += "AND u.insumo.fecha_Caducacion >= :fCaducacionMin ";
                }
                
                else{
                    ejbQuery += "AND u.insumo.fecha_Caducacion BETWEEN :fCaducacionMin AND :fCaducacionMax ";
                } 
                
        }
        
        
        try{
            Query query = em.createQuery(ejbQuery);
            
            if(bean.getIdInsumo() != null){
                query.setParameter("codigo", "%"+bean.getIdInsumo()+"%");
            }
            if(bean.getComentario() != null){
                query.setParameter("nombre", "%"+bean.getComentario()+"%");
            }
            if(bean.getIdunidadMeidad() != 0){
                query.setParameter("uMedida", bean.getIdunidadMeidad());
            }
            if(bean.getIdtipoInsumo() != 0){
                query.setParameter("tInsumo", bean.getIdtipoInsumo());
            }
            if(bean.getIdcontenedor() != 0){
                query.setParameter("contenedor", bean.getIdcontenedor());
            }
            if(bean.getIdAlmacen() != 0){
                query.setParameter("nidAlmacen", bean.getIdAlmacen());
            }
            if(bean.getIdEmpresa() != 0){
                query.setParameter("nidEmpresa", bean.getIdEmpresa());
            }
            if(bean.getCalidad() != 0){
                query.setParameter("calidad", bean.getCalidad());
            }
            
            
            if(bean.getFechaCreaciondMin() != null || bean.getFechaCreaciondMax() != null){
                
                if(bean.getFechaCreaciondMin() == null && bean.getFechaCreaciondMax() != null){
                    query.setParameter("fCreacionMax", bean.getFechaCreaciondMax());
                }
                
                else if(bean.getFechaCreaciondMin() != null && bean.getFechaCreaciondMax() == null){
                    query.setParameter("fCreacionMin", bean.getFechaCreaciondMin());
                }
                
                else{
                    query.setParameter("fCreacionMin", bean.getFechaCreaciondMin());
                    query.setParameter("fCreacionMax", bean.getFechaCreaciondMax());
                } 
                
            }
            
            
            if(bean.getFechaCaducidadMin() != null || bean.getFechaCaducidadMax() != null){
                    
                    if(bean.getFechaCaducidadMin() == null && bean.getFechaCaducidadMax() != null){
                        query.setParameter("fCaducacionMax", bean.getFechaCaducidadMax());
                    }
                    
                    else if(bean.getFechaCaducidadMin() != null && bean.getFechaCaducidadMax() == null){
                        query.setParameter("fCaducacionMin", bean.getFechaCaducidadMin());
                    }
                    
                    else{
                        query.setParameter("fCaducacionMin", bean.getFechaCaducidadMin());
                        query.setParameter("fCaducacionMax", bean.getFechaCaducidadMax());
                    } 
                    
            }
            
            
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
}

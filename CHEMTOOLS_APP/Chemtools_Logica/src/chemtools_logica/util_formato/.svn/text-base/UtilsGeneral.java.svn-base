package silat.servicios_negocio.util_formato;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.collections.BeanMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilsGeneral {

    //Comparaobjetos exactamente iguales (incluye el tipo)
    public static boolean comparaItems(Object oldObject, Object newObject){
        try{
            BeanMap map = new BeanMap(oldObject);
            PropertyUtilsBean propUtils = new PropertyUtilsBean();
            for (Object propNameObject : map.keySet()) {
                String propertyName = (String)propNameObject;
                Object property1 = propUtils.getProperty(oldObject, propertyName);
                Object property2 = propUtils.getProperty(newObject, propertyName);
                if(property1 != null && property2 != null){
                    if (property1.equals(property2)) {
                    } else {
                        return false;
                    }
                }
                if((property1 != null && property2 == null) || (property1 == null && property2 != null)){
                    return false;
                }
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static void depurar(Object o){
        System.out.println(o);
    }
    
    public static boolean comparaNidItems(Object oldObject, Object newObject,String propiedad){
        try{
            BeanMap map = new BeanMap(oldObject);
            PropertyUtilsBean propUtils = new PropertyUtilsBean();
            for (Object propNameObject : map.keySet()) {
                String propertyName = (String)propNameObject;
                if(propertyName.equals(propiedad)){
                    Object property1 = propUtils.getProperty(oldObject, propertyName);
                    Object property2 = propUtils.getProperty(newObject, propertyName);
                    if(property1 != null && property2 != null){
                        if (property1.equals(property2)) {
                            //System.out.println("  " + propertyName + " is equal");
                        } else {
                           // System.out.println("> " + propertyName + " is different (oldValue=\"" + property1 + "\", newValue=\"" + property2 + "\")");
                            return false;
                        }
                    }
                    if((property1 != null && property2 == null) || (property1 == null && property2 != null)){
                        return false;
                    }
                }
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public static String quitarUltimoCaracter(String _strFinal, String car){
        if(_strFinal.length() > 0){
            if(_strFinal.lastIndexOf(car) + 1 == _strFinal.length()){//el ultimo caracter es una coma
                _strFinal = _strFinal.substring(0,_strFinal.length() - 1);
            }   
        }
        return _strFinal;
    }
    
    public static byte[] extractBytes(String ImageName) throws IOException {
        File archivo = new File(ImageName);
        byte[] aBytes = null;
        long tamanoA = archivo.length(); 
        aBytes = new byte[(int) tamanoA];
        try{
            FileInputStream docu = new FileInputStream(archivo);
            int numBytes = docu.read(aBytes);
            docu.close();
            archivo.delete();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return aBytes;
    }
    
    public static byte[] imagen(String rutaImg){
        try{
            if(rutaImg != null){
                if(!rutaImg.equals("")){
                    byte[] byt = extractBytes(rutaImg);
                    if(byt != null){
                        return byt;
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
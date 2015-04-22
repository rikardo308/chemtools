package chemtools_logica.util_formato;

import org.apache.commons.collections.BeanMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilsGeneral {

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
package chemtools_logica.util_formato.Caracter;

import java.lang.reflect.Array;

/** Clase Util para tratar los Strings (Caracteres)
 * @author dfloresgonz
 * @since 09.05.2013
 */
public class FormatoLetra {
    
    /**
     * Metodo para quitar los tags de HTML en un string.
     * @author dfloresgonz
     * @param cadena String con tags HTML
     * @return String sin tags
     */
    public static String quitarTagsHTML(String cadena) {
        int nChars = cadena.length();
        int primerIndx = -1;
        int segIndx = -1;
        String c = "";
        for (int i = 0; i < cadena.length(); i++) {
            if (i <= nChars ) {
                if (cadena.charAt(i) == '<') {
                    primerIndx = i;
                } else if (cadena.charAt(i) == '>') {
                    segIndx = i;
                }
                if (primerIndx != -1 && segIndx != -1 && primerIndx < segIndx) {
                    c = "";    
                    c = c.concat(cadena.substring(primerIndx, segIndx + 1));
                        if (cadena.contains(c)) {
                            cadena = cadena.replace(c, "");
                            i=-1;
                            primerIndx = -1;
                            segIndx = -1;
                        }
                }
            }
        }
        return String.valueOf(cadena);
    }

    public static String llenaCeros(String strCad, int intNumero) {
        String strAcumulaCadena = "";
        for (int i = 0; i < intNumero; i++) {
            strAcumulaCadena = strAcumulaCadena + strCad;
        }
        return strAcumulaCadena;
    }
    
    public static  String[] convert(Object[] objects, Class type) {
        String[] convertedObjects = (String[]) Array.newInstance(type, objects.length);
        try {
            for(int i = 0; i < objects.length; i++) {
                convertedObjects[i] = (String)objects[i];
            }
        } catch (ClassCastException e) {
           // log.debug("Exception on convert() : ", e);
        }
     
        return convertedObjects;
    }
}
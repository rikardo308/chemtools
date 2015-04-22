package chemtools_logica.util_formato.Fecha;

import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;


public class FechaUtiles {
    public static final String DATE_FORMAT_NOW = "dd/MM/yyyy";

    public boolean isBetween(Timestamp fecEva, Timestamp limInf, Timestamp limSup) {
        if (fecEva.before(limInf) || fecEva.after(limSup)) { //esta fuera del intervalo
            return false;
        } else if ((fecEva.after(limInf) || fecEva.equals(limInf)) &&
                   (fecEva.before(limSup) || fecEva.equals(limSup))) {
            return true; //dentro del intervalo
        } else {
            return false;
        }
    }

    public static Date getPrimerDiaDelANIO() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.getActualMinimum(Calendar.MONTH),
                cal.getActualMinimum(Calendar.DAY_OF_MONTH),
                cal.getMinimum(Calendar.HOUR_OF_DAY),
                cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));
        return cal.getTime();
    }

    public static Date getUltimoDiaDelANIO() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.getActualMaximum(Calendar.MONTH),
                cal.getActualMaximum(Calendar.DAY_OF_MONTH),
                cal.getMaximum(Calendar.HOUR_OF_DAY),
                cal.getMaximum(Calendar.MINUTE),
                cal.getMaximum(Calendar.SECOND));
        return cal.getTime();
    }

    public void swapFechas(Timestamp fecMenor, Timestamp fecMayor) {
        Timestamp temp = null;
        temp = fecMenor;
        fecMenor = fecMayor;
        fecMayor = temp;
    }
    
     public static String getFechaStr(Date fech){
         try {
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
             String fec = sdf.format(fech.getTime()).toString();
             return fec;
         } catch (Exception pe) {
             pe.printStackTrace();
             return null;
         }
     }

    public static String fechaHoy() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime()).toString();
    }
    
    public static Date fechaActual() {
        String fechaHoy = fechaHoy(); //fecha actual
        int dia = Integer.parseInt(fechaHoy.substring(0, 2));
        int mes = Integer.parseInt(fechaHoy.substring(3, 5));
        int year = Integer.parseInt(fechaHoy.substring(6, 10));
        Date fechaSistema = new Date(year - 1900, mes - 1, dia);//fecha actual en formato DATE  FORMATO: Mon Nov 14 00:00:00 COT 2011
        return fechaSistema;
    }
    
    /**
     *
     * @param fec
     * @param dias
     * @return
     */
    public static Date fechaHoyMasXdias(Date fec, int dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(fec.getTime());
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.add(cal.DATE, dias);
        return cal.getTime();
    }
}

package adrian.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtil {

    private static SimpleDateFormat dt = new SimpleDateFormat("dd-mm-YYYY");

    public static Date convertirFecha(String fecha) throws ParseException {
        Date date = null;
        try {
            date = dt.parse(fecha);
        } catch (ParseException e) {
            System.out.println("Error, el formato de la fecha no es correcto.");
            throw e;
        }
        return date;
    }

}

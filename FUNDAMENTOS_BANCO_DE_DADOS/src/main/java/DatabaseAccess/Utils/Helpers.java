package DatabaseAccess.Utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;

public class Helpers {


    public static Object convertStringToObject(String str, Class<?> c) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, IllegalArgumentException {
        if (str.equals("")) return null;
        else if (c == Date.class) {
            try {
                return Date.valueOf(str);
            } catch (IllegalArgumentException e) {
                throw e;
            }
        } else
            return c.getConstructor(new Class[]{String.class}).newInstance(str);
    }
}

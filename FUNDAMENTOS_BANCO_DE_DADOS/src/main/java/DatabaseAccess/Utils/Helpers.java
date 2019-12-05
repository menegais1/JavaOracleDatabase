package DatabaseAccess.Utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;

public class Helpers {


    public static Object convertStringToObject(String str, Class<?> c) {
        try {
            if (str.equals("")) return null;
            else if (c == Date.class) {
                return Date.valueOf(str);
            } else
                return c.getConstructor(new Class[]{String.class}).newInstance(str);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("NÃO É POSSIVEL CONVERTER A STRING PARA O TIPO " + c.getTypeName());
        }
        return null;
    }
}

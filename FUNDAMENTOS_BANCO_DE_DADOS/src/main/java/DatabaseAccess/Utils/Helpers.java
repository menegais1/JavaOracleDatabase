package DatabaseAccess.Utils;

import java.lang.reflect.InvocationTargetException;

public class Helpers {


    public static Object convertStringToObject(String str, Class<?> c) {
        try {
            return c.getConstructor(new Class[]{String.class}).newInstance(str);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("NÃO É POSSIVEL CONVERTER A STRING PARA O TIPO " + c.getTypeName());
        }
        return null;
    }
}

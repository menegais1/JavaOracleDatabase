package DatabaseAccess.Utils;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.List;

public class TypeMapping {


    private static List<Tuple<JDBCType, Type>> typeMapping = new ArrayList();
    private static TypeMapping instance;

    private TypeMapping() {
        typeMapping.add(new Tuple<>(JDBCType.INTEGER, Long.class));
        typeMapping.add(new Tuple<>(JDBCType.VARCHAR, String.class));
        typeMapping.add(new Tuple<>(JDBCType.DATE, Date.class));
        typeMapping.add(new Tuple<>(JDBCType.DECIMAL, BigDecimal.class));
    }

    public static JDBCType getJDBCType(Type t) {
        if (instance == null) instance = new TypeMapping();
        for (Tuple<JDBCType, Type> typeMap : typeMapping) {
            if (typeMap.y.equals(t)) return typeMap.x;
        }
        return null;
    }

    public static JDBCType getType(JDBCType t) {
        if (instance == null) instance = new TypeMapping();
        for (Tuple<JDBCType, Type> typeMap : typeMapping) {
            if (typeMap.x == t) return typeMap.x;
        }
        return null;
    }

}

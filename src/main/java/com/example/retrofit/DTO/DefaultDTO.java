package com.example.retrofit.DTO;
import java.lang.reflect.Field;
public abstract class DefaultDTO {
    public boolean hasNullFields() {
        return hasNullFields(this);
    }

    private boolean hasNullFields(Object obj) {
        if (obj == null) {
            return true;
        }

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (value == null) {
                    return true;
                } else if (!field.getType().isPrimitive() && !field.getType().getName().startsWith("java.lang")) {
                    if (hasNullFields(value)) {
                        return true;
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}

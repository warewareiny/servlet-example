package org.example.car.rental.project.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {

    public static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream stream = PropertiesUtil.class.getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (stream == null) {
                throw new RuntimeException("Файл application.properties не найден");
            }

            PROPERTIES.load(stream);

        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException("Ошибка загрузки properties файла", exception);
        }
    }

    private PropertiesUtil() {
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
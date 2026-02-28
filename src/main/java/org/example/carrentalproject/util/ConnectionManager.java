package org.course.http.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.example.carrentalproject.util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;

@UtilityClass
public final class ConnectionManager {

    public static final String URL_KEY = "db.url";
    public static final String USERNAME_KEY = "db.username";
    public static final String PASSWORD_KEY = "db.password";

    static {
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public static Connection get()  {
        return DriverManager.getConnection(PropertiesUtil.get(URL_KEY),
                PropertiesUtil.get(USERNAME_KEY),
                PropertiesUtil.get(PASSWORD_KEY));
    }
}
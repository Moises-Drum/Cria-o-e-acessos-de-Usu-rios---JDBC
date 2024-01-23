package server;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Link {
    private static Connection conn = null;

    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("userdb.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e){
            System.out.println("Falha na leitura do arquivo. Erro: " + e.getMessage());
        }
        return null;
    }

    public static Connection getConnection(){
        if (conn == null){
            try {
                Properties props = loadProperties();
                String url = props.getProperty("url");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e){
                System.out.println("Falha ao conectar ao BD. Erro: " + e.getMessage());
            }
        }
        return conn;
    }

}

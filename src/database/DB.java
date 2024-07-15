package database;

import javax.swing.*;
import java.sql.*;

public class DB {

    public static Connection conn = null;

    // Função para conectar com o banco de dados
    public static Connection getConnection(){

        if (conn == null){
            try {
                String url = "jdbc:mysql://localhost:3306/ordersjdbc?user=root&password=123456";
                conn = DriverManager.getConnection(url);

            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "ConexaoDAO: " + e.getMessage());
            }
        }
        return conn;
    }

    // Método para fechar a conexão
    public static Connection closeConnection(){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ConexaoDAO: " + e.getMessage());
            }
        }
        return conn;
    }

    // Método para fechar statement
    public static  void closeStatement(Statement st){
        if (st != null){

            try {
                st.close();

            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "ConexaoDAO: " + e.getMessage());
            }

        }
    }

    // Método para fechar result set
    public static void closeResultSet(ResultSet rs){
        if (rs != null){

            try {
                rs.close();

            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "ConexaoDAO: " + e.getMessage());
            }

        }
    }

}

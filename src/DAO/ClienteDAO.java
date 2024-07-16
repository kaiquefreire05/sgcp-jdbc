package DAO;

import database.DB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public boolean autenticarCliente(String email, int senha){
        Connection conn = null;

        try {
            conn = DB.getConnection();

            String query = "SELECT * FROM clientes WHERE email_cliente = ? AND senha_cliente = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setInt(2, senha);

            ResultSet rs = ps.executeQuery();
            return rs.next();  // True or False

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ClienteDAO: " + e.getMessage());
            return false;

        }
    }
}

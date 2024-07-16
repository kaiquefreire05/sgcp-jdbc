package DAO;

import database.DB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO {

    public boolean autenticarUsuario(String username, int password) {

        Connection conn = null;

        try {

            conn = DB.getConnection();  // Obtendo conexão com o BD

            // Query para verificar se o usuário e a senha existem
            String sql = "SELECT * FROM administradores WHERE usuario = ? AND senha_usuario = ?";

            // Preparar a consulta
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setInt(2, password);

            // Executar a consulta
            ResultSet rs = pst.executeQuery();

            return rs.next(); // True or False

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "AdministradorDAO: " + e.getMessage());
            return false;

        }

    }
}
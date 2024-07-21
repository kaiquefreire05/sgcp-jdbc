package DAO;

import database.DB;
import entities.ProdutoDTO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseDTO {

    public ArrayList<ProdutoDTO> visualizarTodosProdutos(){
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<ProdutoDTO> produtos = new ArrayList<>();

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("SELECT * FROM produtos ORDER BY nome_produto");
            rs = st.executeQuery();

            while (rs.next()) {
                ProdutoDTO produto = new ProdutoDTO();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setDescProduto(rs.getString("desc_produto"));
                produto.setPrecoProduto(rs.getBigDecimal("preco_produto"));
                produto.setEstoqueProduto(rs.getInt("estoque_produto"));
                produtos.add(produto);
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "BaseDTO: " + e.getMessage());

        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return produtos;
    }


}

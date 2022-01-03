/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.pdv.dao;

import br.com.projeto.pdv.jdbc.ConnectionFactory;
import br.com.projeto.pdv.model.ItemVendaModel;
import br.com.projeto.pdv.model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lex
 */
public class ItemVendaDAO {

    private final Connection con;

    public ItemVendaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastraItem(ItemVendaModel obj) {
        try {
            String sql = "insert into tb_itensvendas (venda_id, produto_id, qtd, subtotal) values(?,?,?,?)";

            //Conetar o bd e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubTotal());

            //Executar o comando SQL
            stmt.execute();
            //Encerrar a conexão
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro..." + e);
        }
    }

    public List<ItemVendaModel> listarItensPorVenda(int venda_id) {
        try {
            //Criar a Lista
            List<ItemVendaModel> lista = new ArrayList<>();
            //criar o sql
            String sql = "select i.id,p.descricao,i.qtd,p.preco,i.subtotal "
                    + "from tb_itensvendas as i inner join tb_produtos as p on(i.produto_id = p.id)"
                    + "where i.venda_id =?";
            //criar o comando, organizar e executar
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, venda_id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ItemVendaModel obj = new ItemVendaModel();
                ProdutoModel p = new ProdutoModel();

                obj.setId(rs.getInt("i.id"));
                p.setDescricao(rs.getString("p.descricao"));
                obj.setQtd(rs.getInt("i.qtd"));
                p.setPreco(rs.getDouble("p.preco"));
                obj.setSubTotal(rs.getInt("i.subtotal"));

                obj.setProduto(p);
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o SQL!!" + e);
            return null;
        }
    }
}

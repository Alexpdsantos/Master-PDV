/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.pdv.dao;

import br.com.projeto.pdv.jdbc.ConnectionFactory;
import br.com.projeto.pdv.model.FornecedorModel;
import br.com.projeto.pdv.model.ProdutoModel;
import br.com.projeto.pdv.view.ClienteView;
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
public class ProdutoDAO {

    ClienteView cv = new ClienteView();

    private final Connection con;

    public ProdutoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo Cadastrar Produto
    public void cadastrarProduto(ProdutoModel obj) {
        //criar o comando SQL
        try {
            String sql = "insert into tb_produtos (descricao,preco, qtd_estoque, for_id) values(?,?,?,?);";

            //Conetar o bd e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());

            //Executar o comando SQL
            stmt.execute();
            //Encerrar a conexão
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro. Já existe um Produto cadastrado com este nome!" + e);
        }
    }

    //Metodo Listar Cliente
    public List<ProdutoModel> listarProduto() {
        try {
            //Criar a Lista
            List<ProdutoModel> lista = new ArrayList<>();
            //criar o sql
            String sql = "select p.id,p.descricao,p.preco,p.qtd_estoque,f.nome "
                    + "from tb_produtos as p inner join tb_fornecedores as f on(p.for_id = f.id)";
            //criar o comando, organizar e executar
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoModel obj = new ProdutoModel();
                FornecedorModel f = new FornecedorModel();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getFloat("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));
                obj.setFornecedor(f);

                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o SQL!!" + e);
            return null;
        }
    }

    public List<ProdutoModel> listarPorDesc(String nome) {
        try {
            //Criar a Lista
            List<ProdutoModel> lista = new ArrayList<>();
            //criar o sql
            String sql = "select p.id,p.descricao,p.preco,p.qtd_estoque,f.nome "
                    + "from tb_produtos as p inner join tb_fornecedores as f on(p.for_id = f.id) where p.descricao like ?";
            //criar o comando, organizar e executar
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProdutoModel obj = new ProdutoModel();
                FornecedorModel f = new FornecedorModel();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));
                obj.setFornecedor(f);

                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o SQL!!" + e);
            return null;
        }
    }

    public ProdutoModel listarPorCod(int id) {
        try {
            //criar o sql
            String sql = "select * from tb_produtos where id = ?";
            //criar o comando, organizar e executar
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ProdutoModel obj = new ProdutoModel();
            while (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getFloat("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));
            }
            return obj;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o SQL!!" + e);
            return null;
        }
    }

    //Metodo Alterar Produto
    public void alterarProduto(ProdutoModel obj) {
        try {
            //criar o comando SQL
            String sql = "update tb_produtos set descricao=?, preco=?,qtd_estoque=?,for_id=? where id=?";

            //Conetar o bd e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());

            stmt.setInt(5, obj.getId());

            //Executar o comando SQL
            stmt.execute();
            //Encerrar a conexão
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a alteração!" + e);
        }
    }

    //Método Excluir cliente
    public void excluirProduto(ProdutoModel obj) {
        try {
            String sql = "delete from tb_produtos where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto Excluido com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a exclusão!!!" + ex);
        }
    }

    public void baixaEstoque(int id, int qtd_nova) {

        try {
            String sql = "update tb_produtos set qtd_estoque=? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o sql!!!" + e);
        }
    }

    public int retornaEstoqueAtual(int id) {

        try {

            int qtd_estoque = 0;
            String sql = "select qtd_estoque from tb_produtos where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                qtd_estoque = (rs.getInt("qtd_estoque"));
            }
            return qtd_estoque;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

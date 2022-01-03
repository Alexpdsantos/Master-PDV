/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.pdv.dao;

import br.com.projeto.pdv.jdbc.ConnectionFactory;
import br.com.projeto.pdv.model.FornecedorModel;
import br.com.projeto.pdv.view.FornecedorView;
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
public class FornecedorDAO{


    FornecedorView fv = new FornecedorView();
    FornecedorModel obj = new FornecedorModel();
    
    private final Connection con;

    public FornecedorDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo Cadastrar Fornecedor
    public void cadastrarFornecedor(FornecedorModel obj) {
        //criar o comando SQL
        try {
            String sql = "insert into tb_fornecedores (nome,cnpj,email,telefone,celular,cep,endereco,numero,"
                    + "complemento,bairro,cidade,estado) values(?,?,?,?,?,?,?,?,?,?,?,?);";

            //Conetar o bd e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setString(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());
            //Executar o comando SQL
            stmt.execute();
            //Encerrar a conexão
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado com Sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro. Já existe um Fornecedor cadastrado com este CNPJ!");
        }
    }

    //Metodo Listar Fornecedor
    public List<FornecedorModel> listarFornecedor() {
        try {
            //Criar a Lista
            List<FornecedorModel> lista = new ArrayList<>();
            //criar o sql
            String sql = "select * from tb_fornecedores";
            //criar o comando, organizar e executar
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FornecedorModel obj = new FornecedorModel();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setBairro(rs.getString("Bairro"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o SQL!!" + e);
            return null;
        }
    }

    public List<FornecedorModel> listarPorNome(String nome) {
        try {
            //Criar a Lista
            List<FornecedorModel> lista = new ArrayList<>();
            //criar o sql
            String sql = "select * from tb_fornecedores where nome = ?";
            //criar o comando, organizar e executar
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setBairro(rs.getString("Bairro"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));

                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o SQL!!" + e);
            return null;
        }
    }

    //Metodo Alterar Fornecedor
    public void alterarFornecedor(FornecedorModel obj) {
        try {
            //criar o comando SQL
            String sql = "update tb_fornecedores set nome=?, cnpj=?, email=?, telefone=?, celular=?, cep=?,"
                    + " endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";

            //Conetar o bd e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setString(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());
            stmt.setInt(13, obj.getId());

            //Executar o comando SQL
            stmt.execute();
            //Encerrar a conexão
            stmt.close();
            JOptionPane.showMessageDialog(null, "Fornecedor Alterado com Sucesso.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a alteração!" + e);
        }
    }

    //Método Excluir fornecedor
    public void excluirFornecedor(FornecedorModel obj) {
        try {
            String sql = "delete from tb_fornecedores where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor Excluido com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a exclusão!!!" + ex);
        }
    }

}
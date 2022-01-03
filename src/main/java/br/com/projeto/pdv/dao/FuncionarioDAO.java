/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.pdv.dao;

import br.com.projeto.pdv.jdbc.ConnectionFactory;
import br.com.projeto.pdv.model.FuncionarioModel;
import br.com.projeto.pdv.util.WebServiceCep;
import br.com.projeto.pdv.view.LoginView;
import br.com.projeto.pdv.view.MenuView;
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
public class FuncionarioDAO {
    

    private final Connection con;

    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo Cadastrar Funcionario
    public void cadastrarFuncionario(FuncionarioModel obj) {
        //criar o comando SQL
        try {
            String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,"
                    + "complemento,bairro,cidade,estado) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            //Conetar o bd e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setString(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            //Executar o comando SQL
            stmt.execute();
            //Encerrar a conexão
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário Cadastrado com Sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro. Já existe um funcionário cadastrado com este CPF!");
        }
    }

    //Metodo Listar Funcionário
    public List<FuncionarioModel> listarFuncionario() {
        try {
            //Criar a Lista
            List<FuncionarioModel> lista = new ArrayList<>();

            //criar o sql
            String sql = "select * from tb_funcionarios";

            //criar o comando, organizar e executar
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FuncionarioModel obj = new FuncionarioModel();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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

    public List<FuncionarioModel> listarPorNome(String nome) {
        try {
            //Criar a Lista
            List<FuncionarioModel> lista = new ArrayList<>();
            //criar o sql
            String sql = "select * from tb_funcionarios where nome like ?";
            //criar o comando, organizar e executar
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FuncionarioModel obj = new FuncionarioModel();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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

    //Metodo Alterar Funcionario
    public void alterarFuncionario(FuncionarioModel obj) {
        try {
            //criar o comando SQL
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, celular=?, cep=?,"
                    + " endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";

            //Conetar o bd e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setString(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            stmt.setInt(17, obj.getId());

            //Executar o comando SQL
            stmt.execute();
            //Encerrar a conexão
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionário Alterado com Sucesso.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a alteração!" + e);
        }
    }

    //Método Excluir Funcionario
    public void excluirFuncionario(FuncionarioModel obj) {
        try {
            String sql = "delete from tb_funcionarios where id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionario Excluido com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a exclusão!!!" + ex);
        }
    }

    public FuncionarioModel buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        FuncionarioModel obj = new FuncionarioModel();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setEstado(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }
    }
    
    //Efetuar Login
    public void efetuaLogin(String email, String senha){
        MenuView menuView = new MenuView();
        LoginView loginView = new LoginView();
        try {
            String sql="select * from tb_funcionarios where email=? and senha=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,email);
            stmt.setString(2,senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                
                //tipo de usuário
                if(rs.getString("nivel_acesso").equals("Administrador")){
                    JOptionPane.showMessageDialog(null, "Seja Bem-vindo ao Sistema"); 
                    menuView.setVisible(true);
                    menuView.usuarioLogado = rs.getString("nome");
                    
                    //se usuário não for administrador, desabilita botão de funcionarios
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Seja Bem-vindo ao Sistema");
                    menuView.btnControleFuncionarios.setEnabled(false);
                    menuView.setVisible(true);
                    menuView.usuarioLogado = rs.getString("nome");
                }
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Dados Incorretos! ");
                loginView.setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha na Conexão "+e);
        }    
    }
}
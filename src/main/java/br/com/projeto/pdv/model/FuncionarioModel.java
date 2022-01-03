/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.pdv.model;

/**
 *
 * @author Lex
 */
public class FuncionarioModel extends ClienteModel{
    
    private String senha;
    private String cargo;
    private String nivel_acesso;

//    public FuncionarioModel(int id, String nome, String rg, String cpf, String email, String senha, 
//            String cargo, String nivel_acesso, String telefone, String celular, String cep, String endereco, 
//            String numero, String complemento, String bairro, String cidade, String estado) {
//        super(id, nome, rg, cpf, email,senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado);
//        this.senha = senha;
//        this.cargo = cargo;
//        this.nivel_acesso = nivel_acesso;
//    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }
    
    
          
    
}

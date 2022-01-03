/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.pdv.dao;

import br.com.projeto.pdv.jdbc.ConnectionFactory;
import br.com.projeto.pdv.model.ClienteModel;
import br.com.projeto.pdv.model.VendaModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lex
 */
public class VendaDAO {

    private final Connection con;

    public VendaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarVenda(VendaModel obj) {

        try {
            String sql = "insert into tb_vendas (cliente_id, data_venda, total_venda) values(?,?,?)";

            //Conetar o bd e organizar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getDataVenda());
            stmt.setDouble(3, obj.getTotalVenda());

            //Executar o comando SQL
            stmt.execute();
            //Encerrar a conexão
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro..." + e);
        }
    }

    public int retornaUltimaVenda() {
        try {
            int idVenda = 0;

            String sql = "select max(id) id from tb_vendas";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                VendaModel venda = new VendaModel();
                venda.setId(rs.getInt("id"));
                idVenda = venda.getId();
            }
            return idVenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<VendaModel> listarVendas() {
        try {
            //Criar a Lista
            List<VendaModel> lista = new ArrayList<>();
            //criar o sql
            String sql = "select v.id,date_format(v.data_venda,'%d/%m/%Y %H:%i') as data_formatada,c.nome,v.total_venda,v.total_venda "
                    + "from tb_vendas as v inner join tb_clientes as c on(v.cliente_id = c.id)";
            //criar o comando, organizar e executar
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VendaModel obj = new VendaModel();
                ClienteModel c = new ClienteModel();

                obj.setId(rs.getInt("v.id"));
                obj.setDataVenda(rs.getString("data_formatada"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotalVenda(rs.getDouble("v.total_venda"));

                obj.setCliente(c);
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o SQL!!" + e);
            return null;
        }
    }

    public List<VendaModel> listarVendasPorData(LocalDateTime dataInicio, LocalDateTime dataFim) {
        try {
            //Criar a Lista
            List<VendaModel> lista = new ArrayList<>();
            //criar o sql
            String sql = "select v.id,date_format(v.data_venda,'%d/%m/%Y %T') as data_formatada,c.nome,v.total_venda,v.total_venda "
                    + "from tb_vendas as v inner join tb_clientes as c on(v.cliente_id = c.id)"
                    + "where v.data_venda BETWEEN ? AND ?";
            //criar o comando, organizar e executar
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, dataInicio.toString());
            stmt.setString(2, dataFim.toString());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VendaModel obj = new VendaModel();
                ClienteModel c = new ClienteModel();

                obj.setId(rs.getInt("v.id"));
                obj.setDataVenda(rs.getString("data_formatada"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotalVenda(rs.getDouble("v.total_venda"));

                obj.setCliente(c);
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar o SQL!!" + e);
            return null;
        }
    }

}

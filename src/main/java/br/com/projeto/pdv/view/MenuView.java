/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.projeto.pdv.view;

import java.awt.Graphics;
import java.awt.Image;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Lex
 */
public class MenuView extends javax.swing.JFrame {

    LoginView loginView = new LoginView();  
    ClienteView clienteView = new ClienteView();
    FuncionarioView funcionarioView = new FuncionarioView();
    FornecedorView fView = new FornecedorView();
    ProdutoView pView = new ProdutoView();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    public String usuarioLogado;

    /**
     * Creates new form MenuView
     */
    public MenuView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/E-commerce.jpg"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
        ;
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDataHora = new javax.swing.JLabel();
        jMenuBarMenu = new javax.swing.JMenuBar();
        btnFuncionarios = new javax.swing.JMenu();
        btnControleFuncionarios = new javax.swing.JMenuItem();
        btnClientes = new javax.swing.JMenu();
        btnControleClientes = new javax.swing.JMenuItem();
        btnFornecedores = new javax.swing.JMenu();
        btnControleFornecedores = new javax.swing.JMenuItem();
        btnProdutos = new javax.swing.JMenu();
        btnControleProdutos = new javax.swing.JMenuItem();
        btnVendas = new javax.swing.JMenu();
        btnPDV = new javax.swing.JMenuItem();
        btnPosicaoDia = new javax.swing.JMenuItem();
        btnHistoricoVendas = new javax.swing.JMenuItem();
        btnConfiguracoes = new javax.swing.JMenu();
        btnTrocarUsuario = new javax.swing.JMenuItem();
        btnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TELA PRINCIPAL");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Usuário Logado:");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(51, 51, 255));
        lblUsuario.setText("Pessoa");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Desenvolvido por:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Alex Santos©");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuario)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        lblDataHora.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        lblDataHora.setForeground(new java.awt.Color(0, 153, 0));

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblDataHora, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBarMenu.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBarMenu.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu Inicial"));
        jMenuBarMenu.setForeground(new java.awt.Color(255, 255, 255));

        btnFuncionarios.setBackground(new java.awt.Color(255, 255, 255));
        btnFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/funcionarios.png"))); // NOI18N
        btnFuncionarios.setText("FUNCIONARIOS ");

        btnControleFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/funcionario.png"))); // NOI18N
        btnControleFuncionarios.setText("Controle de Funcionários");
        btnControleFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControleFuncionariosActionPerformed(evt);
            }
        });
        btnFuncionarios.add(btnControleFuncionarios);

        jMenuBarMenu.add(btnFuncionarios);

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clientes.png"))); // NOI18N
        btnClientes.setText("CLIENTES ");

        btnControleClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente.png"))); // NOI18N
        btnControleClientes.setText("Controle de Clientes");
        btnControleClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControleClientesActionPerformed(evt);
            }
        });
        btnClientes.add(btnControleClientes);

        jMenuBarMenu.add(btnClientes);

        btnFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fornecedores.png"))); // NOI18N
        btnFornecedores.setText("FORNECEDORES ");

        btnControleFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fornecedor.png"))); // NOI18N
        btnControleFornecedores.setText("Controle de Fornecedores");
        btnControleFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControleFornecedoresActionPerformed(evt);
            }
        });
        btnFornecedores.add(btnControleFornecedores);

        jMenuBarMenu.add(btnFornecedores);

        btnProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/produtos.png"))); // NOI18N
        btnProdutos.setText("PRODUTOS ");

        btnControleProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/produto.png"))); // NOI18N
        btnControleProdutos.setText("Controle de Produtos");
        btnControleProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControleProdutosActionPerformed(evt);
            }
        });
        btnProdutos.add(btnControleProdutos);

        jMenuBarMenu.add(btnProdutos);

        btnVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendas.png"))); // NOI18N
        btnVendas.setText("VENDAS ");

        btnPDV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pdv.png"))); // NOI18N
        btnPDV.setText("PDV");
        btnPDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDVActionPerformed(evt);
            }
        });
        btnVendas.add(btnPDV);

        btnPosicaoDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/posicaoDia.png"))); // NOI18N
        btnPosicaoDia.setText("Posição do Dia");
        btnPosicaoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosicaoDiaActionPerformed(evt);
            }
        });
        btnVendas.add(btnPosicaoDia);

        btnHistoricoVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/historicoVendas.png"))); // NOI18N
        btnHistoricoVendas.setText("Histórico de Vendas");
        btnHistoricoVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoricoVendasActionPerformed(evt);
            }
        });
        btnVendas.add(btnHistoricoVendas);

        jMenuBarMenu.add(btnVendas);

        btnConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/configuracoes.png"))); // NOI18N
        btnConfiguracoes.setText("CONFIGURAÇÕES ");

        btnTrocarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trocarFunc.png"))); // NOI18N
        btnTrocarUsuario.setText("Trocar Usuário");
        btnTrocarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrocarUsuarioActionPerformed(evt);
            }
        });
        btnConfiguracoes.add(btnTrocarUsuario);

        jMenuBarMenu.add(btnConfiguracoes);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sair.png"))); // NOI18N
        btnSair.setText("SAIR ");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        jMenuBarMenu.add(btnSair);

        setJMenuBar(jMenuBarMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDVActionPerformed
        // TODO add your handling code here:
        VendaView venda = new VendaView();
        venda.setVisible(true);
        
    }//GEN-LAST:event_btnPDVActionPerformed

    private void btnPosicaoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosicaoDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPosicaoDiaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        this.setExtendedState(this.MAXIMIZED_BOTH);
        lblUsuario.setText(usuarioLogado);
        loginView.dispose();
        lblDataHora.setText(dtf.format(LocalDateTime.now()));
    }//GEN-LAST:event_formWindowActivated

    private void btnTrocarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrocarUsuarioActionPerformed
        // TODO add your handling code here:
        loginView.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnTrocarUsuarioActionPerformed

    private void btnControleClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControleClientesActionPerformed
        // TODO add your handling code here:
        clienteView.setVisible(true);
    }//GEN-LAST:event_btnControleClientesActionPerformed

    private void btnControleFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControleFuncionariosActionPerformed
        // TODO add your handling code here:
        funcionarioView.setVisible(true);
    }//GEN-LAST:event_btnControleFuncionariosActionPerformed

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        // TODO add your handling code here:

        int op = JOptionPane.showConfirmDialog(null, "Você deseja realmente Sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (op != 2 && op != -1) {
            if (op == 0) {
                JOptionPane.showMessageDialog(null, "Até Logo...");
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btnSairMouseClicked

    private void btnControleFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControleFornecedoresActionPerformed
        // TODO add your handling code here:
        fView.setVisible(true);
    }//GEN-LAST:event_btnControleFornecedoresActionPerformed

    private void btnControleProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControleProdutosActionPerformed
        // TODO add your handling code here:
        pView.setVisible(true);
        
    }//GEN-LAST:event_btnControleProdutosActionPerformed

    private void btnHistoricoVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoricoVendasActionPerformed
        // TODO add your handling code here:
        HistoricoView historico = new HistoricoView();
        historico.setVisible(true);
    }//GEN-LAST:event_btnHistoricoVendasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnClientes;
    private javax.swing.JMenu btnConfiguracoes;
    public javax.swing.JMenuItem btnControleClientes;
    private javax.swing.JMenuItem btnControleFornecedores;
    public javax.swing.JMenuItem btnControleFuncionarios;
    private javax.swing.JMenuItem btnControleProdutos;
    private javax.swing.JMenu btnFornecedores;
    private javax.swing.JMenu btnFuncionarios;
    private javax.swing.JMenuItem btnHistoricoVendas;
    private javax.swing.JMenuItem btnPDV;
    private javax.swing.JMenuItem btnPosicaoDia;
    private javax.swing.JMenu btnProdutos;
    private javax.swing.JMenu btnSair;
    private javax.swing.JMenuItem btnTrocarUsuario;
    private javax.swing.JMenu btnVendas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBarMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDataHora;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
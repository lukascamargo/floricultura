/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojafloricultura.view;

import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lojafloricultura.controller.ClienteController;
import lojafloricultura.controller.ProdutoController;
import lojafloricultura.controller.VendaController;
import lojafloricultura.controller.ItemVendaController;
import lojafloricultura.model.Cliente;
import lojafloricultura.model.Produto;
import lojafloricultura.model.ItemVenda;
import lojafloricultura.model.Venda;

/**
 *
 * @author italo.brfreitas
 */
public class VendaView extends javax.swing.JFrame {
    ProdutoController produtoController = new ProdutoController();
    ClienteController clienteController = new ClienteController();
    VendaController vendaController = new VendaController();
    ItemVendaController itemVenda = new ItemVendaController();
    int vendaId = -1;
    Venda venda = new Venda();

    /**
     * Creates new form VendaView
     */
    public VendaView() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        
        DesabilitaFormularioCliente();
        DesabilitaFormularioProduto();
    }
    
    /**
     * 
     * Método para desabilitar formulário de clientes.
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void DesabilitaFormularioCliente()
    {
        txtIdCliente.setEditable(false);
        txtNomeCliente.setEditable(false);
        txtCPFCliente.setEditable(false);
        txtEmailCliente.setEditable(false);
        
        btnPesquisaCliente.setEnabled(false);        

    }
    
    /**
     * 
     * Método para desabilitar formulário de produtos.
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void DesabilitaFormularioProduto()
    {
        txtIdProduto.setEditable(false);
        txtNomeProduto.setEditable(false);
        txtValorProduto.setEditable(false);
        txtQtdProduto.setEditable(false);
        txtBuscarProdutoPorNome.setEditable(false);
        
        btnAdicionaProduto.setEnabled(false);
        btnPesquisaProduto.setEnabled(false);        
        btnCancelaProduto.setEnabled(false);
        btnAdicionarAoCarrinho.setEnabled(false);
    }
    
   /**
     * 
     * Método para habilitar formulário de clientes e permitir inserção de dados.
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void HabilitaFormularioCliente()
    {
        txtIdCliente.setEditable(true);
        txtNomeCliente.setEditable(true);
        txtCPFCliente.setEditable(true);
        
        btnPesquisaCliente.setEnabled(true);        
    }
    
    /**
     * 
     * Método para habilitar formulário de clientes e permitir inserção de dados.
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void HabilitaFormularioProduto()
    {
        txtIdProduto.setEditable(false);
        txtValorProduto.setEditable(false);
        txtNomeProduto.setEditable(true);
        txtQtdProduto.setEditable(true);
        txtBuscarProdutoPorNome.setEditable(true);
        
        btnAdicionaProduto.setEnabled(true);
        btnPesquisaProduto.setEnabled(true);        
        btnCancelaProduto.setEnabled(true);
        btnAdicionarAoCarrinho.setEnabled(true);
    }
    
    /**
     * 
     * Método para limpar formulário de produtos e limpar dados já colocados.
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void LimpaFormularioProduto()
    {
        txtIdProduto.setText("");
        txtNomeProduto.setText("");
        txtQtdProduto.setText("");
        txtValorProduto.setText("");
        btnAdicionarAoCarrinho.setEnabled(false);
        
        DefaultTableModel tmProdutos = new DefaultTableModel();
        tmProdutos.addColumn("Id");
        tmProdutos.addColumn("Nome");
        tmProdutos.addColumn("Estoque");
        tmProdutos.addColumn("Valor Unitário");
        tmProdutos.addColumn("Descrição");
        tblProdutos.setModel(tmProdutos);
    }
    
    /**
     * 
     *Método para limpar formulário de clientes e limpar dados já colocados.
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void LimpaFormularioCliente()
    {
        txtIdCliente.setText("");
        txtNomeCliente.setText("");
        txtCPFCliente.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnPesquisaCliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtEmailCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCPFCliente = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        btnPesquisaProduto = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnAdicionaProduto = new javax.swing.JButton();
        lblQtd = new javax.swing.JLabel();
        txtQtdProduto = new javax.swing.JTextField();
        btnCancelaProduto = new javax.swing.JButton();
        lblNome1 = new javax.swing.JLabel();
        txtValorProduto = new javax.swing.JTextField();
        btnAdicionarAoCarrinho = new javax.swing.JButton();
        txtBuscarProdutoPorNome = new javax.swing.JTextField();
        lblNome2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        btnCancelaCompra = new javax.swing.JButton();
        btnExcluiItem = new javax.swing.JButton();
        btnFinaliza = new javax.swing.JButton();
        rboDinheiro = new javax.swing.JRadioButton();
        rboDebito = new javax.swing.JRadioButton();
        rboCredito = new javax.swing.JRadioButton();
        lblFormasPag = new javax.swing.JLabel();
        lblFormasPag1 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        btnAdicionarCliente = new javax.swing.JButton();
        btnAdicionarProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Passo 1: Pesquisar Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Nome:");

        jLabel2.setText("CPF:");

        btnPesquisaCliente.setText("Pesquisar");
        btnPesquisaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaClienteActionPerformed(evt);
            }
        });

        jLabel6.setText("ID:");

        txtIdCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdClienteKeyReleased(evt);
            }
        });

        jLabel3.setText("E-mail:");

        try {
            txtCPFCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPFCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPFClienteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtCPFCliente)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisaCliente)
                    .addComponent(jLabel2)
                    .addComponent(txtCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(285, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Passo 2: Pesquisar Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblID.setText("ID:");

        lblNome.setText("Valor Unitário:");

        btnPesquisaProduto.setText("Pesquisar");
        btnPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaProdutoActionPerformed(evt);
            }
        });

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Quantidade", "Descrição", "Quantidade no Estoquue"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProdutos);

        btnAdicionaProduto.setText("Selecionar");
        btnAdicionaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaProdutoActionPerformed(evt);
            }
        });

        lblQtd.setText("Quantidade:");

        btnCancelaProduto.setText("Cancelar");
        btnCancelaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaProdutoActionPerformed(evt);
            }
        });

        lblNome1.setText("Nome:");

        btnAdicionarAoCarrinho.setText("Adicionar ao Carrinho");
        btnAdicionarAoCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAoCarrinhoActionPerformed(evt);
            }
        });

        lblNome2.setText("Nome:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNome2)
                                .addGap(8, 8, 8)
                                .addComponent(txtBuscarProdutoPorNome))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdicionaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNome)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblQtd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNome1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeProduto)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdicionarAoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarProdutoPorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPesquisaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdicionaProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID)
                    .addComponent(lblNome)
                    .addComponent(txtValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQtd))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome1))
                .addGap(18, 18, 18)
                .addComponent(btnAdicionarAoCarrinho)
                .addGap(18, 18, 18)
                .addComponent(btnCancelaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Passo 3: Carrinho de Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Produto", "Quantidade", "Preço Únitario", "Total da Compra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCarrinho);

        btnCancelaCompra.setText("Cancelar");
        btnCancelaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaCompraActionPerformed(evt);
            }
        });

        btnExcluiItem.setText("Retirar Produto");
        btnExcluiItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiItemActionPerformed(evt);
            }
        });

        btnFinaliza.setText("Finalizar");
        btnFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaActionPerformed(evt);
            }
        });

        buttonGroup2.add(rboDinheiro);
        rboDinheiro.setText("Dinheiro");

        buttonGroup2.add(rboDebito);
        rboDebito.setText("Débito");

        buttonGroup2.add(rboCredito);
        rboCredito.setText("Crédito");

        lblFormasPag.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFormasPag.setText("Formas de Pagamento:");

        lblFormasPag1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFormasPag1.setText("Desconto:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnExcluiItem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinaliza, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblFormasPag)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rboDebito)
                                    .addComponent(rboDinheiro)
                                    .addComponent(rboCredito)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblFormasPag1)
                                .addGap(18, 18, 18)
                                .addComponent(txtDesconto)))))
                .addGap(205, 205, 205))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFormasPag1)
                            .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFormasPag)
                            .addComponent(rboDinheiro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rboDebito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rboCredito)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluiItem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinaliza, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnAdicionarCliente.setText("Adicionar Cliente");
        btnAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarClienteActionPerformed(evt);
            }
        });

        btnAdicionarProduto.setText("Adicionar Produto");
        btnAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarCliente)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdicionarProduto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(btnAdicionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * 
     * O modo de tela usado para adicionar cliente
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed
        HabilitaFormularioCliente();
        LimpaFormularioCliente();
        DesabilitaFormularioProduto();
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed

    /**
     * 
     * O modo de tela usado para adicionar produtos
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    
    private void btnAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoActionPerformed
        HabilitaFormularioProduto();
        LimpaFormularioProduto();
        DesabilitaFormularioCliente();
    }//GEN-LAST:event_btnAdicionarProdutoActionPerformed

    /**
     * 
     * Método que cancela a operação, desabilita e limpa os formulários.
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    
    private void btnCancelaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaProdutoActionPerformed
        DesabilitaFormularioProduto();
        LimpaFormularioProduto();
    }//GEN-LAST:event_btnCancelaProdutoActionPerformed

    
   /**
     * 
     * Método para adição de produto, onde se puxam os dados do produto para inserção dele no carrinho
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    private void btnAdicionaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaProdutoActionPerformed
        
        if(tblProdutos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Ops! Parece que você não selecionou nenhum item.");
        } else {
            txtIdProduto.setText((String) tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0));
            txtNomeProduto.setText((String) tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 1));
            txtQtdProduto.setText("0");
            txtValorProduto.setText((String) tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 3));
            btnAdicionarAoCarrinho.setEnabled(true);  
           //txtNomeProduto.setText((String) TabelaProdutos.getValueAt(TabelaProdutos.getSelectedRow(), 1));
        }
        
    }//GEN-LAST:event_btnAdicionaProdutoActionPerformed

    
    /**
     * 
     * Método para pesquisa de produtos, onde se usa um método de carregar tabela.
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    private void btnPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaProdutoActionPerformed
        try {
            //Instancio um novo cliente
            Produto produto = new Produto();
            ArrayList<String[]> listaProdutos = new ArrayList<>();
            
            /*
            //Verifico se a pesquisa será por Id, CPF ou Nome do Cliente
            if (!txtIdProduto.getText().trim().equals("")) {
                
                //produto = ProdutoController.(Integer.parseInt(txtIdProduto.getText()));
                
            } else if (!txtNomeProduto.getText().trim().equals("")) {
                
                //produto = ProdutoController.(txtNomeProduto.getText());
                
            } else {
                //Caso nenhum dos campos for preenchidos, alerto o usuário para faze-lo
                JOptionPane.showMessageDialog(null, "Preencha corretamente todos os campos para adicionar um produto à compra!");
            }*/
            
            
            listaProdutos = produtoController.getProdutoByName(txtBuscarProdutoPorNome.getText());
            
            DefaultTableModel tmProdutos = new DefaultTableModel();
            tmProdutos.addColumn("Id");
            tmProdutos.addColumn("Nome");
            tmProdutos.addColumn("Estoque");
            tmProdutos.addColumn("Valor Unitário");
            tmProdutos.addColumn("Descrição");
            tblProdutos.setModel(tmProdutos);
            
            for(String[] p:listaProdutos){
                tmProdutos.addRow(p);
            }
            
            //int txtQtd = Integer.parseInt(String.valueOf(txtQtdProduto));
            
            //Verifica se a quantidade em estoque é menor ou maior do que a quantidade do pedido
            /*if (txtQtd <= produto.getQuantidade()) {;
                //Populo a tabela de Clientes
                DefaultTableModel tmClientes = new DefaultTableModel();
                tmClientes.addColumn("Id");
                tmClientes.addColumn("Nome");
                tmClientes.addColumn("CPF");
                tblProdutos.setModel(tmClientes);

                tmClientes.addRow(new String[] { String.valueOf(produto.getId()), 
                    produto.getNome(), String.valueOf(txtQtdProduto), produto.getDescricao(), 
                    String.valueOf(produto.getQuantidade()) });
            } else {
                JOptionPane.showMessageDialog(null, "A quantidade do pedido é maior do que o estoque!");
            }*/
        } catch (Exception e) {
            Logger.getLogger(ProdutoView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnPesquisaProdutoActionPerformed

    /**
     * 
     * Método para exclusão de produtos com jTable
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    private void btnExcluiItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiItemActionPerformed
        if(tblCarrinho.getRowCount() > 0)
        {
            //Resgato o número da linha pelo JTable
            int numeroLinha = tblCarrinho.getSelectedRow();

            int itemId = Integer.parseInt((String) tblCarrinho.getValueAt(numeroLinha, 0));
            int produtoId = Integer.parseInt((String) tblCarrinho.getValueAt(numeroLinha, 1));
            int quantidade = Integer.parseInt((String) tblCarrinho.getValueAt(numeroLinha, 3));
            
            itemVenda.excluirItemVenda(itemId, produtoId, quantidade);
            
            //Atualizar a lista do carrinho
            buscarItensCarrinho();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto à ser excluído!");
        }
    }//GEN-LAST:event_btnExcluiItemActionPerformed

    /**
     * 
     * Método para adição de produtos ao carrinho e mudança de modo de tela.
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    private void btnAdicionarAoCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAoCarrinhoActionPerformed
        try {
            // TODO add your handling code here:
            ItemVenda itemVendaNovo = itemVenda.criarItemVenda(
                    Integer.parseInt((String) txtIdProduto.getText()),
                    vendaId, 
                    Integer.parseInt((String) txtQtdProduto.getText()), 
                    Double.parseDouble((String) txtValorProduto.getText()), 
                    Integer.parseInt((String) txtQtdProduto.getText()) * Double.parseDouble((String) txtValorProduto.getText()));
            
            buscarItensCarrinho();
            LimpaFormularioProduto();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VendaView.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Error e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
    }//GEN-LAST:event_btnAdicionarAoCarrinhoActionPerformed

    
    /**
     * 
     * Método de validação que impede valores incorretos
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    private void txtIdClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdClienteKeyReleased
        if (!txtIdCliente.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo só aceita números inteiros!");
        }
    }//GEN-LAST:event_txtIdClienteKeyReleased

    
    /**
     * 
     * Método para pesquisa e inserção do cliente na venda
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    private void btnPesquisaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaClienteActionPerformed
        
        if(ValidarPesquisaCliente()){
            Cliente cliente = vendaController.buscarClientePorCPF(txtCPFCliente.getText());
            System.out.println(cliente);
            txtIdCliente.setText(String.valueOf(cliente.getId()));
            txtNomeCliente.setText(cliente.getNome());
            txtEmailCliente.setText(cliente.getEmail());

            if(vendaId == -1){
                venda = vendaController.criarVenda(cliente.getId());
                vendaId = venda.getCodigo();
                System.out.println("ID da Venda: " + vendaId);
            }
        }
        
        
    }//GEN-LAST:event_btnPesquisaClienteActionPerformed

    
    /**
     * 
     * Método que impede que o campo esteja vazio
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public boolean ValidarPesquisaCliente(){
        if(this.txtCPFCliente.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this,"Ops, parece que esqueceu de digitar um CPF!");
            return false;
        }
        return true;
    }
    
    
    /**
     * 
     * Término da compra, com a inserção de todos os dados que serão posteriormente tratados
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    private void btnFinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizaActionPerformed
        // TODO add your handling code here:
        if(ValidarFormulario()){
            venda.setCliente(Integer.parseInt((String) txtIdCliente.getText()));
            venda.setDesconto(Integer.parseInt((String) txtDesconto.getText()));
            boolean dinheiro = rboDinheiro.isSelected();
            boolean debito = rboDebito.isSelected();
            boolean credito = rboCredito.isSelected();
            if(dinheiro){
                venda.setPagamento(rboDinheiro.getText());
            } else if(debito){
                venda.setPagamento(rboDebito.getText());
            } else if(credito) {
                venda.setPagamento(rboCredito.getText());
            }
            venda.setValorTotal(itemVenda.buscarValorTotal(vendaId));
            if(vendaController.finalizaVenda(venda)){
                JOptionPane.showMessageDialog(this, "Venda finalizada com sucesso!");
                setVisible(false); //you can't see me!
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Houve algum erro ao finalizar a venda!");
            }
        }
        
         
    }//GEN-LAST:event_btnFinalizaActionPerformed
        
    /**
     * 
     * Os dados anteriores são retirados da memória e se fecha a tela
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    
    private void btnCancelaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaCompraActionPerformed
        // TODO add your handling code here:
        
        setVisible(false); //you can't see me!
        dispose();
    }//GEN-LAST:event_btnCancelaCompraActionPerformed

   /**
     * 
     * Método que garante que não se digitem caracteres inválidos 
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    private void txtCPFClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFClienteKeyTyped
        String numeros = "0123456789";

        if(!numeros.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_txtCPFClienteKeyTyped
/**
     * 
     * Método comum de validação
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    private boolean ValidarFormulario() {
        if(this.txtIdCliente.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this,"Não há cliente selecionado!");
            return false;
        }
        
        if(this.txtDesconto.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this,"Defina um desconto para a Venda, mesmo que 0!");
            return false;
        }
        
        try {

            int valorConvertido = Integer.parseInt(this.txtDesconto.getText());
            System.out.println(valorConvertido);
            if(valorConvertido < 0){
                JOptionPane.showMessageDialog(this,"Desconto deve ser um numero maior ou igual a zero!!");
                return false;
            }
        
        } catch(NumberFormatException e){
            
            JOptionPane.showMessageDialog(this,"Desconto deve ser um numero inteiro!!");
            return false;
        
        }catch(IllegalArgumentException e){
            
            JOptionPane.showMessageDialog(this,"Digite um valor para Desconto");  
            return false;
        
        }
        
        if(!rboDinheiro.isSelected() && !rboDebito.isSelected() && !rboCredito.isSelected()){
            JOptionPane.showMessageDialog(this,"Defina uma forma de pagamento!");
            return false;
        }
        
        return true;       
    }
    
    /**
     * 
     * Método recuperar os produtos adicionados em uma tabela.  
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    
    public void buscarItensCarrinho(){
        DefaultTableModel tmCarrinho = new DefaultTableModel();
        tmCarrinho.addColumn("Item ID"); //ID
        tmCarrinho.addColumn("Produto ID"); //Produto ID
        tmCarrinho.addColumn("Produto Nome"); //Produto Nome
        tmCarrinho.addColumn("Quantidade"); //Quantidade
        tmCarrinho.addColumn("Preco Unitario"); //Preco Unitario
        tmCarrinho.addColumn("Preco Total"); //Preco Total
        tblCarrinho.setModel(tmCarrinho);
        
        ArrayList<String[]> listaDeItens = itemVenda.buscarItens(vendaId);
        
        for(String[] p:listaDeItens){
            tmCarrinho.addRow(p);
        }
        
    }
    
    
    /**
     * 
     * Método para adição de produto, onde se puxam os dados do produto para inserção dele no carrinho
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public void adicionarItemCarrinhoDeCompras(ItemVenda itemVendaNovo) throws SQLException, ClassNotFoundException{
        ArrayList<ItemVenda> backUpItens = backUpCarrinhoDeCompras();
        ArrayList<ItemVenda> novaLista = backUpCarrinhoDeCompras();
        novaLista.add(itemVendaNovo);
        
        DefaultTableModel tmCarrinho = new DefaultTableModel();
        tmCarrinho.addColumn("Item ID"); //ID
        tmCarrinho.addColumn("Produto ID"); //Produto ID
        tmCarrinho.addColumn("Produto Nome"); //Produto Nome
        tmCarrinho.addColumn("Quantidade"); //Quantidade
        tmCarrinho.addColumn("Preco Unitario"); //Preco Unitario
        tmCarrinho.addColumn("Preco Total"); //Preco Total
        tblCarrinho.setModel(tmCarrinho);
        
        for(int i = 0; i < novaLista.size(); i++) {
            tmCarrinho.addRow(new String[]{
               String.valueOf(novaLista.get(i).getId()),
               String.valueOf(novaLista.get(i).getProdutoId()),
               itemVenda.buscarProduto(novaLista.get(i).getProdutoId()).getNome(),
               String.valueOf(novaLista.get(i).getQuantidade()),
               String.valueOf(novaLista.get(i).getPrecoUnitario()),
               String.valueOf(novaLista.get(i).getPrecoTotal())
            });
        }
                
    }
    
    
    /**
     * 
     * Método para guardar dados dos produtos do carrinho de compras.
     * 
     * @author felipe.fhenriques
     * @return void
     * @version 1.0
     * @since 18 de Novembro (Javadoc)
    */
    public ArrayList<ItemVenda> backUpCarrinhoDeCompras(){
        ArrayList<ItemVenda> itensVenda = new ArrayList<>();
        
        int rowCount = tblCarrinho.getRowCount();
        if (rowCount > 0){
            
            for(int i = 0; i < rowCount; i++){
                if(tblCarrinho.getValueAt(i, 0) != null){
                    ItemVenda itemVenda = new ItemVenda(
                            Integer.parseInt((String) tblCarrinho.getValueAt(i, 0)), //ID
                            Integer.parseInt((String) tblCarrinho.getValueAt(i, 1)), //Produto ID
                            vendaId, //Venda ID
                            Integer.parseInt((String) tblCarrinho.getValueAt(i, 3)), //Quantidade
                            Double.parseDouble((String) tblCarrinho.getValueAt(i, 4)), //Preco Unitario
                            Double.parseDouble((String) tblCarrinho.getValueAt(i, 5))
                    );
                    itensVenda.add(itemVenda);
                }
            }
            
        }     
        
        
        return itensVenda;
    }
    
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
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionaProduto;
    private javax.swing.JButton btnAdicionarAoCarrinho;
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnAdicionarProduto;
    private javax.swing.JButton btnCancelaCompra;
    private javax.swing.JButton btnCancelaProduto;
    private javax.swing.JButton btnExcluiItem;
    private javax.swing.JButton btnFinaliza;
    private javax.swing.JButton btnPesquisaCliente;
    private javax.swing.JButton btnPesquisaProduto;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFormasPag;
    private javax.swing.JLabel lblFormasPag1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblNome2;
    private javax.swing.JLabel lblQtd;
    private javax.swing.JRadioButton rboCredito;
    private javax.swing.JRadioButton rboDebito;
    private javax.swing.JRadioButton rboDinheiro;
    private javax.swing.JTable tblCarrinho;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtBuscarProdutoPorNome;
    private javax.swing.JFormattedTextField txtCPFCliente;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtQtdProduto;
    private javax.swing.JTextField txtValorProduto;
    // End of variables declaration//GEN-END:variables
}

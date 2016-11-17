/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import my.contacteditor.conexao.conexaoBD;

/**
 *
 * @author lucas
 */
public class ConsultarExcluir extends javax.swing.JFrame {

    conexaoBD cb = new conexaoBD();
    public String informacaoTabelaCPF;
    
    /**
     * Creates new form ConsultarExcluir
     */
    public ConsultarExcluir() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tabelaConsulta.getModel();
        tabelaConsulta.setRowSorter(new TableRowSorter(modelo));
        cbEscolha.setSelectedItem("NOME");
        
        cb.conectarBD();
        cb.popularComboBoxEstado(cbEstado);
        cb.popularComboBoxPartido(cbPartido);
        cb.desconBD();
    }

    //Pega o CPF na Tabela
    public String info(){
        int linha = tabelaConsulta.getSelectedRow();
        String info = tabelaConsulta.getModel().getValueAt(linha, 0).toString();
        
        return info;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cpf = new javax.swing.JFormattedTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        campoCPF = new javax.swing.JFormattedTextField();
        cbEscolha = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsulta = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        numeroCampanha = new javax.swing.JTextField();
        cbEstado = new javax.swing.JComboBox<>();
        cbPartido = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        quantidadeRegistros = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        campoNome = new javax.swing.JTextField();
        qtdRegistro = new javax.swing.JLabel();

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfActionPerformed(evt);
            }
        });

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Mostrar Todos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        try {
            campoCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCPFActionPerformed(evt);
            }
        });

        cbEscolha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOME", "CPF", "Nº DE CAMPANHA", "ESTADO", "PARTIDO", "CATEGORIA" }));
        cbEscolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEscolhaActionPerformed(evt);
            }
        });

        jLabel1.setText("Procurar por:");

        tabelaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CPF", "Nome", "Nome de Campanha", "Nº Campanha", "Partido", "Vice-Candidato", "Categoria"
            }
        ));
        tabelaConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaConsulta);

        jButton3.setText("Consultar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("CONSULTA DE CANDIDATOS");

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Excluir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        cbPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPartidoActionPerformed(evt);
            }
        });

        jLabel3.setText("Número de registros encontrados: ");

        quantidadeRegistros.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PREFEITO", "VEREADOR" }));
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        qtdRegistro.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        qtdRegistro.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cbEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(240, 240, 240))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numeroCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbPartido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(quantidadeRegistros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(qtdRegistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quantidadeRegistros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(qtdRegistro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            ArrayList<PrefeitoDAO> p = new ArrayList<PrefeitoDAO>();
            conexaoBD cb = new conexaoBD();
            
            try{
                p = (ArrayList<PrefeitoDAO>) cb.consultaTodos();
            } catch (SQLException ex) {
            
                Logger.getLogger(ConsultarExcluir.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(p.isEmpty()){
                JOptionPane.showMessageDialog(null, "Não há registros que satisfazem a pesquisa!");
                return;
            }
            
            DefaultTableModel modelo = (DefaultTableModel) tabelaConsulta.getModel();
            
            modelo.setNumRows(0);
            
            Object[] fila = new Object[modelo.getColumnCount()];
            for(int i=0; i < p.size(); i++){
                modelo.addRow(new Object[]{
                    p.get(i).getCpf(),
                    p.get(i).getNomeReal(),
                    p.get(i).getNomeFantasia(),
                    p.get(i).getNumeroCampanha(),
                    p.get(i).getPartido(),
                    p.get(i).getNomeVice(),
                    p.get(i).getCandidatura()
                });
                
            }
            
            qtdRegistro.setText(Integer.toString(modelo.getRowCount()));
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new ContactEditorUI().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfActionPerformed

    }//GEN-LAST:event_cpfActionPerformed

    private void campoCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCPFActionPerformed

    }//GEN-LAST:event_campoCPFActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            ArrayList<PrefeitoDAO> p = new ArrayList<PrefeitoDAO>();
            conexaoBD cb = new conexaoBD();
            
            try{
                if(cbEscolha.getSelectedItem().equals("CPF")){ //Faz a pesquisa no banco de acordo com o escolhido.
                    p = (ArrayList<PrefeitoDAO>) cb.consultaTodosPorCPF(campoCPF.getText());
                }
                
                if(cbEscolha.getSelectedItem().equals("Nº DE CAMPANHA")){
                    p = (ArrayList<PrefeitoDAO>) cb.consultaTodosPorNumCampanha(numeroCampanha.getText());
                }
                
                if(cbEscolha.getSelectedItem().equals("ESTADO")){
                    p = (ArrayList<PrefeitoDAO>) cb.consultaTodosPorEstado(cbEstado.getSelectedItem().toString().substring(0,2).trim());
                   // System.out.println("TESTE:  "+ cbEstado.getSelectedItem().toString().substring(0,2).trim());
                }
                
                if(cbEscolha.getSelectedItem().equals("PARTIDO")){
                    p = (ArrayList<PrefeitoDAO>) cb.consultaTodosPorPartido(cbPartido.getSelectedItem().toString().substring(0,2).trim());
                    System.out.println("TESTE:  "+ cbPartido.getSelectedItem().toString().substring(0,2).trim());
                }
                
                if(cbEscolha.getSelectedItem().equals("CATEGORIA")){
                    p = (ArrayList<PrefeitoDAO>) cb.consultaTodosPorCategoria(cbCategoria.getSelectedItem().toString());
                }
                
                if(cbEscolha.getSelectedItem().equals("NOME")){
                    p = (ArrayList<PrefeitoDAO>) cb.consultaTodosPorNome(campoNome.getText().toString());
                }
                
                
                
            } catch (SQLException ex) {
            
                Logger.getLogger(ConsultarExcluir.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(p.isEmpty()){
                JOptionPane.showMessageDialog(null, "Não há registros que satisfazem a pesquisa!");
                return;
            }
            
            DefaultTableModel modelo = (DefaultTableModel) tabelaConsulta.getModel();
            
            modelo.setNumRows(0);
            
            Object[] fila = new Object[modelo.getColumnCount()];
            for(int i=0; i < p.size(); i++){
                modelo.addRow(new Object[]{
                    p.get(i).getCpf(),
                    p.get(i).getNomeReal(),
                    p.get(i).getNomeFantasia(),
                    p.get(i).getNumeroCampanha(),
                    p.get(i).getPartido(),
                    p.get(i).getNomeVice(),
                    p.get(i).getCandidatura()
                      
                });
                
            }
            
            qtdRegistro.setText(Integer.toString(modelo.getRowCount()));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbEscolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEscolhaActionPerformed
        if(cbEscolha.getSelectedItem().equals("CPF")){
            numeroCampanha.setEditable(false);
            numeroCampanha.setText("");
            numeroCampanha.setEnabled(false);
            numeroCampanha.setBackground(Color.LIGHT_GRAY);
            cbPartido.setEnabled(false);
            cbEstado.setEnabled(false);
            campoCPF.setEditable(true);
            campoCPF.setEnabled(true);
            campoCPF.setBackground(Color.WHITE);
            cbCategoria.setEnabled(false);
           
            campoNome.setEnabled(false);
            campoNome.setText("");
            campoNome.setBackground(Color.LIGHT_GRAY);
            
        }else{
            if(cbEscolha.getSelectedItem().equals("ESTADO")){   
                numeroCampanha.setEditable(false);
                numeroCampanha.setText("");
                numeroCampanha.setBackground(Color.LIGHT_GRAY);
                cbEstado.setEnabled(true);
                cbPartido.setEnabled(false);
                numeroCampanha.setEnabled(false);
                campoCPF.setEditable(false);
                campoCPF.setText("");
                campoCPF.setBackground(Color.LIGHT_GRAY);
                cbCategoria.setEnabled(false);
                
                campoNome.setEnabled(false);
                campoNome.setBackground(Color.LIGHT_GRAY);
            }
        }
        
        if(cbEscolha.getSelectedItem().equals("PARTIDO")){
                cbEstado.setEnabled(false);
                cbPartido.setEnabled(true);
                numeroCampanha.setEditable(false);
                campoCPF.setEditable(false);
                campoCPF.setBackground(Color.LIGHT_GRAY);
                numeroCampanha.setEditable(false);
                numeroCampanha.setEnabled(false);
                numeroCampanha.setBackground(Color.LIGHT_GRAY);
                campoCPF.setText("");
                numeroCampanha.setText("");
                cbCategoria.setEnabled(false);
                
                campoNome.setEnabled(false);
                campoNome.setBackground(Color.LIGHT_GRAY);
        }
        
        if(cbEscolha.getSelectedItem().equals("Nº DE CAMPANHA")){
                cbEstado.setEnabled(false);
                cbPartido.setEnabled(false);
                numeroCampanha.setEditable(true);
                numeroCampanha.setEnabled(true);
                campoCPF.setEditable(false);
                campoCPF.setEnabled(false);
                campoCPF.setBackground(Color.LIGHT_GRAY);
                numeroCampanha.setEditable(true);
                numeroCampanha.setBackground(Color.WHITE);
                campoCPF.setText("");
                cbCategoria.setEnabled(false);
                
                campoNome.setEnabled(false);
                campoNome.setBackground(Color.LIGHT_GRAY);
                
        }
        
        if(cbEscolha.getSelectedItem().equals("CATEGORIA")){
                cbEstado.setEnabled(false);
                cbPartido.setEnabled(false);
                cbCategoria.setEnabled(true);
                campoCPF.setEnabled(false);
                campoCPF.setBackground(Color.LIGHT_GRAY);
                numeroCampanha.setEnabled(false);
                numeroCampanha.setBackground(Color.LIGHT_GRAY);
                campoCPF.setText("");
                numeroCampanha.setText("");
                campoNome.setEnabled(false);
                campoNome.setBackground(Color.LIGHT_GRAY);
                
        }
        
        if(cbEscolha.getSelectedItem().equals("NOME")){
                campoNome.setEnabled(true);
                campoNome.setEditable(true);
                campoNome.setBackground(Color.WHITE);
                cbEstado.setEnabled(false);
                cbPartido.setEnabled(false);
                cbCategoria.setEnabled(false);
                campoCPF.setEditable(false);
                campoCPF.setEnabled(false);
                campoCPF.setBackground(Color.LIGHT_GRAY);
                numeroCampanha.setEditable(false);
                numeroCampanha.setEnabled(false);
                numeroCampanha.setBackground(Color.LIGHT_GRAY);
                campoCPF.setText("");
                numeroCampanha.setText("");
                
        }
    }//GEN-LAST:event_cbEscolhaActionPerformed

    private void tabelaConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaConsultaMouseClicked
        informacaoTabelaCPF = info();
        System.out.println("INFO: "+informacaoTabelaCPF);
    }//GEN-LAST:event_tabelaConsultaMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        conexaoBD cb = new conexaoBD();
        PrefeitoDAO p = null;

         
        try{
                
             int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Candidato?","Atenção",JOptionPane.YES_NO_OPTION);
             
             if(resposta == JOptionPane.YES_OPTION){
                 
                String info = info();

                cb.excluirCandidato(info);
                JOptionPane.showMessageDialog(null, "Candidato excluído com sucesso!");
                
                DefaultTableModel modelo = (DefaultTableModel) tabelaConsulta.getModel();
                modelo.setNumRows(0);
                
             }else{
                 if(resposta == JOptionPane.NO_OPTION){
                     //Somente fecha a caixa de pergunta.
                 }
             }
         
            }
         catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Erro na exclusão!","Atenção",JOptionPane.ERROR_MESSAGE,null);
         }
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        alterarCandidato ac = new alterarCandidato();
        ConsultarExcluir.this.dispose();        
        //Nessa parte, o campo CPF de alterarCandidato é preenchido com o CPF escolhido da tabela. Logo depois, o sistema 
        //preenche a interface com os dados necessários e em seguida mostra para o usuário.
        ac.cpfAlterar.setText(informacaoTabelaCPF);
        ac.preencheCampos();
        ac.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void cbPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPartidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPartidoActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoriaActionPerformed

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           try{   
               javax.swing.UIManager um = new javax.swing.UIManager();
               um.setLookAndFeel(um.getSystemLookAndFeelClassName());
           }catch(Exception e){
               e.printStackTrace();
           }
           finally {
                new ConsultarExcluir().setVisible(true); //troque o nemo do frame!
            }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbEscolha;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbPartido;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numeroCampanha;
    private javax.swing.JLabel qtdRegistro;
    private javax.swing.JLabel quantidadeRegistros;
    private javax.swing.JTable tabelaConsulta;
    // End of variables declaration//GEN-END:variables


}

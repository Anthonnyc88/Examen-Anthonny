/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anthonny
 */
public class Reporte2 extends javax.swing.JFrame {

    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

    /**
     * Creates new form Reporte2
     */
    public Reporte2() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void conexion() {
        if (connection != null) {
            return;
        }

        String url = "jdbc:postgresql://localhost:5432/examen";
        String password = "1414250816ma";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "postgres", password);
            if (connection != null) {
                System.out.println("Connecting to database...");
            }
        } catch (Exception e) {
            System.out.println("Problem when connecting to the database");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        radioNiño = new javax.swing.JRadioButton();
        radioJoven = new javax.swing.JRadioButton();
        radioAdulto = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        info = new javax.swing.JTable();
        bntMostrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(radioNiño);
        radioNiño.setText("Niño");

        buttonGroup1.add(radioJoven);
        radioJoven.setText("Joven");

        buttonGroup1.add(radioAdulto);
        radioAdulto.setText("Adulto");

        jLabel1.setText("Elija usted ");

        info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre Producto", "Precio", "Tipo usuario"
            }
        ));
        jScrollPane1.setViewportView(info);

        bntMostrar.setText("Mostrar");
        bntMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntMostrarActionPerformed(evt);
            }
        });

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntMostrar)
                            .addComponent(radioAdulto)
                            .addComponent(radioJoven))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(radioNiño))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(54, 54, 54))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(radioNiño))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(radioJoven)
                .addGap(18, 18, 18)
                .addComponent(radioAdulto)
                .addGap(18, 18, 18)
                .addComponent(bntMostrar)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Ventana vb = new Ventana();
        vb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bntMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntMostrarActionPerformed
        // TODO add your handling code here:
        ArrayList<String> nombre = null;
        ArrayList<String> precio = null;
        ArrayList<String> tipo_persona = null;
         conexion();
        
        try {
            nombre = new <String>ArrayList();
            precio = new <String>ArrayList();
            tipo_persona = new <String>ArrayList();
            
            String tipo = null;
            if(radioNiño.isSelected()){
                tipo = "Niño";
            }else if (radioJoven.isSelected()){
                tipo = "Joven";
                     
            }else if (radioAdulto.isSelected()){
                tipo = "Adulto";
            }
            
            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre, precio, tipo_persona FROM producto "
                    + " \n" + " WHERE tipo_persona ='" + tipo +"'");

            while (rs.next()) {
                nombre.add(rs.getString("nombre"));
                precio.add(rs.getString("precio"));
                tipo_persona.add(rs.getString("tipo_persona"));
            }
        } catch (Exception e) {
            System.out.println("Error de conexión" + e);
        }
        try {
            for (int i = 0; i < nombre.size(); i++) {
                info.setValueAt(nombre.get(i), i, 0);
                info.setValueAt(precio.get(i), i, 1);
                info.setValueAt(tipo_persona.get(i), i, 2);
                if (nombre.size() >= info.getRowCount()) {
                    DefaultTableModel temp2 = (DefaultTableModel) info.getModel();
                    Object nuevo[] = {temp2.getRowCount()};
                    temp2.addRow(nuevo);
                }

            }
            if (info.getRowCount() > nombre.size()) {

                try {
                    DefaultTableModel temp2 = (DefaultTableModel) info.getModel();
                    info.getModel();
                    temp2.removeRow(temp2.getRowCount() - 1);

                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }


    }//GEN-LAST:event_bntMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(Reporte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntMostrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable info;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioAdulto;
    private javax.swing.JRadioButton radioJoven;
    private javax.swing.JRadioButton radioNiño;
    // End of variables declaration//GEN-END:variables
}

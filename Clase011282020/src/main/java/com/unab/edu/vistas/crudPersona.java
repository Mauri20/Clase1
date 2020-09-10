/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.vistas;

import com.unab.edu.conexionmysql.ConexionBd;
import com.unab.edu.dao.ClsPersona;
import com.unab.edu.entidades.Persona;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio
 */
public class crudPersona extends javax.swing.JFrame {

    /**
     * Creates new form crudPersona
     */
    public crudPersona() {
        initComponents();
        txtId.enable(false);
        //Centrar el formulario
        this.setLocationRelativeTo(null);
        //Cargar la tabla
        MostrarTablaPersona();
    }
    
    void MostrarTablaPersona() {
        String TITULOS[] = {"ID", "NOMBRE", "APELLIDO", "EDAD", "SEXO"};
        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
        //tbPersona.setModel(ModeloTabla);
        ClsPersona clasePersona = new ClsPersona();
        ArrayList<Persona> Personas = clasePersona.MostrarPersona();
        //Creamos un array donde volcaremos los datos traidos en MostrarPersona()
        String filas[] = new String[5];
        for (var iterarDatoPersona : Personas) {
            //agregamos cada dato de la consulta en un espacio del arreglo
            filas[0] = String.valueOf(iterarDatoPersona.getIdPersona());
            filas[1] = iterarDatoPersona.getNombre();
            filas[2] = iterarDatoPersona.getApellido();
            filas[3] = String.valueOf(iterarDatoPersona.getEdad());
            filas[4] = iterarDatoPersona.getSexo();
            //Agregamos el arreglo de los datos al modelo de la Tabla
            ModeloTabla.addRow(filas);
        }
        //asignamos el modelo a la Tabla para mostrarlos al usuario
        tbPersona.setModel(ModeloTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbMostrar = new javax.swing.JTabbedPane();
        jpOperaciones = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jpMostrarDatos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPersona = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Edad");

        jLabel5.setText("Sexo");

        jButton4.setText("Probar Conexion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpOperacionesLayout = new javax.swing.GroupLayout(jpOperaciones);
        jpOperaciones.setLayout(jpOperacionesLayout);
        jpOperacionesLayout.setHorizontalGroup(
            jpOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOperacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId)
                    .addComponent(txtEdad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNombre)
                    .addComponent(txtSexo)
                    .addComponent(txtApellido)
                    .addGroup(jpOperacionesLayout.createSequentialGroup()
                        .addGroup(jpOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addGroup(jpOperacionesLayout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar)))
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpOperacionesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        jpOperacionesLayout.setVerticalGroup(
            jpOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOperacionesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        tbMostrar.addTab("Operaciones de CRUD", jpOperaciones);

        tbPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPersonaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPersona);

        javax.swing.GroupLayout jpMostrarDatosLayout = new javax.swing.GroupLayout(jpMostrarDatos);
        jpMostrarDatos.setLayout(jpMostrarDatosLayout);
        jpMostrarDatosLayout.setHorizontalGroup(
            jpMostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMostrarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpMostrarDatosLayout.setVerticalGroup(
            jpMostrarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMostrarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        tbMostrar.addTab("Mostrar Datos", jpMostrarDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tbMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbMostrar, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ConexionBd claseConectar = new ConexionBd();
        Connection conectar = claseConectar.retornarConexion();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        ClsPersona personaDAO = new ClsPersona();
        Persona persona = new Persona();
        //Obtener los datos del formulario
        persona.setNombre(txtNombre.getText());
        persona.setApellido(txtApellido.getText());
        persona.setEdad(Integer.parseInt(txtEdad.getText()));
        persona.setSexo(txtSexo.getText());
        //Llamar el metodo de guardado
        personaDAO.AgregarPersona(persona);
        MostrarTablaPersona();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        ClsPersona personaDao = new ClsPersona();
        Persona persona = new Persona();
        persona.setIdPersona(Integer.parseInt(txtId.getText()));
        //Llamamos el metodo para eliminar
        personaDao.EliminarPersona(persona);
        MostrarTablaPersona();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        ClsPersona personaDAO = new ClsPersona();
        Persona persona = new Persona();
        //Obtener los datos del formulario
        persona.setIdPersona(Integer.parseInt(txtId.getText()));
        persona.setNombre(txtNombre.getText());
        persona.setApellido(txtApellido.getText());
        persona.setEdad(Integer.parseInt(txtEdad.getText()));
        persona.setSexo(txtSexo.getText());
        //Llamar el metodo de guardado
        personaDAO.ActualizarPersona(persona);
        MostrarTablaPersona();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tbPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPersonaMouseClicked
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "Si funciona el Evento");
        //Movernos dentro de los elementos del TabbedPane
        tbMostrar.setSelectedIndex(tbMostrar.indexOfComponent(jpOperaciones));
        //Obtener la fila seleccionada
        int fila = tbPersona.getSelectedRow();
        //Capturando los datos de la fila seleccionada
        String Id = String.valueOf(tbPersona.getValueAt(fila, 0));
        String Nombre = String.valueOf(tbPersona.getValueAt(fila, 1));
        String Apellido = String.valueOf(tbPersona.getValueAt(fila, 2));
        String Edad = String.valueOf(tbPersona.getValueAt(fila, 3));
        String Sexo = String.valueOf(tbPersona.getValueAt(fila, 4));
        //Asignando los datos capturados al formulario
        txtId.setText(Id);
        txtNombre.setText(Nombre);
        txtApellido.setText(Apellido);
        txtEdad.setText(Edad);
        txtSexo.setText(Sexo);
    }//GEN-LAST:event_tbPersonaMouseClicked

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
            java.util.logging.Logger.getLogger(crudPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpMostrarDatos;
    private javax.swing.JPanel jpOperaciones;
    private javax.swing.JTabbedPane tbMostrar;
    private javax.swing.JTable tbPersona;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSexo;
    // End of variables declaration//GEN-END:variables
}

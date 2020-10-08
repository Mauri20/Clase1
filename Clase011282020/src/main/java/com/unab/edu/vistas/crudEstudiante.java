/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.vistas;

import com.unab.edu.dao.*;
import com.unab.edu.entidades.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mauricio
 */
public class crudEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form crudEstudiante
     */
    public crudEstudiante() {
        initComponents();
        txtIdEstudiante.enable(false);
        this.setLocationRelativeTo(null);
        MostrarEstudiantes();
//        MostrarPersonas();
        DisplayMember();
    }

    void MostrarEstudiantes() {
        String TITULOS[] = {"IDESTUDIANTE", "MATRICULA", "IDPERSONA", "NOMBRE", "USUARIO", "PASSWORD", "NIE"};
        DefaultTableModel modeloTabla = new DefaultTableModel(null, TITULOS);
        ClsEstudiante estudianteDao = new ClsEstudiante();
        var listaEstudiantes = estudianteDao.MostrarEstudiantes();
        String filas[] = new String[7];
        for (var iterarDatos : listaEstudiantes) {
            filas[0] = String.valueOf(iterarDatos.getId());
            filas[1] = String.valueOf(iterarDatos.getMatricula());
            filas[2] = String.valueOf(iterarDatos.getIdPersona());
            filas[3] = iterarDatos.getNombre();
            filas[4] = iterarDatos.getUsu();
            filas[5] = iterarDatos.getPass();
            filas[6] = iterarDatos.getNie();
            modeloTabla.addRow(filas);
        }
        tbEstudiantes.setModel(modeloTabla);
    }

//    void MostrarPersonas() {
//        String TITULOS[] = {"ID", "NOMBREPERSONA"};
//        DefaultTableModel ModeloTabla = new DefaultTableModel(null, TITULOS);
//        //tbPersona.setModel(ModeloTabla);
//        ClsPersona clasePersona = new ClsPersona();
//
//        //ArrayList<Persona> Personas = clasePersona.MostrarPersonas();
//        ArrayList<Persona> Personas = clasePersona.MostrarEstudiantesSinUsuario();
//        //Creamos un array donde volcaremos los datos traidos en MostrarPersona()
//        String filas[] = new String[2];
//        for (var iterarDatoPersona : Personas) {
//            //agregamos cada dato de la consulta en un espacio del arreglo
//            filas[0] = String.valueOf(iterarDatoPersona.getIdPersona());
//            filas[1] = iterarDatoPersona.getNombre() + " " + iterarDatoPersona.getApellido();
//            //Agregamos el arreglo de los datos al modelo de la Tabla
//            ModeloTabla.addRow(filas);
//        }
//        //asignamos el modelo a la Tabla para mostrarlos al usuario
//        tbPersonas.setModel(ModeloTabla);
//    }
    
    String valueMember[];
    int contador=0;
    //Llenando el combobox
    void DisplayMember(){
        DefaultComboBoxModel cboDefault = new DefaultComboBoxModel();
        ClsPersona personaDao= new ClsPersona();
        var Personas= personaDao.MostrarPersona();
        valueMember= new String[Personas.size()];
//        JOptionPane.showMessageDialog(null, Personas.size());
        String filas[] = new String[2];
        cboDefault.addElement("");
        for (var iterarDatoPersona : Personas) {
            //agregamos cada dato de la consulta en un espacio del arreglo
            filas[0] = String.valueOf(iterarDatoPersona.getIdPersona());
            filas[1] = iterarDatoPersona.getNombre() + " " + iterarDatoPersona.getApellido();
            //Agregamos el arreglo de los datos al modelo de la Tabla
            valueMember[contador]= filas[0];
            cboDefault.addElement(filas[1]);
            contador++;
        }
        cboPersona.setModel(cboDefault);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpMostrar = new javax.swing.JTabbedPane();
        jpDatos = new javax.swing.JPanel();
        txtIdEstudiante = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtNie = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cboPersona = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        jpMostrarTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbEstudiantes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tpMostrar.setBackground(new java.awt.Color(204, 204, 255));
        tpMostrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jpDatos.setBackground(new java.awt.Color(228, 227, 233));

        txtIdEstudiante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMatricula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtNie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("PERSONA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("MATRICULA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("USUARIO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("PASSWORD");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("NIE");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cboPersona.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDatosLayout = new javax.swing.GroupLayout(jpDatos);
        jpDatos.setLayout(jpDatosLayout);
        jpDatosLayout.setHorizontalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar)
                                .addGap(14, 14, 14)
                                .addComponent(btnLimpiar))
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboPersona, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdEstudiante, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(txtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(txtUsuario)
                                .addComponent(txtPass)
                                .addComponent(txtNie)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpDatosLayout.setVerticalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addGap(10, 10, 10)
                .addComponent(txtNie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(40, 40, 40))
        );

        tpMostrar.addTab("DATOS", jpDatos);

        jpMostrarTabla.setBackground(new java.awt.Color(228, 227, 233));

        tbEstudiantes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbEstudiantes);

        javax.swing.GroupLayout jpMostrarTablaLayout = new javax.swing.GroupLayout(jpMostrarTabla);
        jpMostrarTabla.setLayout(jpMostrarTablaLayout);
        jpMostrarTablaLayout.setHorizontalGroup(
            jpMostrarTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMostrarTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpMostrarTablaLayout.setVerticalGroup(
            jpMostrarTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMostrarTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        tpMostrar.addTab("MOSTRAR DATOS", jpMostrarTabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpMostrar)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        ClsEstudiante estudianteDao = new ClsEstudiante();
        Estudiante est = new Estudiante();
        est.setMatricula(Integer.parseInt(txtMatricula.getText()));
//        est.setIdPersona(Integer.parseInt(txtIdPersona.getText()));
        int idp=cboPersona.getSelectedIndex()-1;
        JOptionPane.showMessageDialog(null, idp);
        est.setIdPersona(Integer.parseInt(valueMember[idp]));
        est.setUsu(txtUsuario.getText());
        est.setPass(txtPass.getText());
        est.setNie(txtNie.getText());
        if(txtIdEstudiante.getText().isEmpty()){
            estudianteDao.AgregarEstudiante(est);
        }else{
            est.setId(Integer.parseInt(txtIdEstudiante.getText()));
            estudianteDao.ActualizarEstudiante(est);
        }
        
        MostrarEstudiantes();
//        MostrarPersonas();
        //DisplayMember();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        ClsEstudiante estudianteDao = new ClsEstudiante();
        Estudiante est = new Estudiante();
        est.setId(Integer.parseInt(txtIdEstudiante.getText()));
        estudianteDao.EliminarEstudiante(est);
        MostrarEstudiantes();
//        MostrarPersonas();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tbEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEstudiantesMouseClicked
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "Si funciona el Evento");
        //Movernos dentro de los elementos del TabbedPane
        tpMostrar.setSelectedIndex(tpMostrar.indexOfComponent(jpDatos));
        //Obtener la fila seleccionada
        int fila = tbEstudiantes.getSelectedRow();
        //Capturando los datos de la fila seleccionada "IDESTUDIANTE", "MATRICULA", "IDPERSONA", "NOMBRE", "USUARIO", "PASSWORD", "NIE"
        String Id = String.valueOf(tbEstudiantes.getValueAt(fila, 0));
        String Matricula = String.valueOf(tbEstudiantes.getValueAt(fila, 1));
        String IdPersona = String.valueOf(tbEstudiantes.getValueAt(fila, 2));
        String Usuario = String.valueOf(tbEstudiantes.getValueAt(fila, 4));
        String Pass = String.valueOf(tbEstudiantes.getValueAt(fila, 5));
        String Nie=String.valueOf(tbEstudiantes.getValueAt(fila, 6));
        //Asignando los datos capturados al formulario
        txtIdEstudiante.setText(Id);
        txtMatricula.setText(Matricula);
//        cboPersona.setSelectedIndex(contador[]);
        txtUsuario.setText(Usuario);
        txtPass.setText(Pass);
        txtNie.setText(Nie);
        //JOptionPane.showMessageDialog(null, valueMember);
        int seleccionadordeVista =1;
        for(var iterar : valueMember){
            if(IdPersona.equals(iterar)){
                cboPersona.setSelectedIndex(seleccionadordeVista);
            }
            seleccionadordeVista+=1;
        }
    }//GEN-LAST:event_tbEstudiantesMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(crudEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new crudEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboPersona;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JPanel jpMostrarTabla;
    private javax.swing.JTable tbEstudiantes;
    private javax.swing.JTabbedPane tpMostrar;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNie;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

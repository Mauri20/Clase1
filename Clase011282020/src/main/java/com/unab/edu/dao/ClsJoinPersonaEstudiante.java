/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.dao;

import com.unab.edu.conexionmysql.ConexionBd;
import com.unab.edu.entidades.Estudiante;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class ClsJoinPersonaEstudiante {
    ConexionBd conexion = new ConexionBd();
    Connection con = conexion.retornarConexion();
    
    public ArrayList <Estudiante> MostrarJoinEstudiantePersona(){
        ArrayList<Estudiante> lista= new ArrayList<>();
        try {
            CallableStatement cst=con.prepareCall("call clase1.sp_s_JoinPersonaEstudiante();");
            ResultSet res=cst.executeQuery();
            while (res.next()) {
                Estudiante est= new Estudiante();
                est.setNombre(res.getString("Nombre"));
                est.setApellido(res.getString("Apellido"));
                est.setMatricula(res.getInt("Matricula"));
                lista.add(est);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al Traer los Estudiantes!");
        }
        return lista;
    }
}

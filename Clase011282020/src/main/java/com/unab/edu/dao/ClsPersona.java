/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.dao;

import com.unab.edu.conexionmysql.ConexionBd;
import com.unab.edu.entidades.Persona;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class ClsPersona {

    //Estableciendo la conexion
    ConexionBd claseConectar = new ConexionBd();
    Connection conectar = claseConectar.retornarConexion();

    public ArrayList<Persona> MostrarPersona() {
        //Generar la variable de retorno
        ArrayList<Persona> Personas = new ArrayList<>();
        try {
            CallableStatement Statement = conectar.prepareCall("call sp_s_Persona();");
            ResultSet resultadoDeConsulta = Statement.executeQuery();
            while (resultadoDeConsulta.next()) {
                //Objeto persona
                Persona persona = new Persona();
                //Llnando el objeto
                persona.setIdPersona(resultadoDeConsulta.getInt("idPersona"));
                persona.setNombre(resultadoDeConsulta.getString("Nombre"));
                persona.setApellido(resultadoDeConsulta.getString("Apellido"));
                persona.setEdad(resultadoDeConsulta.getInt("Edad"));
                persona.setSexo(resultadoDeConsulta.getString("sexo"));
                //Agregando el objeto a la coleccion
                Personas.add(persona);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Personas;
    }

    public void AgregarPersona(Persona persona) {
        try {
            CallableStatement Statement = conectar.prepareCall("call sp_i_Persona(?,?,?,?);");
            Statement.setString("pNombre", persona.getNombre());
            Statement.setString("pApellido", persona.getApellido());
            Statement.setInt("pEdad", persona.getEdad());
            Statement.setString("pSexo", persona.getSexo());
            //Esto devuelve un dato al realizar la consulta
            //ResultSet resultado= Statement.executeQuery();
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Datos ingresados Exitosamente!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar los Datos " + e);

        }
    }

    public void EliminarPersona(Persona persona) {
        try {
            CallableStatement Statement = conectar.prepareCall("call sp_d_Persona(?);");
            Statement.setInt("pIdPersona", persona.getIdPersona());
            //Esto devuelve un dato al realizar la consulta
            //ResultSet resultado= Statement.executeQuery();
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Persona Eliminado de la Base de Datos!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar los Datos " + e);

        }
    }
    public void ActualizarPersona(Persona persona) {
        try {
            CallableStatement Statement = conectar.prepareCall("call sp_u_Persona(?,?,?,?,?);");
            Statement.setInt("pIdPersona", persona.getIdPersona());
            Statement.setString("pNombre", persona.getNombre());
            Statement.setString("pApellido", persona.getApellido());
            Statement.setInt("pEdad", persona.getEdad());
            Statement.setString("pSexo", persona.getSexo());
            //Esto devuelve un dato al realizar la consulta
            //ResultSet resultado= Statement.executeQuery();
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Datos Actualizados Exitosamente!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar los Datos " + e);

        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.dao;

import com.unab.edu.conexionmysql.ConexionBd;
import com.unab.edu.entidades.Profesor;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class ClsProfesor {

    ConexionBd cn = new ConexionBd();
    Connection con = cn.retornarConexion();

    public boolean LoginProfesor(String pUsuario, String pPass) {
        boolean retorno = false;
        try {
            CallableStatement statement = con.prepareCall("call sp_s_loginProfesor(?,?);");
            statement.setString("pUsuario", pUsuario);
            statement.setString("pPass", pPass);
            ResultSet res = statement.executeQuery();
            Profesor prof = new Profesor();
            while (res.next()) {
                prof.setId(res.getInt("idProfesor"));
                prof.setIdPersona(res.getInt("IdPersona"));
                prof.setDui(res.getString("Dui"));
                prof.setUsuario(res.getString("Usu"));
                prof.setPass(res.getString("Pass"));
            }
            String passnueva = prof.getPass();
            pPass = passnueva;
            //Es un poco innecesario hacer el IF porque si el while llena el prof quiere
            //decir que encontro un dato, y seria extraño que hubieran 2 usuarios con los mismos datos
            if (prof.getUsuario() != null) {
                //Si logró entrar aqui significa que encontro coincidencias en la base de datos 
                //con los datos ingresados (El pass ya va encriptado en la comparacion)
                if (prof.getUsuario().equals(pUsuario) && prof.getPass().equals(pPass)) {
                    retorno = true;
                }
            }
            con.close();
        } catch (Exception e) {
            //Para comprobacion de errores en la consulta
            //JOptionPane.showMessageDialog(null, " "+e);
        }
        return retorno;
    }

    public ArrayList<Profesor> MostrarProfesores() {
        var listado = new ArrayList<Profesor>();
        try {
            CallableStatement statement = con.prepareCall("call sp_s_Profesor;");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Profesor profe = new Profesor();
                profe.setId(res.getInt("idProfesor"));
                profe.setIdPersona(res.getInt("IdPersona"));
                profe.setDui(res.getString("Dui"));
                profe.setUsuario(res.getString("Usu"));
                profe.setPass(res.getString("Pass"));
                profe.setNombre(res.getString("Nombre"));
                listado.add(profe);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los Profesores " + e);
        }

        return listado;
    }

    public void AgregarProfesor(Profesor profesor) {
        try {
            CallableStatement statement = con.prepareCall("call sp_i_Profesor(?,?,?,?);");
            statement.setInt("pIdPersona", profesor.getIdPersona());
            statement.setString("pDui", profesor.getDui());
            statement.setString("pUsuario", profesor.getUsuario());
            statement.setString("pPass", profesor.getPass());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Profesor registrado Correctamente!");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar los Datos! "+e);
        }
    }
     public void EliminarProfesor(Profesor profesor) {
        try {
            CallableStatement statement = con.prepareCall("call sp_d_Profesor(?);");
            statement.setInt("pIdProfesor", profesor.getId());
            //Esto devuelve un dato al realizar la consulta
            //ResultSet resultado= Statement.executeQuery();
            statement.execute();
            JOptionPane.showMessageDialog(null, "Profesor Eliminado de la Base de Datos!");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar los Datos " + e);

        }
    }
    public void ActualizarProfesor(Profesor profesor, boolean pass) {
        try {
            CallableStatement  statement;
            if(pass==false){
                statement = con.prepareCall("call sp_u_Profesor(?,?,?,?,?);");
            }else{
                statement = con.prepareCall("call sp_u_Profesor2(?,?,?,?,?);");
            }
            statement.setInt("pIdProfesor", profesor.getId());
            statement.setInt("pIdPersona", profesor.getIdPersona());
            statement.setString("pDui", profesor.getDui());
            statement.setString("pUsuario", profesor.getUsuario());
            statement.setString("pPass", profesor.getPass());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Profesor Actualizado Correctamente!");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar los Datos! "+e);
        }
    }
}

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
public class ClsEstudiante {

    ConexionBd cn = new ConexionBd();
    Connection con = cn.retornarConexion();

    public ArrayList<Estudiante> MostrarEstudiantes() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        try {
            CallableStatement statement = con.prepareCall("call sp_s_Estudiante();");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Estudiante est = new Estudiante();
                est.setId(res.getInt("idEstudiante"));
                est.setMatricula(res.getInt("Matricula"));
                est.setIdPersona(res.getInt("idPersona"));
                est.setUsu(res.getString("Usu"));
                est.setPass(res.getString("Pass"));
                est.setNie(res.getString("NIE"));
                est.setNombre(res.getString("Nombre"));
                lista.add(est);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se cargaron los Estudiantes " + e);
        }
        return lista;
    }

    public boolean LoginEstudiante(String pUsuario, String pPass) {
        boolean retorno = false;
        try {
            CallableStatement statement = con.prepareCall("call sp_s_loginEstudiante(?,?);");
            statement.setString("pUsuario", pUsuario);
            statement.setString("pPass", pPass);
            ResultSet res = statement.executeQuery();
            Estudiante est = new Estudiante();
            while (res.next()) {
                est.setId(res.getInt("idEstudiante"));
                est.setMatricula(res.getInt("Matricula"));
                est.setUsu(res.getString("Usu"));
                est.setPass(res.getString("Pass"));
                est.setNie(res.getString("NIE"));
            }
            //Es un poco innecesario hacer el IF porque si el while llena el est quiere
            //decir que encontro un dato, y seria extraño que hubieran 2 usuarios con los mismos datos
            if (est.getUsu() != null) {
                //Si logro entrar aqui significa que encontro coincidencias en la base de datos 
                //con las credenciales ingresadas (El pass ya va encriptado en la comparacion)
                if (est.getUsu().equals(pUsuario)) {
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

    public void AgregarEstudiante(Estudiante estudiante) {
        try {
            CallableStatement statement = con.prepareCall("call sp_i_Estudiante(?,?,?,?,?);");
            statement.setInt("pMatricula", estudiante.getMatricula());
            statement.setInt("pIdPersona", estudiante.getIdPersona());
            statement.setString("pUsuario", estudiante.getUsu());
            statement.setString("pPass", estudiante.getPass());
            statement.setString("pNie", estudiante.getNie());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Estudiante Registrado Correctamente!");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al Guardar!" + e);

        }

    }

    public void EliminarEstudiante(Estudiante estudiante) {
        try {
            CallableStatement statement = con.prepareCall("call sp_d_Estudiante(?);");
            statement.setInt("pIdEstudiante", estudiante.getId());
            //Esto devuelve un dato al realizar la consulta
            //ResultSet resultado= Statement.executeQuery();
            statement.execute();
            JOptionPane.showMessageDialog(null, "Estudiante Eliminado de la Base de Datos!");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al eliminar los Datos " + e);

        }
    }

    public void ActualizarEstudiante(Estudiante estudiante) {
        try {
            CallableStatement statement = con.prepareCall("call sp_u_Estudiante(?,?,?,?,?,?);");
            statement.setInt("pIdEstudiante", estudiante.getId());
            statement.setInt("pMatricula", estudiante.getMatricula());
            statement.setInt("pIdPersona", estudiante.getIdPersona());
            statement.setString("pUsuario", estudiante.getUsu());
            statement.setString("pPass", estudiante.getPass());
            statement.setString("pNie", estudiante.getNie());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Estudiante Actualizado Correctamente!");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al Actualizar! " + e);

        }

    }
}

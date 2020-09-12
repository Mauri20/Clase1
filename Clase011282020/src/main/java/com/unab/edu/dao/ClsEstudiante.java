/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.dao;

import com.unab.edu.conexionmysql.ConexionBd;
import com.unab.edu.entidades.Estudiante;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class ClsEstudiante {

    ConexionBd cn = new ConexionBd();
    Connection con = cn.retornarConexion();

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
            if (est.getUsu().equals(pUsuario) && est.getPass().equals(pPass)) {
                retorno = true;
            }
            con.close();
        } catch (Exception e) {
            //Para comprobacion de errores en la consulta
            //JOptionPane.showMessageDialog(null, " "+e);
        }
        return retorno;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Mauricio
 * La anotacion @Data viene de la libreria de lombok
 * me sirve para crear los metodos de Get y Set automaticamente
 */
@Data
public class Persona {
    protected int IdPersona;
    protected String Nombre;
    protected String Apellido;
    protected int Edad;
    protected String Sexo;
    protected Date Fecha;
}

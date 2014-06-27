/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soluciones.web;

/**
 *
 * @author campitos
 */
public class TestUsuarios {
    
    public static void main(String args[]){
       DAOUsuario3Impl uu=new DAOUsuario3Impl();
       uu.agregarProducto(new Usuario3("ggga","xxx",'N'));
        System.out.println("Usuario agregado con mucho exito");
    }
    
}

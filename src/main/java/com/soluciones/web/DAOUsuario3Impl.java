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
public class DAOUsuario3Impl extends DAO {
    
    public void agregarProducto(Usuario3 usuario) {
    begin();
    getSession().save(usuario);
    commit();
    close();
    
    }  
}

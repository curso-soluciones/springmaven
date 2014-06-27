/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soluciones.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author campitos
 */
@Entity
@Table(name="usuario2")
public class Usuario3 {
    
    @Id
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="admin_rol")
    private Character admin_rol;

    public Usuario3() {
    }

    public Usuario3(String email, String password, Character admin_rol) {
        this.email = email;
        this.password = password;
        this.admin_rol = admin_rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getAdmin_rol() {
        return admin_rol;
    }

    public void setAdmin_rol(Character admin_rol) {
        this.admin_rol = admin_rol;
    }

    @Override
    public String toString() {
        return "Usuario3{" + "email=" + email + ", password=" + password + ", admin_rol=" + admin_rol + '}';
    }
    
    
}

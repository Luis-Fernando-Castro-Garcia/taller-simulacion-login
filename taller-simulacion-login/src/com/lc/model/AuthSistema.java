/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.model;

import java.util.ArrayList;

public class AuthSistema {
    
    private ArrayList<Usuario> listaUsuarios;
    
    public AuthSistema() {
        listaUsuarios = new ArrayList<>();
        crearUsuarios();
    }
    
    private void crearUsuarios() {
        listaUsuarios.add(new Usuario(
                "Luis",
                "2025499",
                "Luis Castro",
                Rol.ADMIN
        ));
        
        listaUsuarios.add(new Usuario(
                "Cristopher",
                "2023081",
                "Cristopher Huaz",
                Rol.USER
        ));
        
        listaUsuarios.add(new Usuario(
                "Javier",
                "2023184",
                "Javier Hernández",
                Rol.ADMIN
        ));
        
        listaUsuarios.add(new Usuario(
                "Jefferson",
                "2023430",
                "Jefferson Mazul",
                Rol.USER
        ));
    }
    
    public Usuario login(String user, String pass) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre_usuario().equals(user) && usuario.getPassword().equals(pass)) {
                return usuario;
            }
        }
        return null;
    }
}

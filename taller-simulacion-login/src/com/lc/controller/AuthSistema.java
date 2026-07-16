/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.controller;

import com.lc.model.Rol;
import com.lc.model.Usuario;
import java.util.ArrayList;

public class AuthSistema {

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public AuthSistema() {
        Usuario usuarioAdmin = new Usuario(
                "Admin",
                "Admin",
                "Admin",
                Rol.ADMIN
        );

        Usuario usuarioUser = new Usuario(
                "User",
                "User",
                "User",
                Rol.USER
        );

        Usuario usuarioYo = new Usuario(
                "Luis",
                "123456789",
                "Luis Castro",
                Rol.USER
        );

        listaUsuarios.add(usuarioAdmin);
        listaUsuarios.add(usuarioUser);
        listaUsuarios.add(usuarioYo);
    }

    public Usuario login(String nombreUsuario, String clave) {
        for (Usuario user : listaUsuarios) {
            if (user.getNombreUsuario().equals(nombreUsuario) && user.getPassword().equals(clave)) {
                return user;
            }
        }
        return null;
    }
}

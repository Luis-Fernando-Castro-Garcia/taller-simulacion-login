/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.controller;

import com.lc.model.AuthSistema;
import com.lc.model.Usuario;
import com.lc.view.LoginView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController {

    private final LoginView LOGIN_VIEW;
    private double ejeX = 0;
    private double ejeY = 0;
    private Stage escenario = SceneManager.getInstanciaSceneManager().getEscenarioPrincipal();

    public LoginController(LoginView loginView) {
        this.LOGIN_VIEW = loginView;
        construirAcciones();
    }

    public void construirAcciones() {
        this.LOGIN_VIEW.getBtnCerrarVentana().setOnMouseClicked(
                (e) -> {
                    System.exit(0);
                });

        this.LOGIN_VIEW.setOnMouseClicked(
                (e) -> {
                    ejeX = e.getSceneX();
                    ejeY = e.getSceneY();
                });

        this.LOGIN_VIEW.setOnMouseDragged(
                (e) -> {
                    double ejeXVentanaDesplazamiento = e.getScreenX();
                    double ejeYVentanaDesplazamiento = e.getScreenY();

                    System.out.println("Xd: " + (ejeXVentanaDesplazamiento - ejeX));
                    System.out.println("Yd: " + (ejeYVentanaDesplazamiento - ejeY));

                    escenario.setX((ejeXVentanaDesplazamiento - ejeX));
                    escenario.setY((ejeYVentanaDesplazamiento - ejeY));
                });

        this.LOGIN_VIEW.getBtnIniciarSesion().setOnMouseClicked(
                (e) -> {
                    iniciarSesion();
                });
    }

    private AuthSistema authSistemas = new AuthSistema();

    public void iniciarSesion() {
        String nombreUsuario = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String clave = this.LOGIN_VIEW.getPwdClave().getText().trim();

        if (nombreUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO DEJE EL CAMPO NOMBRE VACIO");
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("empty");
        } else if (clave.isEmpty()) {
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().remove("empty");
            this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");
            JOptionPane.showMessageDialog(null, "NO DEJE EL CAMPO CONTRASEÑA VACIA");
        } else {
            this.LOGIN_VIEW.getPwdClave().getStyleClass().remove("empty");
            Usuario usuario = authSistemas.login(nombreUsuario, clave);
            if (usuario == null) {
                JOptionPane.showMessageDialog(null, "VALIDE SUS CREDENCIALES");
            } else {
                JOptionPane.showMessageDialog(null, "Oa");
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.controller;

import com.lc.model.Usuario;
import com.lc.view.LoginView;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class LoginController {

    private final LoginView LOGIN_VIEW;
    private final AuthSistema authSistema = new AuthSistema();
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

        this.LOGIN_VIEW.setOnMousePressed(
                (e) -> {
                    ejeX = e.getSceneX();
                    ejeY = e.getSceneY();
                });

        this.LOGIN_VIEW.setOnMouseDragged(
                (e) -> {
                    double ejeXVentanaDesplazamiento = e.getScreenX();
                    double ejeYVentanaDesplazamiento = e.getScreenY();

                    escenario.setX((ejeXVentanaDesplazamiento - ejeX));
                    escenario.setY((ejeYVentanaDesplazamiento - ejeY));
                });

        this.LOGIN_VIEW.getBtnIniciarSesion().setOnMouseClicked(
                (e) -> {
                    iniciarSesion();
                });
    }

    private void iniciarSesion() {
        String nombreUsuario = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String clave = this.LOGIN_VIEW.getPwdClave().getText().trim();

        limpiarEstilosDeCampos();

        if (nombreUsuario.isEmpty()) {
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("empty");
            mostrarAlerta("AVISO: ", "No deje el campo Usuario vacío");
        } else if (clave.isEmpty()) {
            this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");
            mostrarAlerta("AVISO: ", "No deje el campo Contraseña vacío");
        } else {
            Usuario usuario = authSistema.login(nombreUsuario, clave);
            if (usuario == null) {
                this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("error");
                this.LOGIN_VIEW.getPwdClave().getStyleClass().add("error");
                mostrarAlerta("AVISO: ", "Credenciales inválidas");
            } else {
                SceneManager.getInstanciaSceneManager().ventanaBienvenida(usuario.getNombreCompleto());
            }
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarEstilosDeCampos() {
        this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().removeAll("empty", "error");
        this.LOGIN_VIEW.getPwdClave().getStyleClass().removeAll("empty", "error");
    }
}

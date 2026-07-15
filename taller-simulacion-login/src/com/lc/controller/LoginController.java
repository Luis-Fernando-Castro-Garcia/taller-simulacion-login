/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.controller;

import com.lc.view.LoginView;
import javafx.stage.Stage;

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
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class LoginView extends BorderPane {
    
    private static LoginView instanciaLoginView;
    private HBox barraDeVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;
    
    private LoginView() {
        barraDeVentana = new HBox(20);
        btnCerrarVentana = new Button("X");
        lblTituloVentana = new Label("JAVAFX - MAT - SIMULADOR LOGIN");
        
        barraDeVentana.getChildren().addAll(btnCerrarVentana, lblTituloVentana);
        this.setTop(barraDeVentana);
    }
    
    public static LoginView getInstanciaLoginView() {
        if (instanciaLoginView == null) {
            instanciaLoginView = new LoginView();
        }
        return instanciaLoginView;
    }
    
    public static void setInstanciaLoginView(LoginView instanciaLoginView) {
        LoginView.instanciaLoginView = instanciaLoginView;
    }
}

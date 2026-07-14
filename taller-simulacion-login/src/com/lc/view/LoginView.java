/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

public class LoginView extends BorderPane {

    private static LoginView instanciaLoginView;
    private HBox barraDeVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;

    private LoginView() {
        this.setPadding(new Insets(20));

        this.setBorder(new Border(
                new BorderStroke(Paint.valueOf("3B0570"), //color del borde.
                        BorderStrokeStyle.SOLID, //estilo de línea 
                        new CornerRadii(25), // pixeles de redondeado
                        new BorderWidths(5)) //ancho del borde
        ));
        
        this.setBackground(new Background(
                new BackgroundFill(Paint.valueOf("3B0570"), //color del fondo
                        new CornerRadii(25), //pixeles de redondeado
                        Insets.EMPTY //espaciado del fondo
                )
        ));
        
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

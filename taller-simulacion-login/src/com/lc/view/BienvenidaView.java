/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.view;

import com.lc.controller.ImageController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;

public class BienvenidaView extends VBox {

    private final Label lblBienvenida;
    private final String RUTA_ESTILOS = "/com/lc/styles/";
    private ImageView imgLogo;
    private Button btnCerrarVentana;
    private HBox barraSuperior;
    private Label lblTitulo;

    public BienvenidaView(String nombreCompleto) {
        this.getStylesheets().add(RUTA_ESTILOS + "BienvenidaStyle.css");
        this.getStyleClass().add("bienvenida-root");
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));

        barraSuperior = new HBox(15);
        barraSuperior.getStyleClass().add("barra-superior");
        barraSuperior.setAlignment(Pos.CENTER_LEFT);
        barraSuperior.setPadding(new Insets(5, 10, 5, 10));

        btnCerrarVentana = new Button("X");
        btnCerrarVentana.getStyleClass().add("button-cerrar");

        lblTitulo = new Label("BIENVENIDO");
        lblTitulo.getStyleClass().add("titulo-barra");

        barraSuperior.getChildren().addAll(btnCerrarVentana, lblTitulo);

        imgLogo = new ImageView(new ImageController().getImageLogin("logo"));
        imgLogo.setFitHeight(140);
        imgLogo.setFitWidth(140);

        Circle clip = new Circle(70, 70, 70);
        imgLogo.setClip(clip);
        imgLogo.setCache(true);
        imgLogo.getStyleClass().add("logo-bienvenida");

        lblBienvenida = new Label("Bienvenido, " + nombreCompleto);
        lblBienvenida.getStyleClass().add("titulo-bienvenida");
        lblBienvenida.setWrapText(true);

        Label lblMensaje = new Label("Inicio de sesión exitoso");
        lblMensaje.getStyleClass().add("mensaje-bienvenida");

        this.getChildren().addAll(
                barraSuperior,
                imgLogo,
                lblBienvenida,
                lblMensaje
        );
    }

    public Button getBtnCerrarVentana() {
        return btnCerrarVentana;
    }
}

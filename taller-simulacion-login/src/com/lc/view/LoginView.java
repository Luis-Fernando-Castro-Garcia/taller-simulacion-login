/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.view;

import com.lc.controller.ImageController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class LoginView extends BorderPane {

    private static LoginView instanciaLoginView;
    private HBox barraDeVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;
    private ImageView imgLogoLogin;
    private TextField txtNombreUsuario;
    private Label lblNombreUsuario;
    private PasswordField pwdClave;
    private Label lblClave;
    private GridPane formulario;
    private Button btnIniciarSesion;
    private VBox cajaVertical;
    private final String RUTA_ESTILOS = "/com/lc/styles/";

    private LoginView() {
        this.getStylesheets().add(RUTA_ESTILOS + "LoginStyles.css");
        this.getStyleClass().add("login-root");
        this.setPadding(new Insets(20));

        barraDeVentana = new HBox(20);
        barraDeVentana.getStyleClass().add("barra-superior");
        barraDeVentana.setAlignment(Pos.CENTER_LEFT);
        barraDeVentana.setPadding(new Insets(5, 10, 5, 10));
        btnCerrarVentana = new Button("X");
        btnCerrarVentana.getStyleClass().add("button-cerrar");
        lblTituloVentana = new Label("SIMULADOR LOGIN");
        lblTituloVentana.getStyleClass().add("titulo-login");

        barraDeVentana.getChildren().addAll(btnCerrarVentana, lblTituloVentana);
        this.setTop(barraDeVentana);

        cajaVertical = new VBox(25);
        cajaVertical.getStyleClass().add("contenedor-login");
        formulario = new GridPane();
        formulario.getStyleClass().add("formulario-login");
        formulario.setHgap(20);
        formulario.setVgap(18);
        formulario.setAlignment(Pos.CENTER);

        lblNombreUsuario = new Label("Usuario:");
        lblNombreUsuario.getStyleClass().add("label-login");
        txtNombreUsuario = new TextField();
        txtNombreUsuario.getStyleClass().add("campo-login");

        lblClave = new Label("Contraseña:");
        lblClave.getStyleClass().add("label-login");
        pwdClave = new PasswordField();
        pwdClave.getStyleClass().add("campo-login");

        btnIniciarSesion = new Button("Iniciar Sesión");
        btnIniciarSesion.getStyleClass().add("button-ingresar");

        formulario.add(lblNombreUsuario, 0, 0);
        formulario.add(txtNombreUsuario, 1, 0);

        formulario.add(lblClave, 0, 1);
        formulario.add(pwdClave, 1, 1);

        VBox.setMargin(formulario, new Insets(10, 0, 5, 0));
        VBox.setMargin(btnIniciarSesion, new Insets(15, 0, 0, 0));

        imgLogoLogin = new ImageView(new ImageController().getImageLogin("logo"));
        imgLogoLogin.setFitWidth(200);
        imgLogoLogin.setFitHeight(200);
        imgLogoLogin.setCache(true);

        Circle clip = new Circle(100, 100, 100);
        imgLogoLogin.setClip(clip);
        imgLogoLogin.getStyleClass().add("logo-login");

        cajaVertical.setPadding(new Insets(20));
        cajaVertical.setAlignment(Pos.CENTER);

        cajaVertical.getChildren().addAll(imgLogoLogin, formulario, btnIniciarSesion);
        this.setCenter(cajaVertical);
    }

    public static LoginView getInstanciaLoginView() {
        if (instanciaLoginView == null) {
            instanciaLoginView = new LoginView();
        }
        return instanciaLoginView;
    }

    public Button getBtnCerrarVentana() {
        return btnCerrarVentana;
    }

    public TextField getTxtNombreUsuario() {
        return txtNombreUsuario;
    }

    public PasswordField getPwdClave() {
        return pwdClave;
    }

    public Button getBtnIniciarSesion() {
        return btnIniciarSesion;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.controller;

import com.lc.view.BienvenidaView;
import com.lc.view.LoginView;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class SceneManager {

    private static SceneManager instanciaSceneManager;
    private Stage escenarioPrincipal;
    private Scene escenaPrincipal;

    private SceneManager() {
    }

    public void cambiarEscenaPrincipal(Pane panel, int ancho, int alto) {
        try {
            escenaPrincipal = new Scene(panel, ancho, alto);
            escenarioPrincipal.setScene(escenaPrincipal);
            escenarioPrincipal.sizeToScene();
            escenarioPrincipal.show();
        } catch (Exception error) {
            manejarError("Cambiar Escena Principal", error);
        }
    }

    public void ventanaLogin() {
        try {
            this.escenarioPrincipal.initStyle(StageStyle.TRANSPARENT);
            LoginView vistaLogin = LoginView.getInstanciaLoginView();
            cambiarEscenaPrincipal(vistaLogin, 700, 600);
            this.escenaPrincipal.setFill(Color.TRANSPARENT);
            new LoginController(vistaLogin);
        } catch (Exception error) {
            manejarError("Ventana Login", error);
        }
    }

    public void ventanaBienvenida(String nombreCompleto) {
        try {
            this.escenarioPrincipal.close();

            Stage escenarioSecundario = new Stage();
            escenarioSecundario.initStyle(StageStyle.TRANSPARENT);
            escenarioSecundario.initModality(Modality.APPLICATION_MODAL);

            BienvenidaView bienvenida = new BienvenidaView(nombreCompleto);
            bienvenida.getBtnCerrarVentana().setOnAction((e) -> escenarioSecundario.close());
            Scene escenaBienvenida = new Scene(bienvenida, 500, 400);
            escenaBienvenida.setFill(Color.TRANSPARENT);

            escenarioSecundario.setScene(escenaBienvenida);
            escenarioSecundario.sizeToScene();
            escenarioSecundario.showAndWait();
        } catch (Exception error) {
            manejarError("Ventana Bienvenida", error);
        }
    }

    private void manejarError(String contexto, Exception error) {
        JOptionPane.showMessageDialog(null, "Error en " + contexto + ": " + error.getMessage());
        error.printStackTrace();
    }

    public static SceneManager getInstanciaSceneManager() {
        if (instanciaSceneManager == null) {
            instanciaSceneManager = new SceneManager();
        }
        return instanciaSceneManager;
    }

    public Stage getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
}

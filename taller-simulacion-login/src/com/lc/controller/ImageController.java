/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.controller;

import javafx.scene.image.Image;

public class ImageController {

    private final String RUTA_IMAGENES = "/com/lc/resources/";

    /**
     * Metodo que utiliza el patron Factory, para crear diferentes imagenes y
     * retornarlas
     *
     * @param nombreImagen El nombre de la imagen a crear
     * @return la imagen a mostrar
     */
    public Image getImageLogin(String nombreImagen) {
        Image imagenAMostrar;
        switch (nombreImagen) {
            case "logo":
                imagenAMostrar = new Image(RUTA_IMAGENES + "PibbleGif.gif");
                break;
            default:
                imagenAMostrar = new Image(RUTA_IMAGENES + "PibbleGif.gif");
        }
        return imagenAMostrar;
    }
}

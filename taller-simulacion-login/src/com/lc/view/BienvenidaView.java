/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lc.view;

import javafx.scene.layout.VBox;

public class BienvenidaView extends VBox {

    private static BienvenidaView instanciaBienvenidaView;

    public BienvenidaView() {
    }

    public static BienvenidaView getInstanciaBienvenidaView() {
        if (instanciaBienvenidaView == null) {
            instanciaBienvenidaView = new BienvenidaView();
        }
        return instanciaBienvenidaView;
    }

    public static void setInstanciaBienvenidaView(BienvenidaView instanciaBienvenidaView) {
        BienvenidaView.instanciaBienvenidaView = instanciaBienvenidaView;
    }
}

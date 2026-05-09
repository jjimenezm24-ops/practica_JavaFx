package com.practica.productos.app;


import com.practica.productos.modelo.Producto;
import com.practica.productos.servicio.ProductoService;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        ProductoService servicio = new ProductoService();

        TextField campo = new TextField();

        campo.setPromptText("Ingrese producto");

        Button agregar = new Button("Agregar");

        Button eliminar = new Button("Eliminar");

        Button buscar = new Button("Buscar");

        TextArea area = new TextArea();

        area.setEditable(false);

        agregar.setOnAction(e -> {

            try {

                Producto p = new Producto(campo.getText());

                servicio.agregar(p);

                String texto = "";

                for (Producto producto : servicio.listar()) {

                    texto += producto.getNombre() + "\n";
                }

                area.setText(texto);

                campo.clear();

            } catch (Exception ex) {

                area.setText(ex.getMessage());
            }

        });

        eliminar.setOnAction(e -> {

            servicio.eliminar(campo.getText());

            String texto = "";

            for (Producto producto : servicio.listar()) {

                texto += producto.getNombre() + "\n";
            }

            area.setText(texto);

            campo.clear();
        });

        buscar.setOnAction(e -> {

            Producto encontrado =
                    servicio.buscar(campo.getText());

            if (encontrado != null) {

                area.setText(
                        "Encontrado: "
                        + encontrado.getNombre()
                );

            } else {

                area.setText("Producto no encontrado");
            }

        });

        HBox botones =
                new HBox(10, agregar, eliminar, buscar);

        VBox layout =
                new VBox(10, campo, botones, area);

        Scene scene =
                new Scene(layout, 400, 300);

        stage.setScene(scene);

        stage.setTitle("CRUD Productos");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

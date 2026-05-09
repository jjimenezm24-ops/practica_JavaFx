package com.practica.productos.app;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
@Override
public void start(Stage stage) {

TextField campo = new TextField();
Button boton = new Button("Mostrar");
Label label = new Label();
boton.setOnAction(e -> {
label.setText(campo.getText());
});
VBox layout = new VBox(10, campo, boton, label);
Scene scene = new Scene(layout, 300, 200);
stage.setScene(scene);
    stage.show();
}
}

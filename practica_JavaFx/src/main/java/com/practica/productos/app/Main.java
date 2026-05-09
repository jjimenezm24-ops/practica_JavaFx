public class Main extends Application {
@Override
public void start(Stage stage) {
Label label = new Label("Hola JavaFX");
Scene scene = new Scene(new VBox(label), 300, 200);
stage.setScene(scene);
stage.show();
}
}

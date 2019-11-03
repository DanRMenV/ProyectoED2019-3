package Interfaz;

import business.EstudiantesManager;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	
	private double xOffset;
	private double yOffset;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = 	FXMLLoader.load(getClass().getResource("sample.fxml"));
		
		root.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		
		root.setOnMouseDragged(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getScreenY() - yOffset);
			}
		});
		
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setTitle("Login");
		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	static long TInicio, TFin, tiempo;
	static EstudiantesManager lst_stud = new EstudiantesManager();
	
	public static void main(String[] args) {	
		TInicio = System.currentTimeMillis(); 
		lst_stud.readStudents("datosPrueba1000000.txt");
		TFin = System.currentTimeMillis();  
		tiempo = TFin - TInicio;
		System.out.println("Tiempo de ejecución en nanosegundos carga datos: " + tiempo); 
		
		TInicio = System.currentTimeMillis(); 
		lst_stud.searchEstudiante(10000);
		TFin = System.currentTimeMillis(); 
		tiempo = TFin - TInicio;
		System.out.println("Tiempo de ejecución en mili consulta 1 dato: " + tiempo); 
		launch(args);
}
}

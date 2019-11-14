package gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import com.jfoenix.controls.*;
import business.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import data.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Callback;

import javax.swing.*;

public class Controller implements Initializable{
	static AdminManager lst_admin = new AdminManager();
	static EstudiantesManager lst_stud = new EstudiantesManager();
	static CursoManager lst_curso = new CursoManager();
	
	//Login bienvenida
	@FXML private AnchorPane Login1;
	@FXML private AnchorPane Login2;
	@FXML private AnchorPane Prueba;

	@FXML private JFXTextField UserField;
	@FXML private JFXPasswordField PasswordField;
	
	@FXML private Label IngresarError;
	@FXML private Text bienvenida;
	
	//Anadir estudiante
	@FXML private AnchorPane AddEstudiante;
	
	@FXML private JFXTextField inIdEst;
	@FXML private JFXTextField inNomEst;
	@FXML private JFXTextField inApeEst;
	
	@FXML private JFXDatePicker inFecNac;
	@FXML private JFXComboBox<String> inCurso;

	//Lista Estudiantes
	@FXML private JFXTreeTableView<Student> Lista;
	@FXML private AnchorPane VerLista;
	@FXML private JFXTextField buscar;
	@FXML private JFXComboBox<String> BoxCurso;

	ObservableList<String> ListaCursoContent =
			FXCollections.observableArrayList(
					"1", "2", "3", "4", "5", "6", "7", "8",
					"9", "10", "11");
	
	ObservableList<String> comboCursos =
			FXCollections.observableArrayList(
	        "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo", 
	        "Noveno", "Decimo", "Once");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Datos
		lst_admin.addAdminUser(new Admin("juanse","123456"));
		lst_admin.addAdminUser(new Admin("crack yo","09786"));
		lst_admin.addAdminUser(new Admin("babb","12345444"));
		lst_admin.addAdminUser(new Admin("nel","1245"));
		lst_admin.addAdminUser(new Admin("trolazo","696969"));
		for(int a=1; a<=11; a++) {
			String name;
			if(a == 1)name="Primero";
			else if(a == 2)name="Segundo";
			else if(a == 3)name="Tercero";
			else if(a == 4)name="Cuarto";
			else if(a == 5)name="Quinto";
			else if(a == 6)name="Sexto";
			else if(a == 7)name="Septimo";
			else if(a == 8)name="Octavo";
			else if(a == 9)name="Noveno";
			else if(a == 10)name="Decimo";
			else name="Undecimo";
			lst_curso.addCurso(new Curso(a,name));
		}
		lst_curso.FindCurso(1).est_curso.addEstudianteBST(3, "s", "r", 7, 7, 2007, 1);
		lst_curso.FindCurso(1).addNumStud();
		lst_curso.FindCurso(1).est_curso.addEstudianteBST(1, "s4", "rdfg", 7, 7, 2007, 1);
		lst_curso.FindCurso(1).addNumStud();
		lst_curso.FindCurso(1).est_curso.addEstudianteBST(5, "s3", "rdgg", 7, 7, 2007, 1);
		lst_curso.FindCurso(1).addNumStud();
		lst_curso.FindCurso(1).est_curso.addEstudianteBST(6, "s5tg", "sdfsdfr", 7, 7, 2007, 1);
		lst_curso.FindCurso(1).addNumStud();
		lst_curso.FindCurso(1).est_curso.addEstudianteBST(7, "sdf", "rdddd", 7, 7, 2007, 1);
		lst_curso.FindCurso(1).addNumStud();
		lst_curso.readStudents("ProyectoED/datosPrueba100.txt");
		//Elementos graficos
		inCurso.setItems(comboCursos);
		BoxCurso.setItems(ListaCursoContent);
	}
	
	public void onExitButtonClicked(MouseEvent event) {
		Platform.exit();
		System.exit(0);
	}

	public void onExitMenuButtonClicked(MouseEvent event) {
		Platform.exit();
		System.exit(0);
	}

	public void onExitListaButtonClicked(MouseEvent event) {
		VerLista.setVisible(false);
		Prueba.setVisible(true);
	}
	
	public void onIngresarButtonClicked(MouseEvent event) {
		String temp_user="",temp_password="";
		temp_user = UserField.getText();
		temp_password = PasswordField.getText();
		boolean ver=lst_admin.ValUser(new Admin(temp_user,temp_password));	
		if(ver) {
			bienvenida.setText("Bienvenido "+temp_user+" que desea hacer?");
			Login1.setVisible(false);
			Login2.setVisible(false);
			Prueba.setVisible(true);
			
		}else {
			IngresarError.setVisible(true);
			UserField.setText("");
			PasswordField.setText("");	
		}	
	}
	
	public void onAnadirIcon(MouseEvent event) {
		Prueba.setVisible(false);
		AddEstudiante.setVisible(true);
		inNomEst.setText("");
		inApeEst.setText("");
		inFecNac.setValue(null);
		inCurso.setValue("");
	}
	
	
	public void onIngresoEstudiante() {		
		String temp_id="",temp_nombres="",temp_apellidos="",temp_curso="";
		
		int id=0;
		temp_id=inIdEst.getText();
		id=Integer.parseInt(temp_id);
		temp_nombres = inNomEst.getText();
		temp_apellidos = inApeEst.getText();
		
		LocalDate fecha_nac=inFecNac.getValue();
		int temp_day=fecha_nac.getDayOfMonth();
		int temp_month=fecha_nac.getMonthValue();
		int temp_year=fecha_nac.getYear();
		temp_curso=inCurso.getValue();
		
		Calendar fecha=new GregorianCalendar(temp_year,temp_month,temp_day);
		Estudiante tmpNew=new Estudiante(id,temp_nombres,temp_apellidos,fecha,temp_curso);
		lst_stud.addEstudiante(tmpNew);
		
		AddEstudiante.setVisible(false);
		Prueba.setVisible(true);
		
		lst_stud.listaEstudiantes();
	}

	public void onListaButoon(MouseEvent event){
		Prueba.setVisible(false);
		VerLista.setVisible(true);
	}

	public void onComboCursoChanged(ActionEvent event){
		Lista.setDisable(false);
		for(int i=0; i<ListaCursoContent.size(); i++){
			if(BoxCurso.getValue().equals(ListaCursoContent.get(i))){
				CrearLista(BoxCurso.getValue());
			}
		}
	}


	class Student extends RecursiveTreeObject<Student> {
		StringProperty Id;
		StringProperty Nombre;
		StringProperty Apellido;
		StringProperty Edad;
		StringProperty Promedio;

		public Student(String Id, String Nombre, String Apellido, String Edad, String Promedio) {
			this.Id = new SimpleStringProperty(Id) ;
			this.Nombre = new SimpleStringProperty(Nombre);
			this.Apellido = new SimpleStringProperty(Apellido);
			this.Edad = new SimpleStringProperty(Edad);
			this.Promedio= new SimpleStringProperty(Promedio);
		}
	}

	public void CrearLista(String c){

			JFXTreeTableColumn<Student, String> stdId = new JFXTreeTableColumn<>("Id");
			stdId.setPrefWidth(100);
			stdId.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
					return param.getValue().getValue().Id;
				}
			});

			JFXTreeTableColumn<Student, String> stdName = new JFXTreeTableColumn<>("Nombre");
			stdName.setPrefWidth(150);
			stdName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
					return param.getValue().getValue().Nombre;
				}
			});

			JFXTreeTableColumn<Student, String> stdApellido = new JFXTreeTableColumn<>("Apellido");
			stdApellido.setPrefWidth(150);
			stdApellido.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
					return param.getValue().getValue().Apellido;
				}
			});

			JFXTreeTableColumn<Student, String> stdAge = new JFXTreeTableColumn<>("Edad");
			stdAge.setPrefWidth(100);
			stdAge.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
					return param.getValue().getValue().Edad;
				}
			});

			JFXTreeTableColumn<Student, String> stdPromedio = new JFXTreeTableColumn<>("Promedio");
			stdPromedio.setPrefWidth(80);
			stdPromedio.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
					return param.getValue().getValue().Promedio;
				}
			});

			ObservableList<Student> students = FXCollections.observableArrayList();

			Curso temp_curso = lst_curso.FindCurso(Integer.parseInt(c));
			EstudianteBST temp_root = temp_curso.est_curso.getRoot();
			estudiantesDatos(temp_root,students);
			/*
			int n = lst_stud.NumEstud();

					for (int i = 1; i <= n; i++) {
						int cur = lst_stud.searchEstudiante(i).getCurso();
						String curso = Integer.toString(cur);
						if(curso.equals(c)) {
							int I = lst_stud.searchEstudiante(i).getId_estudiante();
							String Id = Integer.toString(I);
							String name = lst_stud.searchEstudiante(i).getNombre_estudiante();
							String apellido = lst_stud.searchEstudiante(i).getApellido_estudiante();
							int edad = lst_stud.searchEstudiante(i).getEdad();
							String age = Integer.toString(edad);
							double pro = lst_stud.searchEstudiante(i).getPromedio();
							String promedio = String.valueOf(pro);
							students.add(new Student(Id, name, apellido, age, curso, promedio));
						}
					}
					*/

			final TreeItem<Student> root = new RecursiveTreeItem<Student>(students, RecursiveTreeObject::getChildren);
			Lista.getColumns().setAll(stdId, stdName, stdApellido, stdAge, stdPromedio);
			Lista.setRoot(root);
			Lista.setShowRoot(false);

			buscar.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					Lista.setPredicate(new Predicate<TreeItem<Student>>() {
						@Override
						public boolean test(TreeItem<Student> student) {
							Boolean flag = student.getValue().Id.getValue().contains(newValue) ||
									student.getValue().Nombre.getValue().contains(newValue) ||
									student.getValue().Apellido.getValue().contains(newValue);
							return flag;
						}
					});
				}
			});
		}

		public void estudiantesDatos(EstudianteBST root, ObservableList<Student> students){
			EstudianteBST raiz = root;
			if(raiz == null)return ;
			if(raiz.left != null) {
				estudiantesDatos(raiz.left,students);
			}
			int I = raiz.getId_estudiante();
			String Id = Integer.toString(I);
			String name = raiz.getNombre_estudiante();
			String apellido = raiz.getApellido_estudiante();
			int edad = raiz.getEdad();
			String age = Integer.toString(edad);
			double pro = raiz.getPromedio();
			String promedio = String.valueOf(pro);
			students.add(new Student(Id, name, apellido, age, promedio));
			if(raiz.right != null) {
				estudiantesDatos(raiz.right,students);
			}
		}

}

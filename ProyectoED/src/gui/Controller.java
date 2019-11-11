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
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class Controller implements Initializable{
	static AdminManager lst_admin = new AdminManager();
	static EstudiantesManager lst_stud = new EstudiantesManager();
	
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

		lst_stud.readStudents("ProyectoED/datosPrueba100.txt");
		CrearLista();
		//Elementos graficos
		inCurso.setItems(comboCursos);
		
	}
	
	public void onExitButtonClicked(MouseEvent event) {
		Platform.exit();
		System.exit(0);
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

	class Student extends RecursiveTreeObject<Student> {
		StringProperty Id;
		StringProperty Nombre;
		StringProperty Apellido;
		StringProperty Edad;
		StringProperty Curso;
		StringProperty Promedio;

		public Student(String Id, String Nombre, String Apellido, String Edad, String Curso, String Promedio) {
			this.Id = new SimpleStringProperty(Id) ;
			this.Nombre = new SimpleStringProperty(Nombre);
			this.Apellido = new SimpleStringProperty(Apellido);
			this.Edad = new SimpleStringProperty(Edad);
			this.Curso = new SimpleStringProperty(Curso);
			this.Promedio= new SimpleStringProperty(Promedio);
		}
	}

	public void onListaButoon(MouseEvent event){
		//lista columnas

		Prueba.setVisible(false);
		VerLista.setVisible(true);
	}

	public void CrearLista(){
		JFXTreeTableColumn<Student,String> stdId = new JFXTreeTableColumn<>("Id");
		stdId.setPrefWidth(100);
		stdId.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
				return param.getValue().getValue().Id;
			}
		});

		JFXTreeTableColumn<Student,String> stdName = new JFXTreeTableColumn<>("Nombre");
		stdName.setPrefWidth(150);
		stdName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
				return param.getValue().getValue().Nombre;
			}
		});

		JFXTreeTableColumn<Student,String> stdApellido = new JFXTreeTableColumn<>("Apellido");
		stdApellido.setPrefWidth(150);
		stdApellido.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
				return param.getValue().getValue().Apellido;
			}
		});

		JFXTreeTableColumn<Student,String> stdAge = new JFXTreeTableColumn<>("Edad");
		stdAge.setPrefWidth(100);
		stdAge.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
				return param.getValue().getValue().Edad;
			}
		});

		JFXTreeTableColumn<Student,String> stdCurso = new JFXTreeTableColumn<>("Curso");
		stdCurso.setPrefWidth(100);
		stdCurso.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
				return param.getValue().getValue().Curso;
			}
		});

		JFXTreeTableColumn<Student,String> stdPromedio = new JFXTreeTableColumn<>("Promedio");
		stdPromedio.setPrefWidth(80);
		stdPromedio.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Student, String> param) {
				return param.getValue().getValue().Promedio;
			}
		});

		ObservableList<Student> students = FXCollections.observableArrayList();
		int n = lst_stud.NumEstud();
		for(int i=1; i<=n; i++) {
			int I = lst_stud.searchEstudiante(i).getId_estudiante();
			String Id = Integer.toString(I);
			String name = lst_stud.searchEstudiante(i).getNombre_estudiante();
			String apellido = lst_stud.searchEstudiante(i).getApellido_estudiante();
			int edad = lst_stud.searchEstudiante(i).getEdad();
			String age = Integer.toString(edad);
			int cur = lst_stud.searchEstudiante(i).getCurso();
			String curso = Integer.toString(cur);
			double pro = lst_stud.searchEstudiante(i).getPromedio();
			String promedio = String.valueOf(pro);
			students.add(new Student(Id, name , apellido, age, curso, promedio));
		}

		final TreeItem<Student> root = new RecursiveTreeItem<Student>(students, RecursiveTreeObject::getChildren);
		Lista.getColumns().setAll(stdId,stdName,stdApellido,stdAge,stdCurso,stdPromedio);
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



}

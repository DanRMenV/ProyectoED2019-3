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
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Callback;

import javax.swing.*;

public class Controller implements Initializable{
	static AdminManager lst_admin = new AdminManager();
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

	//Lista notas
	@FXML private JFXTreeTableView<Grades> ListaNotas;
	@FXML private AnchorPane AnadirNotas;
	@FXML private JFXTextField buscarEst;
	@FXML private JFXComboBox<String> BoxCursoNotas;

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
		
		lst_curso.readStudents("datos10000.txt");
		inCurso.setItems(comboCursos);
		BoxCurso.setItems(ListaCursoContent);
		BoxCursoNotas.setItems(ListaCursoContent);
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

	public void onExitListaNotasButtonClicked(MouseEvent event) {
		AnadirNotas.setVisible(false);
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
		inIdEst.setText("");
		inNomEst.setText("");
		inApeEst.setText("");
		inFecNac.setValue(null);
		inCurso.setValue("");
	}

	public int cursoInt(String curso) {
		int id=0;
		switch(curso) {
			case "Primero":
				id=1;
				break;
			case "Segundo":
				id=2;
				break;
			case "Tercero":
				id=3;
				break;
			case "Cuarto":
				id=4;
				break;
			case "Quinto":
				id=5;
				break;
			case "Sexto":
				id=6;
				break;
			case "Septimo":
				id=7;
				break;
			case "Octavo":
				id=8;
				break;
			case "Noveno":
				id=9;
				break;
			case "Decimo":
				id=10;
				break;
			case "Once":
				id=11;
				break;
			default:
				id=0;
				break;
		}
		return id;
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
		//lst_stud.addEstudiante(tmpNew);
		lst_curso.addEstudianteBST(id,temp_nombres,temp_apellidos,temp_day,temp_month,temp_year,cursoInt(temp_curso.trim()));

		AddEstudiante.setVisible(false);
		Prueba.setVisible(true);

		
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
			EstudianteBST temp_root = temp_curso.students_curso.getRoot();
			estudiantesDatos(temp_root,students);

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
			Estudiante temp=raiz.data;

			int I = temp.getId_estudiante();
			String Id = Integer.toString(I);
			String name = temp.getNombre_estudiante();
			String apellido = temp.getApellido_estudiante();
			int edad = temp.getEdad();
			String age = Integer.toString(edad);
			double pro = temp.getPromedio();
			String promedio = String.valueOf(pro);
			students.add(new Student(Id, name, apellido, age, promedio));
			if(raiz.right != null) {
				estudiantesDatos(raiz.right,students);
			}
		}

		//Lista Grades

		public void onNotaButoon(MouseEvent event){
			Prueba.setVisible(false);
			AnadirNotas.setVisible(true);
		}

		public void onComboCursoNChanged(ActionEvent event){
			ListaNotas.setDisable(false);
			for(int i=0; i<ListaCursoContent.size(); i++){
				if(BoxCursoNotas.getValue().equals(ListaCursoContent.get(i))){
					CrearListaNotas(BoxCursoNotas.getValue());
				}
			}
		}

		class Grades extends RecursiveTreeObject<Grades> {
			StringProperty Ide;
			StringProperty Nombre;
			StringProperty SurName;
			StringProperty Nota1;
			StringProperty Nota2;
			StringProperty Nota3;
			StringProperty Nota4;
			StringProperty Nota5;
			StringProperty Nota6;
			StringProperty Nota7;
			StringProperty Nota8;
			StringProperty Nota9;
			StringProperty Nota10;


			public Grades(String Ide, String Nombre, String SurName, String Nota1,String Nota2,String Nota3,String Nota4,String Nota5,String Nota6,String Nota7,String Nota8,String Nota9,String Nota10) {
				this.Ide = new SimpleStringProperty(Ide);
				this.Nombre = new SimpleStringProperty(Nombre);
				this.SurName= new SimpleStringProperty(SurName);
				this.Nota1 = new SimpleStringProperty(Nota1);
				this.Nota2 = new SimpleStringProperty(Nota2);
				this.Nota3 = new SimpleStringProperty(Nota3);
				this.Nota4 = new SimpleStringProperty(Nota4);
				this.Nota5 = new SimpleStringProperty(Nota5);
				this.Nota6 = new SimpleStringProperty(Nota6);
				this.Nota7 = new SimpleStringProperty(Nota7);
				this.Nota8 = new SimpleStringProperty(Nota8);
				this.Nota9 = new SimpleStringProperty(Nota9);
				this.Nota10 = new SimpleStringProperty(Nota10);
			}



			public StringProperty getnombreProperty() {
				return Nombre;
			}

			public StringProperty getideProperty(){
				return Ide;
			}

			public StringProperty getsurNameProperty() {
				return SurName;
			}

			public void setNota1(String nota1) {
				this.Nota1.set(nota1);
			}

			public void setNota2(String nota2) {
				this.Nota2.set(nota2);
			}

			public void setNota3(String nota3) {
				this.Nota3.set(nota3);
			}

			public void setNota4(String nota4) {
				this.Nota4.set(nota4);
			}

			public void setNota5(String nota5) {
				this.Nota5.set(nota5);
			}

			public void setNota6(String nota6) {
				this.Nota6.set(nota6);
			}

			public void setNota7(String nota7) {
				this.Nota7.set(nota7);
			}

			public void setNota8(String nota8) {
				this.Nota8.set(nota8);
			}

			public void setNota9(String nota9) {
				this.Nota9.set(nota9);
			}

			public void setNota10(String nota10) {
				this.Nota10.set(nota10);
			}

			public StringProperty getnota1Property() {
				return Nota1;
			}

			public StringProperty getnota2Property() {
				return Nota2;
			}

			public StringProperty getnota3Property() {
				return Nota3;
			}

			public StringProperty getnota4Property() {
				return Nota4;
			}

			public StringProperty getnota5Property() {
				return Nota5;
			}

			public StringProperty getnota6Property() {
				return Nota6;
			}

			public StringProperty getnota7Property() {
				return Nota7;
			}

			public StringProperty getnota8Property() {
				return Nota8;
			}

			public StringProperty getnota9Property() {
				return Nota9;
			}

			public StringProperty getnota10Property() {
				return Nota10;
			}
		}

		public void CrearListaNotas(String c){

			JFXTreeTableColumn<Grades, String> stdIde = new JFXTreeTableColumn<>("Id");
			stdIde.setPrefWidth(0);
			stdIde.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getideProperty();
				}
			});

			JFXTreeTableColumn<Grades, String> stdName = new JFXTreeTableColumn<>("Nombre");
			stdName.setPrefWidth(100);
			stdName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnombreProperty();
				}
			});

			JFXTreeTableColumn<Grades, String> stdSurName = new JFXTreeTableColumn<>("Apellido");
			stdSurName.setPrefWidth(100);
			stdSurName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getsurNameProperty();
				}
			});

			JFXTreeTableColumn<Grades, String> stdNota1 = new JFXTreeTableColumn<>("Nota1");
			stdNota1.setPrefWidth(50);
			stdNota1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnota1Property();
				}
			});

			JFXTreeTableColumn<Grades, String> stdNota2 = new JFXTreeTableColumn<>("Nota2");
			stdNota2.setPrefWidth(60);
			stdNota2.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnota2Property();
				}
			});

			JFXTreeTableColumn<Grades, String> stdNota3 = new JFXTreeTableColumn<>("Nota3");
			stdNota3.setPrefWidth(60);
			stdNota3.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnota3Property();
				}
			});

			JFXTreeTableColumn<Grades, String> stdNota4 = new JFXTreeTableColumn<>("Nota4");
			stdNota4.setPrefWidth(60);
			stdNota4.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnota4Property();
				}
			});

			JFXTreeTableColumn<Grades, String> stdNota5 = new JFXTreeTableColumn<>("Nota5");
			stdNota5.setPrefWidth(60);
			stdNota5.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnota5Property();
				}
			});

			JFXTreeTableColumn<Grades, String> stdNota6 = new JFXTreeTableColumn<>("Nota6");
			stdNota6.setPrefWidth(60);
			stdNota6.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnota6Property();
				}
			});

			JFXTreeTableColumn<Grades, String> stdNota7 = new JFXTreeTableColumn<>("Nota7");
			stdNota7.setPrefWidth(60);
			stdNota7.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnota7Property();
				}
			});

			JFXTreeTableColumn<Grades, String> stdNota8 = new JFXTreeTableColumn<>("Nota8");
			stdNota8.setPrefWidth(60);
			stdNota8.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnota8Property();
				}
			});

			JFXTreeTableColumn<Grades, String> stdNota9 = new JFXTreeTableColumn<>("Nota9");
			stdNota9.setPrefWidth(60);
			stdNota9.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnota9Property();
				}
			});

			JFXTreeTableColumn<Grades, String> stdNota10 = new JFXTreeTableColumn<>("Nota10");
			stdNota10.setPrefWidth(60);
			stdNota10.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Grades, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Grades, String> param) {
					return param.getValue().getValue().getnota10Property();
				}
			});


			ObservableList<Grades> Grade = FXCollections.observableArrayList();

			Curso temp_curso = lst_curso.FindCurso(Integer.parseInt(c));
			EstudianteBST temp_root = temp_curso.students_curso.getRoot();
			estudiantesNotas(temp_root,Grade);

			final TreeItem<Grades> root = new RecursiveTreeItem<Grades>(Grade, RecursiveTreeObject::getChildren);
			ListaNotas.getColumns().setAll(stdName,stdSurName,stdNota1,stdNota2,stdNota3,stdNota4,stdNota5,stdNota6,stdNota7,stdNota8,stdNota9,stdNota10);

			stdNota1.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			stdNota1.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Grades, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<Grades, String> event1) {
					Double tem1 = Double.parseDouble(event1.getNewValue());
					TreeItem<Grades> notaEditable1 = ListaNotas.getTreeItem(event1.getTreeTablePosition().getRow());
					notaEditable1.getValue().setNota1(event1.getNewValue());
					int k = Integer.parseInt(event1.getRowValue().getValue().Ide.toString().substring(23,33));
					//temp_curso.students_curso.Find(temp_root,k).data.list_nota.SetNota(1,tem1);
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria("Ingles").getList().SetNota(1, tem1);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio("Ingles");
					
				}
			});

			stdNota2.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			stdNota2.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Grades, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<Grades, String> event2) {
					Double tem2 = Double.parseDouble(event2.getNewValue());
					TreeItem<Grades> notaEditable2 = ListaNotas.getTreeItem(event2.getTreeTablePosition().getRow());
					notaEditable2.getValue().setNota2(event2.getNewValue());
					int k = Integer.parseInt(event2.getRowValue().getValue().Ide.toString().substring(23,33));
					//temp_curso.students_curso.Find(temp_root,k).data.list_nota.SetNota(2,tem2);
				}
			});

			stdNota3.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			stdNota3.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Grades, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<Grades, String> event) {
					Double tem3 = Double.parseDouble(event.getNewValue());
					TreeItem<Grades> notaEditable3 = ListaNotas.getTreeItem(event.getTreeTablePosition().getRow());
					notaEditable3.getValue().setNota3(event.getNewValue());
					int k = Integer.parseInt(event.getRowValue().getValue().Ide.toString().substring(23,33));
					//temp_curso.students_curso.Find(temp_root,k).data.list_nota.SetNota(3,tem3);
				}
			});

			stdNota4.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			stdNota4.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Grades, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<Grades, String> event) {
					Double tem4 = Double.parseDouble(event.getNewValue());
					TreeItem<Grades> notaEditable4 = ListaNotas.getTreeItem(event.getTreeTablePosition().getRow());
					notaEditable4.getValue().setNota4(event.getNewValue());
					int k = Integer.parseInt(event.getRowValue().getValue().Ide.toString().substring(23,33));
					//temp_curso.students_curso.Find(temp_root,k).data.list_nota.SetNota(4,tem4);
				}
			});

			stdNota5.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			stdNota5.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Grades, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<Grades, String> event) {
					Double tem5 = Double.parseDouble(event.getNewValue());
					TreeItem<Grades> notaEditable5 = ListaNotas.getTreeItem(event.getTreeTablePosition().getRow());
					notaEditable5.getValue().setNota5(event.getNewValue());
					int k = Integer.parseInt(event.getRowValue().getValue().Ide.toString().substring(23,33));
					//temp_curso.students_curso.Find(temp_root,k).data.list_nota.SetNota(5,tem5);
				}
			});

			stdNota6.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			stdNota6.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Grades, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<Grades, String> event) {
					Double tem6 = Double.parseDouble(event.getNewValue());
					TreeItem<Grades> notaEditable6 = ListaNotas.getTreeItem(event.getTreeTablePosition().getRow());
					notaEditable6.getValue().setNota6(event.getNewValue());
					int k = Integer.parseInt(event.getRowValue().getValue().Ide.toString().substring(23,33));
					//temp_curso.students_curso.Find(temp_root,k).data.list_nota.SetNota(6,tem6);
				}
			});

			stdNota7.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			stdNota7.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Grades, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<Grades, String> event) {
					Double tem7 = Double.parseDouble(event.getNewValue());
					TreeItem<Grades> notaEditable7 = ListaNotas.getTreeItem(event.getTreeTablePosition().getRow());
					notaEditable7.getValue().setNota7(event.getNewValue());
					int k = Integer.parseInt(event.getRowValue().getValue().Ide.toString().substring(23,33));
					//temp_curso.students_curso.Find(temp_root,k).data.list_nota.SetNota(7,tem7);
				}
			});

			stdNota8.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			stdNota8.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Grades, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<Grades, String> event) {
					Double tem8 = Double.parseDouble(event.getNewValue());
					TreeItem<Grades> notaEditable8 = ListaNotas.getTreeItem(event.getTreeTablePosition().getRow());
					notaEditable8.getValue().setNota8(event.getNewValue());
					int k = Integer.parseInt(event.getRowValue().getValue().Ide.toString().substring(23,33));
					//temp_curso.students_curso.Find(temp_root,k).data.list_nota.SetNota(8,tem8);
				}
			});

			stdNota9.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			stdNota9.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Grades, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<Grades, String> event) {
					Double tem9 = Double.parseDouble(event.getNewValue());
					TreeItem<Grades> notaEditable9 = ListaNotas.getTreeItem(event.getTreeTablePosition().getRow());
					notaEditable9.getValue().setNota9(event.getNewValue());
					int k = Integer.parseInt(event.getRowValue().getValue().Ide.toString().substring(23,33));
					//temp_curso.students_curso.Find(temp_root,k).data.list_nota.SetNota(9,tem9);
				}
			});

			stdNota10.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
			stdNota10.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<Grades, String>>() {
				@Override
				public void handle(TreeTableColumn.CellEditEvent<Grades, String> event) {
					Double tem10 = Double.parseDouble(event.getNewValue());
					TreeItem<Grades> notaEditable10 = ListaNotas.getTreeItem(event.getTreeTablePosition().getRow());
					notaEditable10.getValue().setNota10(event.getNewValue());
					int k = Integer.parseInt(event.getRowValue().getValue().Ide.toString().substring(23,33));
					//temp_curso.students_curso.Find(temp_root,k).data.list_nota.SetNota(10,tem10);
				}
			});

			ListaNotas.setEditable(true);
			ListaNotas.setRoot(root);
			ListaNotas.setShowRoot(false);

			buscarEst.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					ListaNotas.setPredicate(new Predicate<TreeItem<Grades>>() {
						@Override
						public boolean test(TreeItem<Grades> grade) {
							Boolean flag = grade.getValue().Nombre.getValue().contains(newValue) ||
									grade.getValue().SurName.getValue().contains(newValue);
							return flag;
						}
					});
				}
			});
		}

		public void estudiantesNotas(EstudianteBST root, ObservableList<Grades> Grade){
			EstudianteBST raiz = root;
			if(raiz == null)return ;
			if(raiz.left != null) {
				estudiantesNotas(raiz.left,Grade);
			}
			Estudiante temp=raiz.data;

			int id = temp.getId_estudiante();
			String ide = String.valueOf(id);
			String name = temp.getNombre_estudiante();
			String apellido = temp.getApellido_estudiante();
			//double n1 = temp.list_nota.GetNota(1);
			double n1 = temp.list_materias.getMateria("Ingles").getList().GetNota(1);
			String nota1 = String.valueOf(n1);
			double n2 = temp.list_materias.getMateria("Ingles").getList().GetNota(2);
			String nota2 = String.valueOf(n2);
			double n3 = temp.list_materias.getMateria("Ingles").getList().GetNota(3);
			String nota3 = String.valueOf(n3);
			double n4 = temp.list_materias.getMateria("Ingles").getList().GetNota(4);
			String nota4 = String.valueOf(n4);
			double n5 = temp.list_materias.getMateria("Ingles").getList().GetNota(5);
			String nota5 = String.valueOf(n5);
			double n6 = temp.list_materias.getMateria("Ingles").getList().GetNota(6);
			String nota6 = String.valueOf(n6);
			double n7 = temp.list_materias.getMateria("Ingles").getList().GetNota(7);
			String nota7 = String.valueOf(n7);
			double n8 = temp.list_materias.getMateria("Ingles").getList().GetNota(8);
			String nota8 = String.valueOf(n8);
			double n9 = temp.list_materias.getMateria("Ingles").getList().GetNota(9);
			String nota9 = String.valueOf(n9);
			double n10 = temp.list_materias.getMateria("Ingles").getList().GetNota(10);
			String nota10 = String.valueOf(n10);
			
			Grade.add(new Grades(ide,name, apellido,nota1,nota2,nota3,nota4,nota5,nota6,nota7,nota8,nota9,nota10));
			if(raiz.right != null) {
				estudiantesNotas(raiz.right,Grade);
			}
			
			
		}


}

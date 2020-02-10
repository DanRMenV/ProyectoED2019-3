package gui;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class Controller implements Initializable{
	//static AdminManager lst_admin = new AdminManager();
  
  static AdminManager hash_admin = new AdminManager();
	static CursoManager lst_curso = new CursoManager();
	static Admin general;
	
	//Login bienvenida
	@FXML private AnchorPane Login1;
	@FXML private AnchorPane Login2;
	@FXML private AnchorPane Prueba;
	@FXML private AnchorPane ChangePas;

	@FXML private JFXTextField UserField;
	@FXML private JFXPasswordField PasswordField;		
	
	@FXML private JFXPasswordField pas1;
	@FXML private JFXPasswordField pas2;
	
	@FXML private Label IngresarError;
	@FXML private Text bienvenida;
	@FXML private Text currentTime;
	
	@FXML private Text wrongpas;
	@FXML private Text tid;
	@FXML private Text tname;
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
	@FXML private JFXComboBox<String> BoxMaterias;
	@FXML private JFXComboBox<String> BoxCursoNotas;
	
	//Buscar est
	@FXML private AnchorPane BuscarEstudiante;
	@FXML private JFXTextField IdField;
	
	
	//Lista notas estudiante
	@FXML private AnchorPane EstNotas;
	@FXML private JFXTreeTableView<MateriasN> ListaNotasEst;
	@FXML private Label NombreEst;
	
	//Mejores promedios
	@FXML private AnchorPane MejoresPromedios;
	@FXML private AnchorPane MejoresCurso;
	@FXML private JFXComboBox<String> BoxCursoMejores;
	@FXML private Text Mejor1;
	@FXML private Text Mejor2;
	@FXML private Text Mejor3;
	@FXML private Text Mejor4;
	@FXML private Text Mejor5;
	@FXML private Text Prom1;
	@FXML private Text Prom2;
	@FXML private Text Prom3;
	@FXML private Text Prom4;
	@FXML private Text Prom5;
	@FXML private Text mejorCurso;
	
	
	//Lista definitivas
		@FXML private JFXTreeTableView<MateriasDef> ListaDefinitivas;
		@FXML private AnchorPane VerDefinitivas;
		@FXML private JFXTextField buscarEstDef;
		@FXML private JFXComboBox<String> BoxCursoDefinitivas;
	
	ObservableList<String> ListaCursoContent =
			FXCollections.observableArrayList(
					"1", "2", "3", "4", "5", "6", "7", "8",
					"9", "10", "11");
	
	ObservableList<String> comboCursos =
			FXCollections.observableArrayList(
	        "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo", 
	        "Noveno", "Decimo", "Once");
	
	ObservableList<String> ListaMaterias =
			FXCollections.observableArrayList(
					"Castellano","Ingles","Matematicas","Biologia","Etica","Religion","Ed.Fisica","Filosofia","Artes","Informatica","Sociales");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		general = new Admin(-1,"TestUSER");
		System.out.println("xd");
		//Datos
		hash_admin.addAdminUser(new Admin(1000274,"Juanse","123456"));
		hash_admin.addAdminUser(new Admin(1000123,"Mendivelso","654321"));
		hash_admin.addAdminUser(new Admin(1000654,"JuanP","123456"));
		hash_admin.addAdminUser(new Admin(696969,"nel","1245"));
		hash_admin.addAdminUser(new Admin(1,"Admin",""));
    
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
		BoxMaterias.setItems(ListaMaterias);
		BoxCursoNotas.setItems(ListaCursoContent);
		BoxCursoDefinitivas.setItems(ListaCursoContent);
		BoxCursoMejores.setItems(comboCursos);
		
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
	
	public void onExitHistorialNotasButtonClicked(MouseEvent event) {
		BuscarEstudiante.setVisible(false);
		Prueba.setVisible(true);
	}
	
  public void OnEnterButtonPressedLogin(KeyEvent key) {
	  if((key.getCode().toString()).equals("ENTER") && Login1.isVisible()==true) {
		  onIngresarButtonClicked();
	  }
  }	
	
  public void onMejoresButtonClicked() {
	  Prueba.setVisible(false);
	  MejoresPromedios.setVisible(true);
  }
  
  public void onVerMejoresButtonClicked() {
	  MejoresCurso.setVisible(true); 
	  String temp_curso=BoxCursoMejores.getValue();
	  int curso = cursoInt(temp_curso.trim());  
	  Estudiante[] valores=lst_curso.FindCurso(curso).heap_curso.mejProm();
	  mejorCurso.setText(temp_curso);
	  
	  
	  Mejor1.setText(valores[0].getNombre_estudiante()+" "+valores[0].getApellido_estudiante());
	  Mejor2.setText(valores[1].getNombre_estudiante()+" "+valores[1].getApellido_estudiante());
	  Mejor3.setText(valores[2].getNombre_estudiante()+" "+valores[2].getApellido_estudiante());
	  Mejor4.setText(valores[3].getNombre_estudiante()+" "+valores[3].getApellido_estudiante());
	  Mejor5.setText(valores[4].getNombre_estudiante()+" "+valores[4].getApellido_estudiante());
	  
	  Prom1.setText(String.format("%.2f",valores[0].getPromedio()));
	  Prom2.setText(String.format("%.2f",valores[1].getPromedio()));
	  Prom3.setText(String.format("%.2f",valores[2].getPromedio()));
	  Prom4.setText(String.format("%.2f",valores[3].getPromedio()));
	  Prom5.setText(String.format("%.2f",valores[4].getPromedio()));	  
	  
  }
  
  public void onVolverMejoresButtonClicked() {
	  MejoresCurso.setVisible(false);
  }
  
  public void onExitMejoresButtonClicked() {
	  
	  MejoresCurso.setVisible(false);
	  Prueba.setVisible(true);
	  MejoresPromedios.setVisible(false);  
  }
  
  public void onIngresarButtonClicked() {
		long temp_id ;
		String temp_password="";
		temp_id = Long.parseLong((UserField.getText()));
		temp_password = PasswordField.getText();
		Admin ver=hash_admin.ValUser(new Admin(temp_id,temp_password));	
		general = ver;
		
		
		if(ver.getid() != -1) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
			String logTime = (java.time.LocalTime.now().format(dtf)).toString();  
			long millis=System.currentTimeMillis();  
			String date=new java.sql.Date(millis).toString();
			System.out.println(date);  
			currentTime.setText(date+" "+logTime);

      bienvenida.setText(ver.getUsername());
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
	
	
	
	
	public void OnHomeButton() {
		AddEstudiante.setVisible(false);
		ChangePas.setVisible(false);
		Prueba.setVisible(true);
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
		
		String c="";
		String m="";
		public void onComboCursoNChanged(ActionEvent event){
			c = BoxCursoNotas.getValue();
			if(m.equals("")) {
				System.out.println("ponga materia");
			}else {
				ListaNotas.setDisable(false);
				for(int i=0; i<ListaMaterias.size(); i++){
					if(BoxMaterias.getValue().equals(ListaMaterias.get(i))){
						CrearListaNotas(c,BoxMaterias.getValue());
					}
				}
			}
		}
		
		public void onComboMateriaChanged(ActionEvent event){
			m=BoxMaterias.getValue();
			if(c.equals("")) {
				System.out.println("ponga curso");
			}else {
				ListaNotas.setDisable(false);
				for(int i=0; i<ListaMaterias.size(); i++){
					if(BoxMaterias.getValue().equals(ListaMaterias.get(i))){
						CrearListaNotas(c,BoxMaterias.getValue());
					}
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

		public void CrearListaNotas(String c, String m){

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
			estudiantesNotas(temp_root,Grade,m);

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
					
					//BST_Curso
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(1, tem1);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio(BoxMaterias.getValue());
					
					//HEAP
					temp_curso.heap_curso.getEstudiante(k).list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(1, tem1);
					temp_curso.heap_curso.getEstudiante(k).updatePromedio(BoxMaterias.getValue());				
					temp_curso.heap_curso.modProm(k);
					temp_curso.heap_curso.mejProm();
					
					//ArbolGIGANTE
					lst_curso.getArbol_col().Find(k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(1, tem1);			
					lst_curso.getArbol_col().Find(k).data.updatePromedio(BoxMaterias.getValue());
					
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
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(2, tem2);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio(BoxMaterias.getValue());
					
					//HEAP
					temp_curso.heap_curso.getEstudiante(k).list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(2, tem2);
					temp_curso.heap_curso.getEstudiante(k).updatePromedio(BoxMaterias.getValue());				
					temp_curso.heap_curso.modProm(k);
					temp_curso.heap_curso.mejProm();
					
					//ArbolGIGANTE
					lst_curso.getArbol_col().Find(k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(2, tem2);			
					lst_curso.getArbol_col().Find(k).data.updatePromedio(BoxMaterias.getValue());
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
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(3, tem3);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio(BoxMaterias.getValue());
					
					//HEAP
					temp_curso.heap_curso.getEstudiante(k).list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(3, tem3);
					temp_curso.heap_curso.getEstudiante(k).updatePromedio(BoxMaterias.getValue());				
					temp_curso.heap_curso.modProm(k);
					temp_curso.heap_curso.mejProm();
					
					//ArbolGIGANTE
					lst_curso.getArbol_col().Find(k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(3, tem3);			
					lst_curso.getArbol_col().Find(k).data.updatePromedio(BoxMaterias.getValue());
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
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(4, tem4);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio(BoxMaterias.getValue());
					
					//HEAP
					temp_curso.heap_curso.getEstudiante(k).list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(4, tem4);
					temp_curso.heap_curso.getEstudiante(k).updatePromedio(BoxMaterias.getValue());				
					temp_curso.heap_curso.modProm(k);
					temp_curso.heap_curso.mejProm();
					
					//ArbolGIGANTE
					lst_curso.getArbol_col().Find(k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(4, tem4);			
					lst_curso.getArbol_col().Find(k).data.updatePromedio(BoxMaterias.getValue());
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
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(5, tem5);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio(BoxMaterias.getValue());
					
					//HEAP
					temp_curso.heap_curso.getEstudiante(k).list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(5, tem5);
					temp_curso.heap_curso.getEstudiante(k).updatePromedio(BoxMaterias.getValue());				
					temp_curso.heap_curso.modProm(k);
					temp_curso.heap_curso.mejProm();
					
					//ArbolGIGANTE
					lst_curso.getArbol_col().Find(k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(5, tem5);			
					lst_curso.getArbol_col().Find(k).data.updatePromedio(BoxMaterias.getValue());
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
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(6, tem6);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio(BoxMaterias.getValue());
					
					//HEAP
					temp_curso.heap_curso.getEstudiante(k).list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(6, tem6);
					temp_curso.heap_curso.getEstudiante(k).updatePromedio(BoxMaterias.getValue());				
					temp_curso.heap_curso.modProm(k);
					temp_curso.heap_curso.mejProm();
					
					//ArbolGIGANTE
					lst_curso.getArbol_col().Find(k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(6, tem6);			
					lst_curso.getArbol_col().Find(k).data.updatePromedio(BoxMaterias.getValue());
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
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(7, tem7);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio(BoxMaterias.getValue());
					
					//HEAP
					temp_curso.heap_curso.getEstudiante(k).list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(7, tem7);
					temp_curso.heap_curso.getEstudiante(k).updatePromedio(BoxMaterias.getValue());				
					temp_curso.heap_curso.modProm(k);
					temp_curso.heap_curso.mejProm();
					
					//ArbolGIGANTE
					lst_curso.getArbol_col().Find(k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(7, tem7);			
					lst_curso.getArbol_col().Find(k).data.updatePromedio(BoxMaterias.getValue());
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
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(8, tem8);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio(BoxMaterias.getValue());
					
					//HEAP
					temp_curso.heap_curso.getEstudiante(k).list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(8, tem8);
					temp_curso.heap_curso.getEstudiante(k).updatePromedio(BoxMaterias.getValue());				
					temp_curso.heap_curso.modProm(k);
					temp_curso.heap_curso.mejProm();
					
					//ArbolGIGANTE
					lst_curso.getArbol_col().Find(k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(8, tem8);			
					lst_curso.getArbol_col().Find(k).data.updatePromedio(BoxMaterias.getValue());
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
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(9, tem9);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio(BoxMaterias.getValue());
					
					//HEAP
					temp_curso.heap_curso.getEstudiante(k).list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(9, tem9);
					temp_curso.heap_curso.getEstudiante(k).updatePromedio(BoxMaterias.getValue());				
					temp_curso.heap_curso.modProm(k);
					temp_curso.heap_curso.mejProm();
					
					//ArbolGIGANTE
					lst_curso.getArbol_col().Find(k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(9, tem9);			
					lst_curso.getArbol_col().Find(k).data.updatePromedio(BoxMaterias.getValue());
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
					temp_curso.students_curso.Find(temp_root,k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(10, tem10);
					temp_curso.students_curso.Find(temp_root,k).data.updatePromedio(BoxMaterias.getValue());
					
					//HEAP
					temp_curso.heap_curso.getEstudiante(k).list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(10, tem10);
					temp_curso.heap_curso.getEstudiante(k).updatePromedio(BoxMaterias.getValue());				
					temp_curso.heap_curso.modProm(k);
					temp_curso.heap_curso.mejProm();
					
					//ArbolGIGANTE
					lst_curso.getArbol_col().Find(k).data.list_materias.getMateria(BoxMaterias.getValue()).getList().SetNota(10, tem10);			
					lst_curso.getArbol_col().Find(k).data.updatePromedio(BoxMaterias.getValue());
					
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

		public void estudiantesNotas(EstudianteBST root, ObservableList<Grades> Grade, String ma){
			EstudianteBST raiz = root;
			if(raiz == null)return ;
			if(raiz.left != null) {
				estudiantesNotas(raiz.left,Grade,ma);
			}
			Estudiante temp=raiz.data;
			int id = temp.getId_estudiante();
			String ide = String.valueOf(id);
			String name = temp.getNombre_estudiante();
			String apellido = temp.getApellido_estudiante();
			//double n1 = temp.list_nota.GetNota(1);
			double n1 = temp.list_materias.getMateria(ma).getList().GetNota(1);
			String nota1 = String.valueOf(n1);
			double n2 = temp.list_materias.getMateria(ma).getList().GetNota(2);
			String nota2 = String.valueOf(n2);
			double n3 = temp.list_materias.getMateria(ma).getList().GetNota(3);
			String nota3 = String.valueOf(n3);
			double n4 = temp.list_materias.getMateria(ma).getList().GetNota(4);
			String nota4 = String.valueOf(n4);
			double n5 = temp.list_materias.getMateria(ma).getList().GetNota(5);
			String nota5 = String.valueOf(n5);
			double n6 = temp.list_materias.getMateria(ma).getList().GetNota(6);
			String nota6 = String.valueOf(n6);
			double n7 = temp.list_materias.getMateria(ma).getList().GetNota(7);
			String nota7 = String.valueOf(n7);
			double n8 = temp.list_materias.getMateria(ma).getList().GetNota(8);
			String nota8 = String.valueOf(n8);
			double n9 = temp.list_materias.getMateria(ma).getList().GetNota(9);
			String nota9 = String.valueOf(n9);
			double n10 = temp.list_materias.getMateria(ma).getList().GetNota(10);
			String nota10 = String.valueOf(n10);
			
			Grade.add(new Grades(ide,name, apellido,nota1,nota2,nota3,nota4,nota5,nota6,nota7,nota8,nota9,nota10));
			if(raiz.right != null) {
				estudiantesNotas(raiz.right,Grade,ma);
			}		
		}
		
		//Definitiva Materias estudiante
		
		public void onExitHistoriaButtonClicked(MouseEvent event) {
			EstNotas.setVisible(false);
			Prueba.setVisible(true);
		}
		
		public void onHistoriaButtonClicked(MouseEvent event) {
			Prueba.setVisible(false);
			BuscarEstudiante.setVisible(true);
		}
		
		public void onBuscarIdButtonClicked(MouseEvent event) {
			int num = lst_curso.getArbol_col().Find(Integer.parseInt(IdField.getText())).data.getId_estudiante();
			int cur = lst_curso.getArbol_col().Find(Integer.parseInt(IdField.getText())).data.getCurso();
			String n = lst_curso.getArbol_col().Find(Integer.parseInt(IdField.getText())).data.getNombre_estudiante();
			String a = lst_curso.getArbol_col().Find(Integer.parseInt(IdField.getText())).data.getApellido_estudiante();
			if(num==Integer.parseInt(IdField.getText())) {
				BuscarEstudiante.setVisible(false);
				EstNotas.setVisible(true);
				ListaNotasEst.setDisable(false);
				CrearMateriasDe(cur,num);
				NombreEst.setText(n+" "+a);
			}else {
				System.out.println("No existe el estudiante");
			}
		}
		
		class MateriasN extends RecursiveTreeObject<MateriasN> {
			StringProperty Materia;
			StringProperty Definitiva;
			public MateriasN(String Materia, String Definitiva) {
				this.Materia = new SimpleStringProperty(Materia);
				this.Definitiva = new SimpleStringProperty(Definitiva);
			}
		}

		public void CrearMateriasDe(int c, int n){
			
			JFXTreeTableColumn<MateriasN, String> stdMa = new JFXTreeTableColumn<>("Materia");
			stdMa.setPrefWidth(200);
			stdMa.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasN, String>, ObservableValue<String>>() {
				@Override
				public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasN, String> param) {
					return param.getValue().getValue().Materia;
				}
			});

				JFXTreeTableColumn<MateriasN, String> stdDe = new JFXTreeTableColumn<>("Definitiva");
				stdDe.setPrefWidth(200);
				stdDe.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasN, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasN, String> param) {
						return param.getValue().getValue().Definitiva;
					}
				});

				ObservableList<MateriasN> MateriasNs = FXCollections.observableArrayList();

				Curso temp_curso = lst_curso.FindCurso(c);
				EstudianteBST temp_root = temp_curso.students_curso.Find(n);
				estudianteMaterias(temp_root,MateriasNs);

				final TreeItem<MateriasN> root = new RecursiveTreeItem<MateriasN>(MateriasNs, RecursiveTreeObject::getChildren);
				ListaNotasEst.getColumns().setAll(stdMa,stdDe);
				ListaNotasEst.setRoot(root);
				ListaNotasEst.setShowRoot(false);

			}

			public void estudianteMaterias(EstudianteBST root, ObservableList<MateriasN> MateriasNs){
				//EstudianteBST raiz = root;
				String[] mat={"Castellano","Ingles","Matematicas","Biologia","Etica","Religion","Ed.Fisica","Filosofia","Artes","Informatica","Sociales"};
				for(int i=0; i<mat.length;i++) {
					String mate = mat[i];
					double pro = root.data.list_materias.getMateria(mat[i]).getPromedio();
					String promedio = String.valueOf(pro);
					MateriasNs.add(new MateriasN(mate,promedio));
				}
				
			}
			
			//Cambiar contraseña administrados
			public void OnChangeAdmin() {
				Prueba.setVisible(false);
				ChangePas.setVisible(true);
				tid.setText(Long.toString(general.getid()));
				tname.setText(general.getUsername());
				
			}
			public void OnButtonChange() {
				String p1 = pas1.getText();
				String p2 = pas2.getText();
				if(p1.equals(p2)) {
					general.setPassword(p1);
					wrongpas.setVisible(false);
					Prueba.setVisible(true);
					ChangePas.setVisible(false);
					pas1.setText("");
					pas2.setText("");
				}else {
					pas1.setText("");
					pas2.setText("");
					wrongpas.setVisible(true);
				}
			}
			
			public void onComboCursoDefChanged(ActionEvent event){
				ListaDefinitivas.setDisable(false);
				for(int i=0; i<ListaCursoContent.size(); i++){				
					if(BoxCursoDefinitivas.getValue().equals(ListaCursoContent.get(i))){	
						CrearListaDefinitivas(BoxCursoDefinitivas.getValue());
					}
				}
			}
			
			class MateriasDef extends RecursiveTreeObject<MateriasDef> {
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
				StringProperty Nota11;
				public MateriasDef(String Ide, String Nombre, String SurName, String Nota1,String Nota2,String Nota3,String Nota4,String Nota5,String Nota6,String Nota7,String Nota8,String Nota9,String Nota10,String Nota11) {
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
					this.Nota11 = new SimpleStringProperty(Nota11);
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
				
				public StringProperty getnota11Property() {
					return Nota11;
				}
				
				
			}
			
			public void CrearListaDefinitivas(String c){

				JFXTreeTableColumn<MateriasDef, String> stdIde = new JFXTreeTableColumn<>("Id");
				stdIde.setPrefWidth(0);
				stdIde.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getideProperty();
					}
				});

				JFXTreeTableColumn<MateriasDef, String> stdName = new JFXTreeTableColumn<>("Nombre");
				stdName.setPrefWidth(100);
				stdName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnombreProperty();
					}
				});

				JFXTreeTableColumn<MateriasDef, String> stdSurName = new JFXTreeTableColumn<>("Apellido");
				stdSurName.setPrefWidth(100);
				stdSurName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getsurNameProperty();
					}
				});

				JFXTreeTableColumn<MateriasDef, String> stdNota1 = new JFXTreeTableColumn<>("Castellano");
				stdNota1.setPrefWidth(50);
				stdNota1.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota1Property();
					}
				});

				
				
				JFXTreeTableColumn<MateriasDef, String> stdNota2 = new JFXTreeTableColumn<>("Ingles");
				stdNota2.setPrefWidth(60);
				stdNota2.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota2Property();
					}
				});

				JFXTreeTableColumn<MateriasDef, String> stdNota3 = new JFXTreeTableColumn<>("Matematicas");
				stdNota3.setPrefWidth(60);
				stdNota3.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota3Property();
					}
				});

				
				
				JFXTreeTableColumn<MateriasDef, String> stdNota4 = new JFXTreeTableColumn<>("Biologia");
				stdNota4.setPrefWidth(60);
				stdNota4.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota4Property();
					}
				});

				JFXTreeTableColumn<MateriasDef, String> stdNota5 = new JFXTreeTableColumn<>("Etica");
				stdNota5.setPrefWidth(60);
				stdNota5.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota5Property();
					}
				});

				JFXTreeTableColumn<MateriasDef, String> stdNota6 = new JFXTreeTableColumn<>("Religion");
				stdNota6.setPrefWidth(60);
				stdNota6.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota6Property();
					}
				});

				
				
				JFXTreeTableColumn<MateriasDef, String> stdNota7 = new JFXTreeTableColumn<>("Ed.Fisica");
				stdNota7.setPrefWidth(60);
				stdNota7.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota7Property();
					}
				});

				JFXTreeTableColumn<MateriasDef, String> stdNota8 = new JFXTreeTableColumn<>("Filosofia");
				stdNota8.setPrefWidth(60);
				stdNota8.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota8Property();
					}
				});

				JFXTreeTableColumn<MateriasDef, String> stdNota9 = new JFXTreeTableColumn<>("Artes");
				stdNota9.setPrefWidth(60);
				stdNota9.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota9Property();
					}
				});

				JFXTreeTableColumn<MateriasDef, String> stdNota10 = new JFXTreeTableColumn<>("Informatica");
				stdNota10.setPrefWidth(60);
				stdNota10.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota10Property();
					}
				});
				
				JFXTreeTableColumn<MateriasDef, String> stdNota11 = new JFXTreeTableColumn<>("Sociales");
				stdNota11.setPrefWidth(60);
				stdNota11.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<MateriasDef, String>, ObservableValue<String>>() {
					@Override
					public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<MateriasDef, String> param) {
						return param.getValue().getValue().getnota10Property();
					}
				});


				ObservableList<MateriasDef> MateriaDef = FXCollections.observableArrayList();

				Curso temp_curso = lst_curso.FindCurso(Integer.parseInt(c));
				EstudianteBST temp_root = temp_curso.students_curso.getRoot();
				
				estudiantesDef(temp_root,MateriaDef);

				final TreeItem<MateriasDef> root = new RecursiveTreeItem<MateriasDef>(MateriaDef, RecursiveTreeObject::getChildren);
				ListaDefinitivas.getColumns().setAll(stdName,stdSurName,stdNota1,stdNota2,stdNota3,stdNota4,stdNota5,stdNota6,stdNota7,stdNota8,stdNota9,stdNota10,stdNota11);

	
				ListaDefinitivas.setEditable(true);
				ListaDefinitivas.setRoot(root);
				ListaDefinitivas.setShowRoot(false);
				
			}
					
			public void estudiantesDef(EstudianteBST root, ObservableList<MateriasDef> Definitivas){
				EstudianteBST raiz = root;
				if(raiz == null)return ;
				if(raiz.left != null) {
					estudiantesDef(raiz.left,Definitivas);
				}
				
				String[] mat={"Castellano","Ingles","Matematicas","Biologia","Etica","Religion","Ed.Fisica","Filosofia","Artes","Informatica","Sociales"};
				
				Estudiante temp=raiz.data;
				int id = temp.getId_estudiante();
				String ide = String.valueOf(id);
				String name = temp.getNombre_estudiante();
				String apellido = temp.getApellido_estudiante();
				
				double n1= temp.list_materias.getMateria("Castellano").getPromedio();
				String nota1 = String.valueOf(n1);
				double n2 = temp.list_materias.getMateria(mat[1]).getPromedio();
				String nota2 = String.valueOf(n2);
				double n3 = temp.list_materias.getMateria(mat[2]).getPromedio();
				String nota3 = String.valueOf(n3);
				double n4 = temp.list_materias.getMateria(mat[3]).getPromedio();
				String nota4 = String.valueOf(n4);
				double n5 = temp.list_materias.getMateria(mat[4]).getPromedio();
				String nota5 = String.valueOf(n5);
				double n6 = temp.list_materias.getMateria(mat[5]).getPromedio();
				String nota6 = String.valueOf(n6);
				double n7 = temp.list_materias.getMateria(mat[6]).getPromedio();
				String nota7 = String.valueOf(n7);
				double n8 = temp.list_materias.getMateria(mat[7]).getPromedio();
				String nota8 = String.valueOf(n8);
				double n9 = temp.list_materias.getMateria(mat[8]).getPromedio();
				String nota9 = String.valueOf(n9);
				double n10 = temp.list_materias.getMateria(mat[9]).getPromedio();
				String nota10 = String.valueOf(n10);
		
				double n11 = temp.list_materias.getMateria("Sociales").getPromedio();
				String nota11 = String.valueOf(n11);
				
				Definitivas.add(new MateriasDef(ide,name, apellido,nota1,nota2,nota3,nota4,nota5,nota6,nota7,nota8,nota9,nota10,nota11));
				if(raiz.right != null) {
					estudiantesDef(raiz.right,Definitivas);
				}		
			}
	
			public void onExitDefButtonClicked(MouseEvent event) {
				VerDefinitivas.setVisible(false);
				Prueba.setVisible(true);
			}
			
			public void onIngresarDefButtonClicked(MouseEvent event) {
				VerDefinitivas.setVisible(true);
				Prueba.setVisible(false);
			}			
			
		
}

package Interfaz;

import business.AdminManager;
import data.Admin;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller {
	
	static AdminManager lst_admin = new AdminManager();
	static int pantalla=0;
	static String temp_user="",temp_password="";


	@FXML private Button BotonLogin;
	
	@FXML private DialogPane incorrectoDialog;
	
	@FXML private TextField UsuarioField;
	@FXML private TextField ContraseñaField;
	
	@FXML private AnchorPane LoginPanel;
	@FXML private AnchorPane LoginPanel1;
	@FXML private AnchorPane MenuPanel;
	
	public void ExitButton(MouseEvent event){
		Platform.exit();
		System.exit(0);
	}
	
	public void ExitDialog(MouseEvent event){
		incorrectoDialog.setVisible(false);
	}
	
	public void LoginButton(MouseEvent event){
		lst_admin.addAdminUser(new Admin("juanse","123456"));
		lst_admin.addAdminUser(new Admin("crack yo","09786"));
		lst_admin.addAdminUser(new Admin("babb","12345444"));
		lst_admin.addAdminUser(new Admin("nel","1245"));
		lst_admin.addAdminUser(new Admin("trolazo","696969"));
		
		temp_user = UsuarioField.getText();
		temp_password = ContraseñaField.getText();
		
		if(lst_admin.ValUser(new Admin(temp_user, temp_password))) {
			MenuPanel.setVisible(true);
			LoginPanel.setVisible(false);
			LoginPanel1.setVisible(false);
		}else {
			incorrectoDialog.setVisible(true);
		}
	}
	
}

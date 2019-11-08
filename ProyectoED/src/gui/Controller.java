package gui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import business.*;
import data.*;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;

public class Controller {
	static AdminManager lst_admin = new AdminManager();
	static String temp_user="",temp_password="";
	
	@FXML private AnchorPane Login1;
	@FXML private AnchorPane Login2;
	@FXML private AnchorPane Prueba;

	@FXML private JFXTextField UserField;
	@FXML private JFXPasswordField PasswordField;
	
	@FXML private Label IngresarError;
	
	public void onExitButtonClicked(MouseEvent event) {
		Platform.exit();
		System.exit(0);
	}
	
	public void onIngresarButtonClicked(MouseEvent event) {
		lst_admin.addAdminUser(new Admin("juanse","123456"));
		lst_admin.addAdminUser(new Admin("crack yo","09786"));
		lst_admin.addAdminUser(new Admin("babb","12345444"));
		lst_admin.addAdminUser(new Admin("nel","1245"));
		lst_admin.addAdminUser(new Admin("trolazo","696969"));
		temp_user = UserField.getText();
		temp_password = PasswordField.getText();
		
		boolean ver=lst_admin.ValUser(new Admin(temp_user,temp_password));
		
		if(ver) {
			Login1.setVisible(false);
			Login2.setVisible(false);
			Prueba.setVisible(true);
			
		}else {
			IngresarError.setVisible(true);
			UserField.setText("");
			PasswordField.setText("");
			
		}
		
	}
	
}

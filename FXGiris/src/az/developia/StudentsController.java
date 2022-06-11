package az.developia;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import az.developia.repository.StudentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentsController implements Initializable {

	
	@FXML
	private TextField studentName;
	
	@FXML
	private TextField studentSurname;
	
	@FXML
	private Label result;
	
	@FXML	
	private TableView<Student> studentsTable;
	
	@FXML
	private TableColumn<Student, String> nameColumn;
	@FXML
	private TableColumn<Student, String> surnameColumn;
	
	private List<Student> students=new ArrayList<Student>();
	{
		students.add(new Student("Adil","Eliyev"));
		students.add(new Student("Hesen","Veliyev")); 
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		surnameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
		
		ObservableList<Student> list=FXCollections.observableArrayList();
		list.addAll(students);
 		studentsTable.setItems(list);
		
	
	}
	
	@FXML
	private void saveStudent(ActionEvent e) {
		String name=studentName.getText();
		String surname=studentSurname.getText();
		
		Student s=new Student(name, surname);
		
		StudentRepository sr=new StudentRepository();
		sr.saveStudentToDatabase(s);
		
		ObservableList<Student> list=FXCollections.observableArrayList();
		list.addAll(sr.findAllStudents());
 		studentsTable.setItems(list);
		

	
	}
	
	
	@FXML
	private void openNewPage(ActionEvent e) {
		try {
		Stage s=new Stage();
		s.setTitle("Muellimeler");
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Teachers.fxml"));
		
		Scene Scene=new  Scene(root,500,500);
		s.setScene(Scene);
		s.initModality(Modality.APPLICATION_MODAL);
		s.show();
	} catch (Exception e2) {
		e2.printStackTrace();
	}
	}
	
	

	
		
	}
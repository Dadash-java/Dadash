module FXGiris {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires java.naming;
	
	opens az.developia to javafx.graphics, javafx.fxml;
}

module ramirez.francisco.cosano.sergio.BeConnected {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
    requires java.xml.bind;

    
    
    opens ramirez.francisco.cosano.sergio.BeConnected to javafx.fxml, java.xml.bind;
    opens ramirez.francisco.cosano.sergio.BeConnected.model to java.xml.bind;
    exports ramirez.francisco.cosano.sergio.BeConnected;
}

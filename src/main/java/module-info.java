module ramirez.francisco.cosano.sergio.BeConnected {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens ramirez.francisco.cosano.sergio.BeConnected to javafx.fxml;
    exports ramirez.francisco.cosano.sergio.BeConnected;
}

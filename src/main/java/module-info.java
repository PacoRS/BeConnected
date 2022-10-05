module ramirez.francisco.cosano.sergio.BeConnected {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;

    opens ramirez.francisco.cosano.sergio.BeConnected to javafx.fxml;
    exports ramirez.francisco.cosano.sergio.BeConnected;
}

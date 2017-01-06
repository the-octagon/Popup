/*
 * This file is part of Popup.
 * 
 * Popup is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Popup is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Popup.  If not, see <http://www.gnu.org/licenses/>.
 */
package popup;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author andy
 */
public class Popup {
    private String copyYear;
    private String description;
    private String program;

    private static Popup p = new Popup();
    protected static Class pc = p.getClass();

    public Popup(String copyYear, String description, String program) {
        this.copyYear = copyYear;
        this.description = description;
        this.program = program;
    }
    public Popup() {
        
    }

    public void aboutDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About " + program);
        alert.setHeaderText(program);
        alert.setContentText("\u00A9 " + copyYear + " Andrew King\n\nThanks:\nL\nO\nE");

        alert.showAndWait();
    }
    public void contactDialog() {
        File ghFile = new File("./images/GitHub-Mark-64px.png");
        URL url = pc.getResource("/GitHub-Mark-64px.png");
        Image ghImage = new Image(url.toString());
        ImageView ghImageView = new ImageView(ghImage);

        Hyperlink gHLink = new Hyperlink("http://www.github.com/the-octagon");
        gHLink.setText("@the-octagon");
        gHLink.setOnAction((ActionEvent e) -> {
            Application a = new Application() {
                
                @Override
                public void start(Stage stage)
                {
                }
            };
            a.getHostServices().showDocument("http://www.github.com/the-octagon");
        });

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TextEditor");
        alert.setHeaderText("Contact");

        FlowPane fp = new FlowPane();
        fp.getChildren().addAll(ghImageView, gHLink);
        alert.getDialogPane().contentProperty().set( fp );

        alert.showAndWait();
    }
    public void licenseDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        File gplFile = new File("./images/gplv3-88x31.png");
        URL url = pc.getResource("/gplv3-88x31.png");
        Image gplLogo = new Image(url.toString());
        ImageView gplLogoImageView= new ImageView(gplLogo);
        alert.setTitle("License Information");
        alert.setHeaderText(program);
        alert.setGraphic(gplLogoImageView);
        alert.getDialogPane().setPrefSize(550, 350);
        alert.setResizable(true);
        alert.setContentText("\u00A9 " + copyYear + " Andrew King\n" + 
        "\n" +
        "This program is free software: you can redistribute it and/or modify " +
        "it under the terms of the GNU General Public License as published by " +
        "the Free Software Foundation, either version 3 of the License, or " +
        "(at your option) any later version.\n" +
        "\n" +
        "This program is distributed in the hope that it will be useful, " +
        "but WITHOUT ANY WARRANTY; without even the implied warranty of " +
        "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the " +
        "GNU General Public License for more details.\n" +
        "\n" +
        "You should have received a copy of the GNU General Public License " +
        "along with this program.  If not, see <http://www.gnu.org/licenses/>.");

        alert.showAndWait();
    }
}

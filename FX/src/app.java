import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * Created by Saahil on 12/2/2015.
 */
public class app extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Forms");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20,20,20,20));
        grid.add(new Text("hello") , 10, 10);
        grid.add(new TextField("typeHere"), 10,20);
        Scene scene = new Scene(grid, 400,300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

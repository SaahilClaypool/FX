import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * Created by Saahil on 12/2/2015.
 */
public class animation extends Application {
    Group root;
    Scene scene;
    Group circles;
    double frame =0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Group();
        scene = new Scene(root, 500,500, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Testing Graphics");

        circles = new Group();
        root.getChildren().add(circles);

        addCircle(new circleCirc(1,100,100));
        this.timer();

        primaryStage.show();

    }
    public void addCircle(Circle c)
    {
        circles.getChildren().add(c);
    }
    public void timer(){

        Timeline t = new Timeline(new KeyFrame(Duration.seconds(1/15.), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                for (int x = 0; x < circles.getChildren().size(); x++  ) {

                    Node c = circles.getChildren().get(x);
                    ((animatedCirc)c).move();
                }
                frame++;

            }
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }
}
class animatedCirc extends Circle{
    double velX,velY;
    animatedCirc (double vx, double vy){
        super(10,Color.AQUA);
        velX = vx;
        velY = vy;
        this.setTranslateX(110);
        this.setTranslateY(110);
    }
    public void move()
    {
        this.setTranslateX(this.getTranslateX() + velX);
        this.setTranslateY(this.getTranslateY() + velY);

    }
}
class accelCircles extends animatedCirc{
    double ax, ay;
    accelCircles(double vx, double vy, double ax, double ay) {
        super(vx, vy);
        this.ax = ax;
        this.ay = ay;
        this.setFill(Color.AZURE);
    }
    public void move(){
        super.move();
        this.velX+=ax;
        this.velY += ay;

    }

}
// conver to location, do stuff based off that

class circleCirc extends animatedCirc{
    double xc;
    double yc;
    double v;
    double r;
    double angle;
    circleCirc(double velocity, double xCenter, double yCenter) {
        super(0, 0);
        double x = getTranslateX();
        double y = getTranslateY();
        System.out.printf("x : %f y: %f xc: %f yc: %f", x, y, xCenter, yCenter);

        v = velocity;
        yc = yCenter;
        xc = xCenter;
        this.r = Math.sqrt((x-xc)*(x-xc) + (y-yc)*(y-yc));
        System.out.println(r);
        angle = angle(y-yc, x-xc);

        this.setFill(Color.BLUEVIOLET);

    }

    @Override
    public void move() {

        angle+=Math.PI*2/r;
        this.setTranslateX(r*Math.cos(angle) + xc);
        this.setTranslateY(r*Math.sin(angle) + yc);
        System.out.printf("angle: %f radius %f", angle, r );
    }
    private double angle(double y, double x)
    {
        if(x ==0)
        {
            if (y > 0)
            {
                return Math.PI/2;

            }
            else
                return 3./2*Math.PI ;
        }
        if (x < 0)
        {
            return Math.PI + Math.atan(y/x);
        }
        else return Math.atan(y/x);
    }
}
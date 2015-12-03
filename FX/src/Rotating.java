/**
 * Created by Saahil on 12/3/2015.
 */
public class Rotating {
    // all coordinates based of 100,100 grid
    private double centerX;
    private double centerY;
    private Draw draw;
    private double angle = 0;
    private double r = 50;
    Rotating(Draw draw){
        this.draw = draw;
        centerX = 50;
        centerY = 50;

    }

    void rotate(){
        angle +=.1;
    }
    double[][] getCoord()
    {
        double[][] coord = new double[2][2];

        coord[0][0] = centerX + r*Math.cos(angle);
        coord[0][1] = centerX - r*Math.cos(angle);

        coord[1][0] = centerY + r*Math.sin(angle);
        coord[1][1] = centerY - r*Math.sin(angle);
        return coord;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rotating)) return false;

        Rotating rotating = (Rotating) o;

        if (Double.compare(rotating.centerX, centerX) != 0) return false;
        if (Double.compare(rotating.centerY, centerY) != 0) return false;
        if (Double.compare(rotating.angle, angle) != 0) return false;
        if (Double.compare(rotating.r, r) != 0) return false;
        return !(draw != null ? !draw.equals(rotating.draw) : rotating.draw != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(centerX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(centerY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (draw != null ? draw.hashCode() : 0);
        temp = Double.doubleToLongBits(angle);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(r);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static void main(String[] args) {
        Rotating r = new Rotating(new DrawingProgram());
        int x =2;
    }


}


public class VectorFromCoordinates {
    double x;
    double y;



    public VectorFromCoordinates(VectorFromPoints a){
        this.x = a.endPoint.x - a.startPoint.x;
        this.y = a.endPoint.y - a.startPoint.y;

    }


    public VectorFromCoordinates(){

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}


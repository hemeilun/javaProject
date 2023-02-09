package work1;

public class Cricle implements Shape2D{

    public double radius;

    @Override
    public double grith() {
        return PI*2*radius;
    }

    @Override
    public double area() {
        return PI*radius*radius;
    }
}

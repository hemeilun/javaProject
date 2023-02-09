package work1;

public class Rectangle implements Shape2D{
    public double llong;
    public double width;

    @Override
    public double grith() {
        return 2*(llong+width);
    }

    @Override
    public double area() {
        return llong*width;
    }
}

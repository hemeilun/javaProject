package work1;

import java.util.Random;
import java.util.Scanner;

public class InterfaceExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Cricle circle = new Cricle();
        System.out.print("请输入圆的半径：");
        circle.radius = scanner.nextDouble();

        System.out.println("圆的周长为："+circle.grith());
        System.out.println("圆的面积为："+circle.area());

        Rectangle rectangle = new Rectangle();
        System.out.print("请输入矩形的长和宽：");
        rectangle.llong = scanner.nextDouble();
        rectangle.width = scanner.nextDouble();

        System.out.println("矩形的周长为："+rectangle.grith());
        System.out.println("矩形的面积为："+rectangle.area());



    }
}

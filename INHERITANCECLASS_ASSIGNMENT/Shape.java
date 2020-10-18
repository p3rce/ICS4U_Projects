package InheritanceClass_Assignment;

import java.nio.file.FileAlreadyExistsException;

public class Shape {

    protected static final double PI = 3.14;
    protected String color;
    protected boolean isFilled;


    public Shape(){
        this.color = "Green";
        this.isFilled = true;
    }

    public Shape(String Color, boolean isFilled){
        this.color = Color;
        this.isFilled = isFilled;
    }

    public String getColor(){
        return this.color;
    }

    public boolean getFilled(){
        return this.isFilled;
    }

    public String setColor(String newColor){
        return this.color = newColor;
    }

    public boolean setFilled(boolean newFilledStatus){
        return this.isFilled = newFilledStatus;
    }

    public String toString(){
        String circleString;
        String filledValue;
        if(this.isFilled == true ){
            filledValue = "is filled";
        } else {
            filledValue = "is not filled";
        }

        circleString = "A Shape with Color of " +this.color+ "and "+filledValue;

        return circleString;
    }






}

class Circle extends Shape {

        protected static final double PI = 3.14;
        protected double radius;
        protected String color;


        //set radius default value

        public Circle(){
            radius = 1.0;
            color = "Green";
            isFilled = true;

        }

        public Circle(double radius){
            this.radius = radius;
            color = "Green";
            isFilled = true;
        }

        public Cirlce(double radius, String color, boolean isFilled){
            this.radius = radius;
            this.color = color;
            this.isFilled = isFilled;


        }

		public double getRadius(){
            return radius;
        }

        public String getColor(){
            return color;
        }

        public double setRadius(double newRadius){
            radius = newRadius;

            return radius;
        }



        public double getArea(){
            double circleArea;

            circleArea = Math.PI * this.radius * this.radius;

            return circleArea;
        }

        public double getPerimeter(){
            double circlePerimeter;

            circlePerimeter = (Math.PI * this.radius) * 2;

            return circlePerimeter;
        }

        public String toString(){
            String circleString;

            circleString = "Radius of circle " + getRadius() + " which is subclass of" +super.toString();

            return circleString;
        }
}


class Rectangle extends Shape {

    protected double width;
    protected double length;

    public Rectangle(){
        this.width = 1.0;
        this.length = 1.0;
        color = "Green";
        isFilled = true;
    }

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
        color = "Green";
        isFilled = true;
    }

    public Rectangle(double width, double length, String color, boolean isFilled) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.isFilled = isFilled;
    }

    public double getWidth(){
        return this.width;
    }

    public double getLength(){
        return this.length;
    }

    public double setWidth(double newWidth){
        this.width = newWidth;

        return this.width;
    }

    public double setLength(double newLength){
        this.length = newLength;
        
        return this.length;
    }

    public double getArea(){
        double rectangleArea;

        rectangleArea = this.length * this.width;

        return rectangleArea;
    }

    public double getPerimeter(){
        double rectanglePerimeter;

        rectanglePerimeter = (this.length + this.width) * 2;

        return rectanglePerimeter;
    }

    public String toString(){
        String circleString;

        circleString = "A rectangle with width: " + getWidth() + " and length: " + getLength() + " which is a subclass of " + super.toString();

        return circleString;
    }

    

}


class Square extends Rectange {

    public Square(){
        this.width = 1.0;
        this.length = 1.0;
    }

    public Square(double sqSide){
        super(side, side);
    }

    public Square(double side, String color, boolean isFilled){
        super(side, side);
        this.color = color;
        this.isFilled = isFilled;
    }

    public double getWidth() {
        return width;
    }
    
    public double getLength() {
        return length;
    }

    public double setWidth(double width) {
        this.width = width;

        return this.width;
    }

    public double setLength(double length) {
        this.length = length;

        return this.length;
    }

    public double getSide() {
        return width;
    }
     
    public void setSide(double newSide) {
        this.length = newSide;
        this.width = newSide;
    }


    public String toString(){
        String circleString;

        circleString = "A square with side: " + getSide() + " which is a subclass of " + super.toString();

        return circleString;
    }


}

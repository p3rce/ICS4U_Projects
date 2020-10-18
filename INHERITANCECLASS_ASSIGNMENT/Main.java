package InheritanceClass_Assignment;

public class Main {
    
    public static void main (String[] args) {

        //run test
        Shape pgShape1 = new Shape();
        pgShape1.setColor("Neon Green");
        pgShape1.setFilled(true);

        System.out.print(pgShape1.toString());

        Shape pgShape2 = new Shape("Red", true);
        System.out.print(pgShape2.toString());
      
    }

}

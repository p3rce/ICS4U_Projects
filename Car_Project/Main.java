package Car_Project;

import java.util.Scanner;

public class Main {

    static int carSelectedNum = 1;
    double priceOfGas;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("*************** START GAS PROGRAM ***************");

        System.out.println("*************** CAR 1 ***************");

        System.out.print("Enter Price of Gas: ");
        double priceOfGas = sc.nextDouble();

        System.out.print("Enter previous odometer reading: ");
        double prevOdometer = sc.nextDouble();

        System.out.print("Enter most recent odometer reading: ");
        double recentOdometer = sc.nextDouble();

        System.out.print("Enter liters of gas in between stops: ");
        double gasUsed = sc.nextDouble();

        System.out.println("*************** CAR 2 ***************");

        System.out.print("Enter Price of Gas: ");
        double priceOfGas2 = sc.nextDouble();

        System.out.print("Enter previous odometer reading: ");
        double prevOdomete2 = sc.nextDouble();

        System.out.print("Enter most recent odometer reading: ");
        double recentOdomete2 = sc.nextDouble();

        System.out.print("Enter liters of gas in between stops: ");
        double gasUsed2 = sc.nextDouble();

        /* set new car */
        Car usersCar = new Car(prevOdometer, recentOdometer, gasUsed);
        Car usersCar2 = new Car(prevOdomete2, recentOdomete2, gasUsed2);

        System.out.println("\n");
        System.out.println("*************** RESULTS ***************");

        System.out.println("\n");

        System.out.println("*************** CAR 1 ***************");
        System.out.println("Fuel Efficency: " + usersCar.toString(usersCar));

        if (usersCar.gasHog(usersCar) == true) {
            System.out.println("Your car is a gas hog :/");
        } else {
            System.out.println("Your car is a economy car :)");
        }

        System.out.println("\n");

        System.out.println("*************** CAR 2 ***************");
        System.out.println("Fuel Efficency: " + usersCar2.toString(usersCar2));

        if (usersCar2.gasHog(usersCar2) == true) {
            System.out.println("Your car is a gas hog :/");
        } else {
            System.out.println("Your car is a economy car :)");
        }

        System.out.println("\n");

        System.out.println("*************** FUEL EFFICIENCY ***************");
        if (usersCar.compareTo(usersCar, usersCar2) == usersCar.calculateKPL(usersCar)) {
            System.out.println("Car 1 is more fuel efficent at " + usersCar.toString(usersCar));
        } else {
            System.out.println("Car 2 is more fuel efficent at " + usersCar2.toString(usersCar2));
        }

        System.out.println("\n");

        System.out.println("*************** FILL UP YOUR CAR ***************");

        /* FILL UP HANDLER */


        while (carSelectedNum == 1 || carSelectedNum == 2) {
            System.out.println("Enter a Car Number to fill up [1 or 2]: ");
            carSelectedNum = sc.nextInt();

            if(carSelectedNum < 1 || carSelectedNum > 2){
                //incorrect car number
                break;
            } else {

                switch(carSelectedNum) {

                    case 1:
                        System.out.println("Enter gas price: ");
                        priceOfGas = sc.nextDouble();
                        usersCar.setGasPrice(priceOfGas);

                        System.out.print("Enter most recent odometer reading: ");
                        double recentOdometer3 = sc.nextDouble();

                        System.out.print("Enter liters of gas needed to fill tank: ");
                        double gasNeededToFillTank = sc.nextDouble();
                        System.out.println("\n");

                        System.out.println("*************** FILL UP TOTAL ***************");

                        System.out.println("Fill up cost: "+usersCar.fillUp(recentOdometer3, gasNeededToFillTank));
                        System.out.println("Updated fuel efficency: "+ usersCar.toString(usersCar));

                        break;

                    case 2:
                        System.out.println("Enter gas price: ");
                        priceOfGas = sc.nextDouble();
                        usersCar2.setGasPrice(priceOfGas);



                        System.out.print("Enter most recent odometer reading: ");
                        double recentOdometer4 = sc.nextDouble();

                        System.out.print("Enter liters of gas needed to fill tank: ");
                        double gasNeededToFillTank2 = sc.nextDouble();
                        System.out.println("\n");

                        System.out.println("*************** FILL UP TOTAL ***************");

                        System.out.println("Fill up cost: "+usersCar2.fillUp(recentOdometer4, gasNeededToFillTank2));
                        System.out.println("Updated fuel efficency: "+ usersCar2.toString(usersCar2));



                        break;

                    default:
                        System.exit(0);

                    



                } // end switch

                

            }


        }



    







    }
        

}

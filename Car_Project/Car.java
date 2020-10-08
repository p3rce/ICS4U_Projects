package Car_Project;

public class Car {
    
    private double lastKm;
    private double recentKm;
    private double secLitre;

    private static double INEFFICIENT_KPL = 7;
    private static double EFFICIENT_KPL = 13;
    private static double gasPrice;



    public Car(double lKm, double rKm, double sLitre){

        lastKm = lKm;
        recentKm = rKm;
        secLitre = sLitre;

    }

    public double setGasPrice(double newGasPrice){
        gasPrice = newGasPrice;
        return gasPrice;
    }

    public double calculateKPL(Car userCar){
        return (userCar.recentKm - userCar.lastKm) / userCar.secLitre;

    }

    public boolean gasHog(Car userCar2){
        boolean isGasHog = userCar2.calculateKPL(userCar2) < INEFFICIENT_KPL;
        return isGasHog;
    }

    
    public boolean economyCar(Car userCar3){

        boolean isEconomyCar = userCar3.calculateKPL(userCar3) > EFFICIENT_KPL;
        return isEconomyCar;

    }

    
    public double compareTo(Car userCar4, Car userCar5){

        if(userCar4.calculateKPL(userCar4) > userCar5.calculateKPL(userCar5)){
            return userCar4.calculateKPL(userCar4);
        } else {
            return userCar5.calculateKPL(userCar5);
        }


    }

    public String toString(Car userCar6){
        return (userCar6.calculateKPL(userCar6) + "km / litre");
    }

    public double fillUp(double k, double l){

        lastKm = recentKm;
        recentKm = k;

        secLitre = l;
        double cost = l * gasPrice;

        return cost;


    }





}

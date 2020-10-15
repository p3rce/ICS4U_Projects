package ArrayOfObjects_Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
    
        System.out.println("Please enter the number of computers to install: ");
        int y= sc.nextInt();

        sc.nextLine();
        Lab a = new Lab(y);
    
        int counter = 0;
        int counterPlusOne = counter + 1;
        while (counter<y){

          //get required info
          
          System.out.println("***************  COMPUTER " + counterPlusOne + " ***************");

          System.out.print("Please enter the year the computer was built: ");
          int compYearMade = sc.nextInt();

          System.out.print("Please enter the year the computer was bought: ");
          int compYearPurchase = sc.nextInt();

          System.out.print("Please enter the year the computers warranty expires: ");
          int compYearWarranty = sc.nextInt();

          System.out.print("Please enter the serial number: ");
          int compSerialNumber = sc.nextInt();
          sc.nextLine();

          System.out.print("Please enter the brand name: ");
          String compBrand = sc.nextLine();
          sc.nextLine();

          System.out.print("Please enter the processor speed: ");
          double compProcessorSpeed = sc.nextDouble();

          System.out.print("Please enter the ram: ");
          int compRAM = sc.nextInt();

          //create new comp obj and save info to it
    
          Computer x = new Computer(compYearMade, compYearPurchase, compYearWarranty, compSerialNumber, compBrand, compProcessorSpeed, compRAM);
          a.InstalledComputer(counter, x);

          counter = counter + 1;
          counterPlusOne = counterPlusOne + 1;

        }

        //call different functions to print results

        System.out.println("******************************");
        a.compAverageAge();

        System.out.println("******************************");
        a.compNewest();

        System.out.println("******************************");
        a.compFastest();

        System.out.println("******************************");
        a.warrantyExpires();

        System.out.println("******************************");
        a.findBrand();
    
    
      }
}

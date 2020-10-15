package ArrayOfObjects_Project;

import java.util.Scanner;
import java.util.Calendar;

public class Lab {
  
  Scanner sc = new Scanner(System.in);

  //display all variables needed
  double numValue;
  int saveValue;
  double newestComputer;
  double compAge;
  double fastestComputer;
  int warranty;
  int matches;
  boolean expired;
  double speed;
  int compRAM;
  int secondaryRAM;
  boolean largestRAM;
  int x;
  int y;
  int index;
  int counter;
  Computer value;
  //create array for Computer
  Computer[] computerArray;


  //lab constructor
  public Lab(int x){
    computerArray = new Computer[x];
    y = x;
  }

  public Lab CreateLab(Lab userLab){
    counter = 0;
    int counterPlusOne = counter + 1;

    while (counter<userLab.y){

          //run program 

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
    
          Computer userComputer = new Computer(compYearMade, compYearPurchase, compYearWarranty, compSerialNumber, compBrand, compProcessorSpeed, compRAM);
          userLab.InstalledComputer(counter, userComputer);

          counter = counter + 1;
          counterPlusOne = counterPlusOne + 1;
    }
    return userLab;
  }



  public void InstalledComputer(int index, Computer x){
    computerArray[index]=x;
  }



  public void printLab(){
    counter = 0;
    while(counter<y){
      (computerArray[counter]).displayComputer(computerArray[counter]);
      counter = counter+1;
    }

  }

  //calculate average age of computers

  public void compAverageAge(){

    counter = 0;
    numValue = 0;
    while (counter<y){
      numValue = numValue + (computerArray[counter]).getAge(computerArray[counter]);
      counter = counter + 1;
    }
    numValue = numValue/y;
    System.out.println("The average computer is "+numValue+"year old.");
  }

  //get newest computer 

  public void compNewest(){
    counter = 0;
    while (counter<y){
      compAge = (computerArray[counter]).getYear(computerArray[counter]);
      if (compAge>newestComputer){
        newestComputer = compAge;
        saveValue = counter;
      }
      counter = counter + 1;
    }
    System.out.println("The most recent computer was purchased in "+newestComputer+" : ");
    (computerArray[saveValue]).displayComputer(computerArray[saveValue]);    
  }

  //get fastest computer

  public void compFastest(){
    counter = 0;
    fastestComputer = 0;
    while (counter<y){
      speed = (computerArray[counter]).getSpeed(computerArray[counter]);
      if (speed>fastestComputer){

        fastestComputer = speed;
        saveValue = counter;
      }
      counter = counter + 1;
    }
    System.out.println("The speediest computer has a processor of "+fastestComputer+". Here are its specs: ");
    (computerArray[saveValue]).displayComputer(computerArray[saveValue]);

    counter = 0;
    compRAM = (computerArray[saveValue]).getRAM(computerArray[saveValue]);
    secondaryRAM = 0;
    largestRAM = true;

    while (counter<y){
      secondaryRAM = (computerArray[counter]).getRAM(computerArray[counter]);
      if (secondaryRAM>compRAM){
        largestRAM = false;
        break;
      }

      counter = counter + 1;
    }

    if (largestRAM == true){
      System.out.println("The speediest computer also has the largest RAM with "+compRAM);
    }

  }

  //check which warranties expire this year

  public void warrantyExpires(){
    counter = 0;
    int year = Calendar.getInstance().get(Calendar.YEAR);
    System.out.println("Computers with a warranty expiring this year:");
    while (counter < y){
      warranty = (computerArray[counter]).getWarranty();
      if (warranty == year){
        expired = true;
        System.out.println("Computer #"+(counter+1)+", Serial Number: "+computerArray[counter].getSerialNum());
      }
      counter = counter + 1;
    }
  }

  //search array for brand inputted by user

  public void findBrand(){


    counter = 0;
    matches = 0;

    System.out.println("Please enter the name of the brand you'd like to find: ");
    String brandName = sc.nextLine();
    String match; 

    while (counter<y){
       match = (computerArray[counter]).getBrand(computerArray[counter]);
      if (brandName.equals(match)){
        matches = matches + 1;
      }
      counter = counter + 1;
    }
    if (matches >= 1){
      System.out.println("There is "+matches+" computer in the lab created by "+brandName);
    } else {
      System.out.println("No matches in the lab for brand "+brandName);
    }
    

    
  }



} // end class

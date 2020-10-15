package ArrayOfObjects_Project;

import java.util.Scanner;
import java.util.Calendar;

public class Computer {


  private int compYearMade;
  private int compYearPurchase;
  private int compYearWarranty;
  private int compSerialNumber;
  private String compBrand;
  private double compProcessorSpeed;
  private int compRAM;


  //computer constructor
  
  public Computer (int compYearMade, int compYearPurchase, int compYearWarranty, int compSerialNumber, String compBrand, double compProcessorSpeed, int compRAM)
  {
    this.compYearMade = compYearMade;
    this.compYearPurchase = compYearPurchase;
    this.compYearWarranty = compYearWarranty;

    this.compSerialNumber = compSerialNumber;
    this.compBrand = compBrand;
    this.compProcessorSpeed = compProcessorSpeed;
    this.compRAM = compRAM;
  }

  //display computer objc and info given about it
   
  public void displayComputer(Computer userComputer){
    System.out.println(" | Year made: "+userComputer.compYearMade+" | Serial Number: "+userComputer.compSerialNumber+" | Brand: "+userComputer.compBrand+" | Processor: "+userComputer.compProcessorSpeed+" | RAM: "+userComputer.compRAM);
  }

  public int getWarranty ()
  {
    return compYearWarranty;
  }
   
   
  public int getSerialNum ()
  {
    return compSerialNumber;
  }
  
   
  //get age of computer selected

  public double getAge(Computer userComputer){

    int year = Calendar.getInstance().get(Calendar.YEAR);
    return year-userComputer.compYearMade;
  }
   
   
  public int getMade ()
  {
    return compYearMade;
  }

  public double getSpeed(Computer userComputer){
    return userComputer.compProcessorSpeed;
  }

  public int getRAM(Computer userComputer){
    return userComputer.compRAM;
  }


  public String getBrand(Computer userComputer){
    return userComputer.compBrand;
  }

  public double getYear(Computer userComputer){
    return userComputer.compYearPurchase;
  }

  public double getMadeYear(Computer userComputer){
    return userComputer.compYearWarranty;
  }


}

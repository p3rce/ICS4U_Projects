import java.io.*;
import java.util.*;
import java.lang.*;

public class Building {
    
    //declare variables needed (make private for security)
    private String buildingName;
    private int numberOfUnits;
    private int numberOfComplaints;
    private String landlordFullname;

    //init
    public Building(String buildingName, int numberOfUnits, int numberOfComplaints, String landlordFullname){

        //.this to access outside of construct
        this.buildingName = buildingName;
        this.numberOfUnits = numberOfUnits;
        this.numberOfComplaints = numberOfComplaints;
        this.landlordFullname = landlordFullname;
    }

    //MARK: Helper Methods
    public double complaintPercentage(){
        //Get percentage of complaints based on units in building
        double total = (double)(numberOfComplaints) / (double)(numberOfUnits) * 100; //cast as double because could be 14.2% or 78.5%

        return total;
    }


    //MARK: Building Name
    public void setBuildingName(String newBuildingName){
        this.buildingName = newBuildingName;
    }
    
    public String getBuildingName(){
        return buildingName;
    }

    //MARK: Number Of Units
    public void setNumberOfUnits(int newNumberOfUnits){
        this.numberOfUnits = newNumberOfUnits;
    }

    public int getNumberOfUnits(){
        return numberOfUnits;
    }

    //MARK: Building Complaints
    public void setTotalComplaints(int newNumberOfComplaints){
        this.numberOfComplaints = newNumberOfComplaints;
    }

    public int getTotalComplaints(){
        return numberOfComplaints;
    }

    //MARK: Landlord Name
    public void setLandlordFullname(String newLandlordFullname){
        this.landlordFullname = newLandlordFullname;
    }

    public String getLandlordFullname(){
        return landlordFullname;
    }

    //MARK: toString Method
    public String toString(){

        //Put building info into easy to read toString method for easy access

        String x = "---------- DATA FOR "+this.buildingName +": \n Number Of Units: "+this.numberOfUnits+" \n Total Complaint Count: "+this.numberOfComplaints+" \n Landlord Fullname: "+this.landlordFullname+" \n ";

        return x;

    }


}

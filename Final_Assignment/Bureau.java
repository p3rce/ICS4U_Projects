import java.util.*;
import java.io.*;
import java.lang.*;

class Bureau {

    // declare variables needed (made private for security)
    private Building[] buildingArray; // an array of building named buildingArray
    private int bSize; // num of buulding objs
    private String fileName; // name of file w/ raw data

    // init
    public Bureau(int bSize) {
        this.bSize = bSize;

        // check to make sure not greater then 100
        if (bSize > 100) {
            System.out.println("Can't have more then 100 buildings");
            System.exit(0);
        }

        buildingArray = new Building[bSize];

    }

    // MARK: Helper methods
    private static void getRunTime(long start, long end, String toFind) {
        System.out.println("Total Run Time to " + toFind + " : " + (end - start) + " \n");
    }

    private static boolean fileDoesExist(String fileName) {
        File f = new File(fileName);

        if (f.exists()) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean checkBuildingCount(String fileName, int enteredNumberOfBuildings) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            int lines = 0;

            while(reader.readLine() != null){
                lines++;
            }

            reader.close();

            int realNumOfBuildings = lines /4;

            if(realNumOfBuildings != enteredNumberOfBuildings){
                return false;
            } else {
                return true;
            }
        } catch (IOException errror){
            System.out.println("error");
        }
        return false;

    }

    public static void main(String[] args) {
        
        //initalize scanner and needed variables
        Scanner sc = new Scanner(System.in);
        long startTime = System.nanoTime();

        System.out.println("Enter file name (include .txt): ");
        String fileName = sc.nextLine();

        //check file exists
        boolean doesFileExist = fileDoesExist(fileName);

        while(doesFileExist == false){

            System.out.println("File does not exist! Please try again");

            System.out.println("Enter file name (include .txt): ");
            fileName = sc.nextLine();
    
            //check file exists
            doesFileExist = fileDoesExist(fileName);

            if(doesFileExist == true){
                break;
            }

        }


        System.out.println("Enter how many buildings: ");
        int buildingSize = sc.nextInt();

        //check if building count is correct
        boolean isBuildingNumbersCorrect = checkBuildingCount(fileName, buildingSize);

        while(isBuildingNumbersCorrect == false){
            System.out.println("Number of buildings in file is incorrect! \n");

            System.out.println("Enter how many buildings: ");
            buildingSize = sc.nextInt();

            //check if building count is correct
            isBuildingNumbersCorrect = checkBuildingCount(fileName, buildingSize);

            if(isBuildingNumbersCorrect == true ){
                break;
            }
            
        }

        Bureau doRun = new Bureau(buildingSize);
        int i = 0;

        //run all methods needed
        doRun.step1(i, fileName);
        doRun.step2(doRun.buildingArray, fileName);
        doRun.step3(doRun.buildingArray, fileName);
        doRun.step4(doRun.buildingArray, fileName);
        doRun.step5(doRun.buildingArray, fileName);

        //success so show message
        System.out.println("Success! Please check "+fileName+" for the constructed data!");


        //get end time when done running through
        long endTime = System.nanoTime();
        getRunTime(startTime, endTime, "run whole program");



    }



    //MARK: 1. Raw data
    public void step1(int num, String fileName){

        //declare variables
        long startTime = System.nanoTime();
        String line = " ";
        String buildingName; 
        String landlordFullname;
        int numberOfUnits; 
        int numberOfComplaints;


        try{

          BufferedReader bRead = new BufferedReader(new FileReader(fileName));
          line = bRead.readLine();

            while(line != null){
                //get each piece to save
                buildingName = line; //building name
                line = bRead.readLine();

                numberOfUnits = Integer.parseInt(line); //number of units
                line = bRead.readLine();

                numberOfComplaints = Integer.parseInt(line); //number of complaints
                line = bRead.readLine();

                landlordFullname = line; //landlord fullname
                line = bRead.readLine();

                //save to objc 

                Building newBuilding = new Building(buildingName, numberOfUnits, numberOfComplaints, landlordFullname);

                buildingArray[num] = newBuilding; 

                num++; //add so doesnt go over
            }
            
          BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName, true)); //true used to set append to TRUE

          bWriter.write(" \n \n ---------- APARTMENT MANAGEMENT SYSTEM ----------");
          bWriter.write("\n");

          bWriter.write("");

          bWriter.write("---------- RAW DATA ----------");
          bWriter.newLine();

            for (int i = 0; i < buildingArray.length; i++){

                bWriter.write(String.valueOf(buildingArray[i]));

                bWriter.newLine();
            }

          //must close filereader and bufferedwriter

          bWriter.close();
          bRead.close();
        }
        catch(IOException error){
          System.out.println(error);
        }

        long endTime = System.nanoTime();

        getRunTime(startTime, endTime, "get raw data");


      } //end step 1


      //MARK: 2. List of data by building name (alpha) - Uses selection sort
      public void step2(Building[] buildingArray, String fileName){
        
        long startTime = System.nanoTime();
    
        for (int i = 0; i < bSize; i++){
          int smallestI = i;

          for (int x = i; x < bSize; x++){
            if (buildingArray[x].getBuildingName().compareTo(buildingArray[smallestI].getBuildingName()) < buildingArray[smallestI].getBuildingName().compareTo(buildingArray[x].getBuildingName())) {
              smallestI = x;
            }

          }


          if (smallestI != i){
            Building numSwap = buildingArray[smallestI];
            buildingArray[smallestI] = buildingArray[i];
            buildingArray[i] = numSwap;
          }
        }


            try{


                BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName, true));
                bWriter.newLine();
                bWriter.write("---------- DATA SORTED BY BUILDING ----------");
                bWriter.newLine();

                    for (int y = 0; y < buildingArray.length ; y++){
                        bWriter.write(buildingArray[y] + " \n");
                    }
                bWriter.close();
            }

            catch(IOException error){
                System.out.println(error);
            }

        long endTime = System.nanoTime();
        getRunTime(startTime, endTime, "get data sorted by building");


      } //end step 2
    


      //MARK: 3. Sort data by landlord in alpha - uses Insertion Sorting
      public void step3(Building[] buildingArray, String fileName){
        
        long startTime = System.nanoTime();
    
        for (int i = 0; i < bSize; i++){
          int j = i;

          while(j > 0 && buildingArray[j-1].getLandlordFullname().compareTo(buildingArray[j].getLandlordFullname()) > buildingArray[j].getLandlordFullname().compareTo(buildingArray[j-1].getLandlordFullname())){

            //swap using insertion Sort method
            Building numSwap = buildingArray[j - 1];
            buildingArray[j - 1] = buildingArray[j];
            buildingArray[j] = numSwap;

            j--;
          }
        }

            try{

                BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName, true));
                bWriter.newLine();
                bWriter.write("---------- DATA SORTED BY LANDLORD FULLNAME ----------");
                bWriter.newLine();

                    for (int y = 0; y < buildingArray.length ; y++){
                        bWriter.write(buildingArray[y] + " \n");
                    }
                bWriter.close();
            }

            catch(IOException error){
                System.out.println(error);
            }

        long endTime = System.nanoTime();
        getRunTime(startTime, endTime, "to get data sorted by landlord fullname");


      } //end step 3


      /* MARK: 4. Alpha order by landlord, one entry for each landlord, showing total number of units owned by landlord and total number of complaints
      - Uses Bubble Sort
      */
      public void step4(Building[] buildingArray, String fileName){

        long startTime = System.nanoTime();

        //create a new array to compare
        Building [] otherBuildingArray = new Building[bSize];
        
        for(int g = 0; g < bSize; g++){
            //set new array to buildingArray
            otherBuildingArray[g] = buildingArray[g];
        }

        for(int a = 1; a < bSize; a++){
            for(int b = 0; b < bSize - 1; b++){
                if(otherBuildingArray[b + 1].getLandlordFullname().equals(otherBuildingArray[b].getLandlordFullname())){
                    //if landlord has same name as another collection of data, add units and complaints
                    otherBuildingArray[b] = new Building(otherBuildingArray[b].getBuildingName(), otherBuildingArray[b].getNumberOfUnits()+otherBuildingArray[b + 1].getNumberOfUnits(), otherBuildingArray[b].getTotalComplaints()+otherBuildingArray[b + 1].getTotalComplaints(), otherBuildingArray[b].getLandlordFullname());

                    otherBuildingArray[b + 1] = new Building(" ", 0, 0, " "); //only data for units and complaints

                }
            }
        }

        try {

            BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName, true));
                bWriter.newLine();
                bWriter.write("---------- DATA SORTED BY LANDLORD AND COMPLAINTS ----------");
                bWriter.newLine();

                    for (int y = 0; y < otherBuildingArray.length ; y++){
                        
                        if(otherBuildingArray[y].getLandlordFullname() == " "){
                            //no
                            bWriter.write("");
                        } else {
                            //write to file
                            bWriter.write("Landlord Fullname: "+otherBuildingArray[y].getLandlordFullname()+" \n Number of Units Managing: "+otherBuildingArray[y].getNumberOfUnits()+" \n Number of Complaints: "+ otherBuildingArray[y].getTotalComplaints()+ "\n");
                        }

                    }
                bWriter.close();
            }

        catch(IOException error){
            System.out.println(error);
         }




        //calculate run time
        long endTime = System.nanoTime();

        getRunTime(startTime, endTime, "get data by landlord fullname and complaints");

      } //end step 4


      /* MARK: 5. Get the worst landlord based on complaint count relative to number of units
      - Uses Search & Insertion Sorting

      */

      public void step5(Building[] buildingArray, String fileName){

        long startTime = System.nanoTime();
        int count = 0;
        
        //create a new array to compare
        Building [] otherBuildingArray = new Building[bSize];

        for(int g = 0; g < bSize; g++){
            //set new array to buildingArray
            otherBuildingArray[g] = buildingArray[g];
        }

        for(int a = 1; a < bSize; a++){
            for(int b = 0; b < bSize - 1; b++){
                if(otherBuildingArray[b + 1].getLandlordFullname().equals(otherBuildingArray[b].getLandlordFullname())){

                    otherBuildingArray[b] = new Building(otherBuildingArray[b].getBuildingName(), otherBuildingArray[b].getNumberOfUnits()+otherBuildingArray[b + 1].getNumberOfUnits(), otherBuildingArray[b].getTotalComplaints()+otherBuildingArray[b + 1].getTotalComplaints(), otherBuildingArray[b].getLandlordFullname());

                    otherBuildingArray[b + 1] = new Building(" ", 0, 0, " "); //only data for units and complaints

                }
            }
        }


        for(int c = 0; c < otherBuildingArray.length; c++){
            if(otherBuildingArray[c].getLandlordFullname().equals(" ")){
                //add a space
                System.out.println(" ");
            } else {
                //move on
                count++;
            }
        }

        Building [] tempBuildingArray = new Building[count];
        int left = 0;

        for(int d = 0; d < otherBuildingArray.length; d++){
            if(otherBuildingArray[d].getLandlordFullname().equals(" ")){
                System.out.println(" ");
            } else {
                for (int e = left; e < count; e++){
                    tempBuildingArray[e] = otherBuildingArray[d];

                }
                left++;
            }
        }

        //use insertion sort to move top complaint to 0 index
        for(int f = 0; f < tempBuildingArray.length; f++){
            int g = f;

            while(g > 0 && tempBuildingArray[g - 1].complaintPercentage() < tempBuildingArray[g].complaintPercentage()){

                Building numSwap = tempBuildingArray[g - 1];
                tempBuildingArray[g - 1] = tempBuildingArray[g];
                tempBuildingArray[g] = numSwap;

                g--;
            }

        }

        try {

            BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName, true));
                bWriter.newLine();
                bWriter.write("---------- WORST LANDLORD ----------");
                bWriter.newLine();

                bWriter.write("Worst Landlord: "+tempBuildingArray[0].getLandlordFullname()+" with complaint percentage at : "+tempBuildingArray[0].complaintPercentage() +"%");

                bWriter.close();
            }

        catch(IOException error){
            System.out.println(error);
         }


        long endTime = System.nanoTime();
        getRunTime(startTime, endTime, "to get worst landlord");

      } //end step 5


} //end Bureau class

package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.Scanner;
import java.util.*;
public class Main{

    public static void main (String[] args) {
        Scanner scannerObj = new Scanner(System.in);
           System.out.println("Enter your username.");
   
           String userName = scannerObj.nextLine();
   
           System.out.println('\n');
           System.out.println("Enter your password.");
   
           String passWord = scannerObj.nextLine();
   
           QueriesHandling myJDBC = new QueriesHandling("jdbc:mysql://localhost/competition",userName,passWord);
           myJDBC.initializeConnection(userName,passWord);
   
           System.out.println('\n');
           System.out.println("Choose a furniture to view a selection of Chair, Desk, Lamp, or Filing.");
   
           String selectedFurniture = scannerObj.nextLine();
           System.out.println("You have selected : " + selectedFurniture);
           
           System.out.println(myJDBC.selectFurniture(selectedFurniture));
   
           System.out.println('\n');
           System.out.println("Would you like to continue browsing? (yes/no)");
           String contSelectionMenu = scannerObj.nextLine();
   
           while(contSelectionMenu.equals("yes")){
               System.out.println('\n');
               System.out.println("Choose a furniture to view a selection of Chair, Desk, Lamp, or Filing.");
   
               selectedFurniture = scannerObj.nextLine();
               System.out.println("You have selected : " + selectedFurniture);
           
               System.out.println(myJDBC.selectFurniture(selectedFurniture));
   
               System.out.println('\n');
               System.out.println("Would you like to continue browsing? (yes/no)");
               contSelectionMenu = scannerObj.nextLine();
   
           }
   
   
           String contSelectionMenu2 = "yes";
   
           do{
               System.out.println('\n');
               System.out.println("Pick a specific furniture category: (i.e. Chair, Desk, Lamp, or Filing) ");
               String specificCat = scannerObj.nextLine();
               System.out.println("You have selected : " + specificCat);
   
               System.out.println('\n');
               System.out.println("What would you like to search for: (i.e. ID, Type, Legs, Bulb, etc.) ");
               String specificVar = scannerObj.nextLine();
               System.out.println("You have selected : " + specificVar);
   
               System.out.println('\n');
               System.out.println("Enter the specific " +specificVar+" you are looking for:");
               String inputSearch = scannerObj.nextLine();
               System.out.println("You are searching for: " + inputSearch);
   
               System.out.println(myJDBC.specificSelection(specificCat,specificVar, inputSearch));
   
               System.out.println('\n');
               System.out.println("Would you like to continue searching? (yes/no)");
               contSelectionMenu2 = scannerObj.nextLine();
           }while(contSelectionMenu2.equals("yes"));
        
           String contSelectionMenu3 = "yes";
   
           /*
           System.out.println('\n');
           System.out.println("You are now looking for an individual characteristic.");
   
           do{
               System.out.println('\n');
               System.out.println("Pick a specific furniture category: (i.e. Chair, Desk, Lamp, or Filing) ");
               String specificCat = scannerObj.nextLine();
               System.out.println("You have selected : " + specificCat);
   
               System.out.println('\n');
               System.out.println("What would you like to search for: (i.e. ID, Type, Legs, Bulb, etc.) ");
               String specificVar = scannerObj.nextLine();
               System.out.println("You have selected : " + specificVar);
   
               System.out.println('\n');
               System.out.println("Enter the specific " +specificVar+" you are looking for:");
               String inputSearch = scannerObj.nextLine();
               System.out.println("You are searching for: " + inputSearch);
   
               System.out.println('\n');
               System.out.println("What value would you like (i.e. ID, ManuID, Type) :");
               String searchInput = scannerObj.nextLine();
               System.out.println("You are searching for: " + searchInput);
   
               System.out.println(myJDBC.testingStrArr(specificCat,specificVar, inputSearch, searchInput));
   
               System.out.println('\n');
               System.out.println("Would you like to continue searching? (yes/no)");
               contSelectionMenu3 = scannerObj.nextLine();
           }while(contSelectionMenu3.equals("yes"));
   
           */
   
           System.out.println('\n');
           System.out.println("You may now make a request form.");
   
           do{
               System.out.println('\n');
               System.out.println("What category of furniture would you like?: (i.e. Chair, Desk, Lamp, or Filing) ");
               String specificCat = scannerObj.nextLine();
               System.out.println("You have selected the category: " + specificCat);
   
               System.out.println('\n');
               System.out.println("What type of "+specificCat+" would you like?");
               String specificType = scannerObj.nextLine();
   
               System.out.println('\n');
               System.out.println("What quantity of " +specificType+" "+specificCat+" would you like:");
               String quantity = scannerObj.nextLine();
               System.out.println("Requesting: " + quantity+ " "+ specificType+" "+specificCat+"s.....");
   
               System.out.println(myJDBC.callCombinations(specificCat,specificType, quantity));
   
               System.out.println('\n');
               System.out.println("Would you like to make another request? (yes/no)");
               contSelectionMenu3 = scannerObj.nextLine();
           }while(contSelectionMenu3.equals("yes"));
   }


}

package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.Scanner;
import java.util.*;
public class Main{

    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter your username.");

        String userName = scannerObj.nextLine();

        System.out.println('\n');
        System.out.println("Enter your password.");

        String passWord = scannerObj.nextLine();

        QueriesHandling myJDBC = new QueriesHandling("jdbc:mysql://localhost/inventory",userName,passWord);
        myJDBC.initializeConnection(userName,passWord);
        
        String selectionBOO="yes";
        
        do{
        System.out.println('\n');
        System.out.println("Would you like to browse the stock of furniture or place an order?(browse/order)");
        String browseOrOrder = scannerObj.nextLine();
        
        if (browseOrOrder.equalsIgnoreCase("browse")){

         String contSelectionMenu = "yes";
 
        do{
             System.out.println('\n');
             System.out.println("Choose a furniture to view a selection of Chair, Desk, Lamp, or Filing.");
 
             String selectedFurniture = scannerObj.nextLine();
             System.out.println("You have selected : " + selectedFurniture);
         
             System.out.println(myJDBC.selectFurniture(selectedFurniture));
 
             System.out.println('\n');
             System.out.println("Would you like to continue browsing? (yes/no)");
             contSelectionMenu = scannerObj.nextLine();
 
         }while(contSelectionMenu.equals("yes"));
 
 
         

         System.out.println('\n');
            System.out.println("Would you to search for a list of specific furniture(s)? i.e. Mesh chairs or a furniture with specific ID (yes/no)");
            String contSelectionMenu2 = scannerObj.nextLine();

 
            while(contSelectionMenu2.equals("yes")){
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
         }
      
 

        }


      
        if (browseOrOrder.equalsIgnoreCase("order")){
        
        System.out.println('\n');
        System.out.println("You may now make a request form.");

        String contSelectionMenu3 = "yes";

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
            int quantity = Integer.parseInt(scannerObj.nextLine());
            System.out.println("Requesting: " + quantity+ " "+ specificType+" "+specificCat+"s.....");

            myJDBC.callCombinations(specificCat,specificType, quantity);

            System.out.println('\n');
            System.out.println("Would you like to make another request? (yes/no)");
            contSelectionMenu3 = scannerObj.nextLine();
        }while(contSelectionMenu3.equals("yes"));
     }


        System.out.println('\n');
            System.out.println("Would you like to continue browsing or ordering?(yes/no)");
        selectionBOO= scannerObj.nextLine();

     }while (selectionBOO.equals("yes"));


    }

}

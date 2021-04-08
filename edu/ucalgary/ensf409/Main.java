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

        /////checks for exceptions
        boolean bool=false;
        if ((browseOrOrder.equalsIgnoreCase("browse"))||(browseOrOrder.equalsIgnoreCase("order")))
        {
            bool=true;
        }
    
        while(!bool){
            System.out.println('\n');
            System.out.println("Invalid input. Please try again.");
            System.out.println("Would you like to browse the stock of furniture or place an order?(browse/order)");
            browseOrOrder = scannerObj.nextLine();

            if ((browseOrOrder.equalsIgnoreCase("browse"))||(browseOrOrder.equalsIgnoreCase("order")))
            {
            bool=true;
            }

        }
        
        if (browseOrOrder.equalsIgnoreCase("browse")){

         String contSelectionMenu = "yes";
 
        boolean bool2= false;
        boolean bool3=false;

        do{
             System.out.println('\n');
             System.out.println("Choose a furniture to view a selection of Chair, Desk, Lamp, or Filing.");
 
             String selectedFurniture = scannerObj.nextLine();
             if ((selectedFurniture.equalsIgnoreCase("chair"))||(selectedFurniture.equalsIgnoreCase("desk"))||(selectedFurniture.equalsIgnoreCase("lamp"))||(selectedFurniture.equalsIgnoreCase("filing")))
                 {
                      bool2=true;
                }
    
        while(!bool2){
            System.out.println('\n');
            System.out.println("Invalid input. Please try again.");
            System.out.println("Choose a furniture to view a selection of Chair, Desk, Lamp, or Filing.");
            selectedFurniture = scannerObj.nextLine();

            if ((selectedFurniture.equalsIgnoreCase("chair"))||(selectedFurniture.equalsIgnoreCase("desk"))||(selectedFurniture.equalsIgnoreCase("lamp"))||(selectedFurniture.equalsIgnoreCase("filing")))
            {
                bool2=true;
            }
        }


             System.out.println("You have selected : " + selectedFurniture);
         
             System.out.println(myJDBC.selectFurniture(selectedFurniture));
 
             System.out.println('\n');
             System.out.println("Would you like to continue browsing? (yes/no)");
             contSelectionMenu = scannerObj.nextLine();

             if ((contSelectionMenu.equalsIgnoreCase("yes"))||(contSelectionMenu.equalsIgnoreCase("no")))
                 {
                      bool3=true;
                }
    
        while(!bool3){
            System.out.println('\n');
            System.out.println("Invalid input. Please try again.");
            System.out.println("Would you like to continue browsing? (yes/no)");
            contSelectionMenu = scannerObj.nextLine();

            if ((contSelectionMenu.equalsIgnoreCase("yes"))||(contSelectionMenu.equalsIgnoreCase("no")))
            {
                bool3=true;
            }
        }
 
         }while(contSelectionMenu.equals("yes"));
 
 
         

         System.out.println('\n');
            System.out.println("Would you to search for a list of specific furniture(s)? i.e. Mesh chairs or a furniture with specific ID (yes/no)");
            String contSelectionMenu2 = scannerObj.nextLine();

            boolean bool4=false;

            if ((contSelectionMenu2.equalsIgnoreCase("yes"))||(contSelectionMenu2.equalsIgnoreCase("no")))
                {
                 bool4=true;
                 }

             while(!bool4){
              System.out.println('\n');
              System.out.println("Invalid input. Please try again.");
             System.out.println("Would you to search for a list of specific furniture(s)? i.e. Mesh chairs or a furniture with specific ID (yes/no)");
             contSelectionMenu2 = scannerObj.nextLine();

             if ((contSelectionMenu2.equalsIgnoreCase("yes"))||(contSelectionMenu2.equalsIgnoreCase("no")))
             {
                 bool4=true;
             }
            }

 
            while(contSelectionMenu2.equals("yes")){
             System.out.println('\n');
             System.out.println("Pick a specific furniture category: (i.e. Chair, Desk, Lamp, or Filing) ");
             String specificCat = scannerObj.nextLine();
           ////exceptions
             boolean bool5=false;
             if ((specificCat.equalsIgnoreCase("chair"))||(specificCat.equalsIgnoreCase("desk"))||(specificCat.equalsIgnoreCase("lamp"))||(specificCat.equalsIgnoreCase("filing")))
             {
                  bool5=true;
            }

             while(!bool5){
               System.out.println('\n');
               System.out.println("Invalid input. Please try again.");
               System.out.println("Pick a specific furniture category: (i.e. Chair, Desk, Lamp, or Filing) ");
               specificCat = scannerObj.nextLine();

               if ((specificCat.equalsIgnoreCase("chair"))||(specificCat.equalsIgnoreCase("desk"))||(specificCat.equalsIgnoreCase("lamp"))||(specificCat.equalsIgnoreCase("filing")))
               {
                   bool5=true;
                }
               }

             System.out.println("You have selected : " + specificCat);
 
             System.out.println('\n');
             System.out.println("What would you like to search for: (i.e. ID, Type, ManuID, Price) ");
             String specificVar = scannerObj.nextLine();
            /////exceptions
             boolean bool6=false;
             if ((specificVar.equalsIgnoreCase("id"))||(specificVar.equalsIgnoreCase("type"))||(specificVar.equalsIgnoreCase("manuid"))||(specificCat.equalsIgnoreCase("price")))
             {
                  bool6=true;
            }

             while(!bool6){
               System.out.println('\n');
               System.out.println("Invalid input. Please try again.");
               System.out.println("What would you like to search for: (i.e. ID, Type, ManuID, Price) ");
               specificVar = scannerObj.nextLine();

               if ((specificVar.equalsIgnoreCase("id"))||(specificVar.equalsIgnoreCase("type"))||(specificVar.equalsIgnoreCase("manuid"))||(specificCat.equalsIgnoreCase("price")))
               {
                   bool6=true;
                }
               }

             System.out.println("You have selected : " + specificVar);
 
             System.out.println('\n');
             System.out.println("Enter the specific " +specificVar+" you are looking for:");
             String inputSearch = scannerObj.nextLine();
             System.out.println("You are searching for: " + inputSearch);
 
             System.out.println(myJDBC.specificSelection(specificCat,specificVar, inputSearch));
 
             System.out.println('\n');
             System.out.println("Would you like to continue searching? (yes/no)");
             contSelectionMenu2 = scannerObj.nextLine();
             /////exception
              bool4=false;

            if ((contSelectionMenu2.equalsIgnoreCase("yes"))||(contSelectionMenu2.equalsIgnoreCase("no")))
                {
                 bool4=true;
                 }

             while(!bool4){
              System.out.println('\n');
              System.out.println("Invalid input. Please try again.");
              System.out.println("Would you like to continue searching? (yes/no)");
             contSelectionMenu2 = scannerObj.nextLine();

             if ((contSelectionMenu2.equalsIgnoreCase("yes"))||(contSelectionMenu2.equalsIgnoreCase("no")))
             {
                 bool4=true;
             }
            }
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
               ////exceptions
               boolean bool7=false;
               if ((specificCat.equalsIgnoreCase("chair"))||(specificCat.equalsIgnoreCase("desk"))||(specificCat.equalsIgnoreCase("lamp"))||(specificCat.equalsIgnoreCase("filing")))
               {
                    bool7=true;
              }
  
               while(!bool7){
                 System.out.println('\n');
                 System.out.println("Invalid input. Please try again.");
                 System.out.println("Pick a specific furniture category: (i.e. Chair, Desk, Lamp, or Filing) ");
                 specificCat = scannerObj.nextLine();
  
                 if ((specificCat.equalsIgnoreCase("chair"))||(specificCat.equalsIgnoreCase("desk"))||(specificCat.equalsIgnoreCase("lamp"))||(specificCat.equalsIgnoreCase("filing")))
                 {
                     bool7=true;
                  }
                 }
            System.out.println("You have selected the category: " + specificCat);

            System.out.println('\n');
            System.out.println("What type of "+specificCat+" would you like?");
            String specificType = scannerObj.nextLine();

               ////exceptions
               boolean bool8=false;
               if (specificCat.equalsIgnoreCase("chair"))
               {
                   if ((specificType.equalsIgnoreCase("kneeling"))||(specificType.equalsIgnoreCase("task"))||(specificType.equalsIgnoreCase("mesh"))||(specificType.equalsIgnoreCase("executive"))||(specificType.equalsIgnoreCase("ergonomic")))
                   {
                    bool8=true;
                   }
               }
               else if (specificCat.equalsIgnoreCase("desk"))
               {
                if ((specificType.equalsIgnoreCase("standing"))||(specificType.equalsIgnoreCase("adjustable"))||(specificType.equalsIgnoreCase("traditional")))
                {
                 bool8=true;
                }
            }
            else if (specificCat.equalsIgnoreCase("lamp"))
               {
                if ((specificType.equalsIgnoreCase("desk"))||(specificType.equalsIgnoreCase("study"))||(specificType.equalsIgnoreCase("swing arm")))
                {
                 bool8=true;
                }
            }
            else if (specificCat.equalsIgnoreCase("filing"))
               {
                if ((specificType.equalsIgnoreCase("small"))||(specificType.equalsIgnoreCase("medium"))||(specificType.equalsIgnoreCase("large")))
                {
                 bool8=true;
                }
            }
  
               while(!bool8){
                 System.out.println('\n');
                 System.out.println("Invalid input. Please try again.");
                 System.out.println("What type of "+specificCat+" would you like?");
                 specificType = scannerObj.nextLine();
  
                 if (specificCat.equalsIgnoreCase("chair"))
                 {
                     if ((specificType.equalsIgnoreCase("kneeling"))||(specificType.equalsIgnoreCase("task"))||(specificType.equalsIgnoreCase("mesh"))||(specificType.equalsIgnoreCase("executive"))||(specificType.equalsIgnoreCase("ergonomic")))
                     {
                      bool8=true;
                     }
                 }
                 else if (specificCat.equalsIgnoreCase("desk"))
                 {
                  if ((specificType.equalsIgnoreCase("standing"))||(specificType.equalsIgnoreCase("adjustable"))||(specificType.equalsIgnoreCase("traditional")))
                  {
                   bool8=true;
                  }
              }
              else if (specificCat.equalsIgnoreCase("lamp"))
                 {
                  if ((specificType.equalsIgnoreCase("desk"))||(specificType.equalsIgnoreCase("study"))||(specificType.equalsIgnoreCase("swing arm")))
                  {
                   bool8=true;
                  }
              }
              else if (specificCat.equalsIgnoreCase("filing"))
                 {
                  if ((specificType.equalsIgnoreCase("small"))||(specificType.equalsIgnoreCase("medium"))||(specificType.equalsIgnoreCase("large")))
                  {
                   bool8=true;
                  }
              }
                 }

            System.out.println('\n');
            System.out.println("What quantity of " +specificType+" "+specificCat+" would you like:");
            String quantity1 = scannerObj.nextLine();
                  ////exceptions
                  boolean bool9=false;
                  
 
                    try {
                      int x = Integer.parseInt(quantity1); 
        
                      if (x>0){
                        bool9=true;
                        }
                        else if (x<=0){
                            System.out.println("Invalid input, cannot request negative numbers or 0. Please try again."); 
                        }
                    }catch(NumberFormatException e) {
                      System.out.println("Invalid input. Please try again."); 
                    } 

     
                  while(!bool9){
                    System.out.println("What quantity of " +specificType+" "+specificCat+" would you like:");
                    quantity1 = scannerObj.nextLine();
     
                    try {
                        int x = Integer.parseInt(quantity1); 
                  
                        if (x>0){
                            bool9=true;
                            }
                            else if (x<=0){
                                System.out.println("Invalid input, cannot request negative numbers or 0. Please try again."); 
                            }
                      }catch(NumberFormatException e) {
                        System.out.println("Invalid input. Please try again."); 
                      } 
                     
                    }

            int quantity = Integer.parseInt(quantity1);
            System.out.println("Requesting: " + quantity+ " "+ specificType+" "+specificCat+"s.....");

            myJDBC.callCombinations(specificCat,specificType, quantity);

            System.out.println('\n');
            System.out.println("Would you like to make another request? (yes/no)");
            contSelectionMenu3 = scannerObj.nextLine();

            /////exception
            boolean bool10=false;

            if ((contSelectionMenu3.equalsIgnoreCase("yes"))||(contSelectionMenu3.equalsIgnoreCase("no")))
                {
                 bool10=true;
                 }

             while(!bool10){
              System.out.println('\n');
              System.out.println("Invalid input. Please try again.");
              System.out.println("Would you like to make another request? (yes/no)");
             contSelectionMenu3 = scannerObj.nextLine();

             if ((contSelectionMenu3.equalsIgnoreCase("yes"))||(contSelectionMenu3.equalsIgnoreCase("no")))
             {
                 bool10=true;
             }
            }
        }while(contSelectionMenu3.equals("yes"));
     }


        System.out.println('\n');
            System.out.println("Would you like to continue browsing or ordering?(yes/no)");
        selectionBOO= scannerObj.nextLine();
         /////exception
         boolean bool11=false;

         if ((selectionBOO.equalsIgnoreCase("yes"))||(selectionBOO.equalsIgnoreCase("no")))
             {
              bool11=true;
              }

          while(!bool11){
           System.out.println('\n');
           System.out.println("Invalid input. Please try again.");
           System.out.println("Would you like to continue browsing or ordering?(yes/no)");
          selectionBOO = scannerObj.nextLine();

          if ((selectionBOO.equalsIgnoreCase("yes"))||(selectionBOO.equalsIgnoreCase("no")))
          {
              bool11=true;
          }
         }

        

     }while (selectionBOO.equals("yes"));


    }

}

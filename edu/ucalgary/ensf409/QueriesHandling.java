package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.Scanner;
import java.util.*;



public class QueriesHandling {
    public final String DBURL;
    public final String USERNAME; 
    public final String PASSWORD; 
    ///private ArrayList<Combination> aCombination;

    private ResultSet results;
    private Connection dbConnect;

    public static void main(String[] args) {

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
            int quantity = scannerObj.nextLine();
            System.out.println("Requesting: " + inputSearch+ " "+ specificType+" "+specificCat+"s.....");

            System.out.println(myJDBC.callCombinations(specificCat,specificType, quantity));

            System.out.println('\n');
            System.out.println("Would you like to make another request? (yes/no)");
            contSelectionMenu3 = scannerObj.nextLine();
        }while(contSelectionMenu3.equals("yes"));





   
        
    }

/**
 * 
 * @param url
 * @param username
 * @param password
 */

    public QueriesHandling(String url, String username, String password){
        DBURL=url;
        USERNAME=username;
        PASSWORD=password;
    }

/**
 * 
 * @return
 */

    public String getDBURL(){
        return this.DBURL;

    }

/**
 * 
 * @return
 */

    public String getUSERNAME(){
        return this.USERNAME;

    }

/**
 * 
 * @return
 */

    public String getPASSWORD(){
        return this.PASSWORD;

    }

/**
 * 
 * @param a
 * @param b
 */

    public void initializeConnection(String a, String b){
        try{
            dbConnect= DriverManager.getConnection("jdbc:mysql://localhost/inventory", a, b);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

/**
 * 
 * @param furniture
 * @return
 */

    public String selectFurniture(String furniture){
        StringBuffer seeFurniture= new StringBuffer();

        try{
            Statement myStmt = dbConnect.createStatement();
            results= myStmt.executeQuery("SELECT * FROM "+ furniture);

        if (furniture.equalsIgnoreCase("chair"))
        {
            seeFurniture.append("ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID");
            seeFurniture.append('\n');
            seeFurniture.append("___________________________________________");
            seeFurniture.append('\n');

            while(results.next()){
                seeFurniture.append(results.getString("ID")+","+results.getString("Type")+","+results.getString("Legs")+","+results.getString("Arms")+","+results.getString("Seat")+","+results.getString("Cushion")+","+results.getString("Price")+","+results.getString("ManuID"));
                seeFurniture.append('\n');
            }
        }
        else if (furniture.equalsIgnoreCase("desk"))
        {
            seeFurniture.append("ID, Type, Legs, Top, Drawer, Price, ManuID");
            seeFurniture.append('\n');
            seeFurniture.append("___________________________________________");
            seeFurniture.append('\n');

            while(results.next()){
                seeFurniture.append(results.getString("ID")+","+results.getString("Type")+","+results.getString("Legs")+","+results.getString("Top")+","+results.getString("Drawer")+","+results.getString("Price")+","+results.getString("ManuID"));
                seeFurniture.append('\n');
            }
        }
        else if (furniture.equalsIgnoreCase("lamp"))
        {
            seeFurniture.append("ID, Type, Base, Bulb, Price, ManuID");
            seeFurniture.append('\n');
            seeFurniture.append("___________________________________________");
            seeFurniture.append('\n');

            while(results.next()){
                seeFurniture.append(results.getString("ID")+","+results.getString("Type")+","+results.getString("Base")+","+results.getString("Bulb")+","+results.getString("Price")+","+results.getString("ManuID"));
                seeFurniture.append('\n');
            }
        }
        else if (furniture.equalsIgnoreCase("filing"))
        {
            seeFurniture.append("ID, Type, Rails, Drawers, Cabinet, Price, ManuID");
            seeFurniture.append('\n');
            seeFurniture.append("___________________________________________");
            seeFurniture.append('\n');

            while(results.next()){
                seeFurniture.append(results.getString("ID")+","+results.getString("Type")+","+results.getString("Rails")+","+results.getString("Drawers")+","+results.getString("Cabinet")+","+results.getString("Price")+","+results.getString("ManuID"));
                seeFurniture.append('\n');
            }
        }


            myStmt.close();
    
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return seeFurniture.toString();

    }

/**
 * 
 * @param furniture
 * @param specificVar
 * @param inputSearch
 * @return
 */
 

    public String specificSelection(String furniture,String specificVar,String inputSearch){
        StringBuffer seeFurniture= new StringBuffer();

        try{
            Statement myStmt = dbConnect.createStatement();
            results= myStmt.executeQuery("SELECT * FROM "+furniture+" WHERE "+specificVar+" ='"+ inputSearch+"'");

        if (furniture.equalsIgnoreCase("chair"))
        {
            seeFurniture.append("ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID");
            seeFurniture.append('\n');
            seeFurniture.append("___________________________________________");
            seeFurniture.append('\n');

            while(results.next()){
                seeFurniture.append(results.getString("ID")+","+results.getString("Type")+","+results.getString("Legs")+","+results.getString("Arms")+","+results.getString("Seat")+","+results.getString("Cushion")+","+results.getString("Price")+","+results.getString("ManuID"));
                seeFurniture.append('\n');
            }
        }
        else if (furniture.equalsIgnoreCase("desk"))
        {
            seeFurniture.append("ID, Type, Legs, Top, Drawer, Price, ManuID");
            seeFurniture.append('\n');
            seeFurniture.append("___________________________________________");
            seeFurniture.append('\n');

            while(results.next()){
                seeFurniture.append(results.getString("ID")+","+results.getString("Type")+","+results.getString("Legs")+","+results.getString("Top")+","+results.getString("Drawer")+","+results.getString("Price")+","+results.getString("ManuID"));
                seeFurniture.append('\n');
            }
        }
        else if (furniture.equalsIgnoreCase("lamp"))
        {
            seeFurniture.append("ID, Type, Base, Bulb, Price, ManuID");
            seeFurniture.append('\n');
            seeFurniture.append("___________________________________________");
            seeFurniture.append('\n');

            while(results.next()){
                seeFurniture.append(results.getString("ID")+","+results.getString("Type")+","+results.getString("Base")+","+results.getString("Bulb")+","+results.getString("Price")+","+results.getString("ManuID"));
                seeFurniture.append('\n');
            }
        }
        else if (furniture.equalsIgnoreCase("filing"))
        {
            seeFurniture.append("ID, Type, Rails, Drawers, Cabinet, Price, ManuID");
            seeFurniture.append('\n');
            seeFurniture.append("___________________________________________");
            seeFurniture.append('\n');

            while(results.next()){
                seeFurniture.append(results.getString("ID")+","+results.getString("Type")+","+results.getString("Rails")+","+results.getString("Drawers")+","+results.getString("Cabinet")+","+results.getString("Price")+","+results.getString("ManuID"));
                seeFurniture.append('\n');
            }
        }


            myStmt.close();
    
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return seeFurniture.toString();

    }

/**
 * 
 * @param furniture
 * @param specificVar
 * @param inputSearch
 * @param searchInput
 * @return
 */

    public ArrayList<String> testingStrArr(String furniture,String specificVar,String inputSearch, String searchInput){
        ArrayList<String> testStr= new ArrayList<String>();

        try{
            Statement myStmt = dbConnect.createStatement();
            results= myStmt.executeQuery("SELECT * FROM "+furniture+" WHERE "+specificVar+" ='"+ inputSearch+"'");

            while(results.next()){
                testStr.add(results.getString(searchInput));
            }


            myStmt.close();
    
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return testStr;

    }





    /*public ArrayList<Combination> allCompatible(ArrayList<Furniture> furniture){

    }*/

    /*public ArrayList<String> validManufacturers(String fur, String type){

    }*/

    public void callCombinations(String category, String type, int quantity){
        
    }


    /*public ArrayList<String> getStrArr(String furniture){
        ArrayList<String> testStr= new ArrayList<String>();

        try{
            Statement myStmt = dbConnect.createStatement();
            results= myStmt.executeQuery("SELECT * FROM "+furniture+" WHERE "+specificVar+" ='"+ inputSearch+"'");

            while(results.next()){
                testStr.add(results.getString(searchInput));
            }


            myStmt.close();
    
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return testStr;

    }*/





    public void close(){
        try{
            results.close();
            dbConnect.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}

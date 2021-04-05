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

    public String callCombinations(String category, String type, int quantity){
        if (category.equals("Lamp")){
			Combinations combinationSet = new Combinations();
			combinationSet.findAllCombinationsLamp(allCompatibleLamp(type), quantity);
			Combination result = combinationSet.bestCombination(); // this should contain the best Combination
			
			if (result == null) {
				// TODO: add handling for no combinations found case
			} else {
				 
			}
		} 
        else if(category.equals("Chair")){
            Combinations combinationSet = new Combinations();
			combinationSet.findAllCombinationsChair(allCompatibleChair(type), quantity);
			Combination result = combinationSet.bestCombination(); // this should contain the best Combination
			
			if (result == null) {
				// TODO: add handling for no combinations found case
			} else {
				 
			}
        }
        else if(category.equals("Desk")){
            Combinations combinationSet = new Combinations();
			combinationSet.findAllCombinationsDesk(allCompatibleDesk(type), quantity);
			Combination result = combinationSet.bestCombination(); // this should contain the best Combination
			
			if (result == null) {
				// TODO: add handling for no combinations found case
			} else {
				 
			}
        }
        else if(category.equals("Filing")){
            Combinations combinationSet = new Combinations();
			combinationSet.findAllCombinationsFiling(allCompatibleFiling(type), quantity);
			Combination result = combinationSet.bestCombination(); // this should contain the best Combination
			
			if (result == null) {
				// TODO: add handling for no combinations found case
			} else {
				 
			}
        }

        // TODO: else if for other cases
    }

    private ArrayList<Lamp> allCompatibleLamp(String type)
    {
        ArrayList<Lamp> lampArr = new ArrayList<>();
		try {
			Statement stmt = dbConnect.createStatement();
            this.results = stmt.executeQuery("SELECT * FROM Lamp WHERE Type = " + type);
			
			while(results.next()) {
				int base, bulb;
				if((results.getString("base")).equals("Y")) {
					base = 1;
				} else {
					base = 0;
				}
				if((results.getString("bulb")).equals("Y")) {
					bulb = 1;
				} else {
					bulb = 0;
				}
				
				Lamp a = new Lamp (results.getString("ID"), results.getInt("Price"), results.getString("ManuID"),
										results.getString("Type"), base, bulb);
				lampArr.add(a);						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    private ArrayList<Desk> allCompatibleDesk (String type) {
		ArrayList<Desk> DeskArr = new ArrayList<>();
		try {
			Statement stmt = dbConnect.createStatement();
            this.results = stmt.executeQuery("SELECT * FROM Desk WHERE Type = " + type);
			
			while(results.next()) {
				int legs, top, drawer;
				if((results.getString("legs")).equals("Y")) {
					legs = 1;
				} else {
					legs = 0;
				}
				if((results.getString("top")).equals("Y")) {
					top = 1;
				} else {
					top = 0;
				}
                if((results.getString("top")).equals("Y")) {
					drawer = 1;
				} else {
					drawer = 0;
				}
                
				
				Desk a = new Desk (results.getString("ID"), results.getInt("Price"), results.getString("ManuID"),
										results.getString("Type"), legs, top, drawer);
				DeskArr.add(a);						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    private ArrayList<Chair> allCompatibleChair (String type) {
		ArrayList<Chair> ChairArr = new ArrayList<>();
		try {
			Statement stmt = dbConnect.createStatement();
            this.results = stmt.executeQuery("SELECT * FROM Chair WHERE Type = " + type);
			
			while(results.next()) {
				int legs, arms, seat, cushion;
				if((results.getString("legs")).equals("Y")) {
					legs = 1;
				} else {
					legs = 0;
				}
				if((results.getString("arms")).equals("Y")) {
					arms = 1;
				} else {
				    arms = 0;
				}
                if((results.getString("seat")).equals("Y")) {
					seat = 1;
				} else {
					seat = 0;
				}
                if((results.getString("cushion")).equals("Y")) {
					cushion = 1;
				} else {
					cushion = 0;
				}
                
				
				Chair a = new Chair(results.getString("ID"), results.getInt("Price"), results.getString("ManuID"),
										results.getString("Type"), legs, arms, seat, cushion);
				ChairArr.add(a);						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<Filing> allCompatibleFiling(String type) {
		ArrayList<Filing> FilingArr = new ArrayList<>();
		try {
			Statement stmt = dbConnect.createStatement();
            this.results = stmt.executeQuery("SELECT * FROM Filing WHERE Type = " + type);
			
			while(results.next()) {
				int rails, drawers, cabinet;
				if((results.getString("rails")).equals("Y")) {
					rails = 1;
				} else {
					rails = 0;
				}
				if((results.getString("drawers")).equals("Y")) {
					drawers = 1;
				} else {
				    drawers = 0;
				}
                if((results.getString("cabinet")).equals("Y")) {
					cabinet = 1;
				} else {
					cabinet = 0;
				}
                
                
				
				Filing a = new Filing(results.getString("ID"), results.getInt("Price"), results.getString("ManuID"),
										results.getString("Type"), rails, drawers, cabinet);
				FilingArr.add(a);						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private ArrayList<String> validManufacturers(String fur, String type) {
        ArrayList<String> manuArrayList = new ArrayList<>();
        try {
            Statement stmt = dbConnect.createStatement();
            this.results = stmt.executeQuery("SELECT * FROM " + fur +" WHERE Type = " + type);

            while(results.next()){
                String a = results.getString("ManuID");
                manuArrayList.add(a);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return manuArrayList;
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

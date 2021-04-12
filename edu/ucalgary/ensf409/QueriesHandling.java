package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;
import java.io.*;

/**
 * @author Li, Jack <a href="mailto:jack.li2@ucalgary.ca">
 * @author 
 * @version 1.8
 * @since 1.0
 */


public class QueriesHandling {
    public final String DBURL; //String datamember that holds the directory of the database, cannot be changed after created.
    public final String USERNAME; //String data member that has the username to the database, cannot be changed after created.
    public final String PASSWORD; //String data member that has the password to the database, cannot be changed after created.

    private ResultSet results; //ResultSet data member that holds values obtained from the database
    private Connection dbConnect; //Connection data member that holds the connection to the database


/**
 * Three argument constructor, initializes the members DBURL, USERNAME, and PASSWORD.
 * @param url the string that holds the value to be inserted into DBURL 
 * @param username  the string that holds the value to be inserted into USERNAME
 * @param password the string that holds the value to be inserted into PASSWORD
 */

    public QueriesHandling(String url, String username, String password){
        DBURL=url;
        USERNAME=username;
        PASSWORD=password;
    }

/**
 * Getter method, for DBURL
 * @return the current DBURL for this instance
 */

    public String getDBURL(){
        return this.DBURL;

    }

/**
 * getter method for USERNAME
 * @return this instance's USERNAME
 */

    public String getUSERNAME(){
        return this.USERNAME;

    }

/**
 * getter method for PASSWORD
 * @return this instance's PASSWORD
 */

    public String getPASSWORD(){
        return this.PASSWORD;

    }

/**
 * Creates a connection to the database, using the username and password as arguments.
 * @param userName the username of the user as a string
 * @param passWord the password of the user as a string
 * @return the state of the connection as a boolean data member
 */

    public boolean initializeConnection(String userName, String passWord){
        try{
            dbConnect= DriverManager.getConnection("jdbc:mysql://localhost/inventory", userName, passWord);
            return true;
        } catch (SQLException e){
            System.out.println("Error, password or username was incorrect.");
            return false;
        }
    }

/**
 * Retrieves a specific category of furniture and adds all its characteristics to the results data base
 * afterwards, it appends it to a string buffer which is later converted to a String, which is returned
 * @param furniture the category of the furniture as a string
 * @return a string that contains all the
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
 * This method recieves 3 parameters containing the category of furniture, the desired type of identifier
 * and the specific identifier in order to use the database to find those furnitures that match
 * the given parameters. It then appends the desired results to a string buffer which is later
 * converted into a string to be passed.
 * @param furniture this passes the category of the furniture as a string
 * @param specificVar this passes the desired type of identifier as a string
 * @param inputSearch this passes the specific identifier as a string
 * @return a string which contains the data of the furniture which satisfies the search requirements
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
 * This method takes in 3 parameter and calls combinations from Combinations.java and uses other methods to attempt to obtain
 * the best combination. Later, it calls a method to create an order form.
 * @param category the specific category of the furniture as a string.
 * @param type the specific type of furniture the user is looking for as a string.
 * @param quantity the number of furniture the user requests as an integer.
 */

    public void callCombinations(String category, String type, int quantity){
        if (category.equalsIgnoreCase("Lamp")){
			Combinations combinationSet = new Combinations();
			combinationSet.findAllCombinationsLamp(allCompatibleLamp(type), quantity);
			Combination result = combinationSet.bestCombination(); // this should contain the best Combination
			
			if (result == null) {
                System.out.println("Order cannot be fulfilled based on current inventory. Suggested manufacturers are " +
                "Office Furnishings, Furniture Goods, Fine Office Supplies.");
			} else {
				System.out.println("Items Ordered: ");
				result.print();
				createOrderForm(category, type, quantity, result);
                for (Furniture furniture : result.combination){
                    String id=furniture.getID();
                    removeFurniture(category,id);
                }

			}
		} 
        else if(category.equalsIgnoreCase("Chair")){
            Combinations combinationSet = new Combinations();
			combinationSet.findAllCombinationsChair(allCompatibleChair(type), quantity);
			Combination result = combinationSet.bestCombination(); // this should contain the best Combination
			
			if (result == null) {
				System.out.println("Order cannot be fulfilled based on current inventory. Suggested manufacturers are " +
                        "Office Furnishings, Chairs R Us, Furniture Goods, Fine Office Supplies.");
			} else {
				System.out.println("Items Ordered: ");
				result.print();
				createOrderForm(category, type, quantity, result);
                for (Furniture furniture : result.combination){
                    String id=furniture.getID();
                    removeFurniture(category,id);
                }
			}
        }
        else if(category.equalsIgnoreCase("Desk")){
            Combinations combinationSet = new Combinations();
			combinationSet.findAllCombinationsDesk(allCompatibleDesk(type), quantity);
			Combination result = combinationSet.bestCombination(); // this should contain the best Combination
			
			if (result == null) {
                System.out.println("Order cannot be fulfilled based on current inventory. Suggested manufacturers are " +
                "Academic Desks, Office Furnishings, Furniture Goods, Fine Office Supplies.");
			} else {
				System.out.println("Items Ordered: ");
				result.print();
				createOrderForm(category, type, quantity, result);
                for (Furniture furniture : result.combination){
                    String id=furniture.getID();
                    removeFurniture(category,id);
                }
			}
        }
        else if(category.equalsIgnoreCase("Filing")){
            Combinations combinationSet = new Combinations();
			combinationSet.findAllCombinationsFiling(allCompatibleFiling(type), quantity);
			Combination result = combinationSet.bestCombination(); // this should contain the best Combination
		
			if (result == null) {
                System.out.println("Order cannot be fulfilled based on current inventory. Suggested manufacturers are " +
                "Office Furnishings, Furniture Goods, Fine Office Supplies.");
			} else {
				System.out.println("Items Ordered: ");
				result.print();
				createOrderForm(category, type, quantity, result);
                for (Furniture furniture : result.combination){
                    String id=furniture.getID();
                    removeFurniture(category,id);
                }

			}
        }
	    
	   // TODO: else if for other cases

    
    }

/**
 * This method retrieves all the lamps with the same type from the database and looks for all 
 * of the lamps that fit the criteria and adds them to a lamp arraylist. 
 * @param type the specific type of lamp that one is looking for as a string
 * @return an arraylist containing furniture class lamp with the compatible lamps 
 */

    private ArrayList<Lamp> allCompatibleLamp(String type)
    {
        ArrayList<Lamp> lampArr = new ArrayList<>();
		try {
			Statement stmt = dbConnect.createStatement();
            this.results = stmt.executeQuery("SELECT * FROM Lamp WHERE Type = '" + type +"'");
			
			while(results.next()) {
				int base, bulb;
				if((results.getString("Base")).equals("Y")) {
					base = 1;
				} else {
					base = 0;
				}
				if((results.getString("Bulb")).equals("Y")) {
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
		return lampArr;
    }
/**
 * This method retrieves all the desks with the same type from the database and looks for all 
 * of the desks that fit the criteria and adds them to a desk arraylist. 
 * @param type the specific type of desk that one is looking for as a string
 * @return an arraylist containing furniture class desk with the compatible desks 
 */
    private ArrayList<Desk> allCompatibleDesk (String type) {
		ArrayList<Desk> DeskArr = new ArrayList<>();
		try {
			Statement stmt = dbConnect.createStatement();
            this.results = stmt.executeQuery("SELECT * FROM Desk WHERE Type = '" + type + "'");
			
			while(results.next()) {
				int legs, top, drawer;
				if((results.getString("Legs")).equals("Y")) {
					legs = 1;
				} else {
					legs = 0;
				}
				if((results.getString("Top")).equals("Y")) {
					top = 1;
				} else {
					top = 0;
				}
                if((results.getString("Drawer")).equals("Y")) {
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
		return DeskArr;
	}
/**
 * This method retrieves all the chairs with the same type from the database and looks for all 
 * of the chairss that fit the criteria and adds them to a chair arraylist. 
 * @param type the specific type of chair that one is looking for as a string.
 * @return an arraylist containing furniture class chair with the compatible chairs. 
 */
    private ArrayList<Chair> allCompatibleChair (String type) {
		ArrayList<Chair> ChairArr = new ArrayList<>();
		try {
			Statement stmt = dbConnect.createStatement();
            this.results = stmt.executeQuery("SELECT * FROM Chair WHERE Type = '" + type + "'");
			
			while(results.next()) {
				int legs, arms, seat, cushion;
				if((results.getString("Legs")).equals("Y")) {
					legs = 1;
				} else {
					legs = 0;
				}
				if((results.getString("Arms")).equals("Y")) {
					arms = 1;
				} else {
				    arms = 0;
				}
                if((results.getString("Seat")).equals("Y")) {
					seat = 1;
				} else {
					seat = 0;
				}
                if((results.getString("Cushion")).equals("Y")) {
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
		return ChairArr;
	}
/**
 * This method retrieves all the filings with the same type from the database and looks for all 
 * of the filings that fit the criteria and adds them to a filing arraylist. 
 * @param type the specific type of filing that one is looking for as a string
 * @return an arraylist containing furniture class filing with the compatible filings; 
 */
	private ArrayList<Filing> allCompatibleFiling(String type) {
		ArrayList<Filing> FilingArr = new ArrayList<>();
		try {
			Statement stmt = dbConnect.createStatement();
            this.results = stmt.executeQuery("SELECT * FROM Filing WHERE Type = '" + type + "'");
			
			while(results.next()) {
				int rails, drawers, cabinet;
				if((results.getString("Rails")).equals("Y")) {
					rails = 1;
				} else {
					rails = 0;
				}
				if((results.getString("Drawers")).equals("Y")) {
					drawers = 1;
				} else {
				    drawers = 0;
				}
                if((results.getString("Cabinet")).equals("Y")) {
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
		return FilingArr;
	}
    
/**
 * This method looks for all the possible manufacturers that manufacture the specific type of furniture
 * that the user is looking for. It starts by grabbing all the furniture that has the correct type
 * from the database and adds it to a stringBuilder variable. It then looks for all the manuID of all the correct
 * furniture and appends it to the stringBuilder variable. Later, it turns the stringBuilder into a string
 * which it then returns.
 * @param fur the category of the furniture as a string.
 * @param type the type of furniture as a string.
 * @return the valid manufacturers which supply the desired furniture
 */
	private String validManufacturers(String fur, String type) {     // TODO: changes should be made here
        ArrayList<String> manuArrayList = new ArrayList<>();
		StringBuilder result = new StringBuilder();
		String resultString = new String();
        try {
            Statement stmt = dbConnect.createStatement();
            this.results = stmt.executeQuery("SELECT * FROM " + fur +" WHERE Type = '" + type + "'");

            while(results.next()){
                String a = results.getString("ManuID");
                if(!manuArrayList.contains(a)){
					manuArrayList.add(a);
					result.append(manufacturerName(a));
					result.append(", ");
				}
            }
			resultString = result.substring(0, result.length()-2); // remove the last ", "
        } catch (SQLException e){
            e.printStackTrace();
        }
        return resultString;
    }

/**
 * This method pulls from the manufacturer database and picks the manufacturer name that matches
 * the provided ManuID and returns it as a string.
 * @param manuID the specific manuID that is being looked for.
 * @return the manufacturer name corresponding to the provided ManuID.
 */

	private String manufacturerName (String manuID) {
		String result = new String();
		try {
			Statement stmt = dbConnect.createStatement();
            ResultSet resultset = stmt.executeQuery("SELECT * FROM Manufacturer WHERE ManuID = '" + manuID + "'");
			while(resultset.next()){
				result = resultset.getString("Name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
/**
 * This method takes in 1 parameter and is called when an order cannot be carried through, it returns a message
 * saying exactly that and gives the suggested manufacturer in a string format.
 * @param manu the manufacturer to be returned as a string.
 * @return a message containing the manufacturer as a string.
 */
	private String noCombinationsFound (String manu) {
		return "Order cannot be fulfilled based on current inventory. Suggested manufacturers are " + manu + ".";
	}

/**
 * This method takes in 4 parameters containing the furniture category, type and quantity, as 
 * well as the combination which is required to create that kind of furniture. It uses a 
 * StringBuffer to create the format for the output text, then creates the file to input the 
 * order into. It then makes sure the file is clean and then writes to the file.
 * @param category the category of the furniture as a string.
 * @param type the type of the furniture as a string.
 * @param quantity the number of furniture requested to make as an integer.
 * @param result the found combination of furniture that is required as a class Combination.
 */

	private void createOrderForm(String category, String type, int quantity, Combination result){
		StringBuffer format = new StringBuffer();
		format.append("Furniture Order Form");
		format.append('\n');
		format.append('\n');
		format.append("Faculty Name: ");
		format.append('\n');
		format.append("Contact: ");
		format.append('\n');
		format.append("Date: ");
		format.append('\n');
		
		format.append("Original Request: " + type + " " + category + ", " + quantity);
		format.append('\n');
		format.append('\n');
		format.append("Items Ordered: ");
		format.append('\n');
		format.append(result.getFormat());
		
		File myOut = new File("order-form.txt");
		// clear current content of input file
		try {
            RandomAccessFile raf = new RandomAccessFile(myOut, "rw");
            raf.setLength(0);
        } catch (IOException ex) {
            System.out.printf("Error: %s\n", ex);
        }
		
		// write to file
		try (PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(myOut, true)))) {
            output.print(format.toString());
        } catch (IOException ex) {
            System.out.printf("Error: %s\n", ex);
        }
	}

/**
 * This method takes in two parameters containing the category of the furniture and the 
 * id of the furniture and then removes it from the database so that it cannot be used again.
 * It accesses the database with the specific category and then uses the id to remove 
 * the specfic furniture that has a matching id.
 * @param category the category of the furniture as a string.
 * @param id the id of the furniture to be removed as a string.
 */
    public void removeFurniture(String category, String id){
        try {
            String query = "DELETE FROM "+category+" WHERE ID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, id);
                        
            int rowCount = myStmt.executeUpdate();
            
            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }




/**
 * This method closes the connection to the database and catches any errors that 
 * may occur during this process.
 */
    public void close(){
        try{
            dbConnect.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}

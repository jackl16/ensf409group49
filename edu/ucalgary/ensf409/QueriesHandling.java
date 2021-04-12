package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;
import java.io.*;



public class QueriesHandling {
    public final String DBURL;
    public final String USERNAME; 
    public final String PASSWORD; 

    private ResultSet results;
    private Connection dbConnect;


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




    public void callCombinations(String category, String type, int quantity){
        if (category.equals("Lamp")){
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
        else if(category.equals("Chair")){
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
        else if(category.equals("Desk")){
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
        else if(category.equals("Filing")){
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

	private String validManufacturers(String fur, String type) {    // TODO: changes should be made here
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
	
	private String noCombinationsFound (String manu) {
		return "Order cannot be fulfilled based on current inventory. Suggested manufacturers are " + manu + ".";
	}
	
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


    public void removeFurniture(String category, String id){
        try {
            String query = "DELETE FROM "+category+" WHERE ID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, id);
                        
            int rowCount = myStmt.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            
            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }





    public void close(){
        try{
            results.close();
            dbConnect.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}

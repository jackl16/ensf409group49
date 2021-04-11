package edu.ucalgary.ensf409;
import java.util.*;

/**
 * @author Truong, Viet An <a href="mailto:vietan.truong@ucalgary.ca">
 * vietan.truong@ucalgary.ca</a>
 * @author Kwon, Minseung
 * @version 1.9
 * @since 1.0
 */
public class Combinations {
    public ArrayList<Combination> result;   // ArrayList for all possible Combiantion found

    /**
     * Zero argument constructor. Initiliaze the result data member.
     */
    public Combinations() {
        result = new ArrayList<>();
    }

    /**
     * Calculate the best combination from data member result by accesing the totalPrice data member in class Combination
     * @return a Combination object that is best combination in the ArrayList. Returns null if no combinations were found.
     */
    public Combination bestCombination (){
        if (this.result.isEmpty()){
            return null;
        }
        Combination best = null;
        for (Combination current : this.result){
            if (best == null){
                best = current;
            }
            if(current.totalPrice < best.totalPrice){
                best = current;
            }
        }
        return best;
    }

    /**
     * Calls and instantiates arguments for the recursive function uniqueCombinationLamp
     * @param arr An ArrayList of type Lamp (expects to be passed from QueriesHandling class).
     * @param quantity An integer for the number of furniture items the user wants (expects to be passed from QueriesHandling class).
     */
    public void findAllCombinationsLamp (ArrayList<Lamp> arr, int quantity){
        Vector<Lamp> A = new Vector<>(arr);
        Vector<Lamp> local = new Vector<>();

        uniqueCombinationLamp(0, 0, 0, quantity, local, A);
    }

    /**
     * Recursive function to find all unique combinations of Lamps. Every time a combination is found, it creates a new
     * Combination object and then add that Object to the data member result of type ArrayList for Combination
     * @param l the index of the latest Lamp that got added into Vector local
     * @param sum1 represents the number of bases found so far
     * @param sum2 represents the number of bulbs found so far
     * @param quantity the number of furniture item(s) the user requested
     * @param local current working/checking Vector of Lamps
     * @param A full Vector of Lamps (contains all the valid Lamps of type requested by the user)
     */
    public void uniqueCombinationLamp(int l, int sum1, int sum2, int quantity, Vector<Lamp> local, Vector<Lamp> A){
        if(A.isEmpty()){
            return;
        }
        if (sum1 >= quantity && sum2 >= quantity){              // if bases and bulbs found are at least the quantity
            ArrayList<Furniture> comb = new ArrayList<>();
            for (Lamp lamp : local) {
                comb.add((Furniture) lamp);
            }
            this.result.add(new Combination(comb));             // adding the newly created Furniture Object to the result data member
            return;
        }

        // add another Lamp from A to local to check.
        for (int i = l; i < A.size(); i++){
            // check if the current Lamp is repeated or not
            if (i > l && A.get(i) == A.get(i-1)){
                continue; // skip this increment
            }

            // adding the next Lamp into local
            local.add(A.get(i));

            // recursive call
            uniqueCombinationLamp(i+1, sum1 + A.get(i).getBase(), sum2 + A.get(i).getBulb(), quantity, local, A);

            // Remove element from the combination
            local.remove(local.size() - 1);
        }
    }

    /**
     * Calls and instantiates arguments for the recursive function uniqueCombinationChair
     * @param arr An ArrayList of type Chair (expects to be passed from QueriesHandling class).
     * @param quantity An integer for the number of furniture items the user wants (expects to be passed from QueriesHandling class).
     */
    public void findAllCombinationsChair (ArrayList<Chair> arr, int quantity) {
        Vector<Chair> A = new Vector<>(arr);
        Vector<Chair> local = new Vector<>();

        uniqueCombinationChair(0, 0, 0, 0, 0, quantity, local, A);
    }

    /**
     * Recursive function to find all unique combinations of Chairs. Every time a combination is found, it creates a new
     * Combination object and then add that Object to the data member result of type ArrayList for Combination
     * @param l the index of the latest Lamp that got added into Vector local
     * @param sum1 represents the number of legs found so far
     * @param sum2 represents the number of arms found so far
     * @param sum3 represents the number of seat found so far
     * @param sum4 represents the number of cushion found so far
     * @param quantity number of furniture item(s) the user requested
     * @param local current working/checking Vector of Chairs
     * @param A full Vector of Chairs (contains all the valid Chairs of type requested by the user)
     */
    public void uniqueCombinationChair(int l, int sum1, int sum2, int sum3, int sum4, int quantity, Vector<Chair> local, Vector<Chair> A) {
        if(A.isEmpty()){
            return;
        }
        if (sum1 >= quantity && sum2 >= quantity && sum3 >= quantity && sum4 >= quantity) {
            ArrayList<Furniture> comb = new ArrayList<>();
            for (Chair chair : local) {
                comb.add((Furniture) chair);
            }
            this.result.add(new Combination(comb));         // adding the newly created Furniture Object to the result data member
            return;
        }

        // add another Chair from A to local to check.
        for (int i = l; i < A.size(); i++){
            // check if the current Chair is repeated or not
            if (i > l && A.get(i) == A.get(i-1)){
                continue; // skip this increment
            }

            // adding the next Chair into local
            local.add(A.get(i));

            // recursive call
            uniqueCombinationChair(i+1, sum1 + A.get(i).getLegs(), sum2 + A.get(i).getArms(),
                    sum3 + A.get(i).getSeat(), sum4 + A.get(i).getCushion(), quantity, local, A);

            // Remove element from the combination
            local.remove(local.size() - 1);
        }
    }

    /**
     * Calls and instantiates arguments for the recursive function uniqueCombinationDesk
     * @param arr An ArrayList of type Desk (expects to be passed from QueriesHandling class).
     * @param quantity An integer for the number of furniture items the user wants (expects to be passed from QueriesHandling class).
     */
    public void findAllCombinationsDesk (ArrayList<Desk> arr, int quantity) {
        Vector<Desk> A = new Vector<>(arr);
        Vector<Desk> local = new Vector<>();

        uniqueCombinationDesk(0, 0, 0, 0, quantity, local, A);
    }

    /**
     * Recursive function to find all unique combinations of Desks. Every time a combination is found, it creates a new
     * Combination object and then add that Object to the data member result of type ArrayList for Combination
     * @param l the index of the latest Lamp that got added into Vector local
     * @param sum1 represents the number of legs found so far
     * @param sum2 represents the number of top foudn so far
     * @param sum3 represents the number of drawers found so far
     * @param quantity the number of furniture item(s) the user requested
     * @param local current working/checking Vector of Desks
     * @param a full Vector of Desks (contains all the valid Desks of type requested by the user)
     */
    public void uniqueCombinationDesk(int l, int sum1, int sum2, int sum3, int quantity, Vector<Desk> local, Vector<Desk> A) {
        if(A.isEmpty()){
            return;
        }
        if (sum1 >= quantity && sum2 >= quantity && sum3 >= quantity) {
            ArrayList<Furniture> comb = new ArrayList<>();
            for (Desk desk : local) {
                comb.add((Furniture) desk);
            }
            this.result.add(new Combination(comb));         // adding the newly created Furniture Object to the result data member
            return;
        }

        // add another Desk from A to local to check.
        for (int i = l; i < a.size(); i++){
            // check if the current Desk is repeated or not
            if (i > l && a.get(i) == a.get(i-1)){
                continue; // skip this increment
            }

            // adding the next Desk into local
            local.add(a.get(i));

            // recursive call
            uniqueCombinationDesk(i+1, sum1 + a.get(i).getLegs(), sum2 + a.get(i).getTop(),
                    sum3 + a.get(i).getDrawer(), quantity, local, a);

            // Remove element from the combination
            local.remove(local.size() - 1);
        }
    }

    /**
     * Calls and instantiates arguments for the recursive function uniqueCombinationFiling
     * @param arr An ArrayList of type Filing (expects to be passed from QueriesHandling class).
     * @param quantity An integer for the number of furniture items the user wants (expects to be passed from QueriesHandling class).
     */
    public void findAllCombinationsFiling (ArrayList<Filing> arr, int quantity) {
        Vector<Filing> A = new Vector<>(arr);
        Vector<Filing> local = new Vector<>();

        uniqueCombinationFiling(0, 0, 0, 0, quantity, local, A);
    }

    /**
     * Recursive function to find all unique combinations of Filings. Every time a combination is found, it creates a new
     * Combination object and then add that Object to the data member result of type ArrayList for Combination
     * @param l the index of the latest Lamp that got added into Vector local
     * @param sum1 represents the number of rails found so far
     * @param sum2 represents the number of drawers found so far
     * @param sum3 represents the number of cabinets found so far
     * @param quantity number of furniture item(s) the user requested
     * @param local current working/checking Vector of Filings
     * @param a full Vector of Filings (contains all the valid Filings of type requested by the user)
     */
    public void uniqueCombinationFiling(int l, int sum1, int sum2, int sum3, int quantity, Vector<Filing> local, Vector<Filing> A) {
        if(A.isEmpty()){
            return;
        }
        if (sum1 >= quantity && sum2 >= quantity && sum3 >= quantity) {
            ArrayList<Furniture> comb = new ArrayList<>();
            for (Filing filing : local) {
                comb.add((Furniture) filing);
            }
            this.result.add(new Combination(comb));         // adding the newly created Furniture Object to the result data member
            return;
        }

        // add another Desk from A to local to check.
        for (int i = l; i < a.size(); i++){
            // check if the current Desk is repeated or not
            if (i > l && a.get(i) == a.get(i-1)){
                continue; // skip this increment
            }

            // adding the next Desk into local
            local.add(a.get(i));

            // recursive call
            uniqueCombinationFiling(i+1, sum1 + a.get(i).getRails(), sum2 + a.get(i).getDrawers(),
                    sum3 + a.get(i).getCabinet(), quantity, local, a);

            // Remove element from the combination
            local.remove(local.size() - 1);
        }
    }


    // getter & setter

    /**
     * getter method for data member result
     * @return ArrayList of type Combination result.
     */
    public ArrayList<Combination> getResult() {
        return result;
    }

}

class Combination {
    public ArrayList<Furniture> combination;                // an ArrayList of Furniture objects that make up a valid combination
    public int totalPrice = 0;                              // total price the this combination

    /**
     * Constructor. Setting the datamember combination to the ArrayList in argument
     * @param comb a valid Furniture objects combination.
     */
    public Combination(ArrayList<Furniture> comb) {
        this.combination = comb;
        for (Furniture furniture : comb){
            totalPrice += furniture.getPRICE();
        }
    }

    /**
     * print method for terminal/console logging purposes only.
     * Prints the IDs of all Furniture objects in ArrayList combination and the total price of this combination.
     */
    public void print() {
        for (Furniture furniture : combination) {
            System.out.println(furniture.getID());
        }
        System.out.println("Total Price: $" + totalPrice);
    }

    /**
     * Builds a String for the formatted output to the order-form.txt file
     * @return String consists of all Furniture objects' IDs and total price in the correct format.
     */
    public String getFormat() {
		StringBuffer format = new StringBuffer();
		for (Furniture furniture : combination) {
            format.append("ID: " + furniture.getID());
			format.append('\n');
        }
		format.append("Total Price: " + totalPrice);
		
		return format.toString();
	}
	
}



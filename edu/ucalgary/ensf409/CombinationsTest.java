package edu.ucalgary.ensf409;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Vector;

import org.junit.Test;

import edu.ucalgary.ensf409.Combinations;





public class CombinationsTest{
	/**
	 * This is testing whether constructor of Combination works.
	 *  It's private variable, totalPrice should equal sum of price of each Furniture objects 
	 */
    @Test
	public void testCombinationTotalPrice(){
        ArrayList<Furniture> furnitures= new ArrayList<Furniture>();
        Furniture one = new Furniture("C1320", 50, "000","mesh");
        Furniture two = new Furniture("C3405", 350, "003","executive");
        Furniture three = new Furniture("C2078", 1050, "100","mesh");
        furnitures.add(one);
        furnitures.add(two);
        furnitures.add(three);
    
        Combination testobj = new Combination(furnitures);
        int price = 0;
        for(int i=0;i<furnitures.size();i++)
        {
            price+=furnitures.get(i).getPRICE();
        }
       
        assertEquals("testobj's total price does not match sum price of each furniture objects",price, testobj.totalPrice);
    }
	/**
	 * tests Combination Constructor, by checking whether the created object has its private variable-combination
	 * ,which is an empty furniture Arraylist,which isn't null
	 */
    @Test
	public void testCombinationConstructor() {
		
		ArrayList<Furniture> furnitures= new ArrayList<Furniture>();
	    Furniture one = new Furniture("C1320", 50, "000","mesh");
	    furnitures.add(one);
        Combination testobj = new Combination(furnitures);

        assertNotNull("testobj.combination is null as Combination object with ArrayList<Furniture>combination as its private variable is not created ",testobj.combination);
	}

	/**
	 * Tests getResult function under class Combinations, which returns Combination Arraylist result
	 * In the sample below, random.result is simply not null as it is empty Arraylist 
	 */
    @Test 
    public void testCombinationsGettor(){
        Combinations random = new Combinations();
        random.getResult();
        assertNotNull("random.result is null, when it should simply be an empty Arraylist<Combination>", random.result);    
    }

	/**
	 * Tests Combinations constructor
	 */
	@Test
	public void testCombinationsConstructor()
	{
		Combinations random = new Combinations();
		assertNotNull("random is null",random);
	}

	/**
	 * Tests uniqueCombinationLamp &bestCombination for 1 lamp. UniqueCombinationLamp stores all possible combinations that may make 1 Lamp. Then bestCombination 
	 * compares the totalPrice variable in each then returns the Combination object with lowest totalPrice value. 
	 */
    @Test
	public void testBestCombinationLamp() {
		Combinations a = new Combinations();
		ArrayList<Lamp>arr = new ArrayList<>();
		Lamp one = new Lamp("L132",1, "005","Desk",1,0);
		Lamp two = new Lamp("L564",20, "010","Desk",1,0);
		Lamp three = new Lamp("L142",30, "000","Desk",0,0);
		Lamp four = new Lamp("L102",100, "020","Desk",0,1);
		Lamp five = new Lamp("L22",3, "003","Desk",1,0);
		Lamp six = new Lamp("L111",20, "01","Desk",0,1);
		Lamp seven = new Lamp("L111",400, "0","Desk",1,0);
		Lamp eight = new Lamp("L111",5000, "011","Desk",0,1);
		Lamp nine = new Lamp("L111",1020, "023","Desk",0,1);
		arr.add(one);
		arr.add(two);
		arr.add(three);
		arr.add(four);
		arr.add(five);
		arr.add(six);
		
		Vector<Lamp>A = new Vector<>(arr);
		Vector<Lamp>local = new Vector<>();
		a.uniqueCombinationLamp(0,0,0,1,local,A);
		Combination result = a.bestCombination();
		ArrayList<Furniture>expected = new ArrayList<>();
		expected.add(one);
		expected.add(six);
		Combination expectedResult = new Combination(expected);
		
		assertEquals("total price of expected result does not match total price of result",expectedResult.totalPrice,result.totalPrice);
		
	}

	/**
	 * Tests uniqueCombinationLamp & bestCombination for more than 1 lamp. Here we test the case when the user requests 2 Lamps.
	 * It returns a Combination object with lowest totalPrice available in the Combination Arraylist
	 */
    @Test   
	public void testBestCombinationMultipleLamp()
	{
		Combinations a = new Combinations();
		ArrayList<Lamp>arr = new ArrayList<>();
		Lamp one = new Lamp("L132",1, "005","Desk",1,0);
		Lamp two = new Lamp("L564",20, "010","Desk",1,0);
		Lamp three = new Lamp("L142",30, "000","Desk",0,0);
		Lamp four = new Lamp("L102",10, "020","Desk",0,1);
		Lamp five = new Lamp("L22",3, "003","Desk",1,0);
		Lamp six = new Lamp("L111",20, "01","Desk",0,1);
		Lamp seven = new Lamp("L001",400, "0","Desk",1,0);
		Lamp eight = new Lamp("L231",1110, "011","Desk",0,1);
		Lamp nine = new Lamp("L141",50, "023","Desk",0,1);
		arr.add(one);
		arr.add(two);
		arr.add(three);
		arr.add(four);
		arr.add(five);
		arr.add(six);
		arr.add(seven);
		arr.add(eight);
		arr.add(nine);
		
		Vector<Lamp>A = new Vector<>(arr);
		Vector<Lamp>local = new Vector<>();
		a.uniqueCombinationLamp(0,0,0,2,local,A);
		Combination result = a.bestCombination();
		ArrayList<Furniture>expected = new ArrayList<>();
		expected.add(one);
		expected.add(four);
		expected.add(five);
		expected.add(six);
		Combination expectedResult = new Combination(expected);
		
		assertEquals("total Price of expected result does not match total price of result",expectedResult.totalPrice,result.totalPrice);
	}
	/**
	 * Testing uniqueCombinationLamp & bestCombination when no Combination exists, such as cases where only the bulbs are available 
	 * so that the User request of 1 lamp cannot be fulfilled
	 */
	@Test
	public void NoCombinationLamp(){
		Combinations a = new Combinations();
		ArrayList<Lamp>arr = new ArrayList<>();
		Lamp one = new Lamp("L132",1, "005","Desk",1,0);
		Lamp two = new Lamp("L564",20, "010","Desk",1,0);
		arr.add(one);
		arr.add(two);
		Vector<Lamp>A = new Vector<>(arr);
		Vector<Lamp>local = new Vector<>();
		a.uniqueCombinationLamp(0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertNull("result is not null and there is a Combination that makes lamps possible",result);
	}
	/**
	 * Testing uniqueCombinationLamp & bestCombination when empty ArrayList<Lamp> is passed as an argument
	 * returning Combination object must be null.
	 */
	@Test
	public void testEmptyArrayListLamp(){
		Combinations a = new Combinations();
		ArrayList<Lamp>arr = new ArrayList<>();
		Vector<Lamp>A = new Vector<>(arr);
		Vector<Lamp>local = new Vector<>();
		a.uniqueCombinationLamp(0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertNull("result is not null and there is a Combination that makes lamps possible",result);
	}
	/**
	 * Testing uniqueCombinationLamp & bestCombination when there is only one valid combination found 
	 */
	@Test
	public void testOneCombinationLamp()
	{
		Combinations a = new Combinations();
		ArrayList<Lamp>arr = new ArrayList<>();
		Lamp one = new Lamp("L132",1, "005","Desk",1,0);
		Lamp two = new Lamp("L564",20, "010","Desk",0,1);
		arr.add(one);
		arr.add(two);
		Vector<Lamp>A = new Vector<>(arr);
		Vector<Lamp>local = new Vector<>();
		a.uniqueCombinationLamp(0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertEquals("there exists more than one Combination and the totalPrice of result does not match expected value",21, result.totalPrice);
	}
	/**
	 * Tests uniqueCombinationChair &bestCombination for 1 Chair. UniqueCombinationChair stores all possible combinations that may make 1 chair. Then bestCombination 
	 * compares the totalPrice variable in each then returns the Combination object with lowest totalPrice value. 
	 */
    @Test
	public void testChairBestCombination() {
		Combinations a = new Combinations();
		ArrayList<Chair>arr = new ArrayList<>();
		Chair one = new Chair("C9",200, "005","Mesh",1,0,1,1);
		Chair two = new Chair("C19",100, "005","Mesh",1,1,0,1);
		Chair three = new Chair("C1",100, "005","Mesh",1,0,1,1);
		Chair four = new Chair("C199",30, "005","Mesh",1,0,0,1);
		Chair five = new Chair("C1909",250, "005","Mesh",1,1,1,0);
		arr.add(one);
		arr.add(two);
		arr.add(three);
		arr.add(four);
		arr.add(five);

		
		Vector<Chair>A = new Vector<>(arr);
		Vector<Chair>local = new Vector<>();
		a.uniqueCombinationChair(0,0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		ArrayList<Furniture>expected = new ArrayList<>();
		expected.add(two);
		expected.add(three);
		Combination expectedResult = new Combination(expected);
		
		assertEquals("totalPrice of result did not match the expectedResult's totalPrice",expectedResult.totalPrice,result.totalPrice);
	}
	/**
	 * Tests uniqueCombinationChair & bestCombination for more than 2 chairs. Here we test the case when the user requests 2 Chairs.
	 * It returns a Combination object with lowest totalPrice available in the Combination Arraylist
	 */
    @Test
	public void testMultipleChairsBestCombination() {
		
		Combinations a = new Combinations();
		ArrayList<Chair>arr = new ArrayList<>();
		Chair one = new Chair("C109",200, "005","Mesh",1,0,1,1);
		Chair two = new Chair("C192",100, "005","Mesh",1,1,0,1);
		Chair three = new Chair("C135",100, "005","Mesh",1,0,1,1);
		Chair four = new Chair("C94",30, "005","Mesh",1,1,0,1);
		Chair five = new Chair("C90",5,"005","Mesh",1,1,1,1);
	
		arr.add(one);
		arr.add(two);
		arr.add(three);
		arr.add(four);
		arr.add(five);
		
		Vector<Chair>A = new Vector<>(arr);
		Vector<Chair>local = new Vector<>();
		a.uniqueCombinationChair(0,0,0,0,0,2,local,A);
		Combination result = a.bestCombination();
		ArrayList<Furniture>expected = new ArrayList<>();
		expected.add(three);
		expected.add(four);
		expected.add(five);
		Combination expectedResult = new Combination(expected);
		
		assertEquals("totalPrice of result for 2 chairs did not match the expectedResult's totalPrice ",expectedResult.totalPrice,result.totalPrice);
	}

	/**
	 * Test bestCombinations when no Combinations exist. Null should be returned. 
	 */
	@Test
	public void NoCombinationChair(){
		Combinations a = new Combinations();
		ArrayList<Chair>arr = new ArrayList<>();
		Chair one = new Chair("C109",200, "005","Mesh",1,0,1,1);
		Chair two = new Chair("C192",100, "005","Mesh",1,0,0,1);
		arr.add(one);
		arr.add(two);
		Vector<Chair>A = new Vector<>(arr);
		Vector<Chair>local = new Vector<>();
		a.uniqueCombinationChair(0,0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertNull("There is a Combination that makes requested number of chairs",result);
	}

	/**
	 * Testing uniqueCombinationChair & bestCombination when empty ArrayList<Chair> is passed as an argument
	 * returning Combination object must be null.
	 */
	@Test
	public void testEmptyArrayListChair(){
		Combinations a = new Combinations();
		ArrayList<Chair>arr = new ArrayList<>();
		Vector<Chair>A = new Vector<>(arr);
		Vector<Chair>local = new Vector<>();
		a.uniqueCombinationChair(0,0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertNull("There is a Combination that makes requested number of chairs",result);
	}


	/**
	 * Testing uniqueCombinationChair & bestCombination when there is only one valid combination found 
	 */
	@Test
	public void testOneCombinationChair()
	{
		Combinations a = new Combinations();
		ArrayList<Chair>arr = new ArrayList<>();
		Chair one = new Chair("C109",200, "005","Mesh",1,0,0,1);
		Chair two = new Chair("C192",100, "005","Mesh",1,0,0,1);
		Chair three = new Chair("C123",300,"001","Mesh",0,1,1,0);
		arr.add(one);
		arr.add(two);
		arr.add(three);
		Vector<Chair>A = new Vector<>(arr);
		Vector<Chair>local = new Vector<>();
		a.uniqueCombinationChair(0,0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertEquals("there exists more than one Combination and the totalPrice of result does not match expected value",400, result.totalPrice);
	}

	/**
	 * Tests uniqueCombinationDesk &bestCombination for 1 Desk. UniqueCombinationDesk stores all possible combinations that may make 1 Desk. Then bestCombination 
	 * compares the totalPrice variable in each then returns the Combination object with lowest totalPrice value. 
	 */
    @Test
	public void testBestCombinationsDesk() {
		Combinations a = new Combinations();
		ArrayList<Desk>arr = new ArrayList<>();
		Desk one = new Desk("D1999",200, "005","Standing",1,0,0);
		Desk two = new Desk("D199",200, "005","Standing",0,1,1);
		Desk three = new Desk("D909",200, "005","Standing",1,1,1);
		Desk four = new Desk("D19",200, "005","Standing",1,0,0);
		arr.add(one);
		arr.add(two);
		arr.add(three);
		arr.add(four);

		
		Vector<Desk>A = new Vector<>(arr);
		Vector<Desk>local = new Vector<>();
		a.uniqueCombinationDesk(0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		ArrayList<Furniture>expected = new ArrayList<>();
		expected.add(three);
		Combination expectedResult = new Combination(expected);
		
		assertEquals("total price of result does not match totalPrice of expectedResult",expectedResult.totalPrice,result.totalPrice);
	}
	/**
	 * Tests uniqueCombinationDesk & bestCombination for more than 2 chairs. Here we test the case when the user requests 2 Chairs.
	 * It returns a Combination object with lowest totalPrice available in the Combination Arraylist
	 */
	@Test
	public void testBestCombinationsMultipleDesk() {
		Combinations a = new Combinations();
		ArrayList<Desk>arr = new ArrayList<>();
		Desk one = new Desk("D1909",10, "005","Standing",1,0,0);
		Desk two = new Desk("D109",100, "005","Standing",0,1,1);
		Desk three = new Desk("D199",150, "005","Standing",1,1,1);
		Desk four = new Desk("D909",20, "005","Standing",1,1,0);
		Desk five = new Desk("D19",2000, "005","Standing",1,0,1);
		arr.add(one);
		arr.add(two);
		arr.add(three);
		arr.add(four);
		arr.add(five);

		Vector<Desk>A = new Vector<>(arr);
		Vector<Desk>local = new Vector<>();
		a.uniqueCombinationDesk(0,0,0,0,2,local,A);
		Combination result = a.bestCombination();
		ArrayList<Furniture>expected = new ArrayList<>();
		expected.add(one);
		expected.add(two);
		expected.add(three);
		Combination expectedResult = new Combination(expected);
		
		assertEquals("total price of result does not match totalPrice of expectedResult",expectedResult.totalPrice,result.totalPrice);
	}

	
	/**
	 * Test bestCombinations when no Combinations exist. Null should be returned. 
	 */
	@Test
	public void NoCombinationDesk(){
		Combinations a = new Combinations();
		ArrayList<Desk>arr = new ArrayList<>();
		Desk one = new Desk("D1909",10, "005","Standing",1,0,0);
		Desk two = new Desk("D109",100, "005","Standing",0,0,1);
		arr.add(one);
		arr.add(two);
		Vector<Desk>A = new Vector<>(arr);
		Vector<Desk>local = new Vector<>();
		a.uniqueCombinationDesk(0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertNull("There is a Combination that makes requested number of Desks",result);
	}

	/**
	 * Testing uniqueCombinationDesk & bestCombination when empty ArrayList<Desk> is passed as an argument
	 * returning Combination object must be null.
	 */
	@Test
	public void testEmptyArrayListDesk(){
		Combinations a = new Combinations();
		ArrayList<Desk>arr = new ArrayList<>();
		Vector<Desk>A = new Vector<>(arr);
		Vector<Desk>local = new Vector<>();
		a.uniqueCombinationDesk(0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertNull("There is a Combination that makes requested number of chairs",result);
	}

	
	/**
	 * Testing uniqueCombinationDesk & bestCombination when there is only one valid combination found 
	 */
	@Test
	public void testOneCombinationDesk()
	{
		Combinations a = new Combinations();
		ArrayList<Desk>arr = new ArrayList<>();
		Desk one = new Desk("D1909",10, "005","Standing",1,1,0);
		Desk two = new Desk("D109",100, "005","Standing",0,0,1);
		Desk three = new Desk("D109",100, "005","Standing",1,0,0);
		arr.add(one);
		arr.add(two);
		arr.add(three);
		Vector<Desk>A = new Vector<>(arr);
		Vector<Desk>local = new Vector<>();
		a.uniqueCombinationDesk(0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertEquals("there exists more than one Combination and the totalPrice of result does not match expected value",110, result.totalPrice);
	}


	/**
	 * Tests uniqueCombinationFiling &bestCombination for 1 Filing. UniqueCombinationFiling stores all possible combinations 
	 * that may make 1 Filing. Then bestCombination 
	 * compares the totalPrice variable in each then returns the Combination object with lowest totalPrice value. 
	 */

	@Test
	public void testBestCombinationsFiling()
	{
		Combinations a = new Combinations();
		ArrayList<Filing>arr = new ArrayList<>();
		Filing one = new Filing("D199",10, "005","Small",1,0,0);
		Filing two = new Filing("D19",20, "005","Small",0,0,1);
		Filing three = new Filing("D1909",30, "005","Small",1,0,1);
		Filing four = new Filing("D1909",40, "005","Small",1,1,0);
		Filing five = new Filing("D1909",50, "005","Small",1,0,1);
		arr.add(one);
		arr.add(two);
		arr.add(three);
		arr.add(four);
		arr.add(five);

		Vector<Filing>A = new Vector<>(arr);
		Vector<Filing>local = new Vector<>();
		a.uniqueCombinationFiling(0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		ArrayList<Furniture>expected = new ArrayList<>();
		expected.add(two);
		expected.add(four);
		Combination expectedResult = new Combination(expected);
		
		assertEquals("the total price of expectedResult doesn't match totalPrice of result",expectedResult.totalPrice,result.totalPrice);
	}
	/**
	 * Tests uniqueCombinationFiling &bestCombination for more than 1 Filing. Here we use 2 as example
	 * UniqueCombinationFiling stores all possible combinations 
	 * that may make 2 Filing. Then bestCombination 
	 * compares the totalPrice variable in each then returns the Combination object with lowest totalPrice value. 
	 */
	@Test
	public void testBestCombinationsMultipleFiling()
	{
		Combinations a = new Combinations();
		ArrayList<Filing>arr = new ArrayList<>();
		Filing one = new Filing("D199",10, "005","Small",1,1,0);
		Filing two = new Filing("D19",20, "005","Small",0,0,1);
		Filing three = new Filing("D1909",30, "005","Small",1,0,1);
		Filing four = new Filing("D1909",40, "005","Small",1,1,0);
		Filing five = new Filing("D1909",50, "005","Small",1,0,1);
		arr.add(one);
		arr.add(two);
		arr.add(three);
		arr.add(four);
		arr.add(five);

		Vector<Filing>A = new Vector<>(arr);
		Vector<Filing>local = new Vector<>();
		a.uniqueCombinationFiling(0,0,0,0,2,local,A);
		Combination result = a.bestCombination();
		ArrayList<Furniture>expected = new ArrayList<>();
		expected.add(one);
		expected.add(two);
		expected.add(three);
		expected.add(four);

		Combination expectedResult = new Combination(expected);
		
		assertEquals("the total price of expectedResult doesn't match totalPrice of result",expectedResult.totalPrice,result.totalPrice);
	}

	/**
	 * Test bestCombinations when no Combinations exist. Null should be returned. 
	 */
	@Test
	public void NoCombinationFiling(){
		Combinations a = new Combinations();
		ArrayList<Filing>arr = new ArrayList<>();
		Filing one = new Filing("D199",10, "005","Small",1,1,0);
		Filing two = new Filing("D19",20, "005","Small",0,0,0);
		arr.add(one);
		arr.add(two);
		Vector<Filing>A = new Vector<>(arr);
		Vector<Filing>local = new Vector<>();
		a.uniqueCombinationFiling(0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertNull("There is a Combination that makes requested number of Desks",result);
	}

	/**
	 * Testing uniqueCombinationFiling & bestCombination when empty ArrayList<Filing> is passed as an argument
	 * returning Combination object must be null.
	 */
	@Test
	public void testEmptyArrayListFiling(){
		Combinations a = new Combinations();
		ArrayList<Filing>arr = new ArrayList<>();
		Vector<Filing>A = new Vector<>(arr);
		Vector<Filing>local = new Vector<>();
		a.uniqueCombinationFiling(0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertNull("There is a Combination that makes requested number of chairs",result);
	}

	/**
	 * Testing uniqueCombinationFiling & bestCombination when there is only one valid combination found 
	 */
	@Test
	public void testOneCombinationFiling()
	{
		Combinations a = new Combinations();
		ArrayList<Filing>arr = new ArrayList<>();
		Filing one = new Filing("D199",10, "005","Small",1,1,0);
		Filing two = new Filing("D19",20, "005","Small",0,0,1);
		Filing three = new Filing("D1",20, "005","Small",1,0,0);
		arr.add(one);
		arr.add(two);
		arr.add(three);
		Vector<Filing>A = new Vector<>(arr);
		Vector<Filing>local = new Vector<>();
		a.uniqueCombinationFiling(0,0,0,0,1,local,A);
		Combination result = a.bestCombination();
		assertEquals("there exists more than one Combination and the totalPrice of result does not match expected value",30, result.totalPrice);
	}

	

    

}















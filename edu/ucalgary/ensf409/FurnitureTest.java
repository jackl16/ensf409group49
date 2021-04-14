package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author Tavakol Moghaddam, Sina <a href="mailto:sina.tavakolmoghadda@ucalgary.ca">
 * sina.tavakolmoghadda@ucalgary.ca</a>
 * @version 1.1
 * @since 1.0
 */

public class FurnitureTest{

	public FurnitureTest(){

	}

	@Test
    /**
     *  Testing the constructor of the class Furniture to see if all data members initiliaze correctly.
     */
	public void testFurniture() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";


        Furniture a =new Furniture(id,price,manuID,type);

        System.out.println("Furniture");
        assertEquals(id,a.getID());
        assertEquals(price,a.getPRICE());
        assertEquals(manuID,a.getMANUID());
        assertEquals(type,a.getTYPE());

    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
     public void testGetID() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";


        Furniture a =new Furniture(id,price,manuID,type);

        System.out.println("getID");
        assertEquals(id,a.getID());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetPRICE() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";


        Furniture a =new Furniture(id,price,manuID,type);

        System.out.println("getPRICE");
        assertEquals(price,a.getPRICE());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetMANUID() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";


        Furniture a =new Furniture(id,price,manuID,type);

        System.out.println("getMANUID");
        assertEquals(manuID,a.getMANUID());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetTYPE() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";


        Furniture a =new Furniture(id,price,manuID,type);

        System.out.println("getTYPE");
        assertEquals(type,a.getTYPE());
    }

    @Test
    /**
     *  Testing the constructor of the class Chair to see if all data members initiliaze correctly.
     */
    public void testChair() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int arms=1;
        int seat=0;
        int cushion=1;


        Chair a =new Chair(id,price,manuID,type,legs,arms,seat,cushion);

        System.out.println("Chair");
        assertEquals(id,a.getID());
        assertEquals(price,a.getPRICE());
        assertEquals(manuID,a.getMANUID());
        assertEquals(type,a.getTYPE());
        assertEquals(legs,a.getLegs());
        assertEquals(arms,a.getArms());
        assertEquals(seat,a.getSeat());
        assertEquals(cushion,a.getCushion());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
     public void testGetLegs() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int arms=1;
        int seat=0;
        int cushion=1;


        Chair a =new Chair(id,price,manuID,type,legs,arms,seat,cushion);

        System.out.println("getLegs");
        assertEquals(legs,a.getLegs());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetArms() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int arms=1;
        int seat=0;
        int cushion=1;


        Chair a =new Chair(id,price,manuID,type,legs,arms,seat,cushion);

        System.out.println("getArms");
        assertEquals(arms,a.getArms());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetSeat() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int arms=1;
        int seat=0;
        int cushion=1;


        Chair a =new Chair(id,price,manuID,type,legs,arms,seat,cushion);

        System.out.println("getSeat");
        assertEquals(seat,a.getSeat());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetCushion() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int arms=1;
        int seat=0;
        int cushion=1;


        Chair a =new Chair(id,price,manuID,type,legs,arms,seat,cushion);

        System.out.println("getCushion");
        assertEquals(cushion,a.getCushion());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
     public void testSetLegs() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int arms=1;
        int seat=0;
        int cushion=1;


        Chair a =new Chair(id,price,manuID,type,legs,arms,seat,cushion);
        a.setLegs(1);
        System.out.println("setLegs");
        assertEquals(1,a.getLegs());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
    public void testSetArms() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int arms=1;
        int seat=0;
        int cushion=1;


        Chair a =new Chair(id,price,manuID,type,legs,arms,seat,cushion);
        a.setArms(0);
        System.out.println("setArms");
        assertEquals(0,a.getArms());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
    public void testSetSeat() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int arms=1;
        int seat=0;
        int cushion=1;


        Chair a =new Chair(id,price,manuID,type,legs,arms,seat,cushion);
        a.setSeat(1);
        System.out.println("setSeat");
        assertEquals(1,a.getSeat());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
    public void testSetCushion() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int arms=1;
        int seat=0;
        int cushion=1;


        Chair a =new Chair(id,price,manuID,type,legs,arms,seat,cushion);
        a.setCushion(0);
        System.out.println("setCushion");
        assertEquals(0,a.getCushion());
    }

    @Test
    /**
     *  Testing the constructor of the class Desk to see if all data members initiliaze correctly.
     */
    public void testDesk() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int top=1;
        int drawer=0;


        Desk a =new Desk(id,price,manuID,type,legs,top,drawer);

        System.out.println("Desk");
        assertEquals(id,a.getID());
        assertEquals(price,a.getPRICE());
        assertEquals(manuID,a.getMANUID());
        assertEquals(type,a.getTYPE());
        assertEquals(legs,a.getLegs());
        assertEquals(top,a.getTop());
        assertEquals(drawer,a.getDrawer());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
     public void testGetLegs2() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int top=1;
        int drawer=0;


        Desk a =new Desk(id,price,manuID,type,legs,top,drawer);

        System.out.println("getLegs");
        assertEquals(legs,a.getLegs());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetTop() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int top=1;
        int drawer=0;


        Desk a =new Desk(id,price,manuID,type,legs,top,drawer);

        System.out.println("getTop");
        assertEquals(top,a.getTop());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetDrawer() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int top=1;
        int drawer=0;


        Desk a =new Desk(id,price,manuID,type,legs,top,drawer);

        System.out.println("getDrawer");
        assertEquals(drawer,a.getDrawer());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
     public void testSetLegs2() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int top=1;
        int drawer=0;


        Desk a =new Desk(id,price,manuID,type,legs,top,drawer);
        a.setLegs(1);
        System.out.println("setLegs");
        assertEquals(1,a.getLegs());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
    public void testSetTop() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int top=1;
        int drawer=0;


        Desk a =new Desk(id,price,manuID,type,legs,top,drawer);
        a.setTop(0);
        System.out.println("setTop");
        assertEquals(0,a.getTop());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
    public void testSetDrawer() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int legs=0;
        int top=1;
        int drawer=0;


        Desk a =new Desk(id,price,manuID,type,legs,top,drawer);
        a.setDrawer(1);
        System.out.println("setDrawer");
        assertEquals(1,a.getDrawer());
    }

    @Test
    /**
     *  Testing the constructor of the class Lamp to see if all data members initiliaze correctly.
     */
    public void testLamp() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int base=0;
        int bulb=1;


        Lamp a =new Lamp(id,price,manuID,type,base,bulb);

        System.out.println("Lamp");
        assertEquals(id,a.getID());
        assertEquals(price,a.getPRICE());
        assertEquals(manuID,a.getMANUID());
        assertEquals(type,a.getTYPE());
        assertEquals(base,a.getBase());
        assertEquals(bulb,a.getBulb());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
     public void testGetBase() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int base=0;
        int bulb=1;


        Lamp a =new Lamp(id,price,manuID,type,base,bulb);

        System.out.println("getBase");
        assertEquals(base,a.getBase());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetBulb() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int base=0;
        int bulb=1;


        Lamp a =new Lamp(id,price,manuID,type,base,bulb);

        System.out.println("getBulb");
        assertEquals(bulb,a.getBulb());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
     public void testSetBase() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int base=0;
        int bulb=1;


        Lamp a =new Lamp(id,price,manuID,type,base,bulb);
        a.setBase(1);
        System.out.println("setBase");
        assertEquals(1,a.getBase());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
    public void testSetBulb() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int base=0;
        int bulb=1;


        Lamp a =new Lamp(id,price,manuID,type,base,bulb);
        a.setBulb(0);
        System.out.println("setBulb");
        assertEquals(0,a.getBulb());
    }

    @Test
    /**
     *  Testing the constructor of the class Filing to see if all data members initiliaze correctly.
     */
    public void testFiling() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int rails=0;
        int drawers=1;
        int cabinet=0;


        Filing a =new Filing(id,price,manuID,type,rails,drawers,cabinet);

        System.out.println("Filing");
        assertEquals(id,a.getID());
        assertEquals(price,a.getPRICE());
        assertEquals(manuID,a.getMANUID());
        assertEquals(type,a.getTYPE());
        assertEquals(rails,a.getRails());
        assertEquals(drawers,a.getDrawers());
        assertEquals(cabinet,a.getCabinet());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
     public void testGetRails() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int rails=0;
        int drawers=1;
        int cabinet=0;


        Filing a =new Filing(id,price,manuID,type,rails,drawers,cabinet);

        System.out.println("getRails");
        assertEquals(rails,a.getRails());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetDrawers() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int rails=0;
        int drawers=1;
        int cabinet=0;


        Filing a =new Filing(id,price,manuID,type,rails,drawers,cabinet);

        System.out.println("getDrawers");
        assertEquals(drawers,a.getDrawers());
    }

    @Test
    /**
     *  Testing the getter method to see if it returns correctly.
     */
    public void testGetCabinet() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int rails=0;
        int drawers=1;
        int cabinet=0;


        Filing a =new Filing(id,price,manuID,type,rails,drawers,cabinet);

        System.out.println("getCabinet");
        assertEquals(cabinet,a.getCabinet());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
     public void testSetRails() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int rails=0;
        int drawers=1;
        int cabinet=0;


        Filing a =new Filing(id,price,manuID,type,rails,drawers,cabinet);
        a.setRails(1);
        System.out.println("setRails");
        assertEquals(1,a.getRails());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
    public void testSetDrawers() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int rails=0;
        int drawers=1;
        int cabinet=0;


        Filing a =new Filing(id,price,manuID,type,rails,drawers,cabinet);
        a.setDrawers(0);
        System.out.println("setDrawers");
        assertEquals(0,a.getDrawers());
    }

    @Test
    /**
     *  Testing the setter method to see if it sets the value correctly.
     */
    public void testSetCabinet() {
        String id="C9890";
        int price=150;
        String manuID="001";
        String type="Mesh";       
        int rails=0;
        int drawers=1;
        int cabinet=0;


        Filing a =new Filing(id,price,manuID,type,rails,drawers,cabinet);
        a.setCabinet(1);
        System.out.println("setCabinet");
        assertEquals(1,a.getCabinet());
    }

    
}
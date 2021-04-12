package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;

public class FurnitureTest{

	public FurnitureTest(){

	}

	@Test
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
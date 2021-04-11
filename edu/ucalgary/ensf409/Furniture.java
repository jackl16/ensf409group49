package edu.ucalgary.ensf409;

/**
 * @author Tavakol Moghaddam, Sina <a href="mailto:sina.tavakolmoghadda@ucalgary.ca">
 * sina.tavakolmoghadda@ucalgary.ca</a>
 * @version 1.3
 * @since 1.0
 */

public class Furniture {
    final String ID;    //final String data member which holds the furniture's ID number.
    final int PRICE;    //final int data member which holds the price of the furniture.
    final String MANUID;    //final String data member which holds the manufacturer's ID number.
    final String TYPE;    //final String data member which holds the type of the furniture.
    
    /**
     *  This constructor, initiliazes all the data members of this class.
     *  @param ID String data member which holds the furniture's ID number.
     *  @param PRICE int data member which holds the price of the furniture.
     *  @param MANUID String data member which holds the manufacturer's ID number.
     *  @param TYPE String data member which holds the type of the furniture.
     */
    public Furniture(String ID, int PRICE, String MANUID, String TYPE) {
        this.ID = ID;
        this.PRICE = PRICE;
        this.MANUID = MANUID;
        this.TYPE = TYPE;
    }

    /**
     *  This is a getter method for the data member ID.
     *  @return the object's ID data member.
     */
    public String getID() {
        return ID;
    }

    /**
     *  This is a getter method for the data member PRICE.
     *  @return the object's PRICE data member.
     */
    public int getPRICE() {
        return PRICE;
    }

    /**
     *  This is a getter method for the data member MANUID.
     *  @return the object's MANUID data member.
     */
    public String getMANUID() {
        return MANUID;
    }

    /**
     *  This is a getter method for the data member TYPE.
     *  @return the object's TYPE data member.
     */
    public String getTYPE() {
        return TYPE;
    }

}

class Chair extends Furniture{
    private int legs;     //int data member which indicates whether the legs component is in usable condition; 1 for yes and 0 for no.
    private int arms;   //int data member which indicates whether the arms component is in usable condition; 1 for yes and 0 for no.
    private int seat;    //int data member which indicates whether the seat component is in usable condition; 1 for yes and 0 for no.
    private int cushion;    //int data member which indicates whether the cushion component is in usable condition; 1 for yes and 0 for no.

    /**
     *  This constructor, initiliazes all the data members of this class and of the super class by calling the super constructor.
     *  @param ID String data member in the super class which holds the furniture's ID number.
     *  @param PRICE int data member in the super class which holds the price of the furniture.
     *  @param MANUID String data member in the super class which holds the manufacturer's ID number.
     *  @param TYPE String data member in the super class which holds the type of the furniture.
     *  @param legs int data member which indicates whether the legs component is in usable condition; 1 for yes and 0 for no.
     *  @param arms int data member which indicates whether the arms component is in usable condition; 1 for yes and 0 for no.
     *  @param seat int data member which indicates whether the seat component is in usable condition; 1 for yes and 0 for no.
     *  @param cushion int data member which indicates whether the cushion component is in usable condition; 1 for yes and 0 for no.
     */
    public Chair(String ID, int PRICE, String MANUID, String TYPE, int legs, int arms, int seat, int cushion) {
        super(ID, PRICE, MANUID, TYPE);     //call to the super constructor.
        this.legs = legs;
        this.arms = arms;
        this.seat = seat;
        this.cushion = cushion;
    }

    /**
     *  This is a getter method for the data member legs.
     *  @return the object's legs data member.
     */
    public int getLegs() {
        return legs;
    }

    /**
     *  This is a getter method for the data member arms.
     *  @return the object's arms data member.
     */
    public int getArms() {
        return arms;
    }

    /**
     *  This is a getter method for the data member seat.
     *  @return the object's seat data member.
     */
    public int getSeat() {
        return seat;
    }

    /**
     *  This is a getter method for the data member cushion.
     *  @return the object's cushion data member.
     */
    public int getCushion() {
        return cushion;
    }

    /**
     *  This is a setter method for the data member legs.
     *  @param legs int data member which indicates whether the legs component is in usable condition; 1 for yes and 0 for no.
     */
    public void setLegs(int legs) {
        this.legs = legs;
    }

    /**
     *  This is a setter method for the data member arms.
     *  @param arms int data member which indicates whether the arms component is in usable condition; 1 for yes and 0 for no.
     */
    public void setArms(int arms) {
        this.arms = arms;
    }

    /**
     *  This is a setter method for the data member seat.
     *  @param seat int data member which indicates whether the seat component is in usable condition; 1 for yes and 0 for no.
     */
    public void setSeat(int seat) {
        this.seat = seat;
    }

    /**
     *  This is a setter method for the data member cushion.
     *  @param cushion int data member which indicates whether the cushion component is in usable condition; 1 for yes and 0 for no.
     */
    public void setCushion(int cushion) {
        this.cushion = cushion;
    }

}

class Desk extends Furniture{
    private int legs;    //int data member which indicates whether the legs component is in usable condition; 1 for yes and 0 for no.
    private int top;    //int data member which indicates whether the top component is in usable condition; 1 for yes and 0 for no.
    private int drawer;    //int data member which indicates whether the drawer component is in usable condition; 1 for yes and 0 for no.

     /**
     *  This constructor, initiliazes all the data members of this class and of the super class by calling the super constructor.
     *  @param ID String data member in the super class which holds the furniture's ID number.
     *  @param PRICE int data member in the super class which holds the price of the furniture.
     *  @param MANUID String data member in the super class which holds the manufacturer's ID number.
     *  @param TYPE String data member in the super class which holds the type of the furniture.
     *  @param legs int data member which indicates whether the legs component is in usable condition; 1 for yes and 0 for no.
     *  @param top int data member which indicates whether the top component is in usable condition; 1 for yes and 0 for no.
     *  @param drawer int data member which indicates whether the drawer component is in usable condition; 1 for yes and 0 for no.
     */
    public Desk(String ID, int PRICE, String MANUID, String TYPE, int legs, int top, int drawer) {
        super(ID, PRICE, MANUID, TYPE);    //call to the super constructor.
        this.legs = legs;
        this.top = top;
        this.drawer = drawer;
    }

     /**
     *  This is a getter method for the data member legs.
     *  @return the object's legs data member.
     */
    public int getLegs() {
        return legs;
    }

     /**
     *  This is a getter method for the data member top.
     *  @return the object's top data member.
     */
    public int getTop() {
        return top;
    }

     /**
     *  This is a getter method for the data member drawer.
     *  @return the object's drawer data member.
     */
    public int getDrawer() {
        return drawer;
    }

     /**
     *  This is a setter method for the data member legs.
     *  @param legs int data member which indicates whether the legs component is in usable condition; 1 for yes and 0 for no.
     */
    public void setLegs(int legs) {
        this.legs = legs;
    }

     /**
     *  This is a setter method for the data member top.
     *  @param top int data member which indicates whether the top component is in usable condition; 1 for yes and 0 for no.
     */
    public void setTop(int top) {
        this.top = top;
    }

     /**
     *  This is a setter method for the data member drawer.
     *  @param drawer int data member which indicates whether the drawer component is in usable condition; 1 for yes and 0 for no.
     */
    public void setDrawer(int drawer) {
        this.drawer = drawer;
    }

}

class Lamp extends Furniture{
    private int base;    //int data member which indicates whether the base component is in usable condition; 1 for yes and 0 for no.
    private int bulb;    //int data member which indicates whether the bulb component is in usable condition; 1 for yes and 0 for no.

     /**
     *  This constructor, initiliazes all the data members of this class and of the super class by calling the super constructor.
     *  @param ID String data member in the super class which holds the furniture's ID number.
     *  @param PRICE int data member in the super class which holds the price of the furniture.
     *  @param MANUID String data member in the super class which holds the manufacturer's ID number.
     *  @param TYPE String data member in the super class which holds the type of the furniture.
     *  @param base int data member which indicates whether the base component is in usable condition; 1 for yes and 0 for no.
     *  @param bulb int data member which indicates whether the bulb component is in usable condition; 1 for yes and 0 for no.
     */
    public Lamp(String ID, int PRICE, String MANUID, String TYPE, int base, int bulb) {
        super(ID, PRICE, MANUID, TYPE);    //call to the super constructor.
        this.base = base;
        this.bulb = bulb;
    }

     /**
     *  This is a getter method for the data member base.
     *  @return the object's base data member.
     */
    public int getBase() {
        return base;
    }

     /**
     *  This is a getter method for the data member bulb.
     *  @return the object's bulb data member.
     */
    public int getBulb() {
        return bulb;
    }

     /**
     *  This is a setter method for the data member base.
     *  @param base int data member which indicates whether the base component is in usable condition; 1 for yes and 0 for no.
     */
    public void setBase(int base) {
        this.base = base;
    }

     /**
     *  This is a setter method for the data member bulb.
     *  @param bulb int data member which indicates whether the bulb component is in usable condition; 1 for yes and 0 for no.
     */
    public void setBulb(int bulb) {
        this.bulb = bulb;
    }
}

class Filing extends Furniture{
    private int rails;    //int data member which indicates whether the rails component is in usable condition; 1 for yes and 0 for no.
    private int drawers;    //int data member which indicates whether the drawers component is in usable condition; 1 for yes and 0 for no.
    private int cabinet;    //int data member which indicates whether the cabinet component is in usable condition; 1 for yes and 0 for no.

     /**
     *  This constructor, initiliazes all the data members of this class and of the super class by calling the super constructor.
     *  @param ID String data member in the super class which holds the furniture's ID number.
     *  @param PRICE int data member in the super class which holds the price of the furniture.
     *  @param MANUID String data member in the super class which holds the manufacturer's ID number.
     *  @param TYPE String data member in the super class which holds the type of the furniture.
     *  @param rails int data member which indicates whether the rails component is in usable condition; 1 for yes and 0 for no.
     *  @param drawers int data member which indicates whether the drawers component is in usable condition; 1 for yes and 0 for no.
     *  @param cabinet int data member which indicates whether the cabinet component is in usable condition; 1 for yes and 0 for no.
     */
    public Filing(String ID, int PRICE, String MANUID, String TYPE, int rails, int drawers, int cabinet) {
        super(ID, PRICE, MANUID, TYPE);    //call to the super constructor.
        this.rails = rails;
        this.drawers = drawers;
        this.cabinet = cabinet;
    }

     /**
     *  This is a getter method for the data member rails.
     *  @return the object's rails data member.
     */
    public int getRails() {
        return rails;
    }

     /**
     *  This is a getter method for the data member drawers.
     *  @return the object's drawers data member.
     */
    public int getDrawers() {
        return drawers;
    }

     /**
     *  This is a getter method for the data member cabinet.
     *  @return the object's cabinet data member.
     */
    public int getCabinet() {
        return cabinet;
    }

     /**
     *  This is a setter method for the data member rails.
     *  @param rails int data member which indicates whether the rails component is in usable condition; 1 for yes and 0 for no.
     */
    public void setRails(int rails) {
        this.rails = rails;
    }

     /**
     *  This is a setter method for the data member drawers.
     *  @param drawers int data member which indicates whether the drawers component is in usable condition; 1 for yes and 0 for no.
     */
    public void setDrawers(int drawers) {
        this.drawers = drawers;
    }

     /**
     *  This is a setter method for the data member cabinet.
     *  @param cabinet int data member which indicates whether the cabinet component is in usable condition; 1 for yes and 0 for no.
     */
    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

}

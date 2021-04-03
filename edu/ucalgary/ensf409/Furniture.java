package edu.ucalgary.ensf409;

public class Furniture {
    final String ID;
    final int PRICE;
    final String MANUID;
    final String TYPE;

    public Furniture(String ID, int PRICE, String MANUID, String TYPE) {
        this.ID = ID;
        this.PRICE = PRICE;
        this.MANUID = MANUID;
        this.TYPE = TYPE;
    }

    public String getID() {
        return ID;
    }

    public int getPRICE() {
        return PRICE;
    }

    public String getMANUID() {
        return MANUID;
    }

    public String getTYPE() {
        return TYPE;
    }

}

class Chair extends Furniture{
    private int legs;
    private int arms;
    private int seat;
    private int cushion;
    private int usable;

    public Chair(String ID, int PRICE, String MANUID, String TYPE, int legs, int arms, int seat, int cushion, int usable) {
        super(ID, PRICE, MANUID, TYPE);
        this.legs = legs;
        this.arms = arms;
        this.seat = seat;
        this.cushion = cushion;
        this.usable= usable;
    }

    public int getLegs() {
        return legs;
    }

    public int getArms() {
        return arms;
    }

    public int getSeat() {
        return seat;
    }

    public int getCushion() {
        return cushion;
    }

    public int isUsable() {
        return usable;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setCushion(int cushion) {
        this.cushion = cushion;
    }

    public void setUsable(int usable) {
        this.usable = usable;
    }

}

class Desk extends Furniture{
    private int legs;
    private int top;
    private int drawer;
    private int usable;

    public Desk(String ID, int PRICE, String MANUID, String TYPE, int legs, int top, int drawer, int usable) {
        super(ID, PRICE, MANUID, TYPE);
        this.legs = legs;
        this.top = top;
        this.drawer = drawer;
        this.usable= usable;
    }

    public int getLegs() {
        return legs;
    }

    public int getTop() {
        return top;
    }

    public int getDrawer() {
        return drawer;
    }

    public int isUsable() {
        return usable;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setDrawer(int drawer) {
        this.drawer = drawer;
    }

    public void setUsable(int usable) {
        this.usable = usable;
    }

}

class Lamp extends Furniture{
    private int base;
    private int bulb;
    private int usable;

    public Lamp(String ID, int PRICE, String MANUID, String TYPE, int base, int bulb, int usable) {
        super(ID, PRICE, MANUID, TYPE);
        this.base = base;
        this.bulb = bulb;
        this.usable= usable;
    }

    public int getBase() {
        return base;
    }

    public int getBulb() {
        return bulb;
    }

    public int isUsable() {
        return usable;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setBulb(int bulb) {
        this.bulb = bulb;
    }

    public void setUsable(int usable) {
        this.usable = usable;
    }
}

class Filing extends Furniture{
    private int rails;
    private int drawers;
    private int cabinet;
    private int usable;

    public Filing(String ID, int PRICE, String MANUID, String TYPE, int rails, int drawers, int cabinet, int usable) {
        super(ID, PRICE, MANUID, TYPE);
        this.rails = rails;
        this.drawers = drawers;
        this.cabinet = cabinet;
        this.usable= usable;
    }

    public int getRails() {
        return rails;
    }

    public int getDrawers() {
        return drawers;
    }

    public int getCabinet() {
        return cabinet;
    }

    public int isUsable() {
        return usable;
    }

    public void setRails(int rails) {
        this.rails = rails;
    }

    public void setDrawers(int drawers) {
        this.drawers = drawers;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    public void setUsable(int usable) {
        this.usable = usable;
    }

}

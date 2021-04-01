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

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    public void setMANUID(String MANUID) {
        this.MANUID = MANUID;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

}

class Chair extends Furniture{
    private char legs;
    private char arms;
    private char seat;
    private char cushion;
    private boolean usable;

    public Chair(char legs, char arms, char seat, char cushion, boolean usable) {
        this.legs = legs;
        this.arms = arms;
        this.seat = seat;
        this.cushion = cushion;
        this.usable= usable;
    }

    public char getLegs() {
        return legs;
    }

    public char getArms() {
        return arms;
    }

    public char getSeat() {
        return seat;
    }

    public char getCushion() {
        return cushion;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setLegs(char legs) {
        this.legs = legs;
    }

    public void setArms(char arms) {
        this.arms = arms;
    }

    public void setSeat(char seat) {
        this.seat = seat;
    }

    public void setCushion(char cushion) {
        this.cushion = cushion;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

}

class Desk extends Furniture{
    private char legs;
    private char top;
    private char drawer;
    private boolean usable;

    public Desk(char legs, char top, char drawer, boolean usable) {
        this.legs = legs;
        this.top = top;
        this.drawer = drawer;
        this.usable= usable;
    }

    public char getLegs() {
        return legs;
    }

    public char getTop() {
        return top;
    }

    public char getDrawer() {
        return drawer;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setLegs(char legs) {
        this.legs = legs;
    }

    public void setTop(char top) {
        this.top = top;
    }

    public void setDrawer(char drawer) {
        this.drawer = drawer;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

}

class Lamp extends Furniture{
    private char base;
    private char bulb;
    private boolean usable;

    public Lamp(char base, char bulb, boolean usable) {
        this.base = base;
        this.bulb = bulb;
        this.usable= usable;
    }

    public char getBase() {
        return base;
    }

    public char getBulb() {
        return bulb;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setBase(char base) {
        this.base = base;
    }

    public void setBulb(char bulb) {
        this.bulb = bulb;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }
}

class Filing extends Furniture{
    private char rails;
    private char drawers;
    private char cabinet;
    private boolean usable;

    public Filing(char rails, char drawers, char cabinet, boolean usable) {
        this.rails = rails;
        this.drawers = drawers;
        this.cabinet = cabinet;
        this.usable= usable;
    }

    public char getRails() {
        return rails;
    }

    public char getDrawers() {
        return drawers;
    }

    public char getCabinet() {
        return cabinet;
    }

    public boolean isUsable() {
        return USABLE;
    }

    public void setRails(char rails) {
        this.rails = rails;
    }

    public void setDrawers(char drawers) {
        this.drawers = drawers;
    }

    public void setCabinet(char cabinet) {
        this.cabinet = cabinet;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

}

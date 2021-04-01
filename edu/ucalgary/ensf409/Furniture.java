public class Furniture {
    private String ID;
    private int PRICE;
    private String MANUID;
    private String TYPE;
    private boolean USABLE;

    public Furniture(String ID, int PRICE, String MANUID, String TYPE, boolean USABLE) {
        this.ID = ID;
        this.PRICE = PRICE;
        this.MANUID = MANUID;
        this.TYPE = TYPE;
        this.USABLE= USABLE;
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

    public boolean isUSABLE() {
        return USABLE;
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

    public void setUSABLE(boolean USABLE) {
        this.USABLE = USABLE;
    }
}

class Chair{
    private char legs;
    private char arms;
    private char seat;
    private char cushion;

    public Chair(char legs, char arms, char seat, char cushion) {
        this.legs = legs;
        this.arms = arms;
        this.seat = seat;
        this.cushion = cushion;
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

}

class Desk{
    private char legs;
    private char top;
    private char drawer;

    public Desk(char legs, char top, char drawer) {
        this.legs = legs;
        this.top = top;
        this.drawer = drawer;
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

    public void setLegs(char legs) {
        this.legs = legs;
    }

    public void setTop(char top) {
        this.top = top;
    }

    public void setDrawer(char drawer) {
        this.drawer = drawer;
    }

}

class Lamp{
    private char base;
    private char bulb;

    public Lamp(char base, char bulb) {
        this.base = base;
        this.bulb = bulb;
    }

    public char getBase() {
        return base;
    }

    public char getBulb() {
        return bulb;
    }

    public void setBase(char base) {
        this.base = base;
    }

    public void setBulb(char bulb) {
        this.bulb = bulb;
    }
}

class Filing{
    private char rails;
    private char drawers;
    private char cabinet;

    public Filing(char rails, char drawers, char cabinet) {
        this.rails = rails;
        this.drawers = drawers;
        this.cabinet = cabinet;
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

    public void setRails(char rails) {
        this.rails = rails;
    }

    public void setDrawers(char drawers) {
        this.drawers = drawers;
    }

    public void setCabinet(char cabinet) {
        this.cabinet = cabinet;
    }

}
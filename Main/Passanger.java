package Main;

// класс Пассажир
public class Passanger {

    private int requiredRouteNumber;

    private OdessaBusStops requiredStop;

    private Boolean haveMoney;

    public Passanger(int requiredRouteNumber,OdessaBusStops requiredStop,Boolean haveMoney){

        this.requiredRouteNumber = requiredRouteNumber;

        this.requiredStop = requiredStop;

        this.haveMoney = haveMoney;

    }

    public Passanger(){

    }

    public Boolean hasPaidMoney() {

        if(haveMoney) return true;

        else return  false;

    }

    // getters and setters
    public void setHaveMoney(Boolean a) {
        haveMoney = a;
    }

    public Boolean getHaveMoney() {
        return haveMoney;
    }

    public void setRequiredStop(OdessaBusStops a) {
        requiredStop = a;
    }

    public OdessaBusStops getRequiredStop() {
        return requiredStop;
    }

    public int getRequiredRouteNumber() {
        return requiredRouteNumber;
    }

    public void setRequiredRouteNumber(int requiredRouteNumber) {
        this.requiredRouteNumber = requiredRouteNumber;
    }


}

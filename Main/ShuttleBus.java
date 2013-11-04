package Main;

import java.util.ArrayList;


//класс Маршрутка
public class ShuttleBus {

    private Driver driver;

    private ArrayList<Passanger> passangers = new ArrayList<Passanger>();

    //маршрут автобуса содержащий ссылки на объекты остановок
    private BusRoute route;

    private int capasity = 42;

    private Boolean isStopped = true;

    private Boolean isFrontDoorOpened = false;

    private Boolean isRearDoorOpened = false;

    public ShuttleBus(Driver driver, ArrayList<Passanger> passangers, BusRoute route, int routeNumber) {

        this.driver = driver;

        this.passangers = passangers;

        this.route = route;

    }

    public ShuttleBus() {

    }


    //пассажир вышел из маршрутки, и испортил настроение водителю, если не заплатил
    public void deletePassangers(ArrayList<Passanger> pass) {

        driver.takeMoney(pass);

        passangers.removeAll(pass);

    }

    public void addPassangers(ArrayList<Passanger> pass) {

        passangers.addAll(pass);

    }

    public ArrayList<Passanger> passangersToExit(OdessaBusStops stopName) {

        ArrayList<Passanger> pass = new ArrayList<Passanger>();

        for (Passanger p : passangers) {

            if (p.getRequiredStop() == stopName) pass.add(p);

        }


        return pass;
    }


    public void stopBus() {
        isStopped = true;
    }

    public void runBus() {
        isStopped = false;
    }

    public void openFrontDoor() {
        isFrontDoorOpened = true;
    }

    public void closeFrontDoor() {
        isFrontDoorOpened = false;
    }

    public void openRearDoor() {
        isRearDoorOpened = true;
    }

    public void closeRearDoor() {
        isRearDoorOpened = false;
    }

    public BusRoute getRoute() {
        return route;
    }

    public void setRoute(BusRoute route) {
        this.route = route;
    }

    public int getCapasity() {
        return capasity;
    }

    public ArrayList<Passanger> getPassangers() {
        return passangers;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Boolean isStopped() {
        return isStopped;
    }

    public Boolean isFrontDoorOpened() {
        return isFrontDoorOpened;
    }

    public Boolean isRearDoorOpened() {
        return isRearDoorOpened;
    }

}


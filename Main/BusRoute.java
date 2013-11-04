package Main;

import java.util.HashMap;

public class BusRoute {

    private int routeNumber;

    private HashMap<OdessaBusStops,Stop> stopsList;

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public HashMap<OdessaBusStops,Stop> getStopsList() {
        return stopsList;
    }

    public void setStopsList(HashMap<OdessaBusStops,Stop> stopsList) {
        this.stopsList = stopsList;
    }

}

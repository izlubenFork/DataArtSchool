package Main;

import java.util.ArrayList;

// класс Остановка
public class Stop {

    private OdessaBusStops name;

    private ArrayList<Passanger> passangers = new ArrayList<Passanger>();

    public Stop(OdessaBusStops name){

        this.name = name;

    }

    public Stop(OdessaBusStops name, ArrayList<Passanger> passangers){

        this.name = name;

        this.passangers = passangers;

    }

    public Stop(){

    }

    public ArrayList<Passanger>  passangersToEnter(Integer routeNumber){

        ArrayList<Passanger> pass = new ArrayList<Passanger>();

        for(Passanger p: passangers){

            if(p.getRequiredRouteNumber() == routeNumber) pass.add(p);

        }

        return pass;
    }

    public void deletePassangers(ArrayList<Passanger> pass){

        passangers.removeAll(pass);

    }

    public void addPassangers(ArrayList<Passanger> pass){

        passangers.addAll(pass);

    }

    public void addPassanger(Passanger p){
        passangers.add(p);
    }



    public void setName(OdessaBusStops name) {
        this.name = name;
    }

    public OdessaBusStops getName() {
        return name;
    }

    public ArrayList<Passanger> getPassangers() {
        return passangers;
    }


}

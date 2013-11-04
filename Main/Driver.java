package Main;

import java.util.ArrayList;
//класс Водитель
public class Driver {

    private DriversMood mood;

    private Boolean isOnBoard;

    private ShuttleBus bus;

    private int money;

    public Driver (DriversMood mood, Boolean isOnBoard, ShuttleBus bus, int money){

        this.mood = mood;

        this.isOnBoard = isOnBoard;

        this.bus = bus;

        this.money = money;

    }

    public Driver(){

    }

    // Поехали!!!
    public void ride() {

        if (isOnBoard) {

            bus.closeFrontDoor();

            bus.closeRearDoor();

            bus.runBus();

        }

    }

    //остановить маршрутку (на светофоре например)
    public void stop() {

        bus.stopBus();

    }

    // остановить маршрутку на остановке, уехать когда пассажиры выйдут/зайдут
    public void stopAtTheBusStop(Stop stop, ArrayList<Passanger> passEnter,ArrayList<Passanger> passExit) {

        bus.stopBus();

        // если водитель в плохом настроении он не открывает заднюю дверь
        if (mood == DriversMood.GOOD) {

            bus.openFrontDoor();

            bus.openRearDoor();

        } else bus.openFrontDoor();

        bus.deletePassangers(passExit); // выходят приехавшие к месту назначения пассажиры

        bus.addPassangers(passEnter); //заходят пассажиры с остановки

        stop.addPassangers(passExit); //пассажиры, вышедшие из автобуса возможно поедут дальше,с пересадкой

        stop.deletePassangers(passEnter); // на остановке не осталось пассажиров зашедших в автобус

        ride(); // можно ехать

    }

    public void takeMoney(ArrayList<Passanger> pass){

        for(Passanger p : pass){

            if(p.hasPaidMoney() == false) setMood(DriversMood.BAD);

            else money++;
        }

    }



    // при подъезде к очередной остановке
    public void onTheStopIsApproachingEvent(Stop nextStop) {

        //если эта остановка есть в маршруте автобуса, то обратим на нее внимание
        if(bus.getRoute().getStopsList().containsValue(nextStop)) {

            ArrayList<Passanger> passEnter = new ArrayList<Passanger>();

            //если в атобусе достаточно места для новых пассажиров, то проверяем есть ли такие пассажиры на остановке
            if(isEnoughSpace())  passEnter = nextStop.passangersToEnter(bus.getRoute().getRouteNumber());

            //проверим, есть ли среди пассажиров маршрутки те, кому нужна эта остановка
            ArrayList<Passanger> passExit = bus.passangersToExit(nextStop.getName());

            //остановимся, если есть люди на высадку/посадку
            if (!passExit.isEmpty() || !passEnter.isEmpty()) stopAtTheBusStop(nextStop,passEnter,passExit);

        }

    }

    //завод изготовитель поскромничал с заявленной емкостью маршрутки
    public Boolean isEnoughSpace(){

        if (bus.getPassangers().size() <= 2*bus.getCapasity()) return true;

        else return false;

    }


    public DriversMood getMood() {
        return mood;
    }

    public void setMood(DriversMood mood) {
        this.mood = mood;
    }

    public Boolean getOnBoard() {
        return isOnBoard;
    }

    public void setOnBoard(Boolean onBoard) {
        isOnBoard = onBoard;
    }

    public ShuttleBus getBus() {
        return bus;
    }

    public void setBus(ShuttleBus bus) {
        this.bus = bus;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }



}

// перечисление настроений водителя


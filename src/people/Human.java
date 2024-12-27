package people;
import exceptions.WrongFloor;
import objects.Lift;
import utilities.*;
public abstract class Human {
    String name;
    HumanActs act;
    Location location;
    public void go(int CorX, int CorY, Lift lift) {
        try {
            if (CorX != location.getX()) {
                if (location.getX() != lift.getFloor()) {
                    lift.setFloor(location.getX());
                }
                if (location.getY() != -1) {
                    location.setY(-1);
                }
                setLocation(CorX, CorY);
                lift.setFloor(CorX);
            } else {
                setLocation(CorX, CorY);
            }
        } catch (WrongFloor e) {
            System.out.println(e.getMessage());
            System.out.println("The lift is broken! We need someone to fix it.");
            lift.setState(LiftStates.NORMAL);
            go(CorX, CorY, lift);
        }
    }

    public void act(Locations location) {
        System.out.print(this.getClass().getSimpleName() + " ");
        System.out.println(act.toString().toLowerCase() + " to " + location);
    }

    public void setHumanAct(HumanActs act) {
        this.act = act;
    }

    public void say(String string) {
        System.out.println(this.getClass().getSimpleName() + " says: " + string);
    }

    private void changeLocation(int CorX, int CorY) {
        location.modify(CorX, CorY);
    }

    private void setLocation(int CorX, int CorY) {
        location.set(CorX, CorY);
        System.out.println(this.getClass().getSimpleName() + " is going to " + location);
    }

    public Location getLocation() {
        return location;
    }
}
package objects;

import exceptions.WrongFloor;
import utilities.LiftStates;

import java.util.Objects;

public class Lift {
    private int floor;
    private LiftStates state;
    public Lift(int floor) {
        this.floor = floor;
    }

    public void setFloor(int floor) {
        if (state == LiftStates.BROKEN && Math.random() < 0.6) {
            this.floor = floor + 2;
        } else {
            this.floor = floor;
        }
        System.out.println("Lift is going to floor " + this.floor);
        if (this.floor != floor) {
            throw new WrongFloor();
        }
    }

    public int getFloor() {
        return floor;
    }

    public void setState(LiftStates state) {
        this.state = state;
    }

    public LiftStates getState() {
        return state;
    }

    @Override
    public String toString() {
        return "This is a lift";
    }

    @Override
    public int hashCode() {
        return Objects.hash(floor, state);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Lift)) return false;
        return this.floor == ((Lift) obj).floor && this.state == ((Lift) obj).state;
    }
}
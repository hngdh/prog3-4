package objects;

import utilities.Location;
import utilities.ClosetStates;

import java.util.Objects;

public class Closet implements Obj {
    private Location location;
    private ClosetStates state;
    public Closet(ClosetStates state, Location location) {
        this.state = state;
        this.location = location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocation() {
        return location.toString();
    }

    public void setClosetState(ClosetStates state) {
        this.state = state;
    }

    public ClosetStates getClosetState() {
        return state;
    }

    @Override
    public String toString() {
        return "This is a closet";
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, location);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Closet)) return false;
        return this.state == ((Closet) obj).state && this.location == ((Closet) obj).location;
    }
}

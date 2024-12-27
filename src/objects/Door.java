package objects;
import exceptions.WrongKey;
import people.Human;
import utilities.DoorStates;
import utilities.Keys;
import utilities.Location;
import java.lang.Object;
import java.util.Objects;

public class Door implements Obj{
    private Location location;
    private DoorStates state;
    private final Keys key;
    public Door(Keys key, DoorStates state, Location location) {
        this.state = state;
        this.location = location;
        this.key = key;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocation() {
        return location.toString();
    }

    private void setDoorState(DoorStates state) {
        this.state = state;
    }

    public String getDoorState() {
        return state.toString();
    }

    public void open(Key key, Human human) {
        System.out.println("Opening " + this.key + "'s door");
        if (state == DoorStates.LOCKED && this.key.equals(key.getKey()) && this.location.get().equals(human.getLocation().get())) {
            setDoorState(DoorStates.OPEN);
            System.out.println("The door is " + state.toString().toLowerCase());
            System.out.println();
        } else {
            throw new WrongKey();
        }
    }

    public void lock(Key key, Human human) {
        System.out.println("Locking " + this.key + "'s door");
        if ( state == DoorStates.CLOSE && this.key.equals(key.getKey()) && this.location.get().equals(human.getLocation().get())) {
                setDoorState(DoorStates.LOCKED);
                System.out.println("The door is " + state.toString().toLowerCase());
        }
    }

    public void close(Human human) {
        if (this.location.get().equals(human.getLocation().get())) {
            setDoorState(DoorStates.CLOSE);
        }
    }

    @Override
    public String toString() {
        return "This is a door";
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, state, location);
    }

    @Override
    public boolean equals(Object door ) {
        if (!(door instanceof Door)) return false;
        return this.location == ((Door) door).location && this.state == ((Door) door).state && this.key == ((Door) door).key;
    }
}
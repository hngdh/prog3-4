package people;

import utilities.Location;

interface HumanLocation {
    default void setLocation(int CorX, int CorY) {}
    default void changeLocation(int CorX, int CorY) {}
    Location getLocation();
}

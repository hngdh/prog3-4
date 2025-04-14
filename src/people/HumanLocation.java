package people;

import utilities.Location;

interface HumanLocation {
    static void setLocation(int CorX, int CorY){}

    static void changeLocation(int CorX, int CorY){}
    Location getLocation();
}

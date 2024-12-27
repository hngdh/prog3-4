import objects.Closet;
import objects.Door;
import objects.Lift;
import people.Doorman;
import people.Kozlik;
import people.Nheznaika;
import utilities.ClosetStates;
import utilities.DoorStates;
import utilities.Keys;
import utilities.Location;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out) {
            @Override
            public void println(String x) {
                super.println(x);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Lift lift = new Lift(1);
        Closet closet = new Closet(ClosetStates.EMPTY, new Location(3,3));
        Door closetdoor = new Door(Keys.Closet, DoorStates.SLIGHTLY_OPEN, new Location(3,2));
        Door officedoor = new Door(Keys.Office, DoorStates.LOCKED, new Location(3,0));
        Doorman doorman = new Doorman("Doorman",new Location(1,0));
        Kozlik kozlik = new Kozlik("Kozlik", new Location(1,0));
        Nheznaika nhez = new Nheznaika("Nheznaika", new Location(1,0));

        Expedition expedition = new Expedition(lift, closet, closetdoor, officedoor,doorman, kozlik, nhez);
        expedition.go();
    }
}
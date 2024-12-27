import exceptions.WrongKey;
import objects.Closet;
import objects.Door;
import objects.Key;
import objects.Lift;
import people.Human;
import utilities.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Expedition {
    private final Lift lift;
    private final Closet closet;
    private final Door closetdoor;
    private final Door officedoor;
    private final Human doorman;
    private final Human kozlik;
    private final Human nhez;
    private final Key key;
    private final ArrayList<KeyList> keylist;

    public Expedition(Lift lift, Closet closet, Door closetdoor, Door officedoor, Human doorman, Human kozlik, Human nhez) {
        this.lift = lift;
        this.closet = closet;
        this.closetdoor = closetdoor;
        this.officedoor = officedoor;
        this.doorman = doorman;
        this.kozlik = kozlik;
        this.nhez = nhez;
        keylist = new ArrayList<>();
        keylist.add(new KeyList(Keys.Closet, KeyOwners.Doorman));
        keylist.add(new KeyList(Keys.Office,KeyOwners.Doorman));
        keylist.add(new KeyList(Keys.ClosetRoom,KeyOwners.Doorman));
        int rand1 = new Random().nextInt(keylist.size());
        key = new Key(keylist.get(rand1).key(), keylist.get(rand1).owner());
    }

    public void go() {
        keylist.forEach(KeyList::list);
        System.out.println("Kozlik and Nheznaika are standing at " + kozlik.getLocation().get());
        System.out.println("Doorman gave Kozlik " + key.getKey() + "'s key");
        lift.setState(LiftStates.values()[(int) (Math.random()*2)]);
        key.setOwner(KeyOwners.Kozlik);
        kozlik.setHumanAct(HumanActs.RUNS);
        nhez.setHumanAct(HumanActs.RUNS);
        kozlik.act(Locations.Lift);
        kozlik.go(3,0, lift);
        nhez.act(Locations.Lift);
        nhez.go(3,0,lift);
        kozlik.setHumanAct(HumanActs.WALKS);
        nhez.setHumanAct(HumanActs.STANDS);
        try {
            officedoor.open(key, kozlik);
        } catch (WrongKey e) {
            System.out.println(e.getMessage());
            kozlik.act(Locations.Lift);
            kozlik.go(1,0,lift);
            key.setOwner(KeyOwners.Doorman);
            key.setKey(Keys.Office);
            key.setOwner(KeyOwners.Kozlik);
            kozlik.act(Locations.Lift);
            kozlik.go(3,0,lift);
            officedoor.open(key, kozlik);
        }
        kozlik.act(Locations.ClosetRoom);
        kozlik.say("There is a fireproof closet here!");
        kozlik.setHumanAct(HumanActs.JUMPS);
        kozlik.act(Locations.inside_Closet);
        System.out.println("The closet is " + closet.getClosetState().toString().toLowerCase() + "!");
    }

    @Override
    public String toString() {
        return "This is the expedition of Kozlik and Nheznaika!";
    }

    @Override
    public int hashCode() {
        return Objects.hash(lift, closet, closetdoor, officedoor,doorman, kozlik, nhez);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Expedition)) return false;
        return this.kozlik == ((Expedition) obj).kozlik && this.nhez == ((Expedition) obj).nhez;
    }
}

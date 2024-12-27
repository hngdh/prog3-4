package objects;

import utilities.Keys;
import utilities.KeyOwners;
import java.lang.Object;
import java.util.Objects;

public class Key {
    private KeyOwners owner;
    private Keys key;

    public Key(Keys key, KeyOwners owner) {
        this.key = key;
        this.owner = owner;
    }

    public void setKey(Keys key) {
        if (this.owner == KeyOwners.Doorman) {
            this.key = key;
        } else { System.out.println("Key needed to be given to doorman to be changed");}
    }

    public Keys getKey() {
        return key;
    }

    public void setOwner(KeyOwners owner) {
        this.owner = owner;
        System.out.println("The key is given to " + owner);
    }

    public KeyOwners getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "This is a key";
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, owner);
    }

    @Override
    public boolean equals(Object key) {
        if(!(key instanceof Key)) return false;
        return this.key == ((Key) key).getKey() && this.owner == (((Key) key).getOwner());
    }
}
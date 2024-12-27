package people;

import utilities.*;

import java.util.Objects;

public class Nheznaika extends Human {
    public Nheznaika(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Human)) return false;
        return this.name.equals(((Human) obj).name) && this.location == ((Human) obj).location;
    }
}



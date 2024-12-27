package utilities;

import exceptions.*;

import java.util.Objects;

public class Location {
    Locations location;
    private int CorX;
    private int CorY;

    public Location(int CorX, int CorY) {
        this.CorX = CorX;
        this.CorY = CorY;
        wrap(this.CorX, this.CorY);
    }

    public void set(int CorX, int CorY) {
        this.CorX = CorX;
        this.CorY = CorY;
        wrap(this.CorX, this.CorY);
    }

    public Locations get() {
        return location;
    }

    public void modify(int CorX, int CorY) {
        this.CorX += CorX;
        this.CorY += CorY;
        wrap(this.CorX, this.CorY);
    }

    public void setX(int CorX) {
        this.CorX = CorX;
        wrap(this.CorX, this.CorY);
    }

    public void setY(int CorY) {
        this.CorY = CorY;
        wrap(this.CorX, this.CorY);
    }

    public int getX() {
        return CorX;
    }

    public int getY() {
        return CorY;
    }

    public void modifyX(int CorX) {
        this.CorX +=CorX;
    }

    public void modifyY(int CorY) {
        this.CorY += CorY;
    }

    public void wrap(int CorX, int CorY) {
            if (CorY == -1) {
                this.location = Locations.Lift;
            } else if (CorX == 1 && CorY == 0) {
                this.location = Locations.First_Floor;
            } else if (CorX == 3) {
                switch (CorY) {
                    case 0: {
                        this.location = Locations.Third_Floor;
                        break;
                    }
                    case 1: {
                        this.location = Locations.Office;
                        break;
                    }
                    case 2: {
                        this.location = Locations.ClosetRoom;
                        break;
                    }
                    case 3: {
                        this.location = Locations.inside_Closet;
                        break;
                    }
                }
            } else {
                throw new UnknownPlace();
            }
    }

    @Override
    public String toString() {
        return location.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(CorX, CorY);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) return false;
        return this.CorX == ((Location) obj).CorX && this.CorY == ((Location) obj).CorY;
    }
}
package utilities;

abstract class Loca {
    Locations location;
    int CorX;
    int CorY;
    abstract void set(int CorX, int CorY);
    abstract void modify(int CorX, int CorY);
    abstract void setX(int CorX);
    abstract void setY(int CorY);
    abstract void modifyX(int CorX);
    abstract void modifyY(int CorY);
    abstract void wrap(int CorX, int CorY);
}
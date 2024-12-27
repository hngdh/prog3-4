package utilities;

public record KeyList(Keys key, KeyOwners owner) {
    public void list() {
        System.out.println("This is " + key + "'s key, belongs to " + owner);
    }
}
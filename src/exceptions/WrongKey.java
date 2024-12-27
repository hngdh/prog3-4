package exceptions;

public class WrongKey extends RuntimeException {
    public WrongKey() {}
    @Override
    public String getMessage() {
        return "We got wrong key!";
    }
}
package exceptions;

public class WrongFloor extends RuntimeException {
    public WrongFloor() {}
    @Override
    public String getMessage() {
        return "We went to wrong floor!";
    }
}

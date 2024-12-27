package exceptions;
public class UnknownPlace extends RuntimeException{
    public UnknownPlace() {}
    @Override
    public String getMessage() {
        return "Unknown place, resetting position...";
    }
}

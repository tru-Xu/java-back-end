package classload;

public class ConstClass {

    public static final String CONST="const";
    static {
        System.out.println("ConstClass init");
    }
}

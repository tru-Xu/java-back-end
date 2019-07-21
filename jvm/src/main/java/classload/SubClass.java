package classload;

public class SubClass  extends  SuperClass{

    //public static int value = 2;
    static {
        System.out.println("SubClass init");
    }

}

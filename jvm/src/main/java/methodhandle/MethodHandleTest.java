package methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * 方法句柄
 */
public class MethodHandleTest{

    public static class A{
        public void println(String s){
            System.out.println(s);
        }
    }

    public static MethodHandle getMethodHandle(Object receiver) throws Throwable{
        MethodType mt =  MethodType.methodType(void.class, String.class);
        return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }

    public static void main(String[] args) {
        A a = new A();
        try {
            getMethodHandle(a).invokeExact("s");
        }catch (Throwable e){
            System.out.println(e.getMessage());
        }

    }
}

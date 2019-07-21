package memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class PermGen {

    public static void main(String[] args) throws InterruptedException{
        List<String> list = new ArrayList<>();
        String base = "intern";
        int i = 0;
        while (true) {
            list.add(base.intern());
            base += base;
        }
    }


    private void CGLibError() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OOMObject.class);
        enhancer.setUseCache(false);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return methodProxy.invokeSuper(o, objects);
            }
        });
        enhancer.create();
    }
    static class OOMObject {
        int [] a = new int [10];
    }
}

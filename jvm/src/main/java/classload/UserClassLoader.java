package classload;

import java.io.IOException;
import java.io.InputStream;
import java.lang.Object;
public class UserClassLoader {

    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    if(name.startsWith("java")){
                        return super.loadClass(name);
                    }
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null) {
                        return super.loadClass(fileName);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("classload.UserClassLoader").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof classload.UserClassLoader);
    }
}

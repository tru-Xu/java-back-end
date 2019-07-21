package reflection;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {

    public static void main(String[] args) throws Exception {


    }

    public Object getObjectByClass(Class<?> targetClass) throws Exception {
        Class<?> cls = targetClass;
        Object obj = cls.newInstance();
        return obj;
    }

    public Object getObjectByClass(String className) throws Exception {
        Class<?> cls = Class.forName(className);
        Object obj = cls.newInstance();
        return obj;
    }

    public Object getObjectByInstance(Object instance) throws Exception {
        Class<?> cls = instance.getClass();
        Object obj = cls.newInstance();
        return obj;
    }

    public Object getObjectByClassLoader(String className) throws Exception {
        Class<?> cls = this.getClass().getClassLoader().loadClass(className);
        Object obj = cls.newInstance();
        return obj;
    }

    public Object getFieldByName(Object instance, String fieldName, Object value) throws Exception {
        Class<?> cls = instance.getClass();
        Field field = cls.getField(fieldName);
        System.out.println(field.getName());
        System.out.println(field.get(instance));
        Class<?> fieldClass = field.getDeclaringClass();
        System.out.println(fieldClass.getName());
        field.setAccessible(true);
        field.set(instance, value);
        return field;
    }

    public Object[] getMethodByName(Object instance, Object[] params) throws Exception {
        Class<?> cls = instance.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            Object[] ps = method.getParameters();
            for(Object p : ps){
                System.out.println(p.toString());
            }
            AnnotatedType annotatedType = method.getAnnotatedReturnType();
            System.out.println(annotatedType.getType().getTypeName());
            method.setAccessible(true);
            method.invoke(instance, params);
        }
        return methods;
    }

    public Object getConstructor(Object instance) throws Exception{
        Class<?> cls = instance.getClass();
        Constructor constructor = cls.getDeclaredConstructor(null);
        Object object = constructor.newInstance();
        return object;
    }
}

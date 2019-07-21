package generalType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wildcards {

    public Class<?> getClass(String className) throws Exception{
        Class<?> cls = className.getClass();
        List<?> list = new ArrayList<>();
        Map<?, ?> map = new HashMap<>();
        return cls;
    }

    public <T extends String> void getInstance(Class<T> tClass) throws Exception{
        T t = tClass.newInstance();
        List<T> tList = new ArrayList<>();
        List<? extends  String> list = tList;
        List<? extends  T> list1 = tList;
    }

}

package generalType;

public class GeneralMethod {

    public <T> String getClassName(T t){
        String name = t.getClass().getName();
        System.out.println(name);
        return name;
    }
    public static void main(String[] args) {
        GeneralMethod generalMethod = new GeneralMethod();
        generalMethod.getClassName("");
        generalMethod.getClassName(0);
        generalMethod.getClassName(0L);
        generalMethod.getClassName(2.0);
    }
}

package generalType;

public class boader {

    public <T extends String> void getChar(T s){
        char c = s.charAt(0);
        System.out.println(c);
    }
}

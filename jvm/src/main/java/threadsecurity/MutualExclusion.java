package threadsecurity;

public class MutualExclusion {

    private String a;

    public String getA() {
        return a;
    }

    public void setA(String b) {
        synchronized (b) {
            this.a = b;
        }
    }
    public static void main(String[] args) {

    }
}

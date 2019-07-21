package generalType;

public class Fibonacci implements Generator<Integer> {

    private int count = 0;
    @Override
    public Integer getNext() {
        return fab(count++);
    }
    private Integer fab(int n){
        if(n < 2) return 1;
        return fab(n-2)+fab(n-1);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for(int i = 0; i < 10; i++){
            int n = fibonacci.getNext();
            System.out.print(n + " ");
        }
    }
}

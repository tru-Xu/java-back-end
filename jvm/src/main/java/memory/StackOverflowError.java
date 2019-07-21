package memory;

public class StackOverflowError {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args){
        StackOverflowError stackOverflowError = new StackOverflowError();
        try {
            stackOverflowError.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + stackOverflowError.stackLength);
            throw e;
        }
    }
}

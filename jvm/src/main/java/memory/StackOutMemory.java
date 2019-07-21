package memory;

public class StackOutMemory {
    private void running(){
        while (true){

        }
    }
    public void stackOutMemory(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    running();
                }
            });
            thread.start();
        }
    }
    public static void main(String[] args){
        StackOutMemory stackOutMemory = new StackOutMemory();
        stackOutMemory.stackOutMemory();
    }
}

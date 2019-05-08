package leetcode;

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int end =  A.length - 1;
        for(int i = 0; i <= end; i++) {
            if(A[i] == elem) {
                while(i < end && A[end] == elem){
                    end--;
                }
                if(i != end){
                    A[i] = A[end];
                }
            }
        }
        return end;
    }

    public static void main(String[] args){
        RemoveElement removeElement = new RemoveElement();
        int[] A = new int[]{2};

        removeElement.removeElement(A, 3);
    }
}

package leetcode;

public class AddBinary
{

    public static void main(String[] args){
        AddBinary addBinary = new AddBinary();
        String s = addBinary.addBinary("1010", "1011");
        System.out.println(s);

    }
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if(aLen == 0) {
            return b;
        }
        if(bLen == 0) {
            return a;
        }
        int i = aLen - 1;
        int j = bLen - 1;
        char next = '0';
        String res = "";
        while(i >= 0 && j >= 0){
            char ac = a.charAt(i);
            char bc = b.charAt(j);
            int n = (ac - '0') + (bc - '0') + (next - '0');
            int remain = n%2;
            next = (char)(n/2 + '0');
            res =  remain + res;
            i--;
            j--;
        }
        if(next == '0'){
            while(i >= 0){
                res = a.charAt(i) + res;
                i--;
            }
            while(j >= 0) {
                res = b.charAt(j) + res;
                j--;
            }
        }else {
            while(i >= 0){
                int n = a.charAt(i) - '0' + next - '0';
                char remain = n%2 == 0 ? '0' : '1';
                next =   n/2 == 1 ? '1' : 0;
                res =  remain + res;
                i--;
            }
            while(j >= 0) {
                int n = b.charAt(j) - '0' + next - '0';
                char remain = n%2 == 0 ? '0' : '1';
                next =   n/2 == 1 ? '1' : 0;
                res =  remain + res;
                j--;
            }
            if(next == '1'){
                res = '1' + res;
            }

        }
        return res;

    }
}

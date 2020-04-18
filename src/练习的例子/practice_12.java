package 练习的例子;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class practice_12 {
    ArrayList<String> res = new ArrayList<>();

    //全排列,回溯
    public ArrayList<String> getPermutation(String A){
        char[] arr = A.toCharArray();
        Arrays.sort(arr);
        getPermutationCore(arr,0);
        return res;
    }

    void getPermutationCore(char[] arr, int k) {
        if (k == arr.length) {
            res.add(new String(arr));
        }
        //从K位开始的每个字符都尝试放在新排列的k这个位置
        for (int i = k; i < arr.length; i++) {
            swap(arr,k,i);
            getPermutationCore(arr,k+1);
            swap(arr,k,i);
        }
    }

    static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    
    @Test
    public void test1() throws IOException {
        ArrayList<String> list = getPermutation("abcdefg");
System.out.println(list.size());
        int count = 0;
        for(String s:list){
            if(isLegal(s)  ){
                count++;
            }
        }
        System.out.println(count);
        
    }



    public boolean isLegal(String expression) {
        Stack<Character> stack = new Stack<Character>();
        char[] ch = expression.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char currCh = ch[i];
            switch (currCh) {
                case '(':
                    stack.push('(');
                    break;

                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
            }
        }
        return true;
    }
}

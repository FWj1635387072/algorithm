package 练习的例子;

import java.util.ArrayList;

import static java.lang.System.exit;

public class practice_16 {
    //部分和
    private static void dfs(int[] a, int k, int cur, ArrayList<Integer> ints){
        if(k == 0){
            System.out.println("YES");
            exit(0);
        }
        if( k <0 || cur == a.length)return ;

        dfs(a,k,cur+1,ints);

        ints.add(a[cur]);
        int index = ints.size()-1;
        dfs(a,k-a[cur],cur + 1,ints);
        ints.remove(index);//回溯


    }
}

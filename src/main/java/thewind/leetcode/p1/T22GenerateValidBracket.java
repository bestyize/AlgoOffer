package thewind.leetcode.p1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * generateParenthesis
 */
public class T22GenerateValidBracket {
    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }

    public void backTrack(List<String> list,String path,int openCount,int closeCount,int pairCount){
        if(path.length()==(pairCount<<1)){
            list.add(path);
            return ;
        }
        if(openCount<pairCount){
            backTrack(list,path+"(",openCount+1,closeCount,pairCount);
        }
        if(closeCount<openCount){
            backTrack(list,path+")",openCount,closeCount+1,pairCount);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        dfs(list,"",0,0,n);
        return list;
    }
    private void dfs(List<String> list,String path,int openCount,int closeCount,int pairCount){
        if(path.length()==(pairCount<<1)){
            list.add(path);
            return;
        }
        if(openCount<pairCount){
            dfs(list,path+"(",openCount+1,closeCount,pairCount);
        }
        if(closeCount<openCount){
            dfs(list,path+")",openCount,closeCount+1,pairCount);
        }
    }
}

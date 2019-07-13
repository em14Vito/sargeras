package cn.com.denny.sargeras.javase.leetcode.d315;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    final static Set duplicate = new HashSet();
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        int[][] params = {
                {1,2,3,2},
                {2,2,2,2},
                {1,2,5,7}
        };
        int[] value = {1,1};
        List<int[]> result = Solution.question2(params,value);
    System.out.println(result.size());
    }

    //index[0] ==x; index[1] = y;
    public static  List<int[]>  question2(int[][] params, int[] index){
        int bad = params[index[0]][index[1]];
        List<int[]> res = new ArrayList<>();

        Solution.rec(params,index,res,bad);

        return res;

    }

    private static  void rec(int[][] params,int[] index,List<int[]> res,int bad){
        if(params[index[0]][index[1]] == bad){
            int[] badOne = {index[0],index[1]};
            if( duplicate.contains((""+badOne[0]+","+badOne[1]))){
                return;
            } else{
                duplicate.add((""+badOne[0]+","+badOne[1]));
                System.out.println("X:"+badOne[0]+"Y:"+badOne[1]);

                res.add(badOne);
            }

        } else{
            return;
        }

        if(index[0]+1 <= params.length-1){
            if(params[index[0]+1][index[1]] == bad){
                int[] badOne = {index[0]+1,index[1]};

                rec(params,badOne,res,bad);
            }
        }
        if(index[0]-1 >= 0){
            if(params[index[0]-1][index[1]] == bad){
                int[] badOne = {index[0]-1,index[1]};
                rec(params,badOne,res,bad);
            }

        }

        if(index[1]+1 <= params[0].length-1){
            if(params[index[0]][index[1]+1] == bad){
                int[] badOne = {index[0],index[1]+1 };
                rec(params,badOne,res,bad);
            }
        }
        if(index[1]-1 >= 0){
            if(params[index[0]][index[1]-1] == bad){
                int[] badOne = {index[0],index[1]-1};
                rec(params,badOne,res,bad);
            }
        }
        return;
    }


}
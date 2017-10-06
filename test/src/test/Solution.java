package test;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    Stack<Integer> max = new Stack<Integer>();
    Integer temp = null;
    public void push(int node) {
        if(temp != null){
            if(node <= temp ){
                temp = node;
                min.push(node);
            }else{
                temp = node;
                max.push(node); 
            }
        }else{
            temp = node;
            min.push(node);
            max.push(node);
        }
        data.push(node);
    }
     
    public void pop() {
        int num = data.pop();
        int num2 = min.pop();
        if(num != num2){
           min.push(num2);
        }
    }
     
    public int max() {
        return max.peek();
    }
     
    public int min() {
        return min.peek();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Solution s = new Solution();
        for(int i = 0;i<n-1;i++){
            s.push(in.nextInt());
        }
        int tem = in.nextInt();
        System.out.print(s.max()+","+s.min());
    }
}

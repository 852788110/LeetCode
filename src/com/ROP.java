package com;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。

        如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

        给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

        对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

public class ROP {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack1=new Stack<Character>();
        Deque<Character> deque=new LinkedList<Character>();
        int N=S.length();
        for (int i=0;i<N;i++){
            char t=S.charAt(i);
            if (t=='('){
                stack1.push(t);
            }else{
                if (stack1.size()==1){
                    stack1.pop();
                }else {
                    deque.addLast(')');
                    deque.addFirst('(');
                }
            }
        }
        String aim="";
        for (char t:deque) {
            aim+=t;
        }
        return aim;
    }
}

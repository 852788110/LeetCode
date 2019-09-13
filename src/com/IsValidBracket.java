package com;

import java.util.Stack;

/*有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串*/
/* 遍历字符串，遇到左括号，入栈，遇到右括号，出栈，若字符串长度不为偶数，出错
* */
public class IsValidBracket {
    public boolean isValid(String s) {
        int N=s.length();
        Stack<Character> stack=new Stack<Character>();
        for (int i=0;i<N;i++){
            char t=s.charAt(i);
            char temp;
            switch (t){
                case '(':stack.push(t);break;
                case '{':stack.push(t);break;
                case '[':stack.push(t);break;

                case ')':
                    if (!stack.isEmpty()){
                        temp=stack.pop();
                        if (temp!='(')    return false;
                    }else return false;break;
                case ']':
                    if (!stack.isEmpty()){
                        temp=stack.pop();
                        if (temp!='[')    return false;
                    }else return false;break;
                case '}':
                    if (!stack.isEmpty()){
                        temp=stack.pop();
                        if (temp!='{')    return false;
                    }else return false;break;
            }
        }
        if (stack.size()!=0) return false;
        return true;
    }
}

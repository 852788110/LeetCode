import com.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    //该方法用于给链表赋值
    public static void convertList(int[] nums, TwoSum lists){
        int length=nums.length;
        for (int i=0;i<length;i++){
            lists.addNode(nums[i]);
        }
    }

    //测试数组是值传递还是引用传递的方法
    public  static void test1(int[] a){
        a[0]=2;
    }

    //用于测试基础类型是引用传递还是值传递
    public static void test2(float a){
        a=3;
    }

    //测试包装类型是否是值传递
    public static void test3(Float a){
        a=3f;
    }

    public static void main(String[] args) {
        /*int x=12221;
        Palindromic palindromic=new Palindromic();
        boolean result=palindromic.isPalindrome(x);
        System.out.println(result);*/

        //测试TWO_SUM
        /*int N1=4;
        int N2=4;
        int[] num1={5};
        int[] num2={5};
        TwoSum list1=new TwoSum();
        TwoSum list2=new TwoSum();
        convertList(num1,list1);
        convertList(num2,list2);
        String testString= list1.toString();
        testString+="\n"+list2.toString();
        System.out.println(testString);
        TwoSum newlist=new TwoSum();
         newlist.node=list1.addTwoNumbers(list1.node,list2.node);
       testString="\n"+newlist.toString();
        System.out.println(testString);*/

        //测试TWO_SUM2
//        TwoSum2 twoSum2=new TwoSum2();
//        int[] test={3,3};
//        int[] result;
//        int target=6;
//        result=twoSum2.twoSum(test,target);
//        for (int num:result) {
//            System.out.println(num+" ");
//        }

        //测试Parenthesis
//        Parenthesis parenthesis=new Parenthesis();
//        List<String> ans=parenthesis.generateParenthesis(3);
//        for (String s:ans) {
//            System.out.println(s+"\n");
//        }


//        LetterCombinations letter=new LetterCombinations();
//        List<String> list= letter.letterCombinations("2354");
//        for (String s:list) {
//            System.out.print(s+" ");
//        }

        //测试数组是值传递还是引用传递
        //实验证明，数组是引用传递
//        int[] a={1,2,3,4,5,6};
//        test1(a);
//        for (int i=0;i<a.length;i++){
//            System.out.print(a[i]+" ");
//        }

//        Permute pe=new Permute();
//        int[] nums={1,2,3,4,5,6,7,8,9,0};
//        List<List<Integer>> result =pe.permute(nums);
//        System.out.println(result.size());
//        for (List<Integer> s:result) {
//            for (Integer t:s) {
//                System.out.print(t+"");
//            }
//            System.out.println();
//        }

        //测试Map构造函数
//        Map<String,Integer> map=new HashMap<String,Integer>();
//        map.put("2",1);
//        map.put("3",4);
//        Map<String,Integer> map1=new HashMap<String,Integer>(map);

//        NumTilePossibilities nu=new NumTilePossibilities();
//        int sum=nu.numTilePossibilities("AAABBCDDEE");
//        System.out.println(sum);

//        MergeKLists mk=new MergeKLists();
//        MergeKLists.ListNode[] lists=new MergeKLists.ListNode[3];
//        int[] num1={1,4,5};
//        MergeKLists.ListNode list1=mk.chushihua(num1);
//
//        int[] num2={1,3,4};
//        MergeKLists.ListNode list2=mk.chushihua(num2);
//
//        int[] num3={2,6};
//        MergeKLists.ListNode list3=mk.chushihua(num3);
//
//        lists[0]=list1;
//        lists[1]=list2;
//        lists[2]=list3;
//
//        MergeKLists.ListNode listNode1=mk.mergeKLists(lists);
//        while(listNode1!=null){
//            System.out.print(listNode1.getVal()+" ");
//            listNode1=listNode1.getNext();
//        }

        /*MaxSubArray max=new MaxSubArray();
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int sum=max.maxSubArray(nums);
        System.out.println(sum);*/

        /*MaxProfit maxProfit=new MaxProfit();
        int[] nums={7,6,4,3,1};
        int sums=maxProfit.maxProfit(nums);
        System.out.println(sums);*/

        /*IsValidBracket isValidBracket=new IsValidBracket();
        String s="((";
        boolean t=isValidBracket.isValid(s);
        System.out.println(t);*/

        /*MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min=minStack.getMin();
        System.out.println(min);
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());*/

        /*ROP2 rop=new ROP2();
        String s="(()())(())";
        s=rop.removeOuterParentheses(s);
        System.out.println(s);*/

       /*float a=4;
       test2(a);
       System.out.println(a);
       test3(a);
        System.out.println(a);*/

       /*Rain rain=new Rain();
       int[] height={3,1,0,2};
       int sum=rain.trap(height);
       System.out.println(sum);*/

       /*ThreeSum1 threeSum=new ThreeSum1();
       int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> results=null;
       results=threeSum.threeSum(nums);
        for (List<Integer> s:results) {
            for (Integer t:s) {
                System.out.print(t+" ");
            }
            System.out.println();
        }*/

       /*TreeNode root1=new TreeNode(3);
       root1.left=new TreeNode(9);
       root1.right=new TreeNode(20);
       TreeNode temp=root1.right;
       temp.left=new TreeNode(15);
       temp.right=new TreeNode(7);

       ZigzagLevelOrder zlo=new ZigzagLevelOrder();
        List<List<Integer>> ans=null;
       ans=zlo.zigzagLevelOrder(root1);
        for (List<Integer> s:ans) {
            for (Integer t:s) {
                System.out.print(t+" ");
            }
            System.out.println();
        }*/
       /*FindKthLargest fk=new FindKthLargest();
       int[] nums={3,2,3,1,2,4,5,5,6};
       int ans=fk.findKthLargest(nums,4);
       System.out.println(ans);*/

        /*TreeNode root1=new TreeNode(3);
        root1.left=new TreeNode(9);
        root1.right=new TreeNode(20);
        TreeNode temp=root1.right;
        temp.left=new TreeNode(15);
        temp.right=new TreeNode(7);

        PreorderTraversal pt=new PreorderTraversal();
        List<Integer> ans=pt.preorderTraversal(root1);
        for (Integer s:ans) {
            System.out.print(s+" ");
        }*/

        TopKFrequent te=new TopKFrequent();
        int[] nums={1,1,1,2,2,3};
        int k=2;
        List<Integer> ans=te.topKFrequent(nums,k);
        for (Integer s:ans) {
            System.out.print(s+" ");
        }
    }
}









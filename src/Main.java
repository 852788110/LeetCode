import com.*;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    //该方法用于给链表赋值
    /*public static void convertList(int[] nums, TwoSum lists){
        int length=nums.length;
        for (int i=0;i<length;i++){
            lists.addNode(nums[i]);
        }
    }*/

    //测试数组是值传递还是引用传递的方法
    public static void test1(int[] a) {
        a[0] = 2;
    }

    //用于测试基础类型是引用传递还是值传递
    public static void test2(float a) {
        a = 3;
    }

    //测试包装类型是否是值传递
    public static void test3(Float a) {
        a = 3f;
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

        /*TopKFrequent te=new TopKFrequent();
        int[] nums={1,1,1,2,2,3};
        int k=2;
        List<Integer> ans=te.topKFrequent(nums,k);
        for (Integer s:ans) {
            System.out.print(s+" ");
        }*/

        /*CanJump CJ=new CanJump();
        int[] nums={3,2,1,0,4};
        boolean can=CJ.canJump(nums);
        System.out.print(can);*/

        /*MaxProfit_1 maxprofit=new MaxProfit_1();
        int[] nums={7,6,4,3,1};
        int ans=maxprofit.maxProfit(nums);
        System.out.println(ans);*/

        /*CanCompleteCircuit CC=new CanCompleteCircuit();
        int[] gas={2};
        int[] cost={2};
        System.out.println(CC.canCompleteCircuit(gas,cost));*/

        /*ListNode first=new ListNode(4);
        ListNode rear=first;
        rear.next=new ListNode(2);
        rear=rear.next;

        rear.next=new ListNode(1);
        rear=rear.next;

        rear.next=new ListNode(3);
        rear=rear.next;

        SortList1 sl=new SortList1();
        first=sl.sortList(first);
        while(first!=null){
            System.out.print(first.val+" ");
            first=first.next;
        }*/

        /*PancakeSort ps=new PancakeSort();
        int[] nums={2,1,3};
        List<Integer> ans=null;
        ans=ps.pancakeSort(nums);
        for (Integer s:ans) {
            System.out.print(s+" ");
        }*/

        /*ListNode first=new ListNode(4);
        ListNode rear=first;
        rear.next=new ListNode(2);
        rear=rear.next;

        rear.next=new ListNode(1);
        rear=rear.next;

        rear.next=new ListNode(3);
        rear=rear.next;

        InsertionSortList IS=new InsertionSortList();
        first=IS.insertionSortList(first);
        while(first!=null){
            System.out.print(first.val+" ");
            first=first.next;
        }*/

        /*SortColors SC=new SortColors();
        int[] nums={2,0,2,1,1,0};
        SC.sortColors(nums);
        for (int s:nums) {
            System.out.print(s+" ");
        }*/

        /*int N=5000000;
        List<String> d=new ArrayList<>();
        d.add("apple");
        d.add("ewaf");
        d.add("awefawfwaf");
        d.add("awef");
        d.add("awefe");
        d.add("ewafeffewafewf");
       for (int i=0;i<N;i++){
           d.add(i+"sfjwlfnlk"+i+"awef");
       }

        long startTime=System.currentTimeMillis();
        FindLongestWord FW=new FindLongestWord();
        String ans=FW.findLongestWord("aewfafwafjlwajflwajflwafj",d);
       // System.out.print(ans);
        long endTime=System.currentTimeMillis();
        System.out.print((endTime-startTime)+"\n");

        startTime=System.currentTimeMillis();
        FindLongestWord1 FW1=new FindLongestWord1();
        ans=FW.findLongestWord("aewfafwafjlwajflwajflwafj",d);
        //System.out.print(ans);
        endTime=System.currentTimeMillis();
        System.out.print((endTime-startTime)+"\n");*/

        /*LargestNumber ln=new LargestNumber();
        int[] nums={3,30,34,5,9};
        String ans=ln.largestNumber(nums);
        System.out.print(ans);*/

        /*long startTime=System.currentTimeMillis();
        int[] prices={0,1,5,8,9,10,17,17,20,24,30,30,41,42,43,44,45,46,50,51,52,53,60,71,72};
        Memoized_Cut_Rod_Aux mcra=new Memoized_Cut_Rod_Aux();
        int sum=mcra.cut_rod_1(prices,20);
        System.out.print(sum);
        long endTime=System.currentTimeMillis();
        System.out.println("\n"+(endTime-startTime));

         startTime=System.currentTimeMillis();
         sum=mcra.cut_rod(prices,20);
            System.out.print(sum);
         endTime=System.currentTimeMillis();
        System.out.println("\n"+(endTime-startTime));*/

        /*int N=10000;
        int[] nums=new int[N];
        for (int i=0;i<N;i++){
            nums[i]=(int)(Math.random()*100);
        }
        long startTime=System.currentTimeMillis();
        Rob rob=new Rob();
        System.out.println(rob.rob(nums));
        long endTime=System.currentTimeMillis();
        System.out.println("\n"+(endTime-startTime));*/

        /*long startTime=System.currentTimeMillis();
        ClimbStairs CS=new ClimbStairs();
        System.out.println(CS.climbStairs(43));
        long endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime));

        startTime=System.currentTimeMillis();
        System.out.println(CS.climbStairs1(43));
        endTime=System.currentTimeMillis();
        System.out.println((endTime-startTime));*/

        /*MinCostClimbingStairs MS=new MinCostClimbingStairs();
        int[] cost={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(MS.minCostClimbingStairs(cost));*/

        /*CountBits cb=new CountBits();
        int[] res=cb.countBits(15);
        for (int s:res){
            System.out.print(s+" ");
        }*/

        /*int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        MinPathSum pathSum=new MinPathSum();
        int sum=pathSum.minPathSum(grid);
        System.out.println(sum);*/

        /*ConstructMaximumBinaryTree cm=new ConstructMaximumBinaryTree();
        int[] nums={3,2,1,6,0,5};
        TreeNode t=cm.constructMaximumBinaryTree(nums);
        System.out.println(t.left);*/

        /*TreeNode node=new TreeNode(1);
        node.right=new TreeNode(0);
        TreeNode temp1=new TreeNode(0);
        node.right.left=temp1;
        temp1=node.right;
        temp1.right=new TreeNode(1);

        PruneTree pt=new PruneTree();
        node=pt.pruneTree(node);
        System.out.println("hello");*/

        /*SingleNumber sn=new SingleNumber();
        int[] nums={1,2,1,3,2,5};
        int[] answer=sn.singleNumber(nums);
        for (int s:answer) {
            System.out.println(s+" ");
        }*/

        /*
        String[] words={"abcw","baz","foo","bar","xtfn","abcdef"};
        MaxProduct mp=new MaxProduct();
        System.out.println(mp.maxProduct(words));
        */

        /*int[] nums={-10, -3, 0, 5, 9};
        ListNode head=new ListNode(nums[0]);
        ListNode node=head.next,pre=head;
        for (int i=1;i<nums.length;i++){
            node=new ListNode(nums[i]);
            pre.next=node;
            pre=node;
        }
        node=head;
        while(node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }

        SortedListToBST SB=new SortedListToBST();
        TreeNode tree=SB.sortedListToBST(head);
        System.out.println("wocaoni");*/

        /*TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        TreeNode node=root.left;
        node.left=new TreeNode(3);
        node.right=new TreeNode(4);
        node=root.right;
        node.right=new TreeNode(6);

        Flatten fl=new Flatten();
        fl.flatten(root);
        System.out.println("Hello world");*/

        /*int[] inorder={9,3,15,20,7},postorder={9,15,7,20,3};
        BuildTree bt=new BuildTree();
        bt.buildTree(inorder,postorder);
        System.out.println("Hello world");*/

        /*String[] grid={
                "/\\",
                "\\/"
        };
        RegionsBySlashes rs=new RegionsBySlashes();
        System.out.println(rs.regionsBySlashes(grid));*/

        /*int N=14;
        System.out.println((int)Math.sqrt(N));*/

        /*NumSquares ns=new NumSquares();
        int n=10;
        System.out.println(ns.numSquares(n));*/

        /*int n=13;
        NumSquares ns=new NumSquares();
        System.out.println(ns.numSquares(n));*/

        /*int[][] M={
                {1,1,0},{1,1,0},{0,0,1}
        };
        FindCircleNum fc=new FindCircleNum();
        System.out.println(fc.findCircleNum(M));*/

        /*int[][] edges={
                {9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}
        };
        FindRedundantConnection fr=new FindRedundantConnection();
        int[] ans=fr.findRedundantConnection(edges);
        for (int s:ans) {
            System.out.print(s+" ");
        }*/

        /*char[][] board={
         *//*{'x','x','x','x'},{'x','o','o','x'},{'x','x','o','x'},{'x','o','x','x'}*//*
                {'x','o','x','o','x','o'},{'o','x','o','x','o','x'},{'x','o','x','o','x','o'},{'o','x','o','x','o','x'}
        };
        Solve sl=new Solve();
        sl.solve(board);
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }*/

        /*String[] equations={
                "a==b","b!=a"
        };
        EquationsPossible ep=new EquationsPossible();
        System.out.print(ep.equationsPossible(equations));*/

        /*String s="dcab";
        List<List<Integer>> pairs=new ArrayList<>();
        List<Integer> pair1=new ArrayList<>();
        pair1.add(0);
        pair1.add(3);
        List<Integer> pair2=new ArrayList<>();
        pair2.add(1);
        pair2.add(2);
        pairs.add(pair1);
        pairs.add(pair2);*/

        /*SmallestStringWithSwaps sw=new SmallestStringWithSwaps();
        String ans=sw.smallestStringWithSwaps(s,pairs);
        System.out.println(ans);*/

        /*List<List<Integer>> rooms=new ArrayList<>();
        List<Integer> room1=new ArrayList<>();
        room1.add(1);
        List<Integer> room2=new ArrayList<>();
        room2.add(2);
        List<Integer> room3=new ArrayList<>();
        room3.add(3);
        List<Integer> room4=new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        CanVisitAllRooms cv=new CanVisitAllRooms();
        boolean canVist=cv.canVisitAllRooms(rooms);
        System.out.println(canVist);*/

        /*List<List<String>> equations=new ArrayList<>();
        List<String> equation1=new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        equations.add(equation1);

        List<String> equation2=new ArrayList<>();
        equation2.add("b");
        equation2.add("c");
        equations.add(equation2);

        List<String> equation3=new ArrayList<>();
        equation3.add("bc");
        equation3.add("cd");
        equations.add(equation3);

        List<List<String>> queries=new ArrayList<>();
        List<String> query=new ArrayList<>();
        query.add("a");
        query.add("c");
        queries.add(query);

        List<String> query1=new ArrayList<>();
        query1.add("c");
        query1.add("b");
        queries.add(query1);

        List<String> query2=new ArrayList<>();
        query2.add("bc");
        query2.add("cd");
        queries.add(query2);

        List<String> query3=new ArrayList<>();
        query3.add("cd");
        query3.add("bc");
        queries.add(query3);

        double[] values={1.5,2.5,5.0};

        CalcEquation1 calc=new CalcEquation1();
        double[] ans=calc.calcEquation(equations,values,queries);
        for (double a:ans){
            System.out.print(a+" ");
        }*/

        /*int nums=2;
        int[][] prerequisites={{0,1}};
        FindOrder fo=new FindOrder();
        int[] ans=fo.findOrder(nums,prerequisites);
        for (int t:ans){
            System.out.print(t+" ");
        }*/

        /*int[][] times={
                {2,1,1},{2,3,1},{3,4,1}
        };
        int N=4;
        int K=2;
        NetworkDelayTime nt=new NetworkDelayTime();
        int sum=nt.networkDelayTime(times,N,K);
        System.out.print(sum);*/

        /*int[][] graph={
                {1,2,3,4},{1,2},{3,4},{0,4},{}
        };
        EventualSafeNodes es=new EventualSafeNodes();
        List<Integer> ans=es.eventualSafeNodes(graph);
        for (int i:ans){
            System.out.print(i+" ");
        }*/

        /*int[][] graph={
                {1,3},{0,2},{1,3},{0,2}
        };
        IsBipartite isb=new IsBipartite();
        boolean ans=isb.isBipartite(graph);
        System.out.print(ans);*/

        /*int[][] edges={
                {0,1},{1,2},{2,3},{0,4},{4,5},{4,6},{6,7}
        };
        int[][] edges1={
                {0,1},{0,2},{0,3},{3,4},{4,5}
        };
        int n=8;
        int n2=6;
        FindMinHeightTrees3 fh=new FindMinHeightTrees3();
        List<Integer> ans=fh.findMinHeightTrees(n,edges);
        for (int an:ans){
            System.out.print(an+" ");
        }*/

        /*int n1=5;
        int[][] red1={
                {0,1},{1,2},{2,3},{3,4}
        };
        int[][] blue1= {
                {1,2},{2,3},{3,1}
        };
        ShortestAlternatingPaths1 sa=new ShortestAlternatingPaths1();
        int[] dist=sa.shortestAlternatingPaths(n1,red1,blue1);
        for (int t:dist){
            System.out.print(t+" ");
        }*/

        /*CountLetter cl=new CountLetter();
        String str="PNEUMONOULTRAMICROSCOPICSILICOVOLCANOCONIOSIS";
        int[] ans=cl.count(str);
        int sum=0;
        for (int i=0;i<ans.length;i++){
            int t='A'+i;
            char s=(char)t;
            sum+=ans[i];
            System.out.print(s+":"+ans[i]+" ");
        }
        System.out.print("\n"+sum);*/

        /*Trie tire=new Trie();
        tire.insert("Trie");
        tire.insert("insert");
        tire.insert("search");
        boolean contain=tire.search("searc");
        boolean startWith=tire.startsWith("searc");
        System.out.print(contain+"\n"+startWith);*/

        /*MyCircularDeque md=new MyCircularDeque(3);
        md.insertLast(1);
        md.insertLast(2);
        md.insertFront(3);
        md.insertFront(4);
        System.out.println(md.getRear());
        System.out.println(md.isFull());
        md.deleteLast();
        md.insertFront(4);
        System.out.println(md.getFront());*/

        /*RandomizedSet rs=new RandomizedSet();
        rs.insert(-1);
        rs.remove(-2);
        rs.insert(-2);
        rs.getRandom();
        rs.remove(-1);
        rs.insert(-2);*/

        /*int capacity=2;
        LRUCache lrc=new LRUCache(capacity);
        System.out.print(lrc.get(2)+" ");
        lrc.put(2,6);
        System.out.print(lrc.get(1)+" ");
        lrc.put(1,5);
        lrc.put(1,2);
        System.out.print(lrc.get(1)+" ");
        System.out.print(lrc.get(2)+" ");*/

       /* WordDictionary1 wd=new WordDictionary1();
        wd.addWord("ran");
        wd.addWord("rune");
        wd.addWord("runner");
        wd.addWord("runs");
        wd.addWord("add");
        wd.addWord("adds");
        wd.addWord("adder");
        wd.addWord("addee");
        wd.search("r.n");
        wd.search("ru.n.e");
        wd.search("add");
        wd.search("add.");
        wd.search("adde.");
        wd.search(".an.");
        wd.search("...s");
        wd.search("....e.");
        wd.search(".......");
        wd.search("..n.r");*/

       /*MyLinkedList ml=new MyLinkedList();
       ml.addAtHead(1);
       ml.addAtTail(3);
       ml.addAtIndex(1,2);
       ml.get(1);
       ml.deleteAtIndex(1);
       ml.get(1);*/

        /*MyLinkedList mll = new MyLinkedList();
        mll.addAtIndex(-1, 0);
        mll.get(0);
        mll.deleteAtIndex(-1);*/

        /*ReplaceWords rw=new ReplaceWords();
        List<String> dict=new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence="the cattle was rattled by the battery";
        String ans=rw.replaceWords(dict,sentence);
        System.out.println(ans);*/

        /*MapSum ms=new MapSum();
        ms.insert("a",3);
        System.out.println(ms.sum("ap"));
        ms.insert("app",3);
        System.out.println(ms.sum("ap"));*/

        /*MagicDictionary1 md=new MagicDictionary1();
        String[] strs={
                "hello","leetcode"
        };
        md.buildDict(strs);
        System.out.println(md.search("hhlo"));
        System.out.println(md.search("hell"));
        System.out.println(md.search("hello"));*/

        /*CamelMatch cm=new CamelMatch();
        String pattern="CooP";
        String[] queries={
                "CompetitiveProgramming","CounterPick","ControlPanel"
        };
        List<Boolean> ans=cm.camelMatch(queries,pattern);
        for (Boolean a:ans){
            System.out.print(a+"  ");
        }*/

        /*int[] nums={
                5,2,6,1
        };
        CountSmaller cs=new CountSmaller();
        List<Integer> ans=cs.countSmaller(nums);
        for (int t:ans){
            System.out.print(t+" ");
        }*/

        /*int[] nums={
                -2,5,-1
        };
        CountRangeSum crs=new CountRangeSum();
        int ans=crs.countRangeSum(nums,-2,2);
        System.out.println(ans);*/

        /*int N=10,K=7;
        KthGrammar kt=new KthGrammar();
        System.out.println(kt.kthGrammar(N,K));*/

        /*int[] nums={10,10,10,7,7,7,7,7,7,6,6,6};
        int k=3;
        CanPartitionKSubsets1 cs=new CanPartitionKSubsets1();
        boolean ans=cs.canPartitionKSubsets(nums,k);
        System.out.println(ans);*/

        SolveNQueens solveNQueens=new SolveNQueens();
        long start=System.currentTimeMillis();
        int ans=solveNQueens.totalNQueens(15);
        long end=System.currentTimeMillis();
        System.out.println((end-start)/1000);
        System.out.println(ans);
    }
}

/*"aewfafwafjlwajflwajflwafj"
["apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"]*/








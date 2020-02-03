package algo;

public class BST<Key extends Comparable<Key>, Value>{

    private class Node{
        private Node left;
        private Node right;
        private Key key;
        private Value value;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
            left=right=null;
        }
    }

    private Node root;
    private int count;

    // public BST(Key key, Value value){
    //     root = new Node(key, value);
    //     count = 1;
    // }
    public BST(){
        root = null;
        count = 0;
    }

    public int size(){ return count; }

    public boolean isEmpty() { return count==0; }

    public void insert(Key key, Value value){
        root = insert(root, key, value);
    }


    private Node insert(Node node, Key key, Value value){
        if(node == null){
            count++;
            return new Node(key, value);
        }

        if(key.CompareTo(node.key) == 0)
            node.value = value;
        else if(key.CompareTo(node.key) < 0)
            node.left = insert(node.left, key, value);
        else //key.CompareTo(node.key) > 0
            node.right = insert(node.right, key, value);

        return node;
        
    }

    public boolean contain(Key key){
        return contains(root, key);
    }

    private boolean contain(Node node, Key key){

        if(node == null)
            return false;
        
        if(key.CompareTo(node.key) == 0)
            return true;
        else if(key.CompareTo(node.key) < 0)
            return contain(node.left, key);
        else //key.CompareTo(node.key) > 0
            return contain(node.right, key);
    }

    public Value search(Key key){
        return search(root, key);
    }

    private Value search(Node node, Key key){

        if(node == null)
            return null;
        
        if(key.CompareTo(node.key) == 0)
            return node.value;
        else if(key.CompareTo(node.key) < 0)
            return search(node.left, key);
        else //key.CompareTo(node.key) > 0
            return search(node.right, key);

    }

    public void preOrder(){ 
        preOrder(root);
    }

    private void preOrder(Node node){

        if(node != null){
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(){ 
        inOrder(root);
    }

    private void inOrder(Node node){

        if(node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){

        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    public static void main(String[] args) {

        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for(int i = 0 ; i < N ; i ++){
            int pos = (int) (Math.random() * (i+1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer,String> bst = new BST<Integer,String>();
        for(int i = 0 ; i < N ; i ++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for(int i = 0 ; i < 2*N ; i ++){
            String res = bst.search(new Integer(i));
            if( i < N )
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }
    }

}
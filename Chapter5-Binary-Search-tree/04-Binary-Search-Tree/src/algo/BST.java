package algo;

//Binary Search Tree 左节点存储小于根节点的值， 右节点存储大于根节点的值
public class BST<Key extends Comparable<Key>, Value>{

    private class Node{
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
            left=right=null;
        }
    }

    private Node root;
    private int count;

    public BST(){
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public Node insert(Key key, Value value){
        return insert(root, key, value);
    }


    private Node insert(Node node, Key key, Value value){
        
        if(node == null){
            count++;
            return new Node(key, value);
        }
        //内部类和外部类可以互相访问private protected成员
        if(key.compareTo(node.key) == 0){
            node.value = value;
        }else if(key.compareTo(node.key) < 0){
            node.left = insert(node.left, key, value);
        }else{
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    public boolean contain(Key key){
        return contain(root, key);
    }

    private boolean contain(Node node, Key key){
        if(node == null)
            return false;
        if(node.key.compareTo(key) == 0)
            return true;
        else if(node.key.compareTo(key) < 0)
            return contain(node.right, key);
        else // node.key.compareTo(key) >0
            return contain(node.right, key);

    }

    public Value search(Key key){
        return search(root, key);
    }

    private Value search(Node node, Key key){

        if(node == null)
            return null;

        if(key.compareTo(node.key) == 0)
            return node.value;
        else if(key.compareTo(node.key) < 0)
            return search(node.left, key);
        else  //(key.compareTo(node.key) > 0)
            return search(node.right, key);
    }

    public static void main(String[] args){

    }

}

package algo;

//Binary Search Tree 左节点存储小于根节点的值， 右节点存储大于根节点的值
public class BST<Key extends Comparable, Value>{

    private class Node{
        private Key key;
        private Value value;
        Node left;
        Node right;

        private Node(Key key, Value value){
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

    public Node Insert(Key key, Value value){
        return Insert(root, key, value);
    }


    private Node Insert(Node node, Key key, Value value){
        
        if(node == null){
            count++;
            node = new Node(key, value);
            return node;
        }
        //内部类和外部类可以互相访问private protected成员
        if(key.compareTo(node.key) == 0){
            node.value = value;
        }else if(key.compareTo(node.key) < 0){
            node.left = Insert(node.left, key, value);
        }else{
            node.right = Insert(node.right, key, value);
        }

        return node;
    }



}

package algo;

public class BTS<Key extends Comparable, Value>{

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

    public BTS(){
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }



}

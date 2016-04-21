public class BSTree<T extends Comparable<T>>{
    private class Node{
        T data;
        Node left;
        Node right;

        public Node(T d){
            data = d;
        }

        public T getData(){
            return data;
        }

        public void setData(T d){
            data = d;
        }

        public Node getLeft(){
            return left;
        }

        public void setLeft(Node l){
            left = l;
        }

        public Node getRight(){
            return right;
        }

        public void setRight(Node r){
            right = r;
        }

        public int height(){
            return heightHelper(this, 1);
        }

        private int heightHelper(Node n, int h){
            if (n.getLeft() == null && n.getRight() == null) {
                return 1;
            }else if (n.getRight() == null) {
                return heightHelper(n.left, h + 1);
            }else if (n.getLeft() == null) {
                return heightHelper(n.right, h + 1);
            }
            int l = heightHelper(n.left, h + 1);
            int r = heightHelper(n.right, h + 1);
            if (l > r) {
                return l;
            }
            return r;
        }

        public void add(T value){

        }

        public String toString(){
            return "";
        }

        public boolean contains(T value){
            return containsHelper(root, value);
        }

        private boolean containsHelper(Node n, T value){
            return false;
        }
    }


    private Node root;

    public BSTree(){
        root = new Node(null);
    }

        //OUTER methods here are wrapper methods for the root
    public int getHeight(){
        //call the root's methods
        //check for empty first!
        return root.height();
    }

    public void add(T value){
 //check for empty before you do things with root.
        if (root.getData() == null) {
            root.setData(value);
        }


    }
    public String toString(){
 //check for empty before you do things with root.

       return "";
   }


   public boolean contains(T value){
 //check for empty before you do things with root.
       return false;
   }
}
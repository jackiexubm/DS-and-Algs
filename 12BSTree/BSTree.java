public class BSTree<T extends Comparable<T>>{
    private class Node{
       T data;
       Node left;
       Node right;
        
        public T getData(){
            return data;
        }

        public void setData(T d){
            data = d;
        }

        public Node getleft(){
            return left;
        }

        public void setleft(Node l){
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
        if (n.left == null && right == null) {
               return 1;
           }else if (right == null) {
               
           }else if (left == null) {
               
           }
           return 0;
       }

       public void add(T value){
       }
       public String toString(){
           return "";
       }
       public boolean contains(T value){
           return false;
       }

   }

   private Node root;

        //OUTER methods here are wrapper methods for the root
   public int getHeight(){
        //call the root's methods
        //check for empty first!
       return root.height();
   }

   public void add(T value){
 //check for empty before you do things with root.
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
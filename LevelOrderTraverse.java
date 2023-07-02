package il.co.ilrd.InterviewQuestions;

public class LevelOrderTraverse {

    public static void printLevelOrderHelper(Node root){

        int height = getHeight(root);
        System.out.println("height: "+ height);

        for (int i = 0; i <= height; ++i) {
            printCurrentLevelRec(root, i);
        }
    }

    public static void printCurrentLevelRec(Node root, int level){
        if(root==null){
            return;
        }
        if(level == 1){
            System.out.print(root.data + " ");
        }
        else if(level>1){
            printCurrentLevelRec(root.left, level-1);
            printCurrentLevelRec(root.right, level-1);
        }
    }

    public static int getHeight(Node root){
        if(root == null){
            return 0;
        }
        else{
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return max(leftHeight,rightHeight) +1;
        }
    }

    public static int max(int a, int b){
        return (a >= b) ? a : b;
    }

    public static void main(String[] args){


        Node node3  = new Node(null, null, 1);
        Node node4  = new Node(null, null, 3);
        Node node1  = new Node(null, null, 5);
        Node node2  = new Node(node3, node4, 2);
        Node root = new Node(node2,node1, 4);
        printLevelOrderHelper(root);
    }

}

class Node{

    public Node(Node left, Node right, int data){
        this.data = data;
        this.right = right;
        this.left = left;
    }
     Node right;
     Node left;
     int data;
}


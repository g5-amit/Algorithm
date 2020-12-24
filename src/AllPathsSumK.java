import java.util.ArrayList;

// Print all paths in downward direction

public class AllPathsSumK {

    ArrayList<Integer> path = new ArrayList<>();


    public void printAllPaths(Node node, int k){

        if(node == null){
            return;
        }

        path.add(node.data);
        printAllPaths(node.left, k);
        printAllPaths(node.right, k);

        int sum =0;
        for(int i= path.size()-1; i>=0; i--){
            sum+= path.get(i);
            if(sum == k){
                printAnsPath(path, i);
            }
        }
        //Important : We need to find the path downwards only
        path.remove(path.size()-1); // It should be outside of for loop since we have to remove node in case we don't found any sum =k
    }

    private void printAnsPath(ArrayList<Integer> path, int index){
        System.out.println("");
        for(int i = index ; i<path.size(); i++){
            System.out.print(" "+ path.get(i));
        }
    }



    static class Node
    {
        int data;
        Node left,right;
        Node(int x)
        {
            data = x;
            left = right = null;
        }
    }

    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);

        int k = 16;
        printKPath(root, k);
    }

    public static void printKPath(Node root, int k){
        AllPathsSumK obj = new AllPathsSumK();
        obj.printAllPaths(root, k);

//        String s = new String();
//        s.toCharArray()


    }

}

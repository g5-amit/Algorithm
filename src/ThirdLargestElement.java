import java.util.HashSet;
import java.util.PriorityQueue;

public class ThirdLargestElement {


    public static void main(String [] args){

        int[] input = {2,3,4,5,8,0,1,2,4};

        int answer = printThirdLargestElement(input);

        System.out.println(answer);

    }

    public static int printThirdLargestElement(int[] in){

        if(in == null || in.length == 0){
            return -1;
        }

        int k = in.length<3 ? in.length : 3;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        HashSet<Integer> hashSet = new HashSet<>();

        int i=0;  //1,1,2
        while(hashSet.size()<4 ){

            if(i == in.length){
                break;
            }

            if(hashSet.contains(in[i])){
                i++;
                continue;
            }

            pq.add(in[i]);
            hashSet.add(in[i]);
            i++;
        }

        for(int j=i; j< in.length; j++){ // 3,2,1,4,5,0
            if(hashSet.contains(in[j]) || in[j] < pq.peek()){
                continue;
            }
            if(pq.size()>2)
                pq.poll();

            pq.add(in[j]);
            hashSet.add(in[j]);
        }

//        int res =-1;
//        while(!pq.isEmpty()){ //3,4,5
//            res = pq.peek();
//            pq.poll();
//        }

        return pq.peek();
    }

    public Node removeNode(Node node, int n){ //1,2


        if(node == null || n==0)
            return  node;

        Node p1 = node;//1
        Node p2 = node;//1

        int counter = 1; //1,2
        for(int i =0; i<n; i++){
            if(p1.next == null || p2.next == null){
                if(counter == n && p2.next==null){
                    return p1.next;
                }
                return node;
            }else{
                counter++;  //2
                p2 = p2.next; //2
            }
        }

        //p1=1, p2=3
        while(p2.next!= null){
            p1 = p1.next;//2,3
            p2 = p2.next;//4,5
        }

        if(p1.next != null)
            p1.next = p1.next.next;

        return node;

    }

}

//
//1>2
//
//1-> 2> 3>4>5
//
//P1=1, 2,3
//P2 = 3,4,5,null
//
//
//
//P1.next = P1.next.next;

    class Node{
        public int data;
        public Node next;

    }































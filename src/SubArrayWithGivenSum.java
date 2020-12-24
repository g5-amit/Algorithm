import java.util.ArrayList;
import java.util.HashMap;

public class SubArrayWithGivenSum {


    public static ArrayList<ArrayList<Integer>> printAllSubArray(int[] a, int k){

        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int curr = 0;
        int start =0;
        int end =0;
        for(int i=0; i< a.length; i++){
            curr+= a[i];

            if(curr == k){
                end = i;
                ArrayList<Integer> list = addToAns(a,start,end);
                output.add(list);
            }

            if(map.containsKey(curr-k)){
                start = map.get(curr-k)+1;
                end = i;
                ArrayList<Integer> list = addToAns(a,start,end);
                output.add(list);
            }else{
                map.put(curr,i);
            }

        }
        return output;
    }

    static  ArrayList<Integer> addToAns(int[] a, int start, int end){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=start; i<=end; i++){
            list.add(a[i]);
        }
        return list;

    }



    public static void main(String[] args){
//        int a[] = {10, 2, -2, -20,10};
        int a[] = {1,3,2,1,1,-1,4,1,2,5,6};
        ArrayList<ArrayList<Integer>> answer = printAllSubArray(a, 5);

        answer.forEach((listItem)-> {
            System.out.println();
            listItem.forEach((item)-> System.out.print(item + " "));
        });
    }

}

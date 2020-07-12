import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// FInd the largest element in array in which first element must be 1,
// you can reduce any element by atleast 1
// and consequative number should have diff of at max 1
//ex:
//3, 1,3,4
//reduce 3->2
//2,1,3,4
//rearrange, 1,2,3,4 and answer is largest element means 4.

public class LargestElementWithConstraints {

    public static void main(String args[]){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(3);
        list.add(4);

        System.out.println(getHeight(list));

    }

    public static int getHeight(List<Integer> arr) {

        Collections.sort(arr);

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) - arr.get(i - 1) > 1) {
                arr.set(i, arr.get(i - 1) + 1);
            }

        }
        return arr.get(arr.size() - 1);

    }
}

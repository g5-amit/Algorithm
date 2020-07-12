import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// List of commands are given , we have to show the autocomplete suggestion element, only one at a time which should be best match
//        list.add("000");
//        list.add("1110");
//        list.add("01");
//        list.add("001");
//        list.add("110");
//        list.add("11");
// for 000-> 0 th element since there is no last command for autosuggestion
// for 1110-> no match , so show last command index which is 1//assuming list starts from index 1
// for 01-> best match is 000 for autosuggestion while entering 0, so show index 1
// for 001-> best match is 000 for autosuggestion while entering 00, so show index 1
//and so on output is [0,1,1,1,2,5]

public class CommandAutoComplete {

    public static void main(String args[]){
        List<String> list = new ArrayList<>();
        list.add("000");
        list.add("1110");
        list.add("01");
        list.add("001");
        list.add("110");
        list.add("11");

        List<Integer> output = autocomplete(list);
        System.out.println(output);

    }

    public static List<Integer> autocomplete(List<String> command) {
        List<Integer> output = new ArrayList<>();
        if(command.size()>0){
            output.add(0);
        }

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=1; i<command.size(); i++){
            String binary = command.get(i-1);
            sanitizeMap(map, binary, i);

            String current = command.get(i);

            int j;
            for(j= current.length(); j>0; j--){
                if(map.containsKey(current.substring(0,j))){
                    output.add(i,map.get(current.substring(0,j)));
                    break;
                }
            }
            if(j==0){
                output.add(i,i);
            }

        }

        return output;
    }

    public static void sanitizeMap(HashMap<String, Integer> map, String binary, int index){
        for(int i=0; i<binary.length(); i++){
            map.put(binary.substring(0,i+1), index);
        }
    }

}

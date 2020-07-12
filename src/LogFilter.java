import java.util.Arrays;
import java.util.Comparator;


/* Asked in Amazon Canada
You have an array of logs.  Each log is a space delimited string of words.
        For each log, the first word in each log is an alphanumeric identifier.  Then, either:
        Each word after the identifier will consist only of lowercase letters, or;
        Each word after the identifier will consist only of digits.
        We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
        Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
        Return the final order of the logs.
        Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
        Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]*/


public class LogFilter {

    public static void main(String args[]){
        String[] inputLogs = {"dig1 8 1 5 1","l2et art can","dig2 3 6","let2 own kit dig","let3 art zero","g1 act","l1et art can"};
        printArray(inputLogs);
        String[] outputLogs = filterLogs(inputLogs);
        System.out.println("\n"+ "output is:"+ "\n");
        printArray(outputLogs);

    }

    public static String[] filterLogs(String[] arr){
        if(arr == null || arr.length ==0){
            return null;
        }
        Arrays.sort(arr, new sortLogs());
        return arr;
    }

    public static void printArray(String[] logs) {
        for(int i=0; i<logs.length; i++) {
            System.out.println(logs[i]);
        }
    }


}

class sortLogs implements Comparator<String> {

    public int compare(String log1, String log2){
        String[] split1 = log1.split(" ",2);
        String[] split2 = log2.split(" ", 2);
        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
        if(!isDigit1 && !isDigit2){
            int compare = split1[1].compareTo(split2[1]);
            if( compare==0){
                return  split1[0].compareTo(split2[0]);
            }else{
                return compare;
            }
        }
        else if(isDigit1 && isDigit2){
            return 0;
        }else{
            return isDigit1?1:-1;
        }
    }

}



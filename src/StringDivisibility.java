

/*
As an assignment, a student is given two strings s and t. Create a function that performs per the following rules.

        Find whether string s is divisible by string t. A string s divisible by string t if string t can be concatenated some number of times to obtain the string s.
        If s is divisible, find the smallest string u such that it can be concatenated some number of times to obtain both s and t.
        If it is not divisible, set the return value to -1.
        Finally, return the length of the string u or -1.

        Example 1:

        s = "bcdbcdbcdbcd"

        t = "bcdbcd"

        If string t is concatenated twice, the result is "bcdbcdbcdbcd" which is equal to the string s. The string s is divisible by string t.

        Since it passes the first test, look for the smallest string u that can be concatenated to create both strings s and t.

        The string "bcd" is the smallest string that can be concatenated to create both strings s and t.

        The length of the string u is 3, the integer value to return.

        Example 2:

        s = "bcdbcdbcd"

        t = "bcdbcd"

        If string t is concatenated twice, the result is "bcdbcdbcdbcd" which is greater than string s. There is an extra "bcd" in the concatenated string.

        The string s is not divisible by string t, so return -1.

        Function Description

        Complete the function findSmallestDivisor in the editor below. The function should return a single integer denoting the length of the smallest string u if string s is divisible by string t, or return -1 if not.

        findSmallestDivisor has the following parameter(s):

        s : string s

        t : string t

        Constraints

        1 ≤ size of s ≤ 2 x 105
        1 ≤ size of t ≤ 2 x105
        size of t ≤ size of s
*/


public class StringDivisibility {

    public static void main(String args[]){


        int output = findSmallestDivisor("bcdbcdbcdbcd", "bcdbcd");
        System.out.println(output);

    }

    public static int findSmallestDivisor(String s, String t) {
        if(s==null || t==null || s.isEmpty() || t.isEmpty()){
            return -1;
        }

        if(s.length() % t.length() != 0){
            return -1;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(t);

        while(sb.length()<s.length()){
            sb.append(t);
        }

        if(!sb.toString().equals(s)){
            return -1;
        }

        return findRepeat(t);


    }

    public static int findRepeat(String t){
        int len =0;
        int strLen = t.length();
        int lps[] = new int[strLen];

        lps[0]=0;

        int i=1;

        while(i<strLen){
            if(t.charAt(i)== t.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len = lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        }

        int res = lps[strLen-1];
        if(res > 0 && (strLen % (strLen-res)==0)){
            return strLen-res;
        }else{
            return strLen;
        }
    }

}




public class LongestOneSubString {

    public static void main(String[] args){
        String input = "01111110100101111";

        int maxSubStringLen = 0;

        int prevZeroCount =0, nextZeroCount =0;
        int len = input.length();
        for(int i=0; i<len; i++){
            if(input.charAt(i) =='1') {
                prevZeroCount++;
            }else{
                i = i+1;

                while(i<len){
                    if(input.charAt(i) =='1') {
                        nextZeroCount++;
                        i++;
                    }else{
                        i--;
                        break;
                    }
                }
                maxSubStringLen = Math.max(maxSubStringLen, prevZeroCount+nextZeroCount);

                prevZeroCount = nextZeroCount;
                nextZeroCount = 0;
            }

        }


//        int prev_max =0, curr_max =0;
//
//
//
//        curr_max = input.charAt(0) == '1' ? 1 : 0;
//
//        for(int i=1; i<len; i++){
//            if(input.charAt(i) =='1'){
//                curr_max++;
//            }else{
//                prev_max = curr_max;
//                curr_max =0;
//                i++;
//                while(i<len){
//                    if(input.charAt(i)=='1'){
//                        curr_max++;
//                        i++;
//                    }else{
//                        i--;
//                        break;
//                    }
//
//                }
//                maxSubStringLen = Math.max(prev_max+curr_max, maxSubStringLen);
//                prev_max = curr_max;
//                curr_max = 0;
//            }
//
//        }

        System.out.println(maxSubStringLen);
    }

}

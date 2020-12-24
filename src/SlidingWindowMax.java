public class SlidingWindowMax {

    public static void main(String[] args){
        int[] input = {1,3,1,2,0,5};
        int[] res = maxSlidingWindow(input, 3);

        for(int x : res){
            System.out.println(x);
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums==null || nums.length ==0){
            return null;
        }
        int resLength = (nums.length < k) ? 1 : nums.length-k+1;
        int[] res = new int[resLength];
        int resIndex = 0;
        int windowLen = k < nums.length ? k : nums.length;

        int windowStartIndex =0;
        res[resIndex] = nums[0] ;

        for(int i=1; i< windowLen; i++){
            if(nums[i]>res[resIndex]){
                res[resIndex] = nums[i];
                windowStartIndex++;
            }
        }

        for(int i=windowLen ; i<nums.length; i++){
            resIndex++;
            if(i-windowStartIndex>=k){
                windowStartIndex++;
            }
            if(nums[i] >= nums[windowStartIndex]){
                res[resIndex] = nums[i];
                for(int j=windowStartIndex;j< i; j++ ){
                    if(nums[j] < nums[i]){
                        windowStartIndex++;
                    }
                }
            }else{
                res[resIndex] = res[resIndex-1];
            }
        }
        return res;
    }
}

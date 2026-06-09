public class maiorNumArray {

    public static int maiorNumArray(int[] nums, int first, int last) {

        int position_max;

        int size = last - first + 1;

        if (size > 5){
            int mid =  first + (last - first) / 2;

            int pos_1 = maiorNumArray(nums, first, mid);
            int pos_2 = maiorNumArray(nums, mid+1, last);

            if (nums[pos_1] > nums[pos_2]){
                position_max = pos_1;
            }
            else {
                position_max = pos_2;
            }
        }
        else{
            position_max = first;

            for(int i = first + 1; i <= last; i++){
                if(nums[i] > nums[position_max]){
                    position_max = i;
                }
            }
        }

        return position_max;
    }
}

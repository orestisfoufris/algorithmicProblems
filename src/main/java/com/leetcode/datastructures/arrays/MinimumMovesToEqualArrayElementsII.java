public class MinimumMovesToEqualArrayElementsII  {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        return find(nums, nums.length);
    }
    
    private int find(int[] nums, int len) {
        int count = 0;
        int mid = nums[len / 2];
        
        for (int i = 0; i < len; ++i) {
            count += Math.abs(nums[i] - mid);
        }
        
        return count;
    }
}

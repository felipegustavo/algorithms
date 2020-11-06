// problem: https://leetcode.com/problems/rotate-array/

public class RotateArray{

	public void rotate(int[] nums, int k) {
		k %= nums.length;
		if (k == 0 || nums.length == 1) {
			return;
		}
	
		int temp;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
		
		left = 0;
		right = k - 1;
		while (left < right) {
			temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
		
		left = k;
		right = nums.length - 1;
		while (left < right) {
			temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
    }

} 

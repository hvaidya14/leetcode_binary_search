
//Query :- Editorial solution is approach is different. I took atleast one side sorted in rotated array approach

// Problem statement

https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/


//Failed test case . 275 / 282 testcases passed
[1,0,1,1,1]


// Code 
class Solution {
    public boolean search(int[] nums, int target) {

        int low =0;
        int high=nums.length-1;
        int mid=0;

        if (nums.length ==0 ){
            return false;
        } else if (nums.length == 1) {
            if (nums[0] == target) {
                return true;
            }
        }
        if (nums[low] == target || target == nums[high]) {
            return true;
        }

        while (low <= high) {
            mid = low+(high-low)/2;
            if (nums[mid] == target) {
                return true;
            } else {
                if (nums[low] <= nums[mid]){
                    if (nums[low] <= target && target < nums[mid]) {
                        high = mid-1;
                    } else {
                        low = mid+1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[high]) {
                        low = mid+1;
                    } else {
                        high = mid-1;
                    }
                }
            }
        }

        return false;
        
    }
}




// Problem
https://leetcode.com/problems/single-element-in-a-sorted-array/description/

// Failed 15 / 16 testcases passed  Failed test case input is of 19999 length


// Approach here is to find single element in first half of array than mid and if not found search in right half of array more than mid
class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int low =0;
        int high =nums.length-1;
        int mid= (low + high)/2;
        int single=0;
        System.out.println(nums.length);
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[mid] != nums[mid-1] && nums[mid]!= nums[mid+1] ) {
            return nums[mid];
        }
        if (nums[mid] == nums[mid-1]) {
            single=binarySearch(nums, low, mid-2);
            if (single == -1) {
                single=binarySearch(nums, mid+1, high);
            }
        } else {
            if (nums[mid] == nums[mid+1]) {
                single=binarySearch(nums, low, mid-1);
                if (single == -1) {
                    single=binarySearch(nums, mid+2, high);
                }
            }
        }
        return single;
    }
    public int binarySearch(int[] nums, int low, int high) {

        int mid=0;
        int single=-1;
        if (low <= high) {
            mid= (low + high)/2;
            if (low == high) {
                System.out.println(nums[mid]);
                return nums[low];
            }
            if (mid != 0 && nums[mid] == nums[mid-1]) {
                single=binarySearch(nums, low, mid-2);
                if (single == -1) {
                    single=binarySearch(nums, mid+1, high);
                }
                return single;
            } else {
                if (mid != nums.length-1 && nums[mid] == nums[mid+1]) {
                    single=binarySearch(nums, low, mid-1);
                    if (single == -1) {
                        single=binarySearch(nums, mid+2, high);
                    }
                    return single;
                }
            }
        }
        return -1;


    }

}


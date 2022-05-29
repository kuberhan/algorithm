package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 39. 数组中出现次数超过一半的数字*/
/*169. 多数元素*/
/*摩尔投票法，我的理解是计数相消法*/
public class exam39 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (num == candidate || count == 0){
                if (count == 0){
                    candidate = num;
                }
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }

    public int majorityElement2(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate ? 1 : -1);
        }
        return candidate;
    }


    @Test
    public void test(){
        int[] n = {4,3,3,3,1,2,3};
        System.out.println(majorityElement2(n));
    }
}

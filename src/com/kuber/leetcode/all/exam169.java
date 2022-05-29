package com.kuber.leetcode.all;

import org.junit.Test;

import java.util.Arrays;

/*169. 多数元素*/
public class exam169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int counter = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            ++counter;
            if (nums[i] != nums[i + 1]) {
                if (counter > nums.length / 2) {
                    return nums[i];
                }
                counter = 0;
            }
        }
        return nums[nums.length - 1];
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*投票法*/
    /*Boyer-Moore 算法的本质和方法四中的分治十分类似。我们首先给出 Boyer-Moore 算法的详细步骤：

我们维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；

我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，
随后我们判断 x：

如果 x 与 candidate 相等，那么计数器 count 的值增加 1；

如果 x 与 candidate 不等，那么计数器 count 的值减少 1。

在遍历完成后，candidate 即为整个数组的众数
*/
    public int majorityElement3(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if(count == 0 ) candidate = num;
            count += (candidate == num ? 1 : -1);
        }
        return candidate;
    }

    @Test
    public void test() {
        int[] nums = {3,2,3};
        System.out.println(majorityElement3(nums));
    }
}

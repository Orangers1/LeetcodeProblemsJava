package com.orangers.leetcodeproblems.Arrays;

/**
 * problem from neetcode: <a href="https://neetcode.io/problems/products-of-array-discluding-self">can be viewed here</a>
 */
public class ProductsOfArrayExceptSelf {
    /**
     * returns an array where the elements are the product of the entire array except nums[i] (i.e. input = [1,2,4,6], output = [48,24,12,8]),
     * problem from neetcode: <a href="https://neetcode.io/problems/products-of-array-discluding-self">can be viewed here</a>
     * @param nums - the input array to use for the product
     * @return an array containing the product of every other element
     *
     * @implNote - uses idea of prefix / suffix products to calculate in o(n) time.
     */
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int[] prefixProducts = new int[nums.length];
        int[] suffixProducts = new int[nums.length];
        int product = 1;
        // create prefix product array (i.e. products starting at first and going up including all previous
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            prefixProducts[i] = product;
        }
        product = 1;
        // create suffix product array (i.e. products starting at last and going down including all previous
        for (int i = nums.length - 1; i > 0; i--) {
            product *= nums[i];
            suffixProducts[i] = product;
        }
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && i + 1 < nums.length) { // standard case - multiply prefix and suffix
                arr[i] = prefixProducts[i - 1] * suffixProducts[i + 1];
            } else if (i == 0) { // beginning of loop (just use suffix)
                arr[i] = suffixProducts[i+1];
            } else { // end of loop (just use prefix)
                arr[i] = prefixProducts[i-1];
            }
        }
        return arr;
    }
}

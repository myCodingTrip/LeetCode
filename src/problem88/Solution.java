package problem88;

/**
 * 归并排序
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] src = new int[m + n];
        int k = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                src[k++] = nums1[i++];
            } else {
                src[k++] = nums2[j++];
            }
        }
        while (i < m) {
            src[k++] = nums1[i++];
        }
        while (j < n) {
            src[k++] = nums2[j++];
        }
        System.arraycopy(src, 0, nums1, 0, m + n);
    }
}
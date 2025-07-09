/*
Approach:
To find the median of two sorted arrays in O(log(min(m, n))) time, we use binary search on the smaller array.
We partition both arrays such that the total number of elements in the left halves is equal to (m + n + 1) / 2.
Then we ensure that all elements in the left half are less than or equal to all elements in the right half.
Once the correct partition is found:
- If the combined length is odd → median is the max of the left parts
- If even → median is the average of max(left) and min(right)

Time Complexity: O(log(min(m, n)))
Space Complexity: O(1)
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1.length > nums2.length ? nums2 : nums1;
        int[] B = nums1.length > nums2.length ? nums1 : nums2;

        int low = 0, high = A.length;
        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = (A.length + B.length + 1) / 2 - i;

            int Aleft = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == A.length) ? Integer.MAX_VALUE : A[i];
            int Bleft = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == B.length) ? Integer.MAX_VALUE : B[j];

            if (Aleft <= Bright && Aright >= Bleft) {
                if ((A.length + B.length) % 2 == 0) {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                } else {
                    return Math.max(Aleft, Bleft);
                }
            } else if (Aleft > Bright) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        return 0.0; // This line is unreachable if inputs are valid
    }
}

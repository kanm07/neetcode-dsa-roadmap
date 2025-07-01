/*
Approach:
1. Convert the input string to lowercase to make it case-insensitive.
2. Remove all non-alphanumeric characters using regex.
3. Use a two-pointer approach to check if the cleaned string is a palindrome.

Time Complexity: O(n), where n is the length of the input string.
Space Complexity: O(n), due to the cleaned character array.
*/

class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().replaceAll("[^a-z0-9]+", "").toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

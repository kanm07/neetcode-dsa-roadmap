class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] freq = new int[26];
        int[] window = new int[26];

        for(char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        for(int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;
            if(i >= s1.length()) {
                window[s2.charAt(i - s1.length()) - 'a']--;
            }
            if(Arrays.equals(freq, window)) {
                return true;
            }
        }

        return false;
    }
}
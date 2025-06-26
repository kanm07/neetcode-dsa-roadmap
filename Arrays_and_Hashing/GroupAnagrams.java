/*
Approach:
- For each string, sort its characters to form a key.
- Anagrams will result in the same sorted key.
- Use a HashMap where the key is the sorted string and the value is a list of original strings.
- Group all strings under their sorted form.
- Finally, return all grouped lists as the result.

Time Complexity: O(n * k log k), where n = number of strings, k = max string length (due to sorting)
Space Complexity: O(n * k), for storing grouped anagrams in the map
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!mp.containsKey(key)) {
                mp.put(key, new ArrayList<>());
            }
            mp.get(key).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}

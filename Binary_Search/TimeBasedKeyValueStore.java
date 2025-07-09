/*
Approach:
We design a time-based key-value store using a HashMap. The key idea is to map each key to a list of (timestamp, value) pairs,
and perform binary search during retrieval to achieve O(log n) time for queries.

1. Object Creation:
   - We initialize a HashMap<String, List<Entry>> called `map`.
   - Each key maps to a list of `Entry` objects, where each `Entry` stores a `timestamp` and a `value`.
   - Since timestamps are strictly increasing for a given key, the list remains sorted by timestamp.

2. set(String key, String value, int timestamp):
   - If the key is not already in the map, we create a new list for it.
   - We then append a new Entry(timestamp, value) to the list.
   - This ensures the list for each key stays sorted by timestamp.

3. get(String key, int timestamp):
   - First, we check if the key exists in the map. If it doesn't, return an empty string.
   - If it does, we perform a binary search on the list of Entry objects for that key.
   - The goal is to find the Entry with the **largest timestamp less than or equal to the given timestamp**.
   - During the binary search:
     - If Entry[mid].time <= timestamp, we update our result to Entry[mid].value and search to the right (low = mid + 1).
     - Else, we search to the left (high = mid - 1).
   - After the loop, we return the stored result (or empty string if no timestamp ≤ given timestamp was found).

Time Complexity:
- set: O(1) — appending to a list
- get: O(log n) — binary search on a sorted list of timestamps

Space Complexity:
- O(n), where n is the total number of set operations (unique timestamps stored)
*/

import java.util.*;

class TimeMap {
    Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Entry> list = map.get(key);
        int low = 0, high = list.size() - 1;
        String result = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid).time <= timestamp) {
                result = list.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}

class Entry {
    String value;
    int time;

    Entry(int time, String value) {
        this.time = time;
        this.value = value;
    }
}

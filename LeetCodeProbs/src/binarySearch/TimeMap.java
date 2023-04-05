package binarySearch;

import java.util.*;

public class TimeMap {

    private Map<String, List<String[]>> kvStore;

    public TimeMap() {
        kvStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        List<String[]> tempList = kvStore.getOrDefault(key, new ArrayList<>());
        tempList.add(new String[]{value, String.valueOf(timestamp)});
        kvStore.put(key, tempList);
    }

    public String get(String key, int timestamp) {
        String res = "";
        if (kvStore.isEmpty() || !kvStore.containsKey(key)) {
            return res;
        }

        List<String[]> values = kvStore.get(key);
        int l = 0;
        int r = values.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int ts = Integer.parseInt(values.get(mid)[1]);

            if (ts <= timestamp) {
                res = values.get(mid)[0];
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {

        List<String> ps = new ArrayList<>();
        ps.add(5, "five");
    }
}

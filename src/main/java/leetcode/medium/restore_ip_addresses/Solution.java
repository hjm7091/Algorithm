package leetcode.medium.restore_ip_addresses;

import java.util.*;

class Solution {

    List<String> validAddresses = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        search(0, s, new ArrayList<>());
        return validAddresses;
    }

    private void search(int idx, String s, List<String> parts) {
        if (parts.size() == 4) {
            if (idx < s.length()) return;
            if (parts.stream().anyMatch(part -> part.length() > 1 && part.startsWith("0"))) return;
            if (parts.stream().anyMatch(part -> Integer.parseInt(part) > 255)) return;
            validAddresses.add(String.join(".", parts));
        }

        for (int range = 1; range < 4 && idx + range <= s.length(); range++) {
            String part = s.substring(idx, idx + range);
            parts.add(part);
            search(idx + range, s, parts);
            parts.remove(parts.size() - 1);
        }
    }
}

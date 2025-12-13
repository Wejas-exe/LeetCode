import java.util.*;

class Solution {
    public List<String> validateCoupons(
        String[] code,
        String[] businessLine,
        boolean[] isActive
    ) {

        List<String> allowedLines = Arrays.asList(
            "electronics", "grocery", "pharmacy", "restaurant"
        );

        Map<String, List<String>> buckets = new HashMap<>();
        for (String line : allowedLines) {
            buckets.put(line, new ArrayList<>());
        }

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;
            if (!buckets.containsKey(businessLine[i])) continue;
            if (!isValidCode(code[i])) continue;

            buckets.get(businessLine[i]).add(code[i]);
        }

        List<String> result = new ArrayList<>();
        for (String line : allowedLines) {
            List<String> list = buckets.get(line);
            Collections.sort(list);
            result.addAll(list);
        }

        return result;
    }

    private boolean isValidCode(String c) {
        if (c == null || c.isEmpty()) return false;
        for (char ch : c.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }
}
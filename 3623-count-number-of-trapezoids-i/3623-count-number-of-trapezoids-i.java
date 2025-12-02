class Solution {
    public int countTrapezoids(int[][] points) {
        int mod = 1_000_000_007;

    Map<Integer, Integer> yCount = new HashMap<>();
    for (int[] point : points) {
        yCount.put(point[1], yCount.getOrDefault(point[1], 0) + 1);
    }

    List<Long> combList = new ArrayList<>();
    for (int count : yCount.values()) {
        if (count >= 2) {
            combList.add(comb2(count));
        }
    }

    int n = combList.size();
    long total = 0;
    long suffixSum = 0;

    for (int i = n - 1; i >= 0; i--) {
        long c = combList.get(i);
        total = (total + c * suffixSum) % mod;
        suffixSum = (suffixSum + c) % mod;
    }

    return (int) total;
}

private long comb2(int n) {
    return ((long) n * (n - 1)) / 2;
}
}
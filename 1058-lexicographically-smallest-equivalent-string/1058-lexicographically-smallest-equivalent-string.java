class Solution {
    int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize DSU
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union characters from s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            int a = s1.charAt(i) - 'a';
            int b = s2.charAt(i) - 'a';
            union(a, b);
        }

        // Build the result using smallest representative
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int smallest = find(c - 'a');
            sb.append((char)(smallest + 'a'));
        }

        return sb.toString();
    }

    // DSU find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // DSU union: attach larger to smaller lex character
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }
}

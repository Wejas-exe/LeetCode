class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        double[][] arr = new double[n][2];
        int i = 0;
        for (int[] d : dimensions) {
            int l = d[0];
            int w = d[1];
            arr[i][0] = Math.sqrt((l * l) + (w * w));
            arr[i++][1] = (double) l * w;
        }
        Arrays.sort(arr, (a, b) -> {
            if (Double.compare(a[0], b[0]) == 0) {
                return Double.compare(b[1], a[1]);
            }
            return Double.compare(b[0], a[0]);
        });

        return (int) arr[0][1];
    }
}

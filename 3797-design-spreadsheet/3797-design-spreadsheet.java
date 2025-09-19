class Spreadsheet {
    int[][] arr;

    public Spreadsheet(int rows) {
        arr = new int[rows + 1][26];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        arr[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        arr[row][col] = 0;
    }

    public int getValue(String formula) {
        if (!formula.startsWith("=")) {
            return Integer.parseInt(formula);
        }

        formula = formula.substring(1);
        String[] parts = formula.split("\\+");
        int sum = 0;

        for (String part : parts) {
            sum += isNumeric(part) ? Integer.parseInt(part) : getCellValue(part);
        }

        return sum;
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private int getCellValue(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1));
        return arr[row][col];
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
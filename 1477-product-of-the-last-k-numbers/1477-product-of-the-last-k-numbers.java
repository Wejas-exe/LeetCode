class ProductOfNumbers {
    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            list = new ArrayList<>();
            list.add(1);
        } else {
            int lastProd = list.get(list.size() - 1);
            list.add(lastProd * num);
        }
    }
    
    public int getProduct(int k) {
        int size = list.size();
        if (k >= size) return 0; // If zero was added, return 0 since product is reset

        return list.get(size - 1) / list.get(size - 1 - k);
    }
}

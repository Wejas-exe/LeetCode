class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i =0;i<n;i++){
            if(digits[i]==0) continue;
            for(int j =0;j<n;j++){
                if(j==i) continue;
                for(int k =0;k<n;k++){
                    if(k==j || k == i) continue;
                    if(digits[k]%2 == 0 ){
                        int num = digits[i]*100 + digits[j]*10 + digits[k];
                        set.add(num);
                    }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] arr = new int[list.size()];
        for(int i =0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr ;
    }
}
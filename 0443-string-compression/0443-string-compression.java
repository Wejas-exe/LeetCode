class Solution {
    public int compress(char[] chars) {
        int index =0;
        int i =0;
        while(i<chars.length){
            int count =0;
            char curr = chars[i];
            while(i<chars.length && curr==chars[i]){
                count++;
                i++;
            }
            chars[index++] = curr;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}
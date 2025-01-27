class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        boolean[][] isPre = new boolean[numCourses][numCourses];

        for(int[] pre : prerequisites){
            isPre[pre[0]][pre[1]] = true;
        }

        //floyd warshall algo to find indirect prerequisites
        for (int k = 0; k < numCourses; k++) {  // Intermediate node
            for (int i = 0; i < numCourses; i++) {  // Start node
                for (int j = 0; j < numCourses; j++) {  // End node
                    if (isPre[i][k] && isPre[k][j]) {
                        isPre[i][j] = true;  // Correct transitive relationship
                    }
                }
            }
        }

        ArrayList<Boolean> list = new ArrayList<>();
        for(int i =0;i<queries.length;i++){
            if(isPre[queries[i][0]][queries[i][1]]){
                list.add(true);
                continue;
            }
            list.add(false);
        }
        return list;

    }
}
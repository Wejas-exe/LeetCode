class TaskManager {
    static class Task {
        int id, priority, userid;
        public Task(int u, int i, int p) {
            this.id=i;
            this.priority = p;
            this.userid = u;
        }
        public int getTaskId() { return this.id; }
        public int getPriority() { return this.priority; }
    }
    Map<Integer, TreeSet<Task>> userToTp;
    Map<Integer, Task> taskToUp;
    TreeSet<Task> allT;
    public TaskManager(List<List<Integer>> tasks) {
        int N = tasks.size();
        
        userToTp = new HashMap<>();
        taskToUp = new HashMap<>();
        allT = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(Task a, Task b) {
                if (a.priority != b.priority) {
                    return Integer.compare(b.priority, a.priority);
                } else {
                    return Integer.compare(b.id, a.id);
                }
            }
        });
        for(int i=0; i < N; i++) {
            List<Integer> curr = tasks.get(i);
            Task tt = new Task(curr.get(0), curr.get(1), curr.get(2));
            userToTp.computeIfAbsent(curr.get(0), k -> new TreeSet<>(
                    Comparator.comparingInt(Task::getPriority)
                        .thenComparingInt(Task::getTaskId)))
                    .add(tt);
            taskToUp.put(curr.get(1), tt);
            //maxH.offer(tt);
            allT.add(tt);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task tt = new Task(userId, taskId, priority);
        userToTp.computeIfAbsent(userId, k -> new TreeSet<>(
                    Comparator.comparingInt(Task::getPriority)
                        .thenComparingInt(Task::getTaskId)))
                    .add(tt);
        taskToUp.put(taskId, tt);
        allT.add(tt);
    }
    
    public void edit(int taskId, int newPriority) {
        if (!taskToUp.containsKey(taskId)) {
            return;
        }
        //get current task
        Task curr = taskToUp.get(taskId);
        allT.remove(curr);
        int currUser = curr.userid;
        //get all this user's tasks assigned
        TreeSet<Task> currAllTasks = userToTp.get(currUser);
        //remove old task i.e. its old priority position
        currAllTasks.remove(curr);
        //update the priority
        Task updatedTask = new Task(currUser, curr.id, newPriority);
        userToTp.get(currUser).add(updatedTask);
        taskToUp.put(curr.id, updatedTask);
        allT.add(updatedTask);
    }
    
    public void rmv(int taskId) {
        if (!taskToUp.containsKey(taskId)) {
            return;
        }
        //get current task
        Task curr = taskToUp.get(taskId);
        //remove this task from the user's tasks list
         userToTp.get(curr.userid).remove(curr);
        //now finally remove this task
        taskToUp.remove(taskId);
        allT.remove(curr);
    }
    
    public int execTop() {
        if (allT.isEmpty()) {
            return -1;
        }
        Task curr = allT.first();
        int u = curr.userid;
        int t = curr.id;
        rmv(t);
        return u;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
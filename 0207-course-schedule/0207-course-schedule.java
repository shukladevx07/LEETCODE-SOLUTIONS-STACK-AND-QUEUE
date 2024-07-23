class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       ArrayList<ArrayList<Integer>> list=new ArrayList<>();
       for(int i=0;i<numCourses;i++){
        list.add(new ArrayList<>());
       } 
       for(int arr[]:prerequisites){
        list.get(arr[0]).add(arr[1]);
       }

        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:list.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int topo[]=new int[numCourses];
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topo[i++]=node;
            for(int it:list.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(i==numCourses){
            return true;
        }
        else
        return false;
    }
}
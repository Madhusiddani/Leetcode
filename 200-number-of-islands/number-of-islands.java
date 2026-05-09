class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;
        int n=grid.length;
        int m=grid[0].length;
        Set<String> vis=new HashSet<>();
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]=='1' && !vis.contains(r+","+c)){
                    islands++;
                    bfs(grid,r,c,vis,dir,n,m);
                }
            }
        }
        return islands;
    }
    void bfs(char[][] grid, int r, int c, Set<String> vis, int[][] dir, int n, int m){
        Queue<int[]> q=new LinkedList<>();
        vis.add(r+","+c);
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            int[] p=q.poll();
            int ro=p[0],co=p[1];

            for(int[] dirs:dir){
                int nr=ro+dirs[0],nc=co+dirs[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1' && !vis.contains(nr+","+nc)){
                    q.add(new int[]{nr,nc});
                    vis.add(nr+","+nc);
                }
            }
        }
    }
}
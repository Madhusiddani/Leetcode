class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int initialCol=image[sr][sc];
       if(initialCol==color){
        return image;
       } 
       dfs(image,sr,sc,initialCol,color);
       return image;
    }
    void dfs(int[][] image,int r, int c, int initialCol, int color){
        int n=image.length;
        int m=image[0].length;
        image[r][c]=color;
        int delr[]={-1,0,1,0};
        int delc[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=r+delr[i];
            int nc=c+delc[i];

            if(nr>=0 &&
            nr<n &&
            nc>=0 &&
            nc<m &&
            image[nr][nc]==initialCol){
                dfs(image,nr,nc,initialCol,color);
            }
        }
    }
}
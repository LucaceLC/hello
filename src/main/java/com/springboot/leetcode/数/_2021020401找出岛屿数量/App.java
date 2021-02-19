package com.springboot.leetcode.数._2021020401找出岛屿数量;

public class App {
    /**
     * 找出所有独立的岛屿
     *
     * 首先列出数组的边界，行列，nm
     *
     * {
     *  111100
     *  110011
     *  100001
     *  000001
     * }
     * 先双层遍历，如果元素是1，result++；然后深度搜索
     * 扫雷的思路，如果是1，相连的部分全部置为0，深度遍历，上下左右4次
     * 遍历的条件，上下左右，依次判断
     * 遍历的推出条件：i,j<0，i,j大于等于边界，grid[i][i] == 0；
     */
    int row,column;
    public int findLand(char[][] grid){
        row = grid.length;
        column = grid[0].length;
        int result = 0;
        for (int i=0; i< row; i++){
            for (int j = 0; j < column; j++) {
                //char类型比较，必须是单引号
                if('1'==grid[i][j]){
                    result++;
                    //todo 深度遍历
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        //退出条件 i,j小于0 ，i,j大于等于边界值，如果遍历到的节点本身急==0，不需要置换
        if(i<0 || j<0|| i>=row || j>=column || grid[i][j] =='0') return;
        /**
         * 首先自身变为0
         */
        grid[i][j] = '0';
        //上下左右
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}

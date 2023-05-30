package com.coding;

public class Test {

    public static void sort(int[] arrays){
        if(arrays == null || arrays.length==0 ) return;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                //比较替换
                if(arrays[j] > arrays[j+1]) swap(arrays,j,j+1);
            }
        }

    }
    public static void swap(int[] arrays, int left, int right){
        int temp = arrays[left];
        arrays[left] = arrays[right];
        arrays[right] = temp;

    }

    public static void main(String[] args) {
        int[] arrays = new int[]{2,3,4,1,-1,7,-3,7,-6};
        sort(arrays);
        for(Integer a: arrays){
            System.out.println(a);
        }
    }
}

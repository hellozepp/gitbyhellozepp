package org.sort;

/**
 * Created by Hello Zepp on 2016/7/26 0026.
 */
public class select {
    public static void main(String[] args) {
        //选择排序
        int arr[]={12,34,19,3,15,2,10,54};
        System.out.println("需要进行选择排序的数组为：");
        printSort(arr);
//        selectSort(arr);
//        System.out.println("排序后的数组为：");
//        printSort(arr);

        selectSorts(arr);System.out.println("排序后的数组为：");printSort(arr);
    }
    public static void printSort(int[] arr) {
        for(int x=0;x<arr.length;x++)
        {
            if(x!=arr.length-1){
                System.out.print(arr[x] + ",");
            }
            else  System.out.println(arr[x]);
        }
    }
//    public static void selectSort(int[] arr) {
//        for(int x=0;x<arr.length-1;x++){
//            for(int y=x+1;y<arr.length;y++){
//                if(arr[x]>arr[y]){
//                    int temp =arr[x];
//                    arr[x]=arr[y];
//                    arr[y]=temp;
//                }
//            }
//        }
//    }
    public static void selectSorts(int[] arr) {
        for(int x=0;x<arr.length-1;x++){
            for(int y=x+1;y<arr.length;y++){
                if(arr[x]>arr[y]){
                    int temp =arr[x];
                    arr[x]=arr[y];
                    arr[y]=temp;
                }
                if(y==arr.length-1){
                    int z=x+1;
                    System.out.print("第"+z+"趟排序的结果为：");
                    printSort(arr);
                }
            }
        }

        System.out.print("第" + (arr.length) +"趟排序的结果为：");
        printSort(arr);
    }
}

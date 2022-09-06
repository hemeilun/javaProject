package binarySearch;

import utils.RandomArr;

public class binarySearchNoraml {

    public static void main(String[] args) {
        int[] arr = RandomArr.produceRandomArr(20, 100);
        //RandomArr.sortArr(arr);
        RandomArr.showArr(arr);
        //System.out.println(binarySearchNormal(arr,33));
        System.out.println(binarySearchSpecial(arr));
    }

    public static boolean binarySearchNormal(int[] arr,int searchNum){

        int left = 0;
        int right = arr.length-1;
        int mid;

        while(left<=right){
            //mid = left + (right-left)>>1;
            mid = (left+right)/2;
            if(arr[mid] == searchNum){
                return true;
            }else if(arr[mid] > searchNum){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return false;
    }



    public static int binarySearchSpecial(int[] arr) {

        //如果字符串为空
        if(arr == null || arr.length == 0){
            return -1;
        }

        int len = arr.length;
        //先判断第一个和最后一个数是不是局部最小值
        if(len==1 || arr[0] < arr[1]){
            return 0;
        }
        if(arr[len-1] <arr[len-2]){
            return len-1;
        }

        int left = 1;
        int right = len-2;
        int mid;

        while (left<=right){
            mid = (left+right)/2;
            if(arr[mid]>arr[mid-1]){
                right = mid - 1;
            }else if(arr[mid]>arr[mid+1]){
                left = mid+1;
            }else {
                return mid;
            }
        }

        return -1;
    }
}

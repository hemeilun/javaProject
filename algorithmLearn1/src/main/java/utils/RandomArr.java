package utils;

public class RandomArr {

    /**
     * 产生一个随机数组
     * @param maxSize           产生数组的最大值
     * @param maxValue       可以产生的最大值
     * @return               返回随机数组
     */
    public static int[] produceRandomArr(int maxSize,int maxValue){

        int[] arr = new int[(int)((maxSize+1)*Math.random())];
        for (int i = 0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*(maxValue+1));
        }
        return arr;
    }


    /**
     * 打印数组
     * @param arr
     */
    public static void showArr(int[] arr){

        System.out.println();
        for (int num: arr) {
            System.out.print(num+" ");
        }
        System.out.println();
    }


    /**
     * 对数组进行排序
     * @param arr
     */
    public static void sortArr(int[] arr){
        //确定每一次分组的间隙是多大
        for(int pag = arr.length/2;pag>0;pag/=2){

            for(int i = pag;i<arr.length;i++){

                //这个地方实质是一个插入排序，所以需要将插入的数据先保存，然后进行移动
                //最后进行赋值
                int index = i;
                int tem = arr[i];

                //如果tem比此组最右边的值要小，才会进入if，否则说明这一次循环数组不需要改变
                if(tem < arr[index-pag]){
                    while(index-pag >= 0 && tem < arr[index-pag]){
                        arr[index] = arr[index-pag];
                        index -= pag;
                    }

                    arr[index] = tem;
                }
            }
        }
    }

}

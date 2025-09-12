package lee.erfen;

/**
 * @Author Yves
 * @Data 2023/4/4 下午3:25
 * @Desc 二分查找有序数组最左侧指定数下标
 *
 * 二分法  ： 如果条件非1即0的情况下就可以使用二分
 *
 */
public class NearestIndex {
    public static void main(String[] args) {
        System.out.println((3-0)>>1);
        int[] arr = new int[]{1,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,4,5};
        System.out.println(findNearestIndex(arr, 1));
        System.out.println(findNearestIndex(arr, 2));
        System.out.println(findNearestIndex(arr, 3));
        System.out.println(findNearestIndex(arr, 4));
        System.out.println(findNearestIndex(arr, 5));
    }

    private static int findNearestIndex(int[] arr, int num) {
        int L = 0;
        int R = arr.length -1;
        int index = -1;  //记录下标
        while (L <= R) {
            int mid = L + ((R-L) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                R = mid -1;
            } else {
                L = mid +1;
            }
        }
        return index;
    }
}

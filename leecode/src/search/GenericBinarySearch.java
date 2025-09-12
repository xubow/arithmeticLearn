package search;

/**
 * @author chenyves
 * @description: (二分查找 --- 泛型数据) 存在相同值的单调数据,并且要查找第一个或最后一个k值的情况
 *  e.g.
 *      1,1,1,1, 0,0,0
 *      0,0,0,0,1,1,1
 *
 * 和一般的二分查找不同点：
 *  一般的二分查找,是在一堆有序数中找到其中一个有效值
 *      arr[mid] > k ; left = mid + 1;
 *      arr[mid] <k; right = mid -1;
 *  而在泛型数据中是要找到
 *      第一个1  [0,0,0,0,1,1,1]
 *          mid = (left + right) >> 1;
 *          arr[mid] < k; left = mid + 1;
 *          arr[mid] >= k; right = mid;
 *      最后一个1 (想当于数据从大到小排序) [1,1,1,1,0,0,0,0,0]
 *          mid = (left + right + 1) >> 1;  此处计算mid的时候需要向上取整 因为如果按照普通的向下取整就会陷入死循环
 *          arr[mid] >= k; left = mid;
 * @date 2025/8/24 12:42
 * @since JDK 1.8
 */
public class GenericBinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3};
        System.out.println(findFirstOne(arr, 0, arr.length - 1, 1));

        arr = new int[]{2,2,1,1,0,0,0,0};
        System.out.println(findLastOne(arr, 0, arr.length - 1, 1));
        System.out.println(findLastOne(arr, 0, arr.length - 1, 2));
    }
    
    public static int findFirstOne(int[] arr, int left, int right, int k) {
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= k) right = mid; // 一般的二分 此处mid-1
            else left = mid + 1;
        }
        // 当left和right重合的时候,第一个k值确定
        return left;  // or return right;
    }

    public static int findLastOne(int[] arr, int left, int right, int n) {
        while(left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (arr[mid] >= n) left = mid;  // 此处一般的二分 left = mid + 1
            else right = mid - 1;
        }
        // left right 重合
        return left;
    }
}
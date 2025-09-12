package lee.Sort;

import lee.erfen.ArrBase;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Yves
 * @Data 2023/5/12 上午11:55
 */
public class TestSort extends ArrBase {
    public static void main(String[] args) {
        Map<String, Object> content = new HashMap<>();
        Map<String, Object> BJ = new HashMap<>();
        BJ.put("京", null);
        BJ.put("方", null);
        content.put("北", BJ);
        System.out.println(content);

        String str = "我要去北方的北京";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            while(content.get(c) != null) {
                //.....
            }

        }
    }


    static int gcd(int a , int b) {
        return b==0?a:gcd(b, a%b);
    }


    static  void sort2(int[] arr, int left, int right) {
        if (left <= right) {
            int p = arr[(left+right)/2];
            int l = left;
            int r= right;
            while(l<=r) {
                while(arr[l] < p) l++;
                while(arr[r] > p) r--;
                if (l <= r) {
                    int temp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp;
                    l++;
                    r--;
                }
            }

            sort2(arr, left, r);
            sort2(arr, l, right);
        }
    }
}

package lee.huadongchuangkou;

import java.util.HashSet;

/**
 * @Author Yves
 * @Data 2023/7/27 下午2:41
 */
public class maxLengthOfSubStr {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabfga"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();

//abcbfdf
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLen = Math.max(maxLen, set.size());
            } else {
                set.remove(s.charAt(left));
//                System.out.println(left);
                left++;
            }
        }

        return maxLen;
    }

}


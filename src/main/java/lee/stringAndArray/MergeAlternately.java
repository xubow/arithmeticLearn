package lee.stringAndArray;

/**
 * @Author Yves
 * @Data 2023/5/24 下午2:47
 */
public class MergeAlternately {
    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "aaaa";
//        System.out.println(mergeAlternately(s1, s2));

        System.out.println(gcd(2,4));
    }

    private static int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }

    public static String mergeAlternately(String word1, String word2) {
        int l=0,r=0;
        StringBuilder sb = new StringBuilder();
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        while (l<word1.length() && r<word2.length()) {
            sb.append(w1[l++]).append(w2[r++]);
        }
        if (l >= word1.length()) {
            for (int i = r; i < w2.length; i++) {
                sb.append(w2[i]);
            }
        }
        if (r >= word2.length()) {
            for (int i = l; i < w1.length; i++) {
                sb.append(w1[i]);
            }
        }
        return sb.toString();

    }
}

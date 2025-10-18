package Easy.CODE;

public class LC_1768_MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < m) {
                res.append(word1.charAt(i));
            }
            if (i < n) {
                res.append(word2.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LC_1768_MergeStringsAlternately sol = new LC_1768_MergeStringsAlternately();
        String word1 = "abcfudhads";
        String word2 = "pqrstu";
        String result = sol.mergeAlternately(word1, word2);
        System.out.println("Kết quả: " + result);
    }
}

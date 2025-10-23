package Medium.CODE;

public class LC_151_ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = words.length -1; i >= 0; i--) {
            res.append(words[i]);
            if(i != 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LC_151_ReverseWordsInAString obj = new LC_151_ReverseWordsInAString();
        System.out.println(obj.reverseWords("havy yeu cau lam")); // true
        System.out.println(obj.reverseWords("happy you ne")); // false
    }
}

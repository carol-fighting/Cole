/**
 * must be in ?* or a* so we from right to left
 */
public class MatchPattern {

    public Boolean isMatch(String s, String p) {
        return smallMath(s, p, s.length() - 1, p.length() - 1);
    }

    private Boolean smallMath(String s, String p, int i, int j) {
        Boolean defaultFlag = false;
        if (i == -1 || j == -1) {
            if (i == -1 && j == -1) {
                return true;
            }
            return defaultFlag;
        }
        if ('?' == p.charAt(j) || p.charAt(j) == s.charAt(i)) {
            return smallMath(s, p, i - 1, j - 1);
        }
        if ('*' == (p.charAt(j))) {
            int t = j;
            while (t >= 0) {
                if (smallMath(s, p, i - 1, t--) == true) {
                    return true;
                }
            }
            return false;
        }

        return defaultFlag;
    }

    public static void main(String[] args) {
        System.out.println(new MatchPattern().isMatch("aaaabc", "a*bc"));
        System.out.println(new MatchPattern().isMatch("aaaabc", "a*?c"));
        System.out.println(new MatchPattern().isMatch("aaaabc", "a*bd"));
    }
}

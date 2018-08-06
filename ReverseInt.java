public class ReverseInt {

    public int reverse(int n) {
        int defalutAns = 0;
        if (n == Integer.MIN_VALUE) {
            return defalutAns;
        }
        if (n < 0) {
            return -reverse(-n);
        }

        while (n != 0) {
            if (defalutAns > Integer.MAX_VALUE / 10) {
                return 0;
            }
            defalutAns = defalutAns * 10 + n % 10;
            n = n / 10;
        }
        return defalutAns;
    }
}

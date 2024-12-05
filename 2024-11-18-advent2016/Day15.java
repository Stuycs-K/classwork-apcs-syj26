import java.util.Arrays;

public class Day15 {
    public static int[] binary(int n) {
        int[] ans=new int[(int) (Math.log(n)/Math.log(2))+1];
        for (int i=0; i<ans.length; i++) {
            ans[i]=n%2;
            n/=2;
        }
        return ans;
    }

    public static int modularInversePrime(int a, int p) { //note ONLY WORKS FOR PRIME MOD cause a^{-1}==a^{p-2} mod p
        int[] expBinary=binary(p-2);
        int[] powers=new int[expBinary.length];
        int ans=1;
        powers[0]=a%p;
        for (int i=1; i<expBinary.length; i++) {
            powers[i]=(powers[i-1]*powers[i-1])%p;
        }
        for (int i=0; i<expBinary.length; i++) {
            if (expBinary[i]==1) {
                ans*=powers[i];
                ans%=p;
            }
        }
        return ans;
    }

    //sry im like rly lazy rn so i dont wanna check for gcd=1 or run euclid alg in reverse
    public static long modularInverse(long a, long n) {
        for (long i=1L; i<n; i++) {
            if ((a*i)%n==1L) {
                return i;
            }
        }
        return 0;
    }

    public static long chineseRemainder(long a1, long n1, long a2, long n2) {
        long b1=modularInverse(n1, n2);
        long b2=modularInverse(n2, n1);
        return ((a1*n2*b2+a2*n1*b1)%(n1*n2));
    }
    /*
 * t0+1==16 mod 17
 * t0+2==0 mod 7
 * t0+3==17 mod 19
 * t0+4==0 mod 5
 * t0+5==0 mod 3
 * t0+6==8 mod 13
 * t0+7==0 mod 11
 */
    public static void main(String[] args) {
        System.out.println(chineseRemainder(14L, 19L, chineseRemainder(15L, 17L, chineseRemainder(2L, 13L, chineseRemainder(5L, 7L, chineseRemainder(1L, 5L, 1L, 3L), 3L*5), 3L*5*7), 3L*5*7*13), 3L*5*7*13*17));
        System.out.println(chineseRemainder(4L, 11L, chineseRemainder(14L, 19L, chineseRemainder(15L, 17L, chineseRemainder(2L, 13L, chineseRemainder(5L, 7L, chineseRemainder(1L, 5L, 1L, 3L), 3L*5), 3L*5*7), 3L*5*7*13), 3L*5*7*13*17), 3L*5*7*13*17*19));
    }

}
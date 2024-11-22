import java.util.*;
import java.io.*;
import java.security.*;

public class MD5 {
    private static String foo(int n) {
        if (n>=0 && n<=9) {return ""+n;}
        if (n>=10 && n<16) {
            String s="abcdef";
            return s.substring(n-10, n-9);
        }
        return "x";
    }
    public static String byteToHex(byte n) {
        int m=(int) n;
        m=(m+256)%256;
        return ""+foo((m/16)%16)+foo(m%16);
    }
    public static String byteToHex(byte[] nums) {
        String ans="";
        for (int i=0; i<nums.length; i++) {
            ans+=byteToHex(nums[i]);
        }
        return ans;
    }

    public static String hash(String salt, int index) {
        try {
            String hashee=salt+index;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(hashee.getBytes());
            byte[] digest=md.digest();
            String hex=byteToHex(digest);
            return hex;
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("no such algorithm");
            return null;
        }
    }
}
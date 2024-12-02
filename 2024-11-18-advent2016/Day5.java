import java.util.*;
import java.io.*;
import java.security.*;

public class Day5 {
    public static String foo(int n) {
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
    public static boolean done(String[] password) {
        for (int i=0; i<password.length; i++) {
            if (password[i]==null) {return false;}
        }
        return true;
    }
    public static void main(String[] args) {
        int count=0;
        int index=0;
        while (count<8) {
            String hashee="ojvtpuvg"+index;
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(hashee.getBytes());
                byte[] digest=md.digest();
                String hex=byteToHex(digest);
                if (hex.substring(0, 5).equals("00000")) {
                    System.out.print(hex.charAt(5));
                    count++;
                }
                index++;
            } catch (NoSuchAlgorithmException ex) {
                System.out.println("no such algorithm");
            }

        }
    }
}
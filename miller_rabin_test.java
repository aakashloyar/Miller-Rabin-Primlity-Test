package com.aakash.Prime_no_Test;

import java.util.*;
public class miller_rabin_test {
    public static void main(String[] args) {
        int k = 5; // for accuracy

        System.out.println("All primes smaller "
                + "than 100: ");
        ArrayList<Integer> list=new ArrayList<>();
        for (int n = 1; n < 100; n++) {
            if (isPrime(n, k)) list.add(n);
        }
        //if (isPrime(67, k)) list.add(67);
        System.out.println(list);
        System.out.println(list.size());
    }
    static boolean isPrime(int n,int k) {
        if(n<=1) return false;
        if(n<=3) return true;
        if(n%2==0) return false;
        int p=n-1;
        while((p&1)==0) {
            p=p/2;
        }
        for(int i=0;i<k;i++) {
            if(!millerTest(n,p)) return false;
        }
        return true;
    }
    static boolean millerTest(int n,int p) {
        int a=2+(int)(Math.random()%(n-4));
        long T=init(a,p,n);
        if(T==1||T==n-1) return true;
        while(p!=n-1) {
            T=(T*T)%n;
            p*=2;
            //if(T==1) return false;
            if(T==(n-1)) return true;
        }
        return false;
    }
    static long init(int a,int p,int n) {
        long T=1;
        long m=a;
        while(p!=0) {
            if(((p&1)==1)) {
                T*=a;
                T%=n;
            }
            a*=a;
            a%=n;
            p=p>>1;
        }
        return T;
    }

}

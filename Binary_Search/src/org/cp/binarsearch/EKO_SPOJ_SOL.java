package org.cp.binarsearch;

import java.io.*;
import java.util.*;

public class EKO_SPOJ_SOL {

	static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
 
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
     }
 
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            boolean neg = (c == '-');
            if (neg) c = read();
            long val = c - '0';
            while ((c = read()) > ' ')
                val = val * 10 + (c - '0');
            return neg ? -val : val;
        }
    }
 
    static long[] trees;
    static int n;
    static long m;
 
    static boolean canCut(long h) {
        long wood = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i] > h) {
                wood += trees[i] - h;
                if (wood >= m) return true;   // early stopping
            }
        }
        return false;
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
 
        n = (int) fs.nextLong();
        m = fs.nextLong();
        trees = new long[n];
 
        long maxH = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = fs.nextLong();
            if (trees[i] > maxH) maxH = trees[i];
        }
 
        long low = 0, high = maxH;
 
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (canCut(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
 
        System.out.println(high);
    }

}

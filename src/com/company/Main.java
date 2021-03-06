package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}

// MST
class Solution {
    int[] uf;
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        uf = new int[n + 1];
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            uf[i + 1] = i + 1;
            edges.add(new int[] {0, i + 1, wells[i]});
        }
        for (int[] p : pipes) {
            edges.add(p);
        }
        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int res = 0;
        for (int[] e : edges) {
            int x = find(e[0]), y = find(e[1]);
            if (x != y) {
                res += e[2];
                uf[x] = y;
                --n;
            }
        }
        return res;
    }

    private int find(int x) {
        if (x != uf[x]) uf[x] = find(uf[x]);
        return uf[x];
    }
}
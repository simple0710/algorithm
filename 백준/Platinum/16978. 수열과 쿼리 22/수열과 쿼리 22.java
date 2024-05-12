import java.io.*;
import java.util.*;

public class Main {
    static long[] segTree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N+1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) arr[i+1] = Integer.parseInt(input[i]);

        ArrayList<int[]> query1 = new ArrayList<>();
        ArrayList<int[]> query2 = new ArrayList<>();

        query1.add(new int[2]);
        int resIdx = 0;
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            input = br.readLine().split(" ");
            int q = Integer.parseInt(input[0]);
            if (q == 1) {
                int i = Integer.parseInt(input[1]);
                int v = Integer.parseInt(input[2]);
                query1.add(new int[] {i, v});
            } else {
                int k = Integer.parseInt(input[1]);
                int i = Integer.parseInt(input[2]);
                int j = Integer.parseInt(input[3]);
                query2.add(new int[] {resIdx++, k, i, j});
            }
        }

        Collections.sort(query2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int size = 1 << (h + 1);

        segTree = new long[size];
        init(arr, 1, 1, N);

        int i, v, k, j;
        int q2Idx = 0;
        long[] resArr = new long[resIdx];
        for (int t = 0; t < query1.size(); t++) {
            if (t > 0) {
                i = query1.get(t)[0];
                v = query1.get(t)[1];
                update(1, 1, N, i, v);
            }
            while (q2Idx < query2.size() && ((k = query2.get(q2Idx)[1]) == t)) {
                int nowIdx = query2.get(q2Idx)[0];
                i = query2.get(q2Idx)[2];
                j = query2.get(q2Idx)[3];
                resArr[nowIdx] = query(1, 1, N, i, j);
                q2Idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < resIdx; i++) sb.append(resArr[i]).append("\n");
        System.out.print(sb);
    }

    private static long query(int node, int start, int end, int left, int right) {
        if (end < left || start > right) return 0;
        if (left <= start && end <= right) return segTree[node];
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    }

    private static void update(int node, int start, int end, int idx, int v) {
        if (end < idx || idx < start) return;
        if (start == end) {
            segTree[node] = v;
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, idx, v);
        update(node * 2 + 1, mid + 1, end, idx, v);
        segTree[node] = segTree[node * 2] + segTree[node * 2 + 1];
    }

    private static long init(long[] arr, int node, int start, int end) {
        if (start == end) return segTree[node] = arr[start];
        int mid = (start + end) / 2;
        return segTree[node] = init(arr, node * 2, start, mid) + init(arr, node * 2 + 1, mid + 1, end);
    }
}
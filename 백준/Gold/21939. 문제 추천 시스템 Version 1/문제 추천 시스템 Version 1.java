import java.io.*;
import java.util.*;

public class Main {
    static class Info {
        int p;
        int l;
        Info(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> problemNumberMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Info> pqAsc = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.l == o2.l) return Integer.compare(o1.p, o2.p);
                return Integer.compare(o1.l, o2.l);
            }
        });

        PriorityQueue<Info> pqDesc = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.l == o2.l) return Integer.compare(o2.p, o1.p);
                return Integer.compare(o2.l, o1.l);
            }
        });
        int P;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            P = Integer.parseInt(input[0]);
            int L = Integer.parseInt(input[1]);
            pqAsc.add(new Info(P, L));
            pqDesc.add(new Info(P, L));
            problemNumberMap.put(P, L);
        }
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            switch (command) {
                case "recommend":
                    boolean flag = Integer.parseInt(input[1]) == 1;
                    if (flag) {
                        while (true) {
                            Info now = pqDesc.poll();
                            if (problemNumberMap.get(now.p) == now.l) {
                                sb.append(now.p).append("\n");
                                pqDesc.add(now);
                                break;
                            }
                        }
                    } else {
                        while (true) {
                            Info now = pqAsc.poll();
                            if (problemNumberMap.get(now.p) == now.l) {
                                sb.append(now.p).append("\n");
                                pqAsc.add(now);
                                break;
                            }
                        }
                    }
                    break;
                case "add":
                    P = Integer.parseInt(input[1]);
                    int L = Integer.parseInt(input[2]);
                    pqAsc.add(new Info(P, L));
                    pqDesc.add(new Info(P, L));
                    problemNumberMap.put(P, L);
                    break;
                case "solved":
                    P = Integer.parseInt(input[1]);
                    problemNumberMap.put(P, -1);
                    break;
            }
        }
        System.out.print(sb);
    }
}
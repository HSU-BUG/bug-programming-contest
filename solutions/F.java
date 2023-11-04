import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static final int[] ry = {-1, 0, 1, 0};
    private static final int[] rx = {0, 1, 0, -1};

    private static int[][] map;
    private static int[][] dist;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.addLast(new Node(0, 0));
        dist[0][0] = 0;
				map[0][0] = -1;

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            if (map[now.r][now.c] >= dist[now.r][now.c]) {
                dist[now.r][now.c]++;
                queue.addLast(now);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + ry[i];
                int nc = now.c + rx[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue;

                if (dist[nr][nc] > 0)
                    continue;

                dist[nr][nc] = dist[now.r][now.c] + 1;
                queue.addLast(new Node(nr, nc));
            }
        }

        System.out.println(dist[N - 1][M - 1]);

    }

}
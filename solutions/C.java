import java.io.*;
import java.util.*;
public class domino {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// N과 K 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		// 모든 도미노의 크기 저장
		int[] list = new int[n];
		for(int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		for(int i = 0; i < n; i++) {
			// list[i]는 가장 낮은 높이의 도미노, amt는 list[i]가 가장 낮은 도미노일 때 사용할 수 있는 도미노의 개수
			int amt = 0;
			for(int j = 0; j < n; j++) {
				// 모든 도미노의 높이를 탐색하며, list[i]보다 크거나 같고, list[i] + k 보다 작거나 같은 높이가 있으면 amt ++;
				if(list[j] >= list[i] && list[j] <= list[i] + k) {
					amt++;
				}
			}
			// 답 갱신
			if(amt > ans) {
				ans = amt;
			}
		}
		// 답 출력
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
		br.close();
	}
}
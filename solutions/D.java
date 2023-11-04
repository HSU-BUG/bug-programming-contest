import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] mcdonald;
	
	static long search(long start, long end, int target) {
		long min_time = 0;
		while(start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for(int cost : mcdonald) {
				sum += mid / cost;
			}
			if(sum >= target) {
				min_time = mid;
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		return min_time;
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		mcdonald = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) {
			mcdonald[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(T.search(0, (long)1e12, (int)(M / 5000)));
	}
}
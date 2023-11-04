import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int combi(int n) {
	    int result = 1;
	    if (n < 3) {
	        return 0;
	    }
	    for (int i = n; i > n - 3; i--) {
	        result *= i;
		    }
	    return result / 6;
	}
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		System.out.println(T.combi(B + C) - T.combi(B) - T.combi(C));
	}
}
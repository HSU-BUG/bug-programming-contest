import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class drinkGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		
		int result = 0;
		// 10^2 > 3자리 , 10^16 > 17자리
		for(int sz = 3 ; sz <= 17 ; sz ++) {
			// d0 = 기존의 수
			for(int d0 = 0; d0 < 10 ; d0 ++) {
				char[] S = new char[sz];
				for(int i = 0 ; i < sz ; i ++) {
					S[i] = (char) ('0' + d0); 
				}
				// d1 = 새로운 수
				for(int d1 = 0 ; d1 < 10 ; d1 ++) {
					if(d0 == d1) continue;
					
					for(int i = 0 ; i < sz ; i ++) {
						S[i] = (char) ('0' + d1);
						
						long num = Long.parseLong(String.valueOf(S));
						if(S[0] != '0' && X <= num && num <= Y) {
							++result;
						}
						
						S[i] = (char) ('0' + d0);
					}
				}
			}
		}
		bw.write(String.valueOf(result));
		bw.close();
		br.close();
	}
}
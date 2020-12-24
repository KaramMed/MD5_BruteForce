package MD5_BruteForce;

import java.util.ArrayList;
import java.util.List;

public class Server2 {

	// this server will make first character search from 80 to 127
	static List<Search_Thread> threads = new ArrayList<Search_Thread>();
	
	
	// this method will get intervals and start thread for each interval
	public static void start_threads(String hashcode,List<String> ints) {
		for(String inte:ints) {
			Search_Thread st = new Search_Thread(inte,hashcode,2);
			threads.add(st);
		}
		// starting threads
		for(Search_Thread st:threads) {
			st.start();
		}
	}
	
	// method to stop threads
	public static void stop_threads() {
		for(Search_Thread st:threads) {
			st.stop();
		}
		//System.out.println("server 2 stopped");
		// also servers shall stop
	}
	
	// method to start the server
	public static void start_server(String hashcode,int n) {
		List<String> intervals = intervals(n);
		start_threads(hashcode,intervals);
	}
	
	// this method takes number of threads and returns intervals to search 
	public static List<String> intervals(int n) {
		List<String> inter = new ArrayList<String>();
		int d = 127 - 80;
		int p = d/n;
		int x=80;
		List<Integer> steps = new ArrayList<Integer>();
		for(int i=80;i<127;i+=p) {
			x=i;
			steps.add(x);
		}
		if(steps.get(steps.size()-1)<126) {
			steps.set(steps.size()-1,126);
		}
		
		for(int i=0;i<steps.size()-1;i++) {
			int a = steps.get(i);
			int b;
			try {
				b = steps.get(i+1);
			}
			catch(Exception e) {b=steps.get(i);}
			//System.out.println(a+"-"+b);
			inter.add(a+"-"+b);
		}
		return inter;
	}
}

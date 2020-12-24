package MD5_BruteForce;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Search_Thread extends Thread{
	
	String interval;
	static int cmp = 0;
	int id = 0;
	boolean stop = false;
	String hashcode;
	int server;
	
	public Search_Thread(String i,String hash,int s) {
		interval = i;
		id = cmp;
		hashcode = hash;
		server = s;
		cmp++;
	}
	
	public void setStop(boolean b) {
		stop = b;
		System.out.println("Thread "+id+" stopped");
	}
	
	public static String getMd5(String input) {
		 try {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] messageDigest = md.digest(input.getBytes());
		 BigInteger no = new BigInteger(1, messageDigest);
		 String hashtext = no.toString(16);
		 while (hashtext.length() < 32) {
		 hashtext = "0" + hashtext;
		 }
		 return hashtext;
		 }
		 catch (NoSuchAlgorithmException e) {
		 throw new RuntimeException(e);
		 }
	}

	// this is the thread for starting search
	public void run() {
		// this method takes an interval and start brute force search on it
			String[] A = interval.split("-");
			int a = Integer.parseInt(A[0]);
			int b = Integer.parseInt(A[1]);
			
			// making search on the first character from a to b
			long startTime = System.nanoTime();
			for(int i=a;i<b;i++) {
				char c = (char) i;
				for(int j=33;j<127;j++) {
					char d = (char) j;
					for(int k=33;k<127;k++) {
						char e = (char) k;
						for(int l=33;l<127;l++) {
							char r = (char) l;
							for(int m=33;m<127;m++) {
								char x = (char) m;
								for(int n=33;n<127;n++) {
									char v = (char) n;
									String word = c+""+d+""+e+""+r+x+""+v;
									//System.out.println(server+":"+id+" : "+word);
									// if we find it the stop flag is true
									if (hashcode.equals(getMd5(word))) {
										System.out.println("Password found : "+word+" by Thread "+id+" on Server "+server);
										double endTime   = System.nanoTime();
										double totalTime = endTime - startTime;
										System.out.println("Time : "+(totalTime/1000000000)/60+" minutes");
										// and also sending it to other threads
										Server1.stop_threads();
									}
								}
							}
						}
					}
				}
			}
	}
}

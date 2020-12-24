package MD5_BruteForce;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main_Server {
	
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

	public static void main(String[] args) {
		// getting hash code from user
		System.out.print("Enter the hashcode --> ");
		Scanner sc = new Scanner(System.in);
		String hashcode = sc.next();
		// getting the number of threads
		System.out.print("Enter the number of threads for each server --> ");
		int n = sc.nextInt();
		
		System.out.println();
		// the search of the first character will be divided for the 2 servers
		// server one will get first character search from 33 to 80
		Server1 s1 = new Server1();
		s1.start_server(hashcode,n);
	
		// server two will get first character search from 80 to 127
		Server2 s2 = new Server2();
		s2.start_server(hashcode, n);
		
		/*
		 * Try using these hashes for less time wait :
		 * bf6871d4fdbe9c0955bf304eaa06c640
		 * 821f40e6beabbc20876d3e0e9ed2bef7
		 * 6766f4262b2c600eddcf5461c7e9938a
		 * Try using also 4 or less threads for more performance
		 * [ 4 threads is the optimal choice ]
		 * */
		
	}

}

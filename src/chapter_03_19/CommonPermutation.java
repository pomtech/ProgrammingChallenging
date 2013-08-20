package chapter_03_19;

import java.util.ArrayList;

public class CommonPermutation {
	private char[] strA;
	private char[] strB;
	
	public CommonPermutation(char[] strA, char[] strB) {
		this.strA = strA;
		this.strB = strB;
	}

	// strA foreach char and check hash1
	// strB foreach char and check hash2
	// compare hash1 hash2 then if hash1 > 0 && hash2 > 0 then get small
	// thing > hash3
	// hash3 foreach and if 'a' is 2 aa is answer
	public char[] getLongestCPString() {
		int[] hashA = new int[128];
		int[] hashB = new int[128];

		for (int i = 0; i < strA.length; ++i) {
			hashA[strA[i]]++;
		}

		for (int i = 0; i < strB.length; ++i) {
			hashB[strB[i]]++;
		}
		
		StringBuffer buf = new StringBuffer();
		
		for (int i = 0; i < 128; ++i) {
			if (hashA[i] > 0 && hashB[i] > 0) {
				int counter = 0;
				if(hashA[i]>=hashB[i]){
					counter = hashB[i];
				}else{
					counter = hashA[i];
				}
				while(counter>0){
					buf.append((char)i);
					counter--;
				}
			}
		}
		
		return buf.toString().toCharArray();
	}

	public static void main(String[] args) {
		// 1.
		CommonPermutation firstTest = new CommonPermutation("pretty".toCharArray(), "women".toCharArray());
		char[] firstTestResult = firstTest.getLongestCPString();
		// 2.
		CommonPermutation secondTest = new CommonPermutation("walking".toCharArray(), "down".toCharArray());
		char[] secondTestResult = secondTest.getLongestCPString();
		// 3.
		CommonPermutation thirdTest = new CommonPermutation("the".toCharArray(), "street".toCharArray());
		char[] thirdTestResult = thirdTest.getLongestCPString();
		// answer..!
		System.out.println(firstTestResult);
		System.out.println(secondTestResult);
		System.out.println(thirdTestResult);
		
		char k = '~';
		System.out.println((int)k);
	}
}

package randomTestCode;

import java.security.SecureRandom;

public class javaSecureRandom {
	private static SecureRandom random = new SecureRandom();
	
	public static void main(String[] args) {

		/* ▼▼▼▼▼▼▼▼▼▼▼ Java Secure Random ▼▼▼▼▼▼▼▼▼▼▼ */
		String ENGLISH_LOWER = "abcdefghijklmnopqrstuvwxyz";
		String NUMBER = "0123456789";
		String ENGLISH_UPPER = ENGLISH_LOWER.toUpperCase();
        String DATA_FOR_RANDOM_STRING = ENGLISH_LOWER + ENGLISH_UPPER + NUMBER;
        
        /** 랜덤 문자열 길이 **/
        int random_string_length=15;
    	
        System.out.println("DATA_FOR_RANDOM_STRING ==> ");
        System.out.println(DATA_FOR_RANDOM_STRING);
        System.out.println("");
        for (int i = 0; i < 10; i++) {
        	System.out.println("random " + i + " : " + generate(DATA_FOR_RANDOM_STRING, random_string_length));
        }
    }
	
	public static String generate(String DATA, int length) {
		
		if (length < 1)
			throw new IllegalArgumentException("length must be a positive number.");
        
		StringBuilder sb = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			sb.append(DATA.charAt(random.nextInt(DATA.length())));
		}
		
		return sb.toString();
    }
}


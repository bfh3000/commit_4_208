package randomTestCode;

import java.security.SecureRandom;

public class javaSecureRandom2 {
	private static SecureRandom random = new SecureRandom();
	
	public static void main(String[] args) {

		SecureRandom random = new SecureRandom ();

		//���� ���� ����
		int numLength = 16;
		String randomStr = "";

		for (int i = 0; i < numLength; i++) {
		//0 ~ 9 ���� ���� ����
		randomStr += random.nextInt(10);
		System.out.println("randomStr "+ i + " :: " + randomStr);
		}
    }
}


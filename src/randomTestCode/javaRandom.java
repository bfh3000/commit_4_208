package randomTestCode;

import java.util.Random;

public class javaRandom {
	public static void main(String[] args) {
		
		/* °Â°Â°Â°Â°Â°Â°Â°Â°Â°Â°Â Java ¿œπ› Random °Â°Â°Â°Â°Â°Â°Â°Â°Â°Â°Â */
		Random rnd = new Random();
		
		for (int i = 0; i < 30; i++) {
			System.out.println(rnd.nextInt(25));
		}
    }
}

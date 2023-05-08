package utility.javaUtility;

import java.util.Random;

public class RandomNumberUtility {
public int getRandomNumber(int boundary) {
	return new Random().nextInt(boundary);
}
}

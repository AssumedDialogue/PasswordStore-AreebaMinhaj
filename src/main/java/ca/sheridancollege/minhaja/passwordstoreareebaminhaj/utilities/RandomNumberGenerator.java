package ca.sheridancollege.minhaja.passwordstoreareebaminhaj.utilities;

import java.security.SecureRandom;

public class RandomNumberGenerator {
    private static SecureRandom secureRandom = new SecureRandom();

    public static long generateRandomId() {
        return 100000000 + Math.abs(secureRandom.nextLong() % 999999999);
    }
}

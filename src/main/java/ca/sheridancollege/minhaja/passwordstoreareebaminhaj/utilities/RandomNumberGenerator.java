package ca.sheridancollege.minhaja.passwordstoreareebaminhaj.utilities;

import java.util.Random;

public class RandomNumberGenerator {

    public static long generateRandomId() {
        Random random = new Random();
        return 100000000 + random.nextLong(999999999);
    }
}

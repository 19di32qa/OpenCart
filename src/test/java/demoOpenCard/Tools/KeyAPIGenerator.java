package demoOpenCard.Tools;

import java.security.SecureRandom;

public class KeyAPIGenerator {

    private static final int API_KEY_LENGTH = 256;
    private static final String CHARACTER_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateApiKey() {
        SecureRandom random = new SecureRandom();
        StringBuilder apiKeyBuilder = new StringBuilder(API_KEY_LENGTH);

        for (int i = 0; i < API_KEY_LENGTH; i++) {
            int index = random.nextInt(CHARACTER_SET.length());
            apiKeyBuilder.append(CHARACTER_SET.charAt(index));
        }

        return apiKeyBuilder.toString();
    }
}

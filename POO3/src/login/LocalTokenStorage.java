package login;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LocalTokenStorage {

    private static final Path FILE = Path.of("login.token");

    public static void save(String token) {
        try {
            Files.writeString(FILE, token);
        } catch (IOException e) {
            throw new RuntimeException("Error saving local token", e);
        }
    }

    public static String read() {
        try {
            if (!Files.exists(FILE)) return null;
            String token = Files.readString(FILE).trim();
            return token.isEmpty() ? null : token;
        } catch (IOException e) {
            throw new RuntimeException("Error reading local token", e);
        }
    }

    public static void clear() {
        try {
            Files.deleteIfExists(FILE);
        } catch (IOException e) {
            throw new RuntimeException("Error clearing local token", e);
        }
    }
}
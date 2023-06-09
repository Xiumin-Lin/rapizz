package dev.rapizz;

import java.io.PrintStream;

public class Utils {
    public static class Log {
        private static final PrintStream out = System.out;
        public static void info(String log) {
            out.println(log);
        }

        public static void success(String log) {
            out.println("✅ " + log);
        }

        public static void error(String log) {
            out.println("❌ " + log);
        }
    }
}

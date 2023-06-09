package dev.rapizz;

import java.io.PrintStream;
import java.sql.SQLException;

public class Utils {
    public static class Log {
        private static final PrintStream out = System.out;
        private static final PrintStream err = System.err;
        public static void info(String msg) {
            out.println(msg);
        }

        public static void success(String msg) {
            out.println("✅ " + msg);
        }

        public static void error(String msg) {
            err.println("❌ " + msg);
        }

        public static void error(String msg, SQLException e) {
            error(msg);
            if(e == null) return;
            e.printStackTrace(err);
            err.println("SQLState: " + e.getSQLState());
            err.println("Error Code: " + e.getErrorCode());
            err.println("Message: " + e.getMessage());
        }
    }
}

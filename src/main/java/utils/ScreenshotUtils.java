package utils;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    private static final String SCREENSHOTS_DIR = "screenshots";

    public static void createFolderIfNotExists() {
        File folder = new File(SCREENSHOTS_DIR);
        if (!folder.exists()) folder.mkdirs();
    }

    public static String getScreenshotPath(String baseName) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        return Paths.get(SCREENSHOTS_DIR, baseName + "_" + timestamp + ".png").toString();
    }
}

package tech.pegasys.net.util;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class FileUtils {

  public static String readContent(final URL url) {
    try {
      return Resources.toString(url, StandardCharsets.UTF_8);
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }
}

package tech.pegasys.net.util;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

  public static <T> T pickRandom(final List<T> values) {
    if (values == null || values.isEmpty()) {
      return null;
    }
    return values.get(ThreadLocalRandom.current().nextInt(values.size()));
  }
}

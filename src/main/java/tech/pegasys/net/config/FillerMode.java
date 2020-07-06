package tech.pegasys.net.config;

public enum FillerMode {
  ONESHOT,
  SCHEDULER,
  CONTINUOUS,
  EXTERNAL_FUZZER_NATS;

  public static FillerMode fromString(final String str) {
    for (final FillerMode mode : FillerMode.values()) {
      if (mode.name().equalsIgnoreCase(str)) {
        return mode;
      }
    }
    return null;
  }
}

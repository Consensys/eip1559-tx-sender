package tech.pegasys.net.core.dagger;

import dagger.Module;
import dagger.Provides;
import tech.pegasys.net.cli.Options;
import tech.pegasys.net.config.TxSenderConfiguration;

import javax.inject.Singleton;

@Module
public class TxSenderModule {

  @Provides
  @Singleton
  public static TxSenderConfiguration txSenderConfiguration() {
    return Options.getInstance().toTxSenderConfiguration();
  }
}

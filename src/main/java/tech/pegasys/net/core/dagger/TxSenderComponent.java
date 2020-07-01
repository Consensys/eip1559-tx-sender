package tech.pegasys.net.core.dagger;

import dagger.Component;
import tech.pegasys.net.core.TxSenderService;

import javax.inject.Singleton;

@Singleton
@Component(modules = TxSenderModule.class)
public interface TxSenderComponent {
  TxSenderService txSender();
}

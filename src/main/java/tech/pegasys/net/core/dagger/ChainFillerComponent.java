package tech.pegasys.net.core.dagger;

import javax.inject.Singleton;

import dagger.Component;
import tech.pegasys.net.core.ChainFillerService;

@Singleton
@Component(modules = ChainFillerModule.class)
public interface ChainFillerComponent {
  ChainFillerService chainFiller();
}

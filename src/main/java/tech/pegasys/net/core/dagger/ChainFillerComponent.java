package tech.pegasys.net.core.dagger;

import dagger.Component;
import tech.pegasys.net.core.ChainFillerService;

import javax.inject.Singleton;

@Singleton
@Component(modules = ChainFillerModule.class)
public interface ChainFillerComponent {
  ChainFillerService chainFiller();
}

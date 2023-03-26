package repositories.impl;

import io.smallrye.mutiny.Uni;
import javax.enterprise.context.ApplicationScoped;
import repositories.api.SampleRepository;

@ApplicationScoped
public class SampleRepositoryImpl implements SampleRepository {

  @Override
  public Uni<String> doSomeThingInDatabase(String name) {
    return Uni.createFrom().item(() -> String.format("Hello %s!!", name));
  }
}

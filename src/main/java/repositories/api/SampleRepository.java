package repositories.api;

import io.smallrye.mutiny.Uni;

public interface SampleRepository {

  Uni<String> doSomeThingInDatabase(String name);
}

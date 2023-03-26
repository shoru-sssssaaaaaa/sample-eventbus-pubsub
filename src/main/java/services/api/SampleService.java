package services.api;

import io.smallrye.mutiny.Uni;

public interface SampleService {
  Uni<String> startService(String name);
}

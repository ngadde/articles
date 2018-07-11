package com.pivovarit.fp;

import java.util.Optional;

public interface UserRepository {
    Optional<String> getUser(String id);
    Optional<String> getUser();

}

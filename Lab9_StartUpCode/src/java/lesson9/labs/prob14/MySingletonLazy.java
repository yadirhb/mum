package lesson9.labs.prob14;

import java.util.Optional;

public class MySingletonLazy {
    private static MySingletonLazy instance = null;

    private MySingletonLazy() {
    }

    public static MySingletonLazy getInstance() {
        synchronized (MySingletonLazy.class) {
            instance = Optional.ofNullable(instance).orElse(new MySingletonLazy());
        }
        return instance;
    }
}

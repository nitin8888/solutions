package designpatterns.singleton;

public final class EagerSingleton {

    private static final EagerSingleton INSTANCE = new EagerSingleton();
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    private EagerSingleton() {
    }
}

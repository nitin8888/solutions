package designpatterns.singleton;

public final class InnerClassSingleton {

    // Create inner static class with an instance
    private static class InnerClass {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }


    public static InnerClassSingleton getInstance() {
        return InnerClass.INSTANCE;
    }

    private InnerClassSingleton() {
    }
}

package designpatterns.singleton;

import common.CommonUtil;

import java.util.concurrent.TimeUnit;

public final class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton INSTANCE;

    public static DoubleCheckSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckSingleton();
                }
            }
        }

        return INSTANCE;
    }

    private DoubleCheckSingleton() {
        CommonUtil.sleepSeconds(2);
    }
}

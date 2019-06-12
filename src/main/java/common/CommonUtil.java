package common;

import java.util.concurrent.TimeUnit;

public final class CommonUtil {

    public static void sleepSeconds(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private CommonUtil() {
    }
}

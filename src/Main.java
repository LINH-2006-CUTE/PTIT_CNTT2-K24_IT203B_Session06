import thread.CountThread;
import thread.RunableCount;

import java.beans.IntrospectionException;

public class Main {
    public static void main(String[] args) throws IntrospectionException {
        CountThread countThread = new CountThread();
        countThread.start();

    }
}
package memoryLeak;

/**
 * Created by lubei on 2017/9/20.
 */
public class ScopeTest {
    Integer[] intArray;

    private void useIntArray() throws InterruptedException {
        intArray = new Integer[100000000];
        Thread.sleep(1000);
//        intArray = null; // 对象不可达
    }

    private static void test() throws InterruptedException {
        ScopeTest test = new ScopeTest();
        test.useIntArray();
        GC();
        Thread.sleep(5000);
    }

    public static void main(String[] args) throws InterruptedException {
        test();
        GC();
        while(true){}
    }

    private static void GC(){
        Runtime.getRuntime().gc();
    }
}

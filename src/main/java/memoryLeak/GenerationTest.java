package memoryLeak;

/**
 * Created by lubei on 2017/9/24.
 */
public class GenerationTest {
    static int KB = 1 * 1024;
//    static int MB = 1 * 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] a = new byte[1024 * KB];
        byte[] b = new byte[1024 * KB];
        byte[] c = new byte[1023 * KB]; // 内存碎片(c被GC后不够分配e)
        byte[] d = new byte[1024 * KB];
        c = null;
        byte[] e = new byte[1024 * KB];
        while (true) {
        }
    }

    private static void GC() {
        Runtime.getRuntime().gc();
    }
}

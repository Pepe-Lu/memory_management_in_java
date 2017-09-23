package memoryLeak;

/**
 * Created by lubei on 2017/9/21.
 */
public class SubStringTest {
    public String a = "abcfjdkafjl;dasfjkldsjafkl;dadjsalf;" +
            "hdshaflkdsbbzxbjdlahfjkdshafjkdsahjfkhdjfhjdhafjk" +
            "dhsfjkdhfjhdjfhdjkfhdjhfjdkhfjkdshafjkdsalhfjdklshfj" +
            "kdsahfjkdhsafjkhdsajklfhdksahfjdklashfjkdshfjkdshfjkdhsajf" +
            "khdsjakfhdjhfjdksalhfjdakshfjdkhjdhfjdhfjdhfjdhfjdhjadhfjklashdfj kladsbfjkds " +
            "ajfkdsajkfgadskjlgjklhgjsadkhfjkdsahfjkdsahlfjdksaf";

    {
        for (int i = 0; i < 16; i++) {
            a += a;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SubStringTest test = new SubStringTest();
        String b = test.a.substring(0, 1);// use jdk 1.6 will cause memory leak here
        test = null; // lose reference here
        Thread.sleep(1000);
        GC();
        System.out.println(b);
        while (true) {
        }
    }

    private static void GC() {
        Runtime.getRuntime().gc();
    }
}

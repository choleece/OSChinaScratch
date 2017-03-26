package cn.choleece.test;

/**
 * Created by choleece on 2017/3/25.
 */
public class TestStringMatch {
    public static void main(String[] args) {
        String test = "<section class=\"blog-brief text-gradient\">hahhah</section>";
        System.out.println(test.replaceAll("<section class=\"blog-brief text-gradient\">|</section>$", ""));

        String testStr = "<span>1分钟前</span>";

        String result = testStr.replaceAll("\\D", "");


        if (testStr.matches(".*分钟.*")) {
        } else {

        }
        System.out.println(testStr.matches(".*分钟.*") + " " + result);

    }
}

package algo.study.java.base.commons.data;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jetluo on 16/8/6.
 */
public class RegularExpressions {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\d");

        String text = "Apollo 13";
        String s1 = " For Brutus is an honourable man";
        Matcher matcher = p.matcher(text);
        System.out.println(matcher.find());
        System.out.println(matcher.group());
    }
}

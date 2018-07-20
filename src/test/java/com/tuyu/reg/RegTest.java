package com.tuyu.reg;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * ////////////////////////////////////////////////////////////////////
 * //                          _ooOoo_                               //
 * //                         o8888888o                              //
 * //                         88" . "88                              //
 * //                         (| ^_^ |)                              //
 * //                         O\  =  /O                              //
 * //                      ____/`---'\____                           //
 * //                    .'  \\|     |//  `.                         //
 * //                   /  \\|||  :  |||//  \                        //
 * //                  /  _||||| -:- |||||-  \                       //
 * //                  |   | \\\  -  /// |   |                       //
 * //                  | \_|  ''\---/''  |   |                       //
 * //                  \  .-\__  `-`  ___/-. /                       //
 * //                ___`. .'  /--.--\  `. . ___                     //
 * //              ."" '<  `.___\_<|>_/___.'  >'"".                  //
 * //            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
 * //            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
 * //      ========`-.____`-.___\_____/___.-`____.-'========         //
 * //                           `=---='                              //
 * //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
 * //             佛祖保佑       永无BUG     永不修改                   //
 * ////////////////////////////////////////////////////////////////////
 * </pre>
 * <p>
 * tuyu于7/10/18祈祷...
 * java 正则测试
 *
 * @author tuyu
 * @date 7/10/18
 * Stay Hungry, Stay Foolish.
 */
public class RegTest {

    @Test
    public void testReg() {

//        String str = "abc3443abcfgjhgabcgfjabc";
//        String rgex = "abc(.*?)abc";
        String str = "#{adb}ddd#{ac}";
        String rgex = "(#\\{(.+?)\\})";
        System.out.println(getSubUtil(str,rgex));
        System.out.println(getSubUtilSimple(str, rgex));

    }


    public static List<String> getSubUtil(String soap, String rgex){
        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        return list;
    }

    /**
     * 返回单个字符串，若匹配到多个的话就返回第一个，方法与getSubUtil一样
     * @param soap
     * @param rgex
     * @return
     */
    public static String getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            return m.group(1);
        }
        return "";
    }

    @Test
    public void test() {
        String text = "#{John} writes about this, and #{John} writes about that," + " and #{John} writes about everything. ";
        String patternString1 = "(#\\{(.*?)\\})";
        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);
//        String hello = matcher.replaceAll("HELLO");
//        System.out.println(hello);
        System.out.println("groupCount is -->" + matcher.groupCount());
        while (matcher.find()) {
            System.out.println("found: " + matcher.group(1));
            System.out.println("found: " + matcher.group(2));
        }
    }

    @Test
    public void testReplaceAll() {
        String target = "#{'‘a']}fsfs#{['b']}";
        String regex = "(#\\{(.+?)\\})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);
        String hello = matcher.replaceAll("HELLO");
        System.out.println(hello);
    }

    @Test
    public void testSubstring() {
        String target = "#{['a']}fsfs#{['b']}";
        String regex = "(#\\{(.+?)\\})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);
// 如果想获取xxx部分的字符串，group()方法需要传递2,如果是想获取整个匹配的字符串，group()方法需要传递1
        while(matcher.find()){
//            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
        matcher.reset();
        while(matcher.find()){
//            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }

    @Test
    public void testIndex() {
        String name = "#{['a']}";
        System.out.println(ensureRegex(name));
        System.out.println(name.replaceAll(ensureRegex(name), "aa"));

    }

    public String ensureRegex(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == '.' || c == '{' || c == '[' || c == ']' || c == '}') {
                stringBuilder.append('\\');
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    @Test
    public void testSplit() {
        String target = "#{'a']}fsfs#{['b']}";
        String regex = "(#\\{(.+?)\\})";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher(target) == pattern.matcher(target));

    }

    @Test
    public void testSub() {
//        String regEx = ".+(.+)$";
        String regEx = ".+(.+)$";
        String s = "c:\\test.txt";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(s);
        boolean rs = mat.find();
        for(int i=1;i<=mat.groupCount();i++){
            System.out.println(mat.group(i));
        }
    }

    @Test
    public void testTes() {

        String testStr = "12315<Test>show me</text>";
        Pattern p = Pattern.compile("<Test>(.*?)</text>");
        Matcher m = p.matcher(testStr);
        while(m.find()){
            System.out.println(m.group(1));
        }
    }

}

package com.tuyu.resourcebundle;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化<b>http://blog.51cto.com/lavasoft/184605</b>
 * @author tuyu
 * @date 9/30/18
 * Talk is cheap, show me the code.
 */
public class ResourceBundleTest {

    @Test
    public void test() {
        Locale locale1 = new Locale("zh", "CN");
        ResourceBundle resb1 = ResourceBundle.getBundle("myres", locale1);
        System.out.println(resb1.getString("aaa"));

        ResourceBundle resb2 = ResourceBundle.getBundle("myres", Locale.getDefault());
        System.out.println(resb1.getString("aaa"));

        Locale locale3 = new Locale("en", "US");
        ResourceBundle resb3 = ResourceBundle.getBundle("myres", locale3);
        System.out.println(resb3.getString("aaa"));
    }
}

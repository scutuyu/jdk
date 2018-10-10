package com.tuyu.autobox;

import java.util.Objects;

/**
 * @author tuyu
 * @date 10/10/18
 * Talk is cheap, show me the code.
 */
public class AutoBox {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 321L;
        Long i = 321L;
        // 缓存，同一对象
        System.out.printf("%20s %-5s\n", "c == d", c == d);
        // 没有缓存，不同对象
        System.out.printf("%20s %-5s\n", "e == f", e == f);
        // 自动装箱，缓存，同一对象
        System.out.printf("%20s %-5s\n", "c == (a + b)", c == (a + b));
        // 比较值，相等
        System.out.printf("%20s %-5s\n", "c.equals(a + b)", c.equals(a + b));
        // 自动装箱为Long类型，缓存，同一对象
        System.out.printf("%20s %-5s\n", "g == (a + b)", g == (a + b));
        // 比较值，自动装箱Integer, 不同对象，不相等
        System.out.printf("%20s %-5s\n", "g.equals(a + b + 0)", g.equals(a + b + 0));
        // 比较值，自动装箱Integer,强转后自动装箱Long，相等.
        System.out.printf("%20s %-5s\n", "g.equals(a + b + 0L)", g.equals(a + b + 0L));
        // 没有缓存，不同对象
        System.out.printf("%20s %-5s\n", "h == i", h == i);
        // 自动装箱Integer,强转后自动装箱Long，缓存，同一对象
        System.out.printf("%20s %-5s\n", "g == (1 + 2)", g == (1 + 2));
        System.out.printf("%20s %-5s\n", "g == (1 + 2L)", g == (1 + 2L));
        System.out.printf("%20s %-5s\n", "h == (1 + 322L)", h == (1 + 322L));
        System.out.println(h.longValue() == 322);
        System.out.println(h.longValue() == 322L);
        System.out.println(h.longValue() == i.longValue());
        long l1 = 20L;
        long l2 = 20L;
        System.out.println(l1 == 20L);

        // 反编译之后的代码
//        Integer a = Integer.valueOf(1);
//        Integer b = Integer.valueOf(2);
//        Integer c = Integer.valueOf(3);
//        Integer d = Integer.valueOf(3);
//        Integer e = Integer.valueOf(321);
//        Integer f = Integer.valueOf(321);
//        Long g = Long.valueOf(3L);
//        Long h = Long.valueOf(321L);
//        Long i = Long.valueOf(321L);
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "c == d", Boolean.valueOf(c == d)
//        });
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "e == f", Boolean.valueOf(e == f)
//        });
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "c == (a + b)", Boolean.valueOf(c.intValue() == a.intValue() + b.intValue())
//        });
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "c.equals(a + b)", Boolean.valueOf(c.equals(Integer.valueOf(a.intValue() + b.intValue())))
//        });
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "g == (a + b)", Boolean.valueOf(g.longValue() == (long)(a.intValue() + b.intValue()))
//        });
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "g.equals(a + b + 0)", Boolean.valueOf(g.equals(Integer.valueOf(a.intValue() + b.intValue() + 0)))
//        });
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "g.equals(a + b + 0L)", Boolean.valueOf(g.equals(Long.valueOf((long)(a.intValue() + b.intValue()) + 0L)))
//        });
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "h == i", Boolean.valueOf(h == i)
//        });
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "g == (1 + 2)", Boolean.valueOf(g.longValue() == 3L)
//        });
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "g == (1 + 2L)", Boolean.valueOf(g.longValue() == 3L)
//        });
//        System.out.printf("%20s %-5s\n", new Object[] {
//                "h == (1 + 322L)", Boolean.valueOf(h.longValue() == 323L)
//        });

    }

    public void testString() {
        String a = "a";
        String b = "b";
        String c = "c";
        String ab = "a" + "b";
        String ab1 = a + "b";
        String abc = "a" + "b" + "c";
        String bc1 = b + "c";
        System.out.println(bc1 == "bc");
        System.out.println(Objects.toString(bc1));
    }

    public void testInt() {
        int a = 1 + 2;
        Integer b = 1 + 2;
        Integer c = a + b;
        Integer d = a + a;
        Integer e = a + a + 1 + 2;
        int f = a + a;
        int g = a + 1 + 2;
    }

    public void test() {
        Object o = new Object();
        Object o1 = new Object();
        System.out.println(o == o1);
    }
}

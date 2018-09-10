package com.tuyu.enums;

/**
 * <p>使用jad -p com.tuyu.enums.AreaEnum反编译之后的代码如下：</p>
 * <pre>
 *      // Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
 *      // Jad home page: http://www.kpdus.com/jad.html
 *      // Decompiler options: packimports(3)
 *      // Source File Name:   AreaEnum.java
 *
 *      package com.tuyu.enums;
 *
 *      import java.io.PrintStream;
 *
 *      public final class AreaEnum extends Enum
 *      {
 *
 *          public static AreaEnum[] values()
 *          {
 *              return (AreaEnum[])$VALUES.clone();
 *          }
 *
 *          public static AreaEnum valueOf(String name)
 *          {
 *              return (AreaEnum)Enum.valueOf(com/tuyu/enums/AreaEnum, name);
 *          }
 *
 *          private AreaEnum(String s, int i, String name, int ordinal)
 *          {
 *              super(s, i);
 *              this.name = name;
 *              this.ordinal = ordinal;
 *          }
 *
 *          public String getName()
 *          {
 *              return name;
 *          }
 *
 *          public void setName(String name)
 *          {
 *              this.name = name;
 *          }
 *
 *          public int getOrdinal()
 *          {
 *              return ordinal;
 *          }
 *
 *          public void setOrdinal(int ordinal)
 *          {
 *              this.ordinal = ordinal;
 *          }
 *
 *          public static void main(String args[])
 *          {
 *              System.out.println(CQ.ordinal);
 *              System.out.println(CQ);
 *              AreaEnum ae = CQ;
 *              Enum e = ae;
 *              System.out.println(e.name());
 *          }
 *
 *          public static final AreaEnum HZ;
 *          public static final AreaEnum CQ;
 *          private String name;
 *          private int ordinal;
 *          private static final AreaEnum $VALUES[];
 *
 *          static
 *          {
 *              HZ = new AreaEnum("HZ", 0, "hangzhou", 1);
 *              CQ = new AreaEnum("CQ", 1, "chongqing", 2);
 *              $VALUES = (new AreaEnum[] {
 *                  HZ, CQ
 *              });
 *          }
 *      }
 * </pre>
 * @author tuyu
 * @date 9/10/18
 * Talk is cheap, show me the code.
 */
public enum AreaEnum {
    HZ("hangzhou", 1),
    CQ("chongqing", 2)
    ;

    /**
     * 每个枚举类都默认继承java.lang.Enum抽象类，
     * 而Enum类定义了一个私有的name实例字段，和私有的ordinal实例字段，
     * 当自定义的枚举也定义一个name实例字段和ordinal实例字段时，
     */


    private final String name;
    private final int ordinal;

    AreaEnum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public String getName() {
        return name;
    }

    public int getOrdinal() {
        return ordinal;
    }


    public static void main(String[] args) {
        System.out.println(AreaEnum.CQ.getOrdinal()); // 2，返回子类AreaEnum的ordinal
        System.out.println(AreaEnum.CQ.getName()); // chongqing，返回子类AreaEnum的name
        System.out.println(AreaEnum.CQ); //CQ，因为toString()返回的是Enum的name
        AreaEnum ae = AreaEnum.CQ;
        // Enum的name()和ordinal()方法不能被重写，都是final方法
        System.out.println(ae.name()); // CQ，返回Enum的name
        System.out.println(ae.ordinal()); // 1，返回Enum的ordinal
        Enum e = ae;
        System.out.println(e.name()); // CQ
        System.out.println(e.ordinal()); // 1
    }
}
package com.tuyu.proxygenerator;

import lombok.Data;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author tuyu
 * @date 10/16/18
 * Talk is cheap, show me the code.
 */
public class AutoProxy {

    @Data
    static class User {
        private Integer id;

        private String name;

        private String address;
    }

    interface UserService {
        int deleteByPrimaryKey(Integer id);

        int insert(User record);

        int insertSelective(User record);

        User selectByPrimaryKey(Integer id);

        int updateByPrimaryKeySelective(User record);

        int updateByPrimaryKey(User record);
    }

    public static void main(String[] args) throws IOException {
        Class[] arr = {UserService.class};
        byte[] bytes = ProxyGenerator.generateProxyClass("$TUYU", arr);
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/auto_proxy.class");
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}

// 下面是src/test/resources/auto_proxy.class反编译后的代码

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)

//import java.lang.reflect.*;
//
//public final class $TUYU extends Proxy
//        implements com.tuyu.proxygenerator.AutoProxy.UserService
//{
//
//    public $TUYU(InvocationHandler invocationhandler)
//    {
//        super(invocationhandler);
//    }
//
//    Overlapped try statements detected. Not all exception handlers will be resolved in the method equals
//    public final boolean equals(Object obj)
//    {
//        try
//        {
//            return ((Boolean)super.h.invoke(this, m1, new Object[] {
//                    obj
//            })).booleanValue();
//        }
//        catch(Error _ex) { }
//        catch(Throwable throwable)
//        {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    Overlapped try statements detected. Not all exception handlers will be resolved in the method selectByPrimaryKey
//    public final com.tuyu.proxygenerator.AutoProxy.User selectByPrimaryKey(Integer integer)
//    {
//        try
//        {
//            return (com.tuyu.proxygenerator.AutoProxy.User)super.h.invoke(this, m6, new Object[] {
//                    integer
//            });
//        }
//        catch(Error _ex) { }
//        catch(Throwable throwable)
//        {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    Overlapped try statements detected. Not all exception handlers will be resolved in the method updateByPrimaryKeySelective
//    public final int updateByPrimaryKeySelective(com.tuyu.proxygenerator.AutoProxy.User user)
//    {
//        try
//        {
//            return ((Integer)super.h.invoke(this, m7, new Object[] {
//                    user
//            })).intValue();
//        }
//        catch(Error _ex) { }
//        catch(Throwable throwable)
//        {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    Overlapped try statements detected. Not all exception handlers will be resolved in the method toString
//    public final String toString()
//    {
//        try
//        {
//            return (String)super.h.invoke(this, m2, null);
//        }
//        catch(Error _ex) { }
//        catch(Throwable throwable)
//        {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    Overlapped try statements detected. Not all exception handlers will be resolved in the method updateByPrimaryKey
//    public final int updateByPrimaryKey(com.tuyu.proxygenerator.AutoProxy.User user)
//    {
//        try
//        {
//            return ((Integer)super.h.invoke(this, m8, new Object[] {
//                    user
//            })).intValue();
//        }
//        catch(Error _ex) { }
//        catch(Throwable throwable)
//        {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    Overlapped try statements detected. Not all exception handlers will be resolved in the method deleteByPrimaryKey
//    public final int deleteByPrimaryKey(Integer integer)
//    {
//        try
//        {
//            return ((Integer)super.h.invoke(this, m4, new Object[] {
//                    integer
//            })).intValue();
//        }
//        catch(Error _ex) { }
//        catch(Throwable throwable)
//        {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    Overlapped try statements detected. Not all exception handlers will be resolved in the method insert
//    public final int insert(com.tuyu.proxygenerator.AutoProxy.User user)
//    {
//        try
//        {
//            return ((Integer)super.h.invoke(this, m3, new Object[] {
//                    user
//            })).intValue();
//        }
//        catch(Error _ex) { }
//        catch(Throwable throwable)
//        {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    Overlapped try statements detected. Not all exception handlers will be resolved in the method insertSelective
//    public final int insertSelective(com.tuyu.proxygenerator.AutoProxy.User user)
//    {
//        try
//        {
//            return ((Integer)super.h.invoke(this, m5, new Object[] {
//                    user
//            })).intValue();
//        }
//        catch(Error _ex) { }
//        catch(Throwable throwable)
//        {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    Overlapped try statements detected. Not all exception handlers will be resolved in the method hashCode
//    public final int hashCode()
//    {
//        try
//        {
//            return ((Integer)super.h.invoke(this, m0, null)).intValue();
//        }
//        catch(Error _ex) { }
//        catch(Throwable throwable)
//        {
//            throw new UndeclaredThrowableException(throwable);
//        }
//    }
//
//    private static Method m1;
//    private static Method m6;
//    private static Method m7;
//    private static Method m2;
//    private static Method m8;
//    private static Method m4;
//    private static Method m3;
//    private static Method m5;
//    private static Method m0;
//
//    static
//    {
//        try
//        {
//            m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[] {
//                    Class.forName("java.lang.Object")
//            });
//            m6 = Class.forName("com.tuyu.proxygenerator.AutoProxy$UserService").getMethod("selectByPrimaryKey", new Class[] {
//                    Class.forName("java.lang.Integer")
//            });
//            m7 = Class.forName("com.tuyu.proxygenerator.AutoProxy$UserService").getMethod("updateByPrimaryKeySelective", new Class[] {
//                    Class.forName("com.tuyu.proxygenerator.AutoProxy$User")
//            });
//            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
//            m8 = Class.forName("com.tuyu.proxygenerator.AutoProxy$UserService").getMethod("updateByPrimaryKey", new Class[] {
//                    Class.forName("com.tuyu.proxygenerator.AutoProxy$User")
//            });
//            m4 = Class.forName("com.tuyu.proxygenerator.AutoProxy$UserService").getMethod("deleteByPrimaryKey", new Class[] {
//                    Class.forName("java.lang.Integer")
//            });
//            m3 = Class.forName("com.tuyu.proxygenerator.AutoProxy$UserService").getMethod("insert", new Class[] {
//                    Class.forName("com.tuyu.proxygenerator.AutoProxy$User")
//            });
//            m5 = Class.forName("com.tuyu.proxygenerator.AutoProxy$UserService").getMethod("insertSelective", new Class[] {
//                    Class.forName("com.tuyu.proxygenerator.AutoProxy$User")
//            });
//            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
//        }
//        catch(NoSuchMethodException nosuchmethodexception)
//        {
//            throw new NoSuchMethodError(nosuchmethodexception.getMessage());
//        }
//        catch(ClassNotFoundException classnotfoundexception)
//        {
//            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
//        }
//    }
//}


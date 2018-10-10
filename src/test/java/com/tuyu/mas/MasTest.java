package com.tuyu.mas;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 云MAS测试短信发送
 * @author tuyu
 * @date 10/8/18
 * Talk is cheap, show me the code.
 */
public class MasTest {

    @Test
    public void testSendMsg() {
        Mas mas = new ZSMas();
        mas.send("18983117636", "hello world");
    }

}

interface Mas{

    /**
     * 发送短信
     * @param phone 电话号码
     * @param content 内容
     * @return 返回结果
     */
    String send(String phone, String content);
}

class ZSMas implements Mas {

    @Override
    public String send(String phone, String content) {
        return null;
    }
}

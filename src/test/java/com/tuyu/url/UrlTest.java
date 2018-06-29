package com.tuyu.url;

import com.tuyu.resource.ResourceUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

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
 * tuyu于6/8/18祈祷...
 * 发送HTTP请求，并获取响应头字段
 * @author tuyu
 * @date 6/8/18
 * Stay Hungry, Stay Foolish.
 */
public class UrlTest {
    @Test
    public void testUrlHeader() throws Exception {
        String urlName = "http://horstmann.com";
        URL url = new URL(urlName);
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();

        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            String key = entry.getKey();
            for (String v : entry.getValue()) {
                System.out.println("key = " + key + ", value = " + v);
            }
        }

        // 快捷方式获取请求头
        System.out.println("-----------");
        System.out.println("getContenType : " + urlConnection.getContentType());
        System.out.println("getContentLength : " + urlConnection.getContentLength());
        System.out.println("getContentEncoding : " + urlConnection.getContentEncoding());
        System.out.println("getDate : " + urlConnection.getDate());
        System.out.println("getExpiration : " + urlConnection.getExpiration());
        System.out.println("getLastModified : " + urlConnection.getLastModified());
        System.out.println("-----------");

        // 读取请求资源的前10行
        Scanner scanner = new Scanner(urlConnection.getInputStream());
        int  i = 0;
        while (i < 10 && scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(s);
            i++;
        }
        scanner.close();
    }

    /**
     * 发送post请求
     */
    @Test
    public void testPost() throws IOException {
//        String urlName = "http://esa.un.org/unpd/wpp/unpp/p2k0data_script.asp";
        String urlName = "http://10.12.102.134:7080/dcm-web/caseApi/addCase.json";
        Properties properties = new Properties();
        InputStream resources = ResourceUtil.getResourceFromPackagePath(UrlTest.class, "prop1.properties");
        properties.load(resources);
        String s = doPost(urlName, properties);
        System.out.println(s);
    }

    private String doPost(String urlName, Map<Object, Object> map) throws IOException {
        URL url = new URL(urlName);
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.connect();

        OutputStream outputStream = urlConnection.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        boolean first = true;
        for (Map.Entry entry : map.entrySet()) {
            if (first) {
                first = false;
            } else {
                printWriter.print("&");
            }
            printWriter.print(entry.getKey());
            printWriter.print("=");
            printWriter.print(URLEncoder.encode(entry.getValue().toString(), "utf-8"));
        }
        printWriter.flush();
        printWriter.close();

        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(urlConnection.getInputStream());
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                stringBuilder.append(s)
                        .append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            throw e;
//            if (!(urlConnection instanceof HttpURLConnection)) {
//                throw e;
//            }
//            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
//            InputStream errorStream = httpURLConnection.getErrorStream();
//            Scanner scanner = new Scanner(errorStream);
//            while (scanner.hasNextLine()) {
//                stringBuilder.append(scanner.nextLine())
//                        .append("\n");
//            }
//            scanner.close();
        }

        return stringBuilder.toString();
    }
}

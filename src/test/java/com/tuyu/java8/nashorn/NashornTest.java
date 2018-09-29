package com.tuyu.java8.nashorn;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * java8新特性，js引擎，nashorn
 *
 * @author tuyu
 * @date 9/28/18
 * Talk is cheap, show me the code.
 */
public class NashornTest {

    @Test
    public void testNashorn() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        // jdk.nashorn.api.scripting.NashornScriptEngine
        System.out.println(engine.getClass().getName());
        String js = "function f(){return 1;}; f() +1;";
        System.out.println("result: " + engine.eval(js));
    }
}

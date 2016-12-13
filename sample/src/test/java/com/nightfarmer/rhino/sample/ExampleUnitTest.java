package com.nightfarmer.rhino.sample;


import org.junit.Test;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testF() {
        Context jsCtx = Context.enter();
        ScriptableObject scope = jsCtx.initStandardObjects();
        jsCtx.evaluateString(scope,
                "function setName(p){testName=p;return '真有意思'}", null, 1, null);
        Object setName = scope.get("setName");

        if (!(setName instanceof Function)) {
            System.out.println("test is undefined or not a function.");
        } else {
            Object testArgs[] = {"张三"};
            Function test = (Function) setName;
            Object result = test.call(jsCtx, scope, scope, testArgs);
            System.out.println(Context.toString(result));
        }
        Object name = scope.get("testName");
        System.out.println(name);
    }
}
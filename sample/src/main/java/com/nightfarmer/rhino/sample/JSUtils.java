package com.nightfarmer.rhino.sample;

import com.nightfarmer.rhino.JsFileUtils;

import org.jetbrains.annotations.Nullable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

/**
 * Created by zhangfan on 2016/12/13 0013.
 */

public class JSUtils {

    public static void initAndroidContext(Context jsContext, android.content.Context context, Scriptable scope) {
        jsContext.setOptimizationLevel(-1);
        String jsFile = JsFileUtils.loadAssets(context, "Base.js");
        jsContext.evaluateString(scope, jsFile, null, 0, null);
        jsFile = JsFileUtils.loadAssets(context, "Common.js");
        jsContext.evaluateString(scope, jsFile, null, 0, null);
        callFunc(jsContext, scope, "initAndroidContext", context);
    }

    public static Object callFunc(Context jsContext, Scriptable scope, String functionName, Object... args) {
        Object functionObject = scope.get(functionName, scope);
        if (!(functionObject instanceof Function)) {
            System.out.println("" + functionName + " is undefined or not a function.");
        } else {
            Function function = (Function) functionObject;
            return function.call(jsContext, scope, scope, args);
        }
        return null;
    }


    @Nullable
    public static String wrapPackages(@Nullable String jsFile) {
        if (jsFile == null) {
            jsFile = "";
        }
        return "with (BasePackages) { with (AppPackages) { " + jsFile + " }}";
    }
}

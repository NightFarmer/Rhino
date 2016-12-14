package com.nightfarmer.rhino.sample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast

import com.nightfarmer.rhino.JsFileUtils
import org.mozilla.javascript.Context

import org.mozilla.javascript.ScriptableObject


class MainActivity : AppCompatActivity() {

    private var jsCtx: Context? = null

    private var scope: ScriptableObject? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jsCtx = org.mozilla.javascript.Context.enter()
        scope = jsCtx?.initStandardObjects()
        JSUtils.initAndroidContext(jsCtx, this, scope)


        var jsFile = JsFileUtils.loadAssets(this, "${javaClass.simpleName}.js")
        jsFile = JSUtils.wrapPackages(jsFile)
        jsCtx?.evaluateString(scope, jsFile, null, 0, null)
        JSUtils.callFunc(jsCtx, scope, "onCreate", savedInstanceState)

//        val str = "        new JavaAdapter(com.nightfarmer.rhino.sample.AAA, {                hehe:function(){}        })"
//        val jsCtx2 = Context.enter()
//        val scope2 = jsCtx.initStandardObjects()
//        jsCtx2.setOptimizationLevel(-1)
//        jsCtx2.evaluateString(scope2, str, null, 0, null)

//        val str = "        new com.nightfarmer.rhino.sample.AAA( {                       })"
//        val jsCtx2 = Context.enter()
//        val scope2 = jsCtx.initStandardObjects()
//                jsCtx2.setOptimizationLevel(-1)
//        jsCtx2.evaluateString(scope2, str, null, 0, null)

    }

    val aaaa = "aaaaccc"

    fun abcd(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        JSUtils.callFunc(jsCtx, scope, "onResume")
    }
}

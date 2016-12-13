package com.nightfarmer.rhino.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast

import com.nightfarmer.rhino.JsFileUtils

import org.mozilla.javascript.ScriptableObject


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jsCtx = org.mozilla.javascript.Context.enter()
        val scope = jsCtx.initStandardObjects()
        JSUtils.initAndroidContext(jsCtx, this, scope)

        val jsFile = JsFileUtils.loadAssets(this, "MainActivity.js")
        jsCtx.evaluateString(scope, jsFile, null, 0, null)
        JSUtils.callFunc(jsCtx, scope, "onCreate")

        findViewById(R.id.button1)

    }

    val aaaa = "aaaaccc"

    fun abcd(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}

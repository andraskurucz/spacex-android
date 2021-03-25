package com.akurucz.spacex

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner
import com.facebook.testing.screenshot.ScreenshotRunner

//import com.facebook.litho.config.ComponentsConfiguration
//import com.facebook.testing.screenshot.ScreenshotRunner
//import com.facebook.testing.screenshot.layouthierarchy.LayoutHierarchyDumper
//import com.facebook.testing.screenshot.layouthierarchy.litho.LithoAttributePlugin
//import com.facebook.testing.screenshot.layouthierarchy.litho.LithoHierarchyPlugin

class ScreenshotTestRunner : AndroidJUnitRunner() {

    override fun onCreate(arguments: Bundle) {
        ScreenshotRunner.onCreate(this, arguments)
        super.onCreate(arguments)
    }

    override fun finish(resultCode: Int, results: Bundle) {
        ScreenshotRunner.onDestroy()
        super.finish(resultCode, results)
    }
}
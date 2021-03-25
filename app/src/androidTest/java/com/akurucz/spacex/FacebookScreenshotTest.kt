package com.akurucz.spacex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.facebook.testing.screenshot.Screenshot
import com.facebook.testing.screenshot.ViewHelpers
import kotlinx.android.synthetic.main.fragment_launch_detail.view.*
import kotlinx.android.synthetic.main.launch_item.view.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FacebookScreenshotTest {

    private lateinit var layoutInflater: LayoutInflater

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        layoutInflater = LayoutInflater.from(context)
    }

    @Test
    fun launchListItem() {

        val view: View = layoutInflater.inflate(R.layout.launch_item, null, false)

//        view.name.text = "Name"
//        view.content.text = "Content"

        ViewHelpers.setupView(view)
            .setExactWidthDp(300)
            .layout()

        Screenshot.snap(view)
            .record()
    }
}
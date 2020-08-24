package fr.jhandguy.swiftkotlination.coordinator

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import fr.jhandguy.story.model.Story
import fr.jhandguy.story.view.StoryActivity
import fr.jhandguy.swiftkotlination.view.MainActivity
import fr.jhandguy.topstories.view.TopStoriesActivity
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import org.robolectric.annotation.LooperMode.Mode.PAUSED
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
@LooperMode(PAUSED)
class CoordinatorUnitTest {

    lateinit var sut: Coordinator

    @BeforeTest
    fun setup() {
        val scenario = ActivityScenario.launch(MainActivity::class.java)
        scenario.onActivity {
            sut = Coordinator(it)
        }
    }

    @Test
    fun `top stories activity is started correctly`() {
        val intent = sut.start()
        assertEquals(intent.component?.className, TopStoriesActivity::class.java.name)
    }

    @Test
    fun `story activity is started correctly`() {
        val story = Story()
        val intent = sut.open(story)
        assertEquals(intent.component?.className, StoryActivity::class.java.name)
    }

    @Test
    fun `url is opened correctly`() {
        val url = "https://url.com"
        val intent = sut.open(url)
        assertEquals(intent.action, Intent.ACTION_VIEW)
        assertEquals(intent.dataString, url)
    }

    @Test
    fun `activity is finished correctly`() {
        sut.finish()
        assert(sut.activity.isFinishing)
    }
}

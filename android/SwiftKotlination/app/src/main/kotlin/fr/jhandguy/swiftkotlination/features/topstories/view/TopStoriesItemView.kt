package fr.jhandguy.swiftkotlination.features.topstories.view

import android.content.Context
import android.graphics.Typeface.DEFAULT_BOLD
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import fr.jhandguy.swiftkotlination.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

class TopStoriesItemView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        return constraintLayout {
            padding = dip(8)
            lparams(width = matchParent, height = wrapContent)

            textView {
                textColorResource = R.color.primary_text
                textSize = sp(6).toFloat()
                typeface = DEFAULT_BOLD
                id = R.id.top_stories_item_title
            }.lparams(width = 0, height = wrapContent) {
                leftToLeft = ConstraintSet.PARENT_ID
                topToTop = ConstraintSet.PARENT_ID
                rightToRight = ConstraintSet.PARENT_ID
            }

            textView {
                textColorResource = R.color.secondary_text
                textSize = sp(5).toFloat()
                lines = 1
                id = R.id.top_stories_item_byline
            }.lparams(width = 0, height = wrapContent) {
                leftToLeft = ConstraintSet.PARENT_ID
                topToBottom = R.id.top_stories_item_title
                bottomToBottom = ConstraintSet.PARENT_ID
                rightToRight = ConstraintSet.PARENT_ID
                topMargin = dip(6)
            }
        }
    }
}
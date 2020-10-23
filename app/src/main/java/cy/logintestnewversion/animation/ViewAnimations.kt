package cy.logintestnewversion.animation

import android.view.View
import android.widget.LinearLayout
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import java.util.*

class ViewAnimations {
    var viewList: MutableList<View> = ArrayList()
    fun openContainerAnimation(view: View?) {
        YoYo.with(Techniques.FadeInUp)
                .duration(800)
                .delay(200)
                .playOn(view)
    }

    fun openChildAnimation(ll: LinearLayout) {
        val childCount = ll.childCount
        for (i in 0 until childCount) {
            val v = ll.getChildAt(i)
            viewList.add(v)
        }
        var delay = 200
        val duration = 1000
        if (viewList.size == 0) {
            return
        }
        for (view in viewList) {
            first(view)
            delay = delay + 250
            YoYo.with(Techniques.FadeIn)
                    .duration(duration.toLong())
                    .delay(delay.toLong())
                    .playOn(view)
        }
    }

    private fun first(view: View) {
        YoYo.with(Techniques.FadeOut)
                .duration(5)
                .playOn(view)
    }
}
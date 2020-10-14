package com.myapp.socialmedia.myapp.constraintdesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.BounceInterpolator
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
        private var isDetailLayout = false

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            constraintLayout.setOnClickListener {
                if (isDetailLayout)
                // switch to default layout
                swapFrames(R.layout.activity_main)
                else
                // switch to detail layout
                swapFrames(R.layout.activity_details)
            }
        }
        private fun swapFrames(layoutId: Int) {
            val constraintSet= ConstraintSet()
            //child constraint of new layout to replace old one
            constraintSet.clone(this, layoutId)


            val transition = ChangeBounds()
            //interpolator changes the value of the object after sometime
            transition.interpolator= BounceInterpolator()
            transition.duration=1500


                    //transaction mngr. class will help transctn on root layout
            TransitionManager.beginDelayedTransition(constraintLayout)
            //apply new constraint to root layout
            constraintSet.applyTo(constraintLayout)
            //boolean value when user tap on screen layout can be switch back and forth
            isDetailLayout= !isDetailLayout

    }
}
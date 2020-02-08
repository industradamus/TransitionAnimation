package com.wispcoolwisp.transitionanimation

import android.os.Bundle
import android.transition.Fade
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(), FragmentInterractor {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            openFragment(ListFragment())
        }
    }

    override fun openDetails(item: MenuItem, view: View) {
        val fragment = DetailsFragment.newInstance(item).apply {
            sharedElementEnterTransition = DetailsTransition(this@MainActivity)
            enterTransition = Fade()
            sharedElementReturnTransition = DetailsTransition(this@MainActivity)
        }
        openDetails(view, fragment)
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun openDetails(view: View, fragment: DetailsFragment) {
        supportFragmentManager
            .beginTransaction()
            .addSharedElement(view, SHARED_VIEW)
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {

        private const val SHARED_VIEW = "shared_view"
    }
}

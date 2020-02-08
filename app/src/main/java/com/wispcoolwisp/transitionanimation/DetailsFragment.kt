package com.wispcoolwisp.transitionanimation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.lsit_item.*

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView()
    }

    private fun setView() {
        arguments?.let {
            image.setBackgroundColor(it.getInt(ARG_COLOR))
            image.text = it.getString(ARG_TITLE)
        }
    }

    companion object {

        private const val ARG_COLOR = "arg_color"
        private const val ARG_TITLE = "arg_title"

        fun newInstance(item: MenuItem): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()

            args.putInt(ARG_COLOR, item.color)
            args.putString(ARG_TITLE, item.title)
            fragment.arguments = args
            return fragment
        }
    }
}

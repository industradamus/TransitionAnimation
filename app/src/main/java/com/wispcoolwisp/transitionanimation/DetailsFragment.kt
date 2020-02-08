package com.wispcoolwisp.transitionanimation

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.lsit_item.*

class DetailsFragment : Fragment(), OnItemClickListener {

    private val adapter = MenuAdapter(this)
    private var selected: Model =
        Model(R.string.animation_slide_from_right, R.anim.layout_animation_from_right)


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
        initRecycler()
    }

    private fun initRecycler() {
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(context)
        adapter.update(generateData())
        runLayoutAnimation(selected)
    }

    private fun setView() {
        arguments?.let {
            image.setBackgroundColor(it.getInt(ARG_COLOR))
            image.text = it.getString(ARG_TITLE)
        }
    }

    private fun generateData() = listOf(
        MenuItem(Color.RED, "RED COLOR"),
        MenuItem(Color.GREEN, "GREEN COLOR"),
        MenuItem(Color.BLUE, "BLUE COLOR"),
        MenuItem(Color.LTGRAY, "LTGRAY COLOR"),
        MenuItem(Color.CYAN, "CYAN COLOR"),
        MenuItem(Color.MAGENTA, "MAGENTA COLOR"),
        MenuItem(Color.YELLOW, "YELLOW COLOR")
    )

    private fun runLayoutAnimation(model: Model) = recycler_view.apply {
        layoutAnimation = AnimationUtils.loadLayoutAnimation(context, model.resourceId)
        adapter?.notifyDataSetChanged()
        scheduleLayoutAnimation()
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

    override fun onItemClicked(view: View, item: MenuItem) {
        Toast.makeText(requireContext(), "Item ${item.title} clicked", Toast.LENGTH_SHORT).show()
    }
}

package com.wispcoolwisp.transitionanimation

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment(), OnItemClickListener {

    private var interractor: FragmentInterractor? = null
    private val adapter = MenuAdapter(this)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is FragmentInterractor)
            interractor = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(context)
        adapter.update(generateData())
    }

    override fun onItemClicked(view: View, item: MenuItem) {
        exitTransition = Fade()

        interractor?.openDetails(item, view)
    }

    private fun generateData() = listOf(
        MenuItem(Color.RED, "RED COLOR"),
        MenuItem(Color.GREEN, "GREEN COLOR"),
        MenuItem(Color.BLUE, "BLUE COLOR"),
        MenuItem(Color.WHITE, "WHITE COLOR"),
        MenuItem(Color.CYAN, "CYAN COLOR"),
        MenuItem(Color.MAGENTA, "MAGENTA COLOR"),
        MenuItem(Color.YELLOW, "YELLOW COLOR")
    )
}

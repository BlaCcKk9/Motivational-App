package com.example.motivationalapp


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.motivationalapp.controller.QuoteData
import kotlinx.android.synthetic.main.fragment_quote.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class QuoteFragment : Fragment() {

    @SuppressLint("ResourceType")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_quote, container, false)

        val quoteText = view.findViewById<TextView>(R.id.quoteText)
        val byAuthor = view.findViewById<TextView>(R.id.byAuthor)

        quoteText.text = arguments!!.getString("quote").toString()
        byAuthor.text = arguments!!.getString("name").toString()


        return view

    }

    companion object {
        fun newInstance(name: String, quote: String): QuoteFragment{
            val fragment = QuoteFragment()
            val bundle = Bundle()

            bundle.putString("quote", quote)
            bundle.putString("name", name)
            fragment.arguments = bundle

            return fragment

        }
    }





}

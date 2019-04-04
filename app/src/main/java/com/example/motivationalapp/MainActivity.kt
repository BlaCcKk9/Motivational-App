package com.example.motivationalapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.motivationalapp.controller.IQuoteListAsyncResponse
import com.example.motivationalapp.controller.QuoteData
import com.example.motivationalapp.controller.QuoteViewPagerAdapter
import com.example.motivationalapp.model.Quote
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_quote.*

class MainActivity : AppCompatActivity() {

    lateinit var quoteViewPagerAdapter: QuoteViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        quoteViewPagerAdapter = QuoteViewPagerAdapter(supportFragmentManager, getFragment())
        viewPager.adapter = quoteViewPagerAdapter


    }

    private fun getFragment() : ArrayList<QuoteFragment>{
        val fragmentList = ArrayList<QuoteFragment>()
        QuoteData().getQuotes(object: IQuoteListAsyncResponse{
            override fun processFinished(quotes: ArrayList<Quote>) {
                (0 until quotes.size).mapTo(fragmentList) {
                    QuoteFragment.newInstance(
                        quotes.get(it).name,
                        quotes.get(it).quote
                    )
                }
                quoteViewPagerAdapter.notifyDataSetChanged()
            }

        })
        return fragmentList
    }

}

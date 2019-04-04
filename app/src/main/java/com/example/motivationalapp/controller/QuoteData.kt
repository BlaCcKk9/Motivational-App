package com.example.motivationalapp.controller

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.buildappswithpaulo.motivationalapp.controller.AppController
import com.example.motivationalapp.model.Quote
import org.json.JSONArray
import org.json.JSONException

class QuoteData {
     private var quoteArrayList =  ArrayList<Quote>()

    fun getQuotes(callback: IQuoteListAsyncResponse){
        val url : String = "https://gist.githubusercontent.com/dmakk767/9375ff01aff76f1788aead1df9a66338/raw/491f8c2e91b7d3b8f1c8230e32d9c9bc1a1adfa6/Quotes.json%2520"

        val quoteRequest = JsonArrayRequest(
            Request.Method.GET, url,
            Response.Listener {
                    response: JSONArray ->
                try {
                    for(item in 0 until response.length()){
                        val quoteObject = response.getJSONObject(item)
                        val quote = Quote(quoteObject.getString("quote"), quoteObject.getString("name"))
                        Log.d("Informaton->>>", quote.name)
                        quoteArrayList.add(quote)
                    }


                }catch(e: JSONException){
                    e.printStackTrace()
                }

                if(null != callback)
                    callback.processFinished(quoteArrayList)

            },
            Response.ErrorListener {
                    error: VolleyError? ->
                try {
                    Log.d("Error->>>", error.toString())
                }catch(e: JSONException){
                    e.printStackTrace()
                }
            })

        AppController.instance!!.addToRequestQueue(quoteRequest)
    }
}



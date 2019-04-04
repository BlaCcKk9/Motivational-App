package com.example.motivationalapp.controller

import com.example.motivationalapp.model.Quote

interface IQuoteListAsyncResponse {
    fun processFinished(quotes: ArrayList<Quote>)
}
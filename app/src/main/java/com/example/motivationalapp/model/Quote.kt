package com.example.motivationalapp.model

import com.google.gson.annotations.SerializedName

data class Quote (
    @SerializedName("quote")var quote: String,
    @SerializedName("name")var name: String
)

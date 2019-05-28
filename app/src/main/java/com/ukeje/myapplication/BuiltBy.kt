package com.ukeje.myapplication

import com.google.gson.annotations.SerializedName

/**
 * @author .: Ukeje Emeka
 * @email ..: ukejee3@gmail.com
 * @created : 5/27/19
 */

data class BuiltBy (

    @SerializedName("username") val username : String,
    @SerializedName("href") val href : String,
    @SerializedName("avatar") val avatar : String
)
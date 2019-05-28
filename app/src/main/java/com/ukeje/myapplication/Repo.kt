package com.ukeje.myapplication

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author .: Ukeje Emeka
 * @email ..: ukejee3@gmail.com
 * @created : 5/27/19
 */


data class Repo (

    @SerializedName("author") val author : String,
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String,
    @SerializedName("description") val description : String,
    @SerializedName("stars") val stars : Int,
    @SerializedName("forks") val forks : Int,
    @SerializedName("currentPeriodStars") val currentPeriodStars : Int,
    @SerializedName("builtBy") val builtBy : List<BuiltBy>
)
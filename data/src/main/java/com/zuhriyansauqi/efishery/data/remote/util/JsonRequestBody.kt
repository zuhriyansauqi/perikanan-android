package com.zuhriyansauqi.efishery.data.remote.util

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject

fun createJsonRequestBody(vararg params: Pair<String, Any>) =
  JSONObject(mapOf(*params)).toString()
    .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

fun createJsonRequestBody(vararg params: JSONObject): RequestBody =
  JSONArray(params.toList()).toString()
    .toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

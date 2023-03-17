package com.hamza.patronus.core.utils.json_parser

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data1: T? = null) : Resource<T>(data1)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}
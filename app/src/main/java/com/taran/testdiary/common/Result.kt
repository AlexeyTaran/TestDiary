package com.taran.testdiary.common

sealed class Result<T> {
    class Success<T>(val data: T) : Result<T>()
    class Error<T>(val error: String) : Result<T>()
    class Loading<T>(val data: T? = null) : Result<T>() // data can be old
}
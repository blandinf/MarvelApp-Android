package com.blandinf.marvelapp.extensions

fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }
}
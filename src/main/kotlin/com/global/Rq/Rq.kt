package com.global.Rq

class Rq(cmd: String) {
    val action: String
    val paramMap = mutableMapOf<String, String>()

    init {
        val cmdBits = cmd.split("?", limit = 2)
        action = cmdBits[0].trim()

        if (cmdBits.size == 2) {
            val params = cmdBits[1].split("?")
            for (param in params) {
                val keyValue = param.split("=", limit = 2)
                if (keyValue.size == 2) {
                    paramMap[keyValue[0].trim()] = keyValue[1].trim()
                } else {
                    println("Invalid parameter format: $param")
                }
            }
        } else if (cmdBits.size > 2) {
            println("Too many '?' in command: $cmd")
        }
    }

    private fun getParamValue(name: String): String? {
        return paramMap[name]
    }

    fun getParamValueAsInt(name: String, default: Int): Int {
        val paramValue = getParamValue(name) ?: return default

        return try {
            paramValue.toInt()
        } catch (e: NumberFormatException) {
            default
        }
    }
}
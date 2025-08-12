package com

data class WiseSaying(
    var content: String,
    var author: String,
) {
    var id: Int = 0
    fun update(content: String, author: String) {
        this.content = content
        this.author = author
    }

    fun isNew(): Boolean {
        return id == 0
    }
}
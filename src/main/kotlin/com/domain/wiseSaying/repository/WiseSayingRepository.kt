package com.domain.wiseSaying.repository

import com.WiseSaying

interface WiseSayingRepository {

    fun save(wiseSaying: WiseSaying): WiseSaying
    fun isEmpty(): Boolean
    fun findAll(): List<WiseSaying>
    fun findById(id: Int): WiseSaying?
    fun delete(wiseSaying: WiseSaying)
    fun clear()
}
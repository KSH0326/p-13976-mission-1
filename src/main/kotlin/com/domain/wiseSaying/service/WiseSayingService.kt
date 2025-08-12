package com.domain.wiseSaying.service

import com.WiseSaying
import com.domain.wiseSaying.repository.WiseSayingRepository

class WiseSayingService {
    private val wiseSayingRepository = WiseSayingRepository()

    fun write(content: String, author: String): WiseSaying {
        return wiseSayingRepository.save(WiseSaying(content, author))
    }

    fun isEmpty(): Boolean {
        return wiseSayingRepository.isEmpty()
    }

    fun findAll(): List<WiseSaying> {
        return wiseSayingRepository.findAll()
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayingRepository.findById(id)
    }

    fun delete(wiseSaying: WiseSaying) {
        wiseSayingRepository.delete(wiseSaying)
    }

    fun update(wiseSaying: WiseSaying, content: String, author: String) {
        wiseSaying.update(content, author)

        wiseSayingRepository.save(wiseSaying)
    }
}
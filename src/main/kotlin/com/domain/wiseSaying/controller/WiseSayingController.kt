package com.domain.wiseSaying.controller

import com.global.Rq.Rq
import com.global.bean.SingletonScope

class WiseSayingController {
    private val wiseSayingService = SingletonScope.wiseSayingService

    fun actionWrite(rq: Rq) {
        print("명언 : ")
        val content = readlnOrNull()!!.trim()
        print("작가 : ")
        val author = readlnOrNull()!!.trim()

        val wiseSaying = wiseSayingService.write(content, author)

        println("${wiseSaying.id}번 명언이 등록되었습니다.")
    }

    fun actionList(rq: Rq) {
        if (wiseSayingService.isEmpty()) {
            println("등록된 명언이 없습니다.")
            return
        }

        println("번호 / 작가 / 명언")

        println("----------------------")
    }

    fun actionDelete(rq: Rq) {
        val id = rq.getParamValueAsInt("id", 0)

        if (id == 0) {
            println("id를 정확히 입력해주세요.")
            return
        }

        val wiseSaying = wiseSayingService
            .findById(id)

        if (wiseSaying == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return
    }

    fun actionUpdate(rq: Rq) {
        val id = rq.getParamValueAsInt("id", 0)

        if (id == 0) {
            println("id를 정확히 입력해주세요.")
            return
        }

        val wiseSaying = wiseSayingService.findById(id)

        if (wiseSaying == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        println("명언(기존) : ${wiseSaying.content}")
        print("명언 : ")
        val content = readlnOrNull()!!.trim()

        println("작가(기존) : ${wiseSaying.author}")
        print("작가 : ")
        val author = readlnOrNull()!!.trim()

        wiseSayingService.update(wiseSaying, content, author)

        println("${id}번 명언을 수정하였습니다.")
        }
    }
}

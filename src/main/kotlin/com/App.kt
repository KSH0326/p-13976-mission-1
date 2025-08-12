package com

import com.domain.wiseSaying.controller.WiseSayingController

class App {
    fun run() {
        val wiseSayingController = WiseSayingController()

        println("== 명언 앱 ==")

        var lastId = 0

        while (true) {
            print("명령) ")
            val input = readlnOrNull()!!.trim()

            val rq = Rq(input)
            when (rq.action) {
                "종료" -> {
                    println("프로그램을 종료합니다.")
                    break
                }
                "등록" -> wiseSayingController.actionWrite(rq)
                "목록" -> wiseSayingController.actionList(rq)
                "삭제" -> wiseSayingController.actionDelete(rq)
                "수정" -> wiseSayingController.actionUpdate(rq)
            }
        }
    }
}
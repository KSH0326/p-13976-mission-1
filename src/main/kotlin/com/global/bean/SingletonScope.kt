package com.global.bean

import com.domain.wiseSaying.controller.WiseSayingController
import com.domain.wiseSaying.repository.WiseSayingFileRepository
import com.domain.wiseSaying.repository.WiseSayingMemoryRepository
import com.domain.wiseSaying.repository.WiseSayingRepository
import com.domain.wiseSaying.service.WiseSayingService

object SingletonScope {
    val wiseSayingController by lazy { WiseSayingController() }
    val wiseSayingService by lazy { WiseSayingService() }
    val wiseSayingRepository: WiseSayingRepository by lazy { WiseSayingMemoryRepository() }
    val wiseSayingFileRepository by lazy { WiseSayingFileRepository() }

}
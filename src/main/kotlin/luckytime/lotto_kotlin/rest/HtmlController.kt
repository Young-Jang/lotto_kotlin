package luckytime.lotto_kotlin.rest

import lombok.RequiredArgsConstructor
import luckytime.lotto_kotlin.application.LottoService
import luckytime.lotto_kotlin.rest.dto.GetLuckyNumRspDTO
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lotto/")
@RequiredArgsConstructor
class LottoController(private val lottoService: LottoService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("get-lucky-number")
    fun getLotto(@RequestParam count: Int): ResponseEntity<*> {
        return ResponseEntity.ok().body(GetLuckyNumRspDTO(lottoService.createLottoNumber(count)))
    }
}

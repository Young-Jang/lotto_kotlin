package luckytime.lotto_kotlin.rest

import luckytime.config.ControllerDocumentation
import luckytime.lotto.application.LottoService
import luckytime.lotto.rest.DTO.GetLuckyNumRspDTO
import org.json.simple.parser.ParseException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lotto/")
@RequiredArgsConstructor
@ControllerDocumentation
class LottoController(private val lottoService: LottoService) {

    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("get-lucky-number")
    fun getLotto(@RequestParam count: Int): ResponseEntity<*> {
        logger.info("getLuckyNumber{}", count)
        return ResponseEntity.ok(
            GetLuckyNumRspDTO.builder()
                .luckyNumber(lottoService.createLottoNumber(count))
                .build()
        )
    }

    @GetMapping("win-percentage")
    @Throws(ParseException::class)
    fun getWinPercentage(@RequestParam drwNo: Int): ResponseEntity<*> {
        return ResponseEntity.ok(lottoService.getWinPercentage(drwNo))
    }
}

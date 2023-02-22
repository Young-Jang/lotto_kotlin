package luckytime.lotto_kotlin.application

import lombok.RequiredArgsConstructor
import luckytime.lotto_kotlin.domain.repository.LottoRepository
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class LottoService() {
    fun createLottoNumber(count: Int): List<String> {
        val lottoList = mutableListOf<String>()
        for (j in 0 until count) {
            lottoList.add(getLottoString())
        }
        return lottoList
    }

    private fun getLottoString(): String {
        val checkSameNumber = mutableSetOf<Int>()
        for (i in 0 until 6) {
            var luckyNumber = (Math.random() * 45 + 1).toInt()
            while (checkSameNumber.contains(luckyNumber)) {
                luckyNumber = (Math.random() * 45 + 1).toInt()
            }
            checkSameNumber.add(luckyNumber)
        }
        return buildPrettyString(checkSameNumber)
    }

    private fun buildPrettyString(lotto: Set<Int>): String {
        return lotto.sorted().joinToString(separator = "-", prefix = "[", postfix = "]") { it.toString() }
    }

}
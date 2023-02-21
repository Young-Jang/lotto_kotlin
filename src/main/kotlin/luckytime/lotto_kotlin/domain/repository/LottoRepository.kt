package luckytime.lotto_kotlin.domain.repository;

interface LottoRepository {
    fun getLottoNum(drwNo: Int): String
}
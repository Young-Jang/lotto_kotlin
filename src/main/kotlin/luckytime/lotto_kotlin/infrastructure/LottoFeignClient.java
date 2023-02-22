package luckytime.lotto_kotlin.infrastructure;


import luckytime.lotto_kotlin.domain.repository.LottoRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "getLottoNumber", url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber",configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface LottoFeignClient extends LottoRepository {
    @GetMapping()
    String getLottoNum(@RequestParam("drwNo") int drwNo);
}

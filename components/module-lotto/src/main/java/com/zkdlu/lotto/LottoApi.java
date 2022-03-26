package com.zkdlu.lotto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class LottoApi {
    @GetMapping("/lotto")
    public Lotto getRandom() {
        return new Lotto(
                Stream.of(1,3,11,23,25,33)
                        .map(LottoNumber::of)
                        .collect(Collectors.toList()));
    }
}

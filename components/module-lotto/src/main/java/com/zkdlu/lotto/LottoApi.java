package com.zkdlu.lotto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@RestController
public class LottoApi {
    private final LottoGame lottoGame;

    @GetMapping("/lotto")
    public Lotto getRandom() {
        return lottoGame.generate();
    }
}

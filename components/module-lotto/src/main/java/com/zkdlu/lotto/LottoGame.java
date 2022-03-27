package com.zkdlu.lotto;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class LottoGame {
    private final List<LottoNumber> lottoNumberSample;

    public LottoGame() {
        lottoNumberSample = IntStream.range(1, 45 + 1)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public Lotto generate() {
        Collections.shuffle(lottoNumberSample);

        return new Lotto(peek());
    }

    private List<LottoNumber> peek() {
        var result = new ArrayList<LottoNumber>();

        System.out.print("[ ");
        for (int i = 0; i < 6; i++) {
            System.out.print(lottoNumberSample.get(i).getNumber());
            System.out.print(", ");

            result.add(lottoNumberSample.get(i));
        }
        System.out.println("]");

        return result;
    }
}

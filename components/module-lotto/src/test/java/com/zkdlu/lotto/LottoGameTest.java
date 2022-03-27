package com.zkdlu.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    void 랜덤한_로또를_반환한다() {
        Lotto lotto1 = lottoGame.generate();
        Lotto lotto2 = lottoGame.generate();

        assertThat(lotto1).isNotEqualTo(lotto2);
    }
}
package com.zkdlu.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
    @Test
    void 로또번호는_1부터_45사이의_숫자이다() {
        LottoNumber.of(1);
        LottoNumber.of(20);
        LottoNumber.of(45);
    }

    @Test
    void 번호가_1보다_작으면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("로또 번호는 1과 45사이의 숫자입니다.");
    }

    @Test
    void 번호가_45보다_크면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("로또 번호는 1과 45사이의 숫자입니다.");
    }
}

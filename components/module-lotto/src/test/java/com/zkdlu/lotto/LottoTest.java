package com.zkdlu.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void 로또는_6개의_번호를_가진다() {
        Assertions.assertThatThrownBy(() -> new Lotto(generateNumbers(1)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("6개의 번호가 필요합니다.");

        Assertions.assertThatThrownBy(() -> new Lotto(generateNumbers(2)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("6개의 번호가 필요합니다.");

        Assertions.assertThatThrownBy(() -> new Lotto(generateNumbers(3)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("6개의 번호가 필요합니다.");

        Assertions.assertThatThrownBy(() -> new Lotto(generateNumbers(4)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("6개의 번호가 필요합니다.");

        Assertions.assertThatThrownBy(() -> new Lotto(generateNumbers(5)))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("6개의 번호가 필요합니다.");

        new Lotto(generateNumbers(6));
    }

    @Test
    void 일치하는_번호_숫자를_가져온다() {
        Lotto lotto = new Lotto(generateNumbers(6));

        assertThat(lotto.match(givenWinLotto(1))).isEqualTo(6);
        assertThat(lotto.match(givenWinLotto(2))).isEqualTo(5);
        assertThat(lotto.match(givenWinLotto(3))).isEqualTo(4);
    }

    @Test
    void 중복되지_않는_번호를_가진다() {
        List<LottoNumber> givenDuplicatedNumbers = getDuplicatedNumbers();

        Assertions.assertThatThrownBy(() -> new Lotto(givenDuplicatedNumbers))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("번호는 중복될 수 없습니다.");
    }

    private List<LottoNumber> getDuplicatedNumbers() {
        return Stream.of(1,1,2,3,4,5)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> generateNumbers(int size) {
        return IntStream.range(1, size + 1)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private Lotto givenWinLotto(int seed) {
        return new Lotto(IntStream.range(seed, seed + 6)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }
}
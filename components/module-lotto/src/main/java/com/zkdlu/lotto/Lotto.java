package com.zkdlu.lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalStateException("6개의 번호가 필요합니다.");
        }

        if (isDuplicated(lottoNumbers)) {
            throw new IllegalStateException("번호는 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicated(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().distinct().count() != lottoNumbers.size();
    }

    public int match(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                .filter(winLotto.getLottoNumbers()::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return this.match(lotto) == 6;
    }
}

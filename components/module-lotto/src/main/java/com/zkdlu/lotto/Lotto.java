package com.zkdlu.lotto;

import java.util.List;

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
}

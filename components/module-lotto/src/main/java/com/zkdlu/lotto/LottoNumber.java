package com.zkdlu.lotto;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber of(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalStateException("로또 번호는 1과 45사이의 숫자입니다.");
        }
        return new LottoNumber(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

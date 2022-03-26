import React, { Component } from "react";
import LottoItem from "./LottoItem";
import './LottoItemList.css'

class LottoItemList extends Component {
    render() {
        const { lottos } = this.props;
        const lottoList = lottos.map(
            (number, index) => (
                <LottoItem
                    number={number}
                    key={index}
                />)
        )

        return (
            <div className="lotto-list">
                {lottoList}
            </div>
        )
    }
}

export default LottoItemList;
import { Component } from "react";
import Button from "../../components/Button";
import LottoItemList from "./components/LottoItemList";
import LottoTemplate from "./components/LottoTemplate";

class LottoPage extends Component {
    render() {
        const lottos = [4, 2, 3, 2, 5, 6];
        return (
            <LottoTemplate form={(
                <Button msg='생성' />
            )}>
                <LottoItemList lottos={lottos} />
            </LottoTemplate>
        )
    }
}

export default LottoPage;
import { Component } from "react";
import Button from "../../components/Button";
import LottoItemList from "./components/LottoItemList";
import LottoTemplate from "./components/LottoTemplate";
import api from '../../api'

class LottoPage extends Component {
    state = {
        lottos: []
    }

    async fetchLotto() {
        const fetchedLottos = await api.get('lotto');
        this.setState({
            lottos: [...fetchedLottos.lottoNumbers]
        });
    }

    async componentDidMount() {
        await this.fetchLotto();
    }

    render() {
        const { lottos } = this.state;

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
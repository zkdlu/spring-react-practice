import { Component } from "react";
import Button from "../../components/Button";
import LottoTemplate from "./components/LottoTemplate";

class LottoPage extends Component {
    render() {
        return (
            <LottoTemplate form={(
                <Button msg='생성'/>
            )}>
                <div>
                    Lotto Page
                </div>
            </LottoTemplate>
        )
    }
}

export default LottoPage;
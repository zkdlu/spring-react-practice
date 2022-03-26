import { Link } from "react-router-dom";
import './Home.css'

const Home = () => {
    return (
        <div className="container">
            <Link className="container-item" to='/todo'>Todo</Link>
            <Link className="container-item" to='/chat'>Chat</Link>
            <Link className="container-item" to='/market'>Market</Link>
            <Link className="container-item" to='/lotto'>Lotto</Link>
        </div>
    )
}

export default Home;
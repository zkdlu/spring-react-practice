import { Link } from "react-router-dom";
import './Home.css'

const Home = () => {
    return (
        <div className="container">
            <Link className="container-item" to='/todo'>Todo</Link>
            <Link className="container-item" to='/chat'>Chat</Link>
        </div>
    )
}

export default Home;
import {useLocation, useNavigate} from "react-router-dom";

export default function Detail() {
    const location = useLocation()
    const {mov} = location.state
    const navigate = useNavigate();

    return (
        <section>
            <h1>{mov}</h1>
            <button onClick={() => {
                navigate("/")
            }
            }>Back</button>
        </section>
    )
}
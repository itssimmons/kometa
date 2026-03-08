function App() {
	const [message, setMessage] = React.useState("");
	const [messages, setMessages] = React.useState([]);
	const [status, setStatus] = React.useState("disconnected");
	/** @type {React.RefObject<WebSocket | null>} */
	const wsRef = React.useRef(null);

	React.useEffect(() => {
		const ws = new WebSocket("ws://localhost:8080/echo");
		wsRef.current = ws;

		ws.onopen = () => {
			console.log("WebSocket connection established");
			setStatus("connected");
		};

		ws.onmessage = (ev) => {
			setMessages((prevMessages) => [...prevMessages, ev.data]);
		};

		ws.onclose = () => {
			console.log("WebSocket connection closed");
			setStatus("disconnected");
		};

		return () => {
			ws.close();
		};
	}, []);

	return (
		<div>
			<span data-status={status} />
			<h1>Message Log:</h1>
			<ul>
				{messages.map((msg, index) => (
					<li key={index}>{msg}</li>
				))}
			</ul>
			<input
				type="text"
				value={message}
				onChange={(e) => setMessage(e.target.value)}
				onKeyDown={(e) => {
					if (e.key !== "Enter") return;
					const { current: ws } = wsRef;

					if (ws && ws.readyState === WebSocket.OPEN) {
						ws.send(message);
						setMessage("");
					}
				}}
				placeholder="Type a message and press Enter"
			/>
		</div>
	);
}

const container = document.querySelector("#container");
const root = ReactDOM.createRoot(container);
root.render(<App />);

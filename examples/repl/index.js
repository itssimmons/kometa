import * as readline from "node:readline";

console.clear();

const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

rl.on("close", () => {
	console.log("\nGoodbye!\n");
	process.exit(0);
});

/**
 * Logs a message without overlapping the readline prompt.
 * Clears the current line, prints the message, then redraws the prompt.
 * @param {...any} args
 */
function log(...args) {
	if (rl) {
		readline.clearLine(process.stdout, 0);
		readline.cursorTo(process.stdout, 0);
	}
	console.log(...args);
	if (rl) {
		rl.prompt(true);
	}
}

log("Welcome to the WebSocket REPL Tester!");
log("---");
log("Type any message and press Enter to send it to the WebSocket server.");
log("Or type 'exit' to quit\n");

const ws = new WebSocket("ws://localhost:8080/echo");

ws.addEventListener("open", () => {
	log("Connection established\n");
});

ws.addEventListener("message", (ev) => {
	log("Received message:", ev.data, "\n");
});

ws.addEventListener("close", () => {
	log("Connection closed\n");
});

ws.addEventListener("error", (ev) => {
	log("Error occurred:", ev, "\n");
});

do {
	try {
		const input = await new Promise((resolve) => {
			rl.question("> ", resolve);
		});

		if (input === null || input.trim() === "exit") {
			log("Goodbye!\n");
			break;
		}

		ws.send(input.trim());
	} catch (e) {
		console.error(e);
	}
} while (true);

ws.close();
process.exit(0);

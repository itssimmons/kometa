# Usage

Kometa creates a **WebSocket server** that you can connect to in order to receive **real-time metrics** about your machine's hardware usage. Once connected, Kometa will continuously stream live data including CPU, memory, disk, and network statistics directly to your client.

## Connecting to the WebSocket

By default, Kometa listens on:

```
ws://localhost:3000
```

You can connect using any WebSocket-compatible client, library, or tool (e.g., `wscat`, a browser, or a Node.js/Python client).

## Example Response

Once connected, you will receive JSON messages at a regular interval. Here is an example of what a response payload looks like:

```json
{
	"timestamp": "2024-06-01T12:34:56.789Z",
	"cpu": {
		"usage_percent": 34.7,
		"cores": 8,
		"model": "Intel(R) Core(TM) i7-9750H CPU @ 2.60GHz",
		"temperature_celsius": 61.0
	},
	"memory": {
		"total_gb": 16.0,
		"used_gb": 9.3,
		"free_gb": 6.7,
		"usage_percent": 58.1
	},
	"disk": {
		"total_gb": 512.0,
		"used_gb": 210.4,
		"free_gb": 301.6,
		"usage_percent": 41.1
	},
	"network": {
		"bytes_sent": 104857600,
		"bytes_received": 209715200,
		"send_speed_kbps": 512.3,
		"receive_speed_kbps": 1024.8
	}
}
```

## Fields Reference

| Field                        | Type    | Description                                       |
| ---------------------------- | ------- | ------------------------------------------------- |
| `timestamp`                  | string  | ISO 8601 timestamp of when the snapshot was taken |
| `cpu.usage_percent`          | float   | Overall CPU usage as a percentage                 |
| `cpu.cores`                  | integer | Number of logical CPU cores                       |
| `cpu.model`                  | string  | CPU model name                                    |
| `cpu.temperature_celsius`    | float   | CPU temperature in degrees Celsius                |
| `memory.total_gb`            | float   | Total installed RAM in gigabytes                  |
| `memory.used_gb`             | float   | Currently used RAM in gigabytes                   |
| `memory.free_gb`             | float   | Available RAM in gigabytes                        |
| `memory.usage_percent`       | float   | RAM usage as a percentage                         |
| `disk.total_gb`              | float   | Total disk capacity in gigabytes                  |
| `disk.used_gb`               | float   | Used disk space in gigabytes                      |
| `disk.free_gb`               | float   | Free disk space in gigabytes                      |
| `disk.usage_percent`         | float   | Disk usage as a percentage                        |
| `network.bytes_sent`         | integer | Total bytes sent since startup                    |
| `network.bytes_received`     | integer | Total bytes received since startup                |
| `network.send_speed_kbps`    | float   | Current upload speed in kilobytes per second      |
| `network.receive_speed_kbps` | float   | Current download speed in kilobytes per second    |

## Notes

- Metrics are pushed to the client at a configurable interval (default: **5 minutes**).
- All connected clients receive the same broadcast stream.
- The WebSocket connection will remain open until either the client disconnects or Kometa is stopped.

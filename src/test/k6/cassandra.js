import http from 'k6/http';
import { sleep } from 'k6';
import { uuidv4 } from 'https://jslib.k6.io/k6-utils/1.4.0/index.js';

export const options = {
  // A number specifying the number of VUs to run concurrently.
  vus: 10,
  // A string specifying the total duration of the test run.
  duration: '30s',
};



export default function() {
  const randomUUID = uuidv4();
  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };
  const payload = JSON.stringify({
    "id": randomUUID,
    "senderId": "1",
    "senderSessionId": "1",
    "receiverId": "2",
    "senderRegion": "AZ2",
    "senderAz": "AZ1",
    "content": "Hello, World!",
    "timestamp": Date.now()
  });
  http.post('http://localhost:8080/cassandra/chat-message', payload, params);
  sleep(1);
}

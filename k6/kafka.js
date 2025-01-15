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
    "id": 1,
    "userId": "user1",
    "songId": "song1",
    "songTime": 100,
    "timestamp": Date.now(),
    "type": "PLAY"
  });
  http.post('http://localhost:8080/kafka/play-event', payload, params);
  sleep(1);
}

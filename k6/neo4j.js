import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  // A number specifying the number of VUs to run concurrently.
  vus: 10,
  // A string specifying the total duration of the test run.
  duration: '30s',
};

export default function() {
  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };
  const payload = JSON.stringify({
    "name": "Some Entity"
  });
  let res = http.post('http://localhost:8080/neo4j/economic-entity', payload, params);
  const ee = res.json();
  res = http.get('http://localhost:8080/neo4j/economic-entity/' + ee.id, params);
  console.log(res.json())
  sleep(1);
}

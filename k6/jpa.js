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
    "name": "Some Person"
  });
  let res = http.post('http://localhost:8080/jpa/person', payload, params);
  const person = res.json();
  res = http.get('http://localhost:8080/jpa/person/' + person.id, params);
  console.log(res.json())
  sleep(1);
}

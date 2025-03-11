import json
import random
from locust import HttpUser, task, between

class QuickstartUser(HttpUser):
    wait_time = between(1, 2)

    @task
    def create_user_and_save_post(self):
        rn = random.randint(1, 1000)
        self.email = f"test{rn}@example.com"
        self.username = f"test_{rn}"
        password = "test@1234"

        # 사용자 생성
        self.client.post("/api/user/save", 
                         json={"username": self.username, "email": self.email, "password": password})

        #로그인
        response = self.client.post("/api/user/login", json={"email": self.email, "password": password})

        if response.status_code == 200:  # 로그인 성공 확인
            try:
                self.token = response.json()["token"]
                print(f"Token received: {self.token}")  # 토큰 확인을 위해 추가

                # 질문 저장
                self.client.post(
                    "/api/question/save",
                    json={"token": self.token, "email": self.email, "username": self.username,
                          "question": "부하테스트 진행 중?"}
                )
            except KeyError:
                print("Error: 'token' key not found in response JSON.")
                try:
                    print("Response JSON: ", json.dumps(response.json(), indent=4))  # 응답 json 확인
                except json.JSONDecodeError:
                    print("Response is not valid JSON.")
        else:
            print(f"Error: Login failed with status code {response.status_code}")  # 로그인 실패시 상태 코드 확인
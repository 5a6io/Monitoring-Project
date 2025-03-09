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

        self.client.post("/api/user/save", 
                         json={"username": self.username, "email": self.email, "password": password})
        
        response = self.client.post("/api/user/login", json={"email": self.email, "password": password})
        self.token = response.json()["token"]

        self.client.post(
            "/api/question/save",
            json={"token": self.token, "email": self.email, "username": self.username, "question": "부하테스트 진행 중?"}
        )
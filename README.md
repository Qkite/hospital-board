# hospital-board

![diagram drawio (1)](https://user-images.githubusercontent.com/109712249/206072579-f229ff06-c58c-4269-931c-167278459a03.png)


(1) 회원가입 기능
POST /api/v1/register

(2) 로그인 기능 - 토큰 발급
POST /api/v1/login

(3) 토큰 인증 후 병원 기록 입력 기능 

POST /api/v1/visits

(4) 특정 병원에서의 환자 기록 조회 기증
GET /api/v1/visits/hospitals/{id}

(5) 특정 사용자의 병원 기록 조회 기능
GET /api/v1/visits/users/{id}

(6) 전체 기록 조회 기능
GET /api/v1/visits



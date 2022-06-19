# 호스트들의 Alive 상태 체크 및 모니터링 API
## API 설명
|METHOD|URL|Description|Params|
----|------|-----------|------|
|GET|/api/host|전체 호스트 조회|
|GET|/api/host/{id}|단일 호스트 조회|
|POST|/api/host|호스트 등록|String name, String ip|
|PUT|/api/host/{id}|단일 호스트 수정|String name, String ip|
|DELETE|/api/host/{id}|단일 호스트 삭제|
|GET|/api/host/alive/{id}|단일 호스트 Alive 상태 조회|
|GET|/api/host/alive/monitor|전체 호스트 Alive 모니터링 결과 조회|
|GET|/api/host/alive/monitor|단일 호스트 Alive 모니터링 결과 조회|

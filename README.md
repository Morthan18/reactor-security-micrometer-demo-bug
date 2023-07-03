# reactor-security-micrometer-demo-bug

Steps to reproduce issue:
1. Run application
2. Execute get request for secured path with random jwt token with correct structure. E.g:
curl --location "http://localhost:8073/secured-hello" --header "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"

Expected behaviour:
-401 response for random jwt
-200 response for correct jwt generated from my auth-service

Actual behaviour:
500 because of "NullPointerException: Cannot invoke "io.micrometer.observation.Observation$Scope.getPreviousObservationScope()" because "scope" is null"

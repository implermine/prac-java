# prac-java

### rule

1. test package에서 package별로 분리
2. package(domain) 추가 시, 최대한 specific 추가 (X -> domain, basic, null) (O -> null_when_serialize)
3. 특정 도메인 관련 test를 검색하고 싶을 시, IDE 도움을 받아 검색.
4. 주석을 IDE로 검색할 수 있도록, 많이 달아 둘 것
5. stream 같은 keyword를 패키지에 사용하기 위해 늘 trailing _를 사용할 것
6. @Test annotation, 즉 각 테스트 위에는 해당 테스트의 목적과 결과(의의)를 명시할 것
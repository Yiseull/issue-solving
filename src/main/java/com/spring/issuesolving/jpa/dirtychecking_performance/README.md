# JPA Dirty Checking Performance Issue

> JPA Dirty Checking(변경 감지)이 성능에 영향을 미치는지 알아보려고 함

## Case1. 데이터 조회 시 변경 감지(dirty checking) 여부에 따른 성능 체크

1. @Transactional 만 사용한 데이터 조회
2. @Transactional(readOnly = true)을 사용한 데이터 조회

= @Transactional(readOnly = true)을 사용하면 영속성 컨텍스트(seesion)의 Flush Mode가 MANUAL로 설정 (default Auto) -> select 할 당시 엔티티의 스냅샷을 만들지 않는다.

### 성능 확인 결과 🖥️
-> 2번이 1번보다 빠름

## Case2. 데이터 조회할 때 가장 빠른 방법은 무엇인가?
1. @Transactional(readOnly = true)을 사용한 데이터 조회
2. 읽기 전용 쿼리 힌트 사용
3. 스칼라 타입으로 조회

### 결과 🖥️
-> 아직 안해봄

## Case3. 데이터 변경할 때는 변경 감지(dirty checking)를 사용하는 게 무조건 성능에 좋나?
1. 변경 감지 사용
2. @DynamicUpdate 사용

## 사용 Tool
- JMeter
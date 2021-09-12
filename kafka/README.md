# Kafka
Kafka의 차별점/장점

기존 메시징 시스템과는 달리 메시지를 파일 시스템에 저장함으로 영속성(durability)이 보장

consumer가 broker로 부터 직접 메시지를 가지고 가는 pull 방식으로 동작

producer 중심적, 많은 양의 데이터를 파티셔닝하는데에 기반을 둔다

consumer가 전달 상태를 기억함

어마어마한 양의 데이터를 처리해야 할 때 사용
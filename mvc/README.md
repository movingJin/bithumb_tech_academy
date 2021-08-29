# mvc
8월 22일: MVC 모델 학습

*@AutoWired보단
@RequiredArgsConstructor 지향, 플랫폼 종속성을 피하기 위해


교차엔티티: 엔티티와 엔티티 사이를 연결하는 1:N, 1:N 엔티티
@ManyToOne(fetch = FetchType.EAGER): 즉시호출 (해당 컬럼을 호출하기 전에 로드함, 성능문제 가능성 있음)
@ManyToOne(fetch = FetchType.LAZY): 즉시호출 (해당 컬럼을 호출하기 전에 로드함, 요즘 사용하는 추세)

RESTful<>SOAP
SOAP방식의 대표적인 방식이 공인인증서
RESTful은 서버에 로그인 정보 등의 데이터를 저장하지 못하게끔을 지향(무상태)
, JSON방식으로 통신함

REST의 4가지 동작방식:
GET: 데이터 조회
POST: 데이터 입력
PUT: 데이터 수정
DELETE: 데이터 삭제

Front 쪽에 Entity를 노출시키면 안됨, 대신 Dto전달
Dto는 깡통, Entity는 db와 연결된 전원 기계: Dto가 entity로 전달
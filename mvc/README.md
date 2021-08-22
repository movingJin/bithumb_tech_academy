# mvc
8월 22일: MVC 모델 학습

*@AutoWired보단
@RequiredArgsConstructor 지향, 플랫폼 종속성을 피하기 위해


교차엔티티: 엔티티와 엔티티 사이를 연결하는 1:N, 1:N 엔티티
@ManyToOne(fetch = FetchType.EAGER): 즉시호출 (해당 컬럼을 호출하기 전에 로드함, 성능문제 가능성 있음)
@ManyToOne(fetch = FetchType.LAZY): 즉시호출 (해당 컬럼을 호출하기 전에 로드함, 요즘 사용하는 추세)

Restful의 4가지 형태:

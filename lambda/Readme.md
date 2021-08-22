8월 22일: lambda식  연습

객체=> 속성(데이터)과 기능의 조합
==>map(list, function);

Thread t = new Thread();
Thread t2 = new Thread();
위와 같이, 객체를 생성해서 사용하면, 자원관리에 어려움이 있음. 지양

*MethodReference는 파라미터가 없는 lambda


*Stream(Async) 방식과 Blocking(Sync) 방식이 공존하는 코드를 고려할 것.
Stream방식은 자료구조가 계속 순환하는 방식이기 때문에 대상이되는 데이터를 찾기가 빠름.

Function<Runnable, Thread> function = Thread::new;
팩토리 방식을 지향

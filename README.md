# ExceptionStrategy
Restfulapi를 이용한 Exception 전략 공부용 프로젝트입니다.

### 라이브러리
- org.springframework.boot:2.7.1
- spring-boot-starter-web
- spring-boot-starter-test
- spring-boot-starter-validation
- spring-boot-devtools
- org.projectlombok:lombok


@RestControllerAdvice를 이용한 글로벌 Exception 전략 사용
- 한 개의 클래스로 모든 컨트롤러에 대한 예외 처리가 가능
- 응답을 일관성 있게 보낼수있음
- try-catch가 없기 때문에 가독성 향상


공부하면서 느낀점 <br>
OrderIdEmptyException.class 같은 예외 클래스를 만들때 자바에서 비슷한 의미를 가진 <br>
IllegalArgumentException.class 예외 클래스를 재사용하는게 더 효율적임. <br>
앞으로는 자바에서 제공해주는 예외 클래스를 최대한 이용하고 불가피 할 경우 예외 클래스 생성 해야겠음.

추가로<br>
Spring5 에서는 ResponseStatusException을 추가 했는데 이 친구는 빠르게 에러 대응이 가능해 좋아보이지만 <br>
일관되게 처리하는게 어렵고, 예외 처리가 중복 될 수 있어 ControllerAdvice 전략을 주로 사용하자.

## 프로젝트 생성
  * 스프링 부트 스타터(https://start.spring.io/)
  * 사용 Dependency 추가 : web, thymeleaf, jpa, h2, lombok, validation
  * groupId: jpabook
  * artifactId: jpashop


## build.gradle 설정관련 
    ```code
    
    runtimeOnly 'com.h2database:h2:{DB버젼과 맞추어서}'
    
    //JUnit4 추가
    testImplementation("org.junit.vintage:junit-vintage-engine") {
    exclude group: "org.hamcrest", module: "hamcrest-core"
    } 
    ```

## 어플리케이션 동작 확인
  * Hello 객체 만들고 출력 기본 테스트 케이스 실행
  * 스프링 부트 메인 실행 후 White level 에러 발생 간단하게 동작 확인
    * http://localhost:8080

## 롬복 적용
  1. Prefrences plugin lombok 검색 실행 (재시작)
  2. Prefrences Annotation Processors 검색 Enable annotation processing 체크 (재시작)
  3. 임의의 테스트 클래스를 만들고 @Getter, @Setter 확인

## IDE 속도 최적화 
  * 최근 IntelliJ 버전은 Gradle로 실행을 하는 것이 기본 설정이다. 
  * 이렇게 하면 실행속도가 느리다. 다음과같이 변경하면 자바로 바로 실행해서 실행속도가 더 빠르다.
    * Preferences Build, Execution, Deployment Build Tools Gradle
    * Build and run using: Gradle을  IntelliJ IDEA 로변경
    * Run tests using: Gradle을 IntelliJ IDEA 로변경

## 라이브러리 살펴보기
  * gradle 의존관계 보기
    * ./gradlew dependencies —configuration compileClasspath

## 스프링 부트 라이브러리 살펴보기
  * spring-boot-starter-web
    * spring-boot-starter-tomcat: 톰캣 (웹서버)
    * spring-webmvc: 스프링 웹 MVC
  * spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View)
  * spring-boot-starter-data-jpa
    * spring-boot-starter-aop
    * spring-boot-starter-jdbc
      * HikariCP 커넥션 풀 (부트 2.0 기본)
    * hibernate + JPA: 하이버네이트 + JPA
    * spring-data-jpa: 스프링 데이터 JPA
  * spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅
    * spring-boot
      * spring-core
    * spring-boot-starter-logging
      * logback, slf4j

## 테스트 라이브러리
  * spring-boot-starter-test
    * junit: 테스트 프레임워크
    * mockito: 목 라이브러리
    * assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
    * spring-test: 스프링 통합 테스트 지원

## 핵심 라이브러리
  * 스프링 MVC
  * 스프링 ORM
  * JPA, 하이버네이트
  * 스프링 데이터 JPA

## 기타 라이브러리
  * H2 데이터베이스 클라이언트
  * 커넥션 풀: 부트 기본은 HikariCP
  * WEB(thymeleaf)
  * 로깅 SLF4J & LogBack
  * 테스트

## 관련 매뉴얼 
  * https://spring.io/guides
  * thymeleaf 공식 사이트: https://www.thymeleaf.org/
  * 스프링 공식 튜토리얼: https://spring.io/guides/gs/serving-web-content/
  * 스프링부트 메뉴얼: https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/boot-features-developing-web-applications.html#boot-features-spring-mvc-template-engines

## 스프링 부트 thymeleaf viewName 매핑
  * resources:templates/ +{ViewName}+ .html
  * prefix , suffix  변경이 가능능하다   
    * spring.thymeleaf.prefix=
    * secondaryTemplateResolver 정의 (ClassLoaderTemplateResolver 형 @Bean 주입) 
      
##  static root 위치 
  * 루트/src/main/resources/static

## view 로직 바로 반영하기 
  * spring-boot-devtools 디펜던시 추가 
  * 인텔리J 컴파일 방법: 메뉴 build Recompile ( Ctrl + Shift + F9)

## H2 데이터베이스 설치
  * https://www.h2database.com
  * 다운로드 및 설치
  * 데이터베이스 파일 생성 방법
  * jdbc:h2:~/jpashop (최소 한번)
  * ~/jpashop.mv.db 파일 생성 확인
  * 이후 부터는 jdbc:h2:tcp://localhost/~/jpashop 이렇게 접속

## yml로 변경 
  * application.properties 파일을 application.yml 로 변경

## live template 등록하기 
  1. preference (Setting) 에서 live template을 찾습니다.
  2. 오른쪽에 +버튼을 누르고 Template Group을 Custom으로 추가합니다.
  3. + 버튼으로 Custom 그룹에 Live template tdd를 추가합니다
  4. 템플릿 코드를 입력합니다.
  5. application context를 Java로 선택합니다.

## TDD 코드 작성 
  * @Transactional 사용시  spring것을 사용하는것을 권고 (쓸수 있는 옵션이 많다 )


## jar build
  * gradlew clean build
  * cd build/lib
  * java -jar 빌드파일 


## 참고 
  * 스프링 부트를 통해 복잡한 설정이 다 자동화 되었다. 
  * persistence.xml 도 없고, LocalContainerEntityManagerFactoryBean 도 없다.
  * 스프링 부트를 통한 추가 설정은 스프링 부트메뉴얼을 참고하고, 
  * 스프링 부트를 사용하지 않고 순수 스프링과 JPA 설정 방법은 자바 ORM 표준 JPA 프로그래밍 책을 참고하자

## 쿼리 파라미터 로그 남기기
  * 로그에 다음을 추가하기 org.hibernate.type : SQL 실행 파라미터를 로그로 남긴다.
  * 외부 라이브러리 사용
    * https://github.com/gavlyukovskiy/spring-boot-data-source-decorator
  * 스프링 부트를 사용하면 이 라이브러리만 추가하면 된다.
    * implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.5.6'
  ```code
  참고: 쿼리 파라미터를 로그로 남기는 외부 라이브러리는 시스템 자원을 사용하므로, 개발 단계에서는 편하게 사용해도 된다. 
  하지만 운영시스템에 적용하려면 꼭 성능테스트를 하고 사용하는 것이 좋다
  ```

## 요구사항
  * 회원 : 회원가입/ 회워목록
  * 상품 : 상품등록/ 상품목록
  * 주문:  상품주문/ 주문내역

## 도메인 설계 / DB 설계 
  * 1:n 관계에서는 N쪽에 FK가 있고 주인이 된다  1은 mappedby 가 된다 .
  * 외래 키가 있는 곳을 연관관계의 주인으로 정해라.!!
  * 예제에서는 설명을 쉽게하기 위해 엔티티 클래스에 Getter, Setter를 모두 열고, 최대한 단순하게 설계
  * 실무에서는 가급적 Getter는 열어두고, Setter는 꼭 필요한 경우에만 사용하는 것을 추천
  ```
  이론적으로 Getter, Setter 모두 제공하지 않고, 
  꼭 필요한 별도의 메서드를 제공하는게 가장 이상적이다. 
  하지만 실무에서 엔티티의 데이터는 조회할 일이 너무 많으므로, 
  Getter의 경우 모두 열어두는 것이 편리하다. 
  Getter는 아무리 호출해도 호출 하는 것 만으로 어떤 일이 발생하지는 않는다. 
  하지만 Setter는 문제가 다르다. 
  Setter를 호출하면 데이터가 변한다. 
  Setter를 막 열어두면 가까운 미래에 엔티티에가 도대 왜 변경되는지 추적하기 점점 힘들어진다. 
  그래서 엔티티를 변경할 때는 Setter 대신에 변ㅏ경 지점이 명확히 하도록 변경을 위한
  비즈니스 메서드를 별도제고해야 한다.  
  ```
  * 1:1 (@OneToOne )일 경우는 FK를 어디다 두는게 좋나? 
    * 비즈니스 로직상 좀더 접근이 많은 테이블에 두는것이 경험상 유리함. 
  
  * JPA는 FK를 잡아준다 
    * FK 잡아줘야 하나 말아야 하나  정합성 VS 안정적 서비스
    * 정산 빌링은 FK쓰는것도 고민해볼필요가..
  
 





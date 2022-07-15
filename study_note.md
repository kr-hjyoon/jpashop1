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

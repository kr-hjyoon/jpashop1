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
  
  * 여기서는 ManyToMany를 학습상 사용하지만 실무에서는 사용안하는것이 이롭다.

  ```
  참고: 값 타입은 변경 불가능하게 설계해야 한다.
  @Setter 를 제거하고, 생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만들자.!!!! 
  JPA 스펙상 엔티티나 임베디드 타입( @Embeddable )은 자바 기본 생성자(default constructor)를 
  public 또는 protected 로 설정해야 한다. !!!!!
  public 으로 두는 것 보다는 protected 로 설정하는 것이 그나마 더 안전하다. !!!
  JPA가 이런 제약을 두는 이유는 JPA 구현 라이브러리가 객체를
  생성할 때 리플랙션 같은 기술을 사용할 수 있도록 지원해야 하기 때문이다
  ```

## 엔티티 설계시 주의점
  * 엔티티에는 가급적 Setter를 사용하지 말자
    * Setter가 모두 열려있다. 변경 포인트가 너무 많아서, 유지보수가 어렵다. 나중에 리펙토링으로 Setter 제거
    
  * 모든 연관관계는 지연로딩으로 설정!
    * 즉시로딩( EAGER )은 예측이 어렵고, 어떤 SQL이 실행될지 추적하기 어렵다. 특히 JPQL을 실행할 때 N+1문제가 자주 발생한다.
    * 실무에서 모든 연관관계는 지연로딩( LAZY )으로 설정해야 한다.
    * 연관된 엔티티를 함께 DB에서 조회해야 하면, fetch join 또는 엔티티 그래프 기능을 사용한다.
    * @XToOne(OneToOne, ManyToOne) 관계는 기본이 즉시로딩! 이므로 직접 지연로딩으로 설정해야 한다.
     
    * 컬렉션은 필드에서 초기화 하자.
      * 컬렉션은 필드에서 바로 초기화 하는 것이 안전하다.
      * null 문제에서 안전하다.
      * 하이버네이트는 엔티티를 영속화 할 때, 컬랙션을 감싸서 하이버네이트가 제공하는 내장 컬렉션으로 변경한다. 
        * 만약 getOrders() 처럼 임의의 메서드에서 컬력션을 잘못 생성하면 하이버네이트 내부 메커니즘에 문제가 발생할 수 있다. 
        * 따라서 필드레벨에서 생성하는 것이 가장 안전하고, 코드도 간결하다.
        * Member member = new Member();
        ```java
          System.out.println(member.getOrders().getClass());
          em.persist(team);
          System.out.println(member.getOrders().getClass());
          //출력 결과
          class java.util.ArrayList
          class org.hibernate.collection.internal.PersistentBag
         ```
        
## 테이블, 컬럼명 생성 전략
  * 스프링 부트에서 하이버네이트 기본 매핑 전략을 변경해서 실제 테이블 필드명은 다름
    * https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#howtoconfigure-hibernate-naming-strategy
    * http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/
    * Hibernate_User_Guide.html#naming
      * 하이버네이트 기존 구현: 엔티티의 필드명을 그대로 테이블의 컬럼명으로 사용
      * SpringPhysicalNamingStrategy 
    * 스프링 부트 신규 설정 (엔티티(필드) 테이블(컬럼))
      1. 카멜 케이스 언더스코어(memberPoint member_point)
      2. (점) -> _ (언더스코어)
      3. 대문자 ->  소문자

    * 적용 2 단계
      1. 논리명 생성: 명시적으로 컬럼, 테이블명을 직접 적지 않으면 ImplicitNamingStrategy 사용
         * spring.jpa.hibernate.naming.implicit-strategy : 테이블이나, 컬럼명을 명시하지 않을 때 논리명 적용
      2. 물리명 적용:
         * spring.jpa.hibernate.naming.physical-strategy : 모든 논리명에 적용됨, 실제 테이블에 적용
         * (username usernm 등으로 회사 룰로 바꿀 수 있음)
         
      * 스프링 부트 기본 설정
      ```code 
      spring.jpa.hibernate.naming.implicit-strategy:
      org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy
      spring.jpa.hibernate.naming.physical-strategy:
      org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy
      ```


## 소스 구조 
  * 계층형 구조 사용
    * controller, web: 웹 계층
    * service: 비즈니스 로직, 트랜잭션 처리
    * repository: JPA를 직접 사용하는 계층, 엔티티 매니저 사용
    * domain: 엔티티가 모여 있는 계층, 모든 계층에서 사용
  * controller 에서  service 호출  or repository 직접호출 (간단한 경우)
  * 개발 순서: 서비스, 리포지토리 계층을 개발하고, 테스트 케이스를 작성해서 검증, 마지막에 웹 계층 적용

## Repository 작성 
  * repository class에 @Repository  어노테이션 추가 
    * 스프링 빈으로 등록, JPA 예외를 스프링 기반 예외로 예외 변환
  * EntityManager 주입받기 
    ```java
    @PersistenceContext
    private EntityManager em;
    ```
  * CURD 메서드 작성
    * save
    * findOne
    * findAll, findByName
    
  * EntityManger 주입 받기 (개선) 
    ```java
    @Repository
    @RequiredArgsConstructor
    public class MemberRepository {
      private final EntityManager em;
    }
    ```

## Service 작성
  * service class에 @Service 어노테이션 추가
    * 스프링 빈으로 등록
    * @Transactional(readOnly = true) 추가
      * write 메서드가 존재하면  @Transactional(readOnly = false ) 직접 추가 , default가 false이므로 생략 가능 
      * 트랜잭션, 영속성 컨텍스트
        * readOnly=true 
          * 데이터의 변경이 없는 읽기 전용 메서드에 사용, 영속성 컨텍스트를 플러시 하지 않으므로 약간의 성능 향상(읽기 전용에는 다 적용)
          *  데이터베이스 드라이버가 지원하면 DB에서 성능 향상
  * Repository 주입받기
    * 생성자 Injection 많이 사용, 생성자가 하나면 생략 가능
    ```java
      @Autowired
      private MemberRepository memberRepository;
    ```
 * 서비스 메서드 작성
    * join
      * 중복체크 (ValidateDuplicateMember)
    * findOne
    * findMembers

## feild injection vs setter injection  vs 생성자 injection

  ```java
  //필드 주입
  public class MemberService {
      @Autowired
      MemberRepository memberRepository;
  }

  //생성자 주입
  public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
      this.memberRepository = memberRepository;
    }
  }
  ```
  * 생성자 주입 방식을 권장
    * 변경 불가능한 안전한 객체 생성 가능
    * 생성자가 하나면, @Autowired 를 생략할 수 있다.
    * final 키워드를 추가하면 컴파일 시점에 memberRepository 를 설정하지 않는 오류를 체크할 수 있다.(보통 기본 생성자를 추가할 때 발견)

  * lombok
  ```java
      @RequiredArgsConstructor
      public class MemberService {
      private final MemberRepository memberRepository;
      }
  ```

## 테스트 코드 작성 
  * Ctrl + Alt + T 로 자동 생성 
  * given - when - then 기법 사용
    * 참고: 테스트 케이스 작성 고수 되는 마법: Given, When, Then
    * http://martinfowler.com/bliki/GivenWhenThen.html
  * 필요한 Serivce , Repository , EntityManger (Optional ) 주입
  * 스프링 FW 통합테스트 어노테이션 
    * @RunWith(SpringRunner.class) 
  * 스프링 부트로 테스트시 : : 스프링 부트 띄우고 테스트(이게 없으면 @Autowired 다 실패)
    * @SpringBootTest 
  * 롤백 설정 
    * @Transactional : 반복 가능한 테스트 지원, 
      * 각각의 테스트를 실행할 때마다 트랜잭션을 시작하고 테스트가 끝나면 트랜잭션을 강제로 롤백 
        * 이 어노테이션이 테스트 케이스에서 사용될 때만 롤백 (default 값이 false )
  * 특정 Exception  테스트 성공으로 기대될때 
    * 기대되는 Exception정의 
      * @Test(expected=IllegalStateException.class)
    * 메서드 마지막에 fail 처리 (기대하는 Exception이 발생하지 않음 )
      * Assert.fail("TC 실패 ");

   ```java
    @RunWith(SpringRunner.class)
    @SpringBootTest
    @Transactional
    public class MemberServiceTest {
        @Autowired MemberService memberService;
        @Autowired MemberRepository memberRepository;
        @AutowiredEntityManager em;
   ```
## DB 테스트 환경 분리
  * test 디렉토리 아래 resource 디렉토리를 직접 생성
  * 생성한 디레토리에 application.yml을  복사해온다. 
  * yml 설정 변경 
    * url: jdbc:h2:mem:test
    * ddl-auto: create-drop

## Entity 객체에 Business 로직 구현하기 
   * DDD를 설계할 때 Entity가 자체적으로 해결할수 있는 비즈니스 로직은 자체로 해결하는것이 좋다.
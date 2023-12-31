# Jisoo-Blog-Assignment

---

## 과제 진행 방식

1. Issue에 할 일을 올린다.
2. Issue번호로 main에서 브랜치를 만든다. (ex. issue6)
3. 작업 후, PR에서 이슈번호를 기록하고, 테스트 성공 여부, 트러블 슈팅에 대해 기록한다.
4. PR된 브랜치는 삭제한다.

---

## 기술 스택

<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white"><img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white">
<br><br>
<img src="https://img.shields.io/badge/IntelliJ IDEA-000000?style=for-the-badge&logo=IntelliJ IDEA&logoColor=white"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"><img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=Slack&logoColor=white">

---

### 추가된 요구사항

<details><summary>1. 게시글 좋아요 API</summary>
    
* 사용자는 선택한 게시글에 ‘좋아요’를 할 수 있습니다.
* 사용자가 이미 ‘좋아요’한 게시글에 다시 ‘좋아요’ 요청을 하면 ‘좋아요’를 했던 기록이 취소됩니다.
* 요청이 성공하면 Client 로 성공했다는 메시지, 상태코드 반환하기
</details>
<details><summary>2. 댓글 좋아요 API</summary>
    
- 사용자는 선택한 댓글에 ‘좋아요’를 할 수 있습니다.
- 사용자가 이미 ‘좋아요’한 댓글에 다시 ‘좋아요’ 요청을 하면 ‘좋아요’를 했던 기록이 취소됩니다.
- 요청이 성공하면 Client 로 성공했다는 메시지, 상태코드 반환하기
</details>
<details><summary>3. 예외처리</summary>
    
- 예외처리를 AOP 를 활용하여 구현하기
</details>

### 요구사항에 맞게 수정할 것.

<details><summary>1. User</summary>
    
1. 회원 가입 API
    - username, password를 Client에서 전달받기
    - username은  `최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9)`로 구성되어야 한다.
    - password는  `최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9), 특수문자`로 구성되어야 한다.
    - DB에 중복된 username이 없다면 회원을 저장하고 Client 로 성공했다는 메시지, 상태코드 반환하기
    - 회원 권한 부여하기 (ADMIN, USER) - ADMIN 회원은 모든 게시글, 댓글 수정 / 삭제 가능
2. 로그인 API
    - username, password를 Client에서 전달받기
    - DB에서 username을 사용하여 저장된 회원의 유무를 확인하고 있다면 password 비교하기
    - 로그인 성공 시, 로그인에 성공한 유저의 정보와 JWT를 활용하여 토큰을 발급하고, 
    발급한 토큰을 Header에 추가하고 성공했다는 메시지, 상태코드 와 함께 Client에 반환하기
</details>
<details><summary>2. Post</summary>
    
3. 전체 게시글 목록 조회 API
    - 제목, 작성자명(username), 작성 내용, 작성 날짜를 조회하기
    - 작성 날짜 기준 내림차순으로 정렬하기
    - 각각의 게시글에 등록된 모든 댓글을 게시글과 같이 Client에 반환하기
    - 댓글은 작성 날짜 기준 내림차순으로 정렬하기
    - 게시글/댓글에 ‘좋아요’ 개수도 함께 반환하기
4. 게시글 작성 API
    - ~~토큰을 검사하여, 유효한 토큰일 경우에만 게시글 작성 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기!
    - 제목, 작성자명(username), 작성 내용을 저장하고
    - 저장된 게시글을 Client 로 반환하기
5. 선택한 게시글 조회 API
    - 선택한 게시글의 제목, 작성자명(username), 작성 날짜, 작성 내용을 조회하기 
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
    - 선택한 게시글에 등록된 모든 댓글을 선택한 게시글과 같이 Client에 반환하기
    - 댓글은 작성 날짜 기준 내림차순으로 정렬하기
    - 게시글/댓글에 ‘좋아요’ 개수도 함께 반환하기
6. 선택한 게시글 수정 API
- ~~토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 수정 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기!
- 제목, 작성 내용을 수정하고 수정된 게시글을 Client 로 반환하기
- 게시글에 ‘좋아요’ 개수도 함께 반환하기
7. 선택한 게시글 삭제 API
    - ~~토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 게시글만 삭제 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기!
    - 선택한 게시글을 삭제하고 Client 로 성공했다는 메시지, 상태코드 반환하기
</details>
<details><summary>3. Comment</summary>
    
8. 댓글 작성 API
    - ~~토큰을 검사하여, 유효한 토큰일 경우에만 댓글 작성 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기!
    - 선택한 게시글의 DB 저장 유무를 확인하기
    - 선택한 게시글이 있다면 댓글을 등록하고 등록된 댓글 반환하기
9. 댓글 수정 API
    - ~~토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 댓글만 수정 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기!
    - 선택한 댓글의 DB 저장 유무를 확인하기
    - 선택한 댓글이 있다면 댓글 수정하고 수정된 댓글 반환하기
    - 댓글에 ‘좋아요’ 개수도 함께 반환하기
10. 댓글 삭제 API
    - ~~토큰을 검사한 후, 유효한 토큰이면서 해당 사용자가 작성한 댓글만 삭제 가능~~  ⇒ Spring Security 를 사용하여 토큰 검사 및 인증하기!
    - 선택한 댓글의 DB 저장 유무를 확인하기
    - 선택한 댓글이 있다면 댓글 삭제하고 Client 로 성공했다는 메시지, 상태코드 반환하기
</details>
<details><summary>4. Exception Handling</summary>
    
11. 예외 처리
    - 토큰이 필요한 API 요청에서 토큰을 전달하지 않았거나 정상 토큰이 아닐 때는 "토큰이 유효하지 않습니다." 라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - 토큰이 있고, 유효한 토큰이지만 해당 사용자가 작성한 게시글/댓글이 아닌 경우에는 “작성자만 삭제/수정할 수 있습니다.”라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - DB에 이미 존재하는 username으로 회원가입을 요청한 경우 "중복된 username 입니다." 라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - 로그인 시, 전달된 username과 password 중 맞지 않는 정보가 있다면 "회원을 찾을 수 없습니다."라는 에러메시지와 statusCode: 400을 Client에 반환하기
    - 회원가입 시 username과 password의 구성이 알맞지 않으면 에러메시지와 statusCode: 400을 Client에 반환하기
</details>

---

## ERD(Entity Relationship Diagram)

![image](https://github.com/JisooPyo/Spring-Blog-Assignment/assets/130378232/86b8ea59-a446-4322-9a5e-89697b7d0390)

---

## API

[포스트맨 이용](https://documenter.getpostman.com/view/27928837/2s946eAYw7)

---

## Trouble Shooting(lv3 + lv4 과제)

### PR에 기록.

PR번호

[#5 security 수정에 따른 Post 관련 클래스 수정](https://github.com/JisooPyo/Spring-Blog-Assignment/pull/5)

[#7 Comment 기능 추가](https://github.com/JisooPyo/Spring-Blog-Assignment/pull/7)

[#9 게시글 좋아요 기능 추가](https://github.com/JisooPyo/Spring-Blog-Assignment/pull/9)

[#11 댓글 좋아요 기능 추가](https://github.com/JisooPyo/Spring-Blog-Assignment/pull/11)

---

## Trouble Shooting(lv2 과제)

### 1. createdAt, modifiedAt 변수 값이 저장이 되지 않음

###### DB에 column은 만들어졌는데 변수 값이 저장이 안되고 null로 저장이 되었다.

-->

application에 @EnableJpaAuditing annotation을 하지 않아서 생긴 문제였다.
JPA Auditing 기능을 사용하려면 꼭 스프링부트에 annotation을 달아서 알려주어야 한다.

### 2. application을 실행시켰더니 다음 오류가 나고 아무것도 먹히지 않음.

###### This generated password is for development use only. Your security configuration must be updated before running your application in production.

-->

SpringBoot Security 문제로, 처음 시작할 때 만들어진 key를 이용해서 security configuration을 update 시켜주어야 한다.
간단하게 security를 잠깐 끄는 옵션을 찾아서 해결.
Application에 @SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) 추가

### 3. POST 요청 보냈을 때의 오류

###### java.lang.IllegalArgumentException: rawPassword cannot be null

-->

Controller에서 SignupRequestDto에 @RequestBody annotation 달아서 해결

### 4. POST 요청 -> DB에 회원정보 등록은 되었으나 ERROR 발생

###### 2023-06-29T01:42:20.033+09:00 ERROR 11688 --- [nio-8080-exec-2] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.thymeleaf.exceptions.TemplateInputException: Error resolving template [회원가입 완료], template might not exist or might not be accessible by any of the configured Template Resolvers] with root cause

-->

Controller 메서드에서 String을 반환하는 메서드에 "로그인 성공" 같은 걸 반환하게 하였더니, thymeleaf의 기능으로 그와 같은 이름의 html파일을 못 찾아서 오류가 남. 이 프로젝트에서는 뷰를 반환하지 않으므로 thymeleaf 의존성 주석처리해서 해결.


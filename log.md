<h1>Log</h1>

<h3>1. 기획1</h3>
2023/7/15 ~ 2023~07/30 (띄엄띄엄) <br/>

<br/>

- 프레임워크 선정 (프론트: Vue, 백: Spring)
- 이름 선정 fixadate -> 최병진씨 아이디어,,, 짱짱맨,,,
- 주요 기능 기획 (Adate, Dates, Anonymous Dates, Alert Centre, Alarm, Notes)
- 프로젝트 규모 설정 (웹, 웹앱, ios, android)
- 유저 설정 (중고등학생, 회사원), 사용 상황 설정 
- Use Cases 구상 
- 화면 스케치
- 주요 기능 개발 순서 지정
1. Preferences
2. Anonymous Dates
3. Adate
4. Dates
5. Reminder
6. Alert Centre
7. Widger
8. Notes (sharing)

<br/>

* * * *

<h3>2. 프로젝트 생성 및 사용환경 세팅</h3>
2023/07/26 ~ 2023/07/27 <br/>

<br/>

- 프로젝트 생성하고, 서버 켜보고, 화면 나오나 보고, 깃 레포 만들고,,, 별거안함...

<br/>

* * * *

<h3>3. home 화면, NavBar 구성 및 Vue Router 설정</h3>
2023/07/28 ~ 2023/07/28 <br/>

<br/>

<img width="500" alt="" src="https://github.com/sungjun4403/fixadate/assets/96364048/54dc7e8b-aacd-4ee7-9820-dc7a63e6d539">
<br/>

- 폰으로 찍은 사진 밖에 없네,,, ~~기록을 잘하자 3회 복창~~
 
<br/>

* * * *

<h3>3. home 화면, NavBar 구현 1</h3>
2023/07/30 ~ 2023/07/31 <br/>

<br/>

<img width="500" alt="Screenshot 2023-07-31 at 4 43 25" src="https://github.com/sungjun4403/fixadate/assets/96364048/1bc7e589-e48b-4d11-a066-41552456a187">

<br/>

- 기획 최병진님이 요청하신 디자인
  
<br/>

<img width="750" alt="Screenshot 2023-07-31 at 4 43 25" src="https://github.com/sungjun4403/fixadate/assets/96364048/5e81abc8-2bce-4446-b402-449c65596392">

<br/>

- 내가 만든 초안,,, ~~초라한~~
- 똑.같.다.!

<br/>

- 기획 및 디자인 협의할 내용
1. font
2. 핀 디자인
3. 노트 디자인
4. ios cal widget
5. weather icon
6. NavBar icons
7. difference between cal widget and memo
8. default NavBar status

<br/>

* * * *

<h3>4. 홈화면 디자인 수정, 백엔드 member, Adate, Team(group) 개발 </h3>
2023/08/1 ~ 2023/08/9 <br/>

<br/>

<img width="400" src="https://github.com/sungjun4403/fixadate/assets/96364048/c4e65f78-1192-4dcb-add0-0169bbc6e67b">

<br/>

- 배치 및 비율 변경
- fixadate 폰트 설정
- 아이콘 디자인 및 적용

<br/>

<img width="800" alt="Screenshot 2023-08-03 at 2 12 01" src="https://github.com/sungjun4403/fixadate/assets/96364048/2064f2ce-c860-40c3-b516-20f27106d3a5">

<br/>

- 일단 이정도... group 구현이 까다로움. group 이름 자체도 지정어라서 좀 애먹었고 team으로 바꿈. Member <-> Team(group)이 Many to Many인데 중간 테이블 승격이 애매함. many to one, one to many로 풀어쓰라고 하는데 필요성을 딱히 못느끼겠음
- Adate도 일단 entity 구현 정도만 해놓음. team 구현이 끝나야 뭐가 될듯

<br/>
  
<img width="800" src="https://github.com/sungjun4403/fixadate/assets/96364048/f1120e61-9295-476d-bf21-ccc24b9cacb6">

- spring-vue axios 통신 성공. Cors 이슈도 해결

<br/>

* * * *

<h3>5. 백엔드 Member, Team, Adate 관계 매핑, vue group 생성 화면 구현</h3>
2023/08/1 ~ 2023/08/10 <br/>

<br/>

<img width="700" src="https://github.com/sungjun4403/fixadate/assets/96364048/f42f9a99-e2f9-42e0-b994-b321f8ce6c40">

<br/>

- MemberTeam 테이블 구현... many to many, one to many, many to one 다 시도해보고 왜 필요한지 깨닫음...
- Team CRUD 구현 후 MemberTeamService에 viewAllByMemberId 구현. memberId -> MemberTeam search -> team search

<br/>

<img width="400" src="https://github.com/sungjun4403/fixadate/assets/96364048/01487719-efd2-4c20-909b-37508c6c1db7">

<br/>
  
- List<TeamResponse>에 감싸서 v-for로 화면에 띄움 (그냥 List<Team>은 안됐음 이유는 모름... ㅠ)
- Adate도 Member랑 매핑 해놓음. CRUD는 아직. 로그인 기능도 아직

<br/>

* * * *

<h3>6. google OAuth 로그인 구현</h3>
2023/08/12 <br/>

<br/>

<img width="400" src="https://github.com/sungjun4403/fixadate/assets/96364048/3e03ccd9-f9dc-4db3-bfff-64d8442c4b72">

- 구글 OAuth 로그인 구현
- 추출 가능한 정보: 
iss=https://accounts.google.com, 
azp=120890874732-gbu01labf2gh9id7hkauropgeuubjpun.apps.googleusercontent.com, aud=120890874732-
gbu01labf2gh9id7hkauropgeuubjpun.apps.googleusercontent.com, 
sub=113883840159478232271, 
email=geulligu89@gmail.com, 
email_verified=true, 
at_hash=u8vZTAlqgY7ekxHFBEA6rA, 
name=이성준, 
picture=https://lh3.googleusercontent.com/a/AAcHTtfwSwIgsSzYAybeZAKjaHoJFbd_GACpsl2RGJqvWCYj=s96-c,
given_name=성준,
family_name=이,
locale=ko, 
iat=1691791922, 
exp=1691795522, 
alg=RS256, 
kid=911e39e27928ae9f1e9d1e21646de92d19351b44, 
typ=JWT

구글, 카카오, 네이버, 애플 로그인 구현 예정

<br/>

* * * *

<h3>7. naver 로그인 구현</h3>
2023/08/13 <br/>

<br/>

 - 구글 로그인 후 url에 주어지는 path variable 'code'를 백으로 보내 유저 정보를 받아오기 위한 페이지인 afterlogin 페이지 개편. 로그인 플랫폼별 afterlogin 페이지 할당. (ex. /googleafterlogin, /naverafterlogin, etc.)
 - 링크로 로그인 플랫폼 판별이 어렵기 때문.
 - 네이버 로그인 화면
   
<img width="400" src="https://github.com/sungjun4403/fixadate/assets/96364048/6394e596-e8d7-421f-a44d-0255d64d6945">


<br/>
 
 - 네이버 로그인시 추출할 수 있는 유저 정보
  
<img width="400" src="https://github.com/sungjun4403/fixadate/assets/96364048/8bb5c379-9c3a-43fe-a2ca-901f147f13a2">

<br/>

* * * *

<h3>8. kakao 로그인 구현 및 trubleshooting</h3>
2023/08/15 ~ 2023/08/23<br/>

<br/>

 - kakao 로그인 구현 완료. 근데 restTemplate 송신 과정에서 dto to multiValueMap conversion이 원활하지 못했음. 이유 미상. google과 정확히 똑같이도 구현해보았으나 httpEntity로 포장해서 보내지 않으면 body로 실리지가 않았음 (no body 어쩌구 오류 발생)
 - 개발 번외로 kakao 로그인시 추출할 수 있는 유저 정보는 상당히 제한적인 편이였음. 정확하게는 추출 과정이 제한적. 구글 같은 경우는 유저 정보 수집을 안해서, 줄 정보가 없어서 제공을 못받았다면, kakao는 민감한 정보를 너무 많이 가지고 있어서 제한적으로 제공하는 느낌. (birth보다 연령대 사용을 권장하는 것부터가 개인정보에 민감해보임) 로그인 후 정보제공 동의 화면에서도 배포 후 심사를 받아야만 필수 제공을 받을 수 있음. 선택 제공 받을 때에도 각 항목에 정보 사용 목적을 서술해야 했음. 네이버는 카카오에 비하면 적당히 중도.
 - 진짜 문제는 apple 로그인 구현. 다행히도 (apple스럽지 않게) 여타 Oauth 2.0과 같은 로그인 프로토콜을 사용하지만 문제는 연 $99의 apple developer program에 등록해야만 apple의 api가 사용 가능하다는 것. 로그인 기능 외에도 캘린더 일정 불러오기 기능도 위 프로그램 가입이 필수.

* * * *

<h3>9. trubleshooting& exception handling, login controller, login service refactoring</h3>
2023/08/25 ~ <br/>

<br/>

- vue 404 handling, 코드 일관화(?), 주석 달고 어쩌구 저쩌구, 뭘 하긴 했는데 따로 적기는 좀 애매한 내용들 뿐이네... 과감히 로그 패스~!

<br/>

* * * *

<h3>10. kakao 회원가입 구현 및 토큰 검증 맛보기</h3>
2023/08/25 ~ 2023/08/30<br/>

일단 눈물 한번 닦고,,, 미친채 쓴 장문의 눈물 젖은 찡찡이 보고 가시겠습니다

<img width="600" src="https://github.com/sungjun4403/fixadate/assets/96364048/9c7eadb6-4e54-408d-8078-5bd3265e99b0">

<br/><br/>

아래는 Input
<img width="392" src="https://github.com/sungjun4403/fixadate/assets/96364048/5df41fb6-c2f4-4532-9771-7792b251000c">

<br/><br/>

아래는 DB에 푸시된 결과... 일단 다 드가긴 함... AccessToken 검증하고 저장하거나 refresh_token_expires_in은 이제 구현해야됨
<img width="1500" src="https://github.com/sungjun4403/fixadate/assets/96364048/f84e178e-dc7d-479f-aafa-395fdf30b0b2">

토큰 검증도 해봄. 필터 만들고 플랫폼별 구현만 하면 될듯...
근데 스프링 업데이트 되면서 필터 많이 바꼈던데 진짜 벌써부터 무섭고 두렵고 손과 발이 벌벌 떨리고 눈물이 흐르고......................

<br/>

* * * *

<h3>11. jwt request filter, cors filter</h3>
2023/08/31 ~ 2023/09/12<br/>

- jwt request filter를 구현하기위해 spring security를 gradle에 설치함 -> 여기서부터 문제가 시작된건데...
- 아래는 기존에 구현해놓은 CORS Configuration

<br/>

<img width="1100" src="https://github.com/sungjun4403/fixadate/assets/96364048/b6353efe-c055-4fc6-9817-ed66fadf8c58">

<br/>

- 이 코드로 CORS 문제가 해결되었었었따,,,
- @Bean으로 등록해놓으면 우선순위로 request를 납치할 수 있을 줄 알았으나,,, spring security를 설치한 뒤에는 spring security가 priority를 가지게 되었다 -> 일단 spring security가 문제인걸 아는데도 꽤 오래걸림
- @EnableWebSecurity 및에 아래 코드를 작성하면 될 줄 알았는데 역시 실패, spring security document에서 제공하는 cors solution을 사용하는 방법도 있었는데 역시 안됨...
- 이런 저런 방법 시도 할래도 latest release spring security가 심하게 많이 바뀌어서 참고할만한 포스팅이 거의 없음
- unoffical, offical 둘 다 별로 도움이 안되는 다소 절망적인 상황
- 과거에 구현했던 방법을 사용하려 보니 2021.05 즈음 버전,,, 너무 outdated 되어서 사용하기 애매함 + spring 버전도 안맞음(?)
- 그렇다고 proxy를 쓰기에는... 좀 아닌데,,,
- 총체적 난국...
- 아 그리고 flutter 공부를 진짜 진짜 시작했는데 최근 flutter는 웹 배포도 가능하단다. 웹(vue) + 앱(flutter) / 웹 소개 페이지 -> 웹&앱(flutter) / 웹 소개 페이지로 개발하기로 했다. 웹 개발을 일단 중단하고 플러터로만 구현하려 한다.
- figma 디자인을 flutter로 옮기는 법도 찾았다. 야호!
- 진짜 야호! 개발 로그 작성하면서 CORS issue 해결했다! 역시 official document는 틀리지 않아
- 

<br/>

* * * *

<h3>12. jwt design</h3>
2023/09/13 ~ <br/>

- jwt service -> jwt request filter -> jwt exception filter

<br/>

* * * *

<h3>13.dart lang, flutter 공부</h3>
2023/08/25 ~ <br/>

<br/>

* * * *

<h3>14. Cors Issue handling...</h3>
2023/09/13 ~ 2023/09/26<br/>

- 해결했던 Cors 이슈가 재발. 정확하게는 403에러. 전후과정은 고사하고 원인 결과 먼저 생각해보면 narrow 했던 authorizeHttpRequest일듯 싶음. spring security configure 후 h2 console이 사용이 불가능해져 authorizeHttpRequest에 h2 console 주소를 exception으로 두었는데 그 때문에 h2 console만 요청 접근이 가능했음.
- ~~spring security mthfuxker~~

<br/>
  
* * * *

<h3>14. jwt service</h3>
2023/09/13 ~ 2023/09/22<br/>

google 먼저

- doFilterInternal

1. createAccessToken
2. createRefreshToken
3. saveAuthentication
4. checkAccessTokenAndAuthentication
5. sendAccessToken
6. extractAccessToken
7. checkRefreshTokenAndReIssueAccessToken

<br/>
  
* * * *

<h3>15. jwt service</h3>
2023/09/22 ~ 2023/09/29<br/>

~~google 먼저~~ -> kakao 먼저 (이미 누가 해놨더라고)

- doFilterInternal
  - 이건 뭐 코드 그대로 쓰면 되고

1. createAccessToken - 이건 뭐 만드는게 아니라 가져오는 거니까 전달만 잘 하면 됨 (method 자체가 필요 없음)
2. createRefreshToken - 위랑 2222
3. saveAuthentication - 이건 조금만 바꾸면 되고 gitId -> oauthId
4. checkAccessTokenAndAuthentication - 이건 switch문으로 각 플랫폼 별로 확인 해야됨
5. sendAccessToken - 이건 
6. extractAccessToken
7. checkRefreshTokenAndReIssueAccessToken

<br/>
  
* * * *

<h3>16. jwt request filter</h3>
2023/09/30 ~ 2023/10/08<br/>

- 진전 사항은 딱히 없지만 일단 써보는 개발 로그
- 대강 토큰 발급하고 넘기는 건 되는데 문제가
  
~~~java

String extractedGitID = SecurityUtil.getLoginedUserGitId();

public static String getLoginedUserGitId() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String name = authentication.getName();

    return name;
}

~~~

- 위 코드의 작동원리를 모르겠음. spring security를 사용하는 이유라고도 볼 수 있는 중요한 기능이라는데 이해가 안돼서 구현이 어려움. 몰라몰라
- 아 이제 이해함

<br/>
  
* * * *

<h3>17. jwt request filter 대충 사용할 수 있을 정도로 완성 </h3>
2023/09/30 ~ 2023/10/08<br/>

- request에서 oauthPlatform, accessToken분리 후 oauthPlatform 케이스에 따라 각 링크 (api.kakao, api.google, etc.)로 토큰을 검증 받음 (일단 카카오만)
- 최초 회원가입시에는 유저가 생성되지 않은 상태이기 때문에 (유저를 생성하는 단계이기 때문에) SecurityContextHolder.getContext()가 작동하지 않음 member를 db에서 찾은 후 saveAuthentication하도록 했음
- jwtRequestFilter의 메서드를 퍼블릭으로 전환하는 것보다 불편해도 로그인 후 한번 더 접속해 고의적으로 saveAuthentication()만을 목적으로 하는 페이지를 생성함.
- 그리고 어쩌다보니 SecurityContextHolder.Authentication의 userDetail클래스의 유저와 pw가 unique항목이라 같은 유저가 두번 데이터베이스에 저장되는 것을 막을 수 있게 됨(물론 추후 orm으로 unique 설정 예정)
- 그리고 뭐 이것저것 함 vue를 최종적으로 사용할 것은 아니지만 현재 api가 정상적으로 작동하는지 확인하기 위해서 페이지를 만들기에는 vue가 제일 쉬운것 같아서 일단 계속 이걸로 만들고 있음. ProfileEdit 페이지 만들어서 name, nickname, birth, gender, profession 등 항목들 수신 받음. 기본 폰트도 roboto regular 400으로 수정함. 뭐 text-align:center 외에도 이것저것,,, 그래도 가끔 보게 될거니까 볼만하게 다듬음
- 로그아웃 기능 구현에서 막힘. localhost:8080/logout으로 로그아웃하려했는데 spring security의 기본 로그아웃에 하이재킹 당해서 로그아웃 성공 후 리다이렉트가 자동으로 되버림 localhost:8080/login?logout으로 가버림...
- 해결하려고 <code>response.setStatus(HttpServletResponse.SC_OK);</code> 를 했는데 안됨,,,
- 아무튼 spring security logout의 중요한 몇가지를 뽑으라면 1. delete cookies, 2. invalidate session, 3. logoutSuccessHandler (callback uri), 4. SecurityContextHolder.clearContext()
- 아맞다 그리고 Adate 프론트 페이지도 조금 구현함
- 그리고 앞으로 해야되는게
 - logout 
 - update refreshToken
 - reissue accessToken
 - sendAccessTokenAndRefreshToken
 - setAccessTokenHeader
 - setRefreshTokenHeader
 - jwtExceptionFilter
 - Adate
- 그래서 현재는 <code>String oauthId = jwtService.extractOauthId(jwtService.extractAccessToken(request).orElseThrow(), jwtService.extractOauthPlatform(request)).orElseThrow();</code>

<br/>
  
* * * *

<h3>18. logout, refactoring</h3>
2023/10/08 ~ 2023/10/21<br/>

- shtt. logout 관련 개발 로그 작성 한 줄 알았는데 꿈이였고.
- 팀원 공유용 프로젝트 문서 작성하느라 개발을 잠깐 못했음
<a href="https://fixadate.gitbook.io/fixadate-api-document/">⚒️about Fixadate</a>
- gitbook으로 작성함. 가끔 쓸 듯. 쉽게 작성하기 좋음.
- logout 프로세스 전반을 구현하는데 이런저런 이슈가 있었음. http://localhost:8080/logout으로 요청을 보내서 백에서 받으려 했으나 /logout은 spring security에서 default logout url 지정되어있었다... 근데 알아보니 SecurityFilterChain에서 HttpSecurity 제공 logout 기능이 꽤나 괜찮아서 그냥 사용하기로 했다.
'''java
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors(); // deprecated for spring security 7.0 (available for now)
    http.authorizeHttpRequests().anyRequest().permitAll();
    http.headers(headers -> headers.frameOptions().disable());
    http.csrf().disable();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.formLogin().disable();
    http.httpBasic().disable();
    http.logout()
            .logoutUrl("/logout")
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .addLogoutHandler(customLogoutHandler())
            .addLogoutHandler(securityContextLogoutHandler())
            .logoutSuccessHandler((request, response, authentication) -> {
                response.setStatus(HttpServletResponse.SC_OK);
            })
            .permitAll();
    http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
    http.addFilterBefore(jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);

    return http.build();
}
'''
- deleteCookies, invalidateHttpSession, clearAuthentication, LogoutHandler, etc... 쓸만한 기능들이다
- 근데 customLogoutHandler를 bean으로 등록해서 원하는 메서드를 실행하기 어려웠다. bean 생성 시에 생성자에 들어갈 것들이 너무 많았음. 그래서 로그아웃시에 프론트에서 요청을 두개를 주는걸로 함 (/logout, /sslogout)
- 서버사이드 로그아웃의 목적은 SecurityContextHolder.clearContext()인데, Context가 남아있는지 확인하는 과정에서 <code>SecurityContextHolder.getContext().getAuthentication();</code>가 null로 나오는 오류가 있다. 왜이러시는지 아직도 모르겠땅.
- 프로젝트 문서하고 API 문서하고 둘 개로 나누어서 작성하고 있는데 생각하던 것 보다 코드가 상당히 중구난방하다. 리턴타입이 다르고, url 링크가 다르고, 어쩌구 저쩌구 대충 맘에 안든다는 뜻. 나는 이해하는데 코드 처음 보는 사람이 이해하기엔 좀 규칙이 부족하단 생각이 들었음. 아무튼 그래서 공사중임. 

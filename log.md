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

* * * *

<h3>8. kakao 로그인 구현 및 trubleshooting</h3>
2023/08/15 ~ 2023/08/23<br/>

<br/>

 - kakao 로그인 구현 완료. 근데 restTemplate 송신 과정에서 dto to multiValueMap conversion이 원활하지 못했음. 이유 미상. google과 정확히 똑같이도 구현해보았으나 httpEntity로 포장해서 보내지 않으면 body로 실리지가 않았음 (no body 어쩌구 오류 발생)
 - 개발 번외로 kakao 로그인시 추출할 수 있는 유저 정보는 상당히 제한적인 편이였음. 정확하게는 추출 과정이 제한적. 구글 같은 경우는 유저 정보 수집을 안해서, 줄 정보가 없어서 제공을 못받았다면, kakao는 민감한 정보를 너무 많이 가지고 있어서 제한적으로 제공하는 느낌. (birth보다 연령대 사용을 권장하는 것부터가 개인정보에 민감해보임) 로그인 후 정보제공 동의 화면에서도 배포 후 심사를 받아야만 필수 제공을 받을 수 있음. 선택 제공 받을 때에도 각 항목에 정보 사용 목적을 서술해야 했음. 네이버는 카카오에 비하면 적당히 중도.
 - 진짜 문제는 apple 로그인 구현. 다행히도 (apple스럽지 않게) 여타 Oauth 2.0과 같은 로그인 프로토콜을 사용하지만 문제는 연 $99의 apple developer program에 등록해야만 apple의 api가 사용 가능하다는 것. 로그인 기능 외에도 캘린더 일정 불러오기 기능도 위 프로그램 가입이 필수.





<template>
    <div id="InfoInputBody">
        <h2>Input</h2>
        

        profileImg<br>
        <input class="InfoInputTag" id="profileImg" placeholder="profileImg" size="30"> <br><br>
        <!-- --------------------------------------------------------------- -->
        signatureColor<br>
        <input class="InfoInputTag" id="signatureColor" placeholder="signatureColor" size="20"> <br><br>
        <!-- --------------------------------------------------------------- -->
        nickname <br>
        <input class="InfoInputTag" id="nickname" placeholder="nickname" size="20"> 
        <button id="getRandNickButton" @click="getRandNick()">🎲</button> <br><br>
        <!-- --------------------------------------------------------------- -->
        name <br>
        <input class="InfoInputTag" id="name" placeholder="name" size="10"> <br><br>
        <!-- --------------------------------------------------------------- -->
        gender <br>
        <input type="checkbox" id="male">male <input type="checkbox" id="female">female <br><br>
        <!-- --------------------------------------------------------------- -->
        age
        <input class="InfoInputTag" id="birth" placeholder="birth" size="10"> <br><br>
        <!-- --------------------------------------------------------------- -->    
        profession
        <select id="profession">
            <option>== select profession ==</option>
            <optgroup label="Student">
                <option>middleschool</option>
                <option>highschool</option>
                <option value="University">University</option>
            </optgroup>
            <optgroup label="직장인">
                <option>디자인</option>
                <option>IT/Tech</option>
                <option>교육</option>
            </optgroup>
        </select>
        <!-- --------------------------------------------------------------- -->
        
        <button @click="signUp()">submit</button>


    </div>
</template>

<script>
import axios from 'axios'
import router from '../../router'

export default {
    name: "InfoInput",
    props: ['oauthId', 'oauthPlatform', 'name', 'gender', 'profileImg', 'birth', 'AccessToken', 'RefreshToken'],
    setup() {    
    },

    beforeMount() {
        localStorage.setItem("oauthPlatform", this.oauthPlatform)
        localStorage.setItem("AccessToken", this.AccessToken)
        localStorage.setItem("OauthId", this.oauthId)
    }, 

    mounted() {
        this.fillInfo()
        console.log(this.AccessToken)
        console.log(this.RefreshToken)
    },

    methods: {
        fillInfo() { //Oauth로 받아온 정보 input tag에 미리 채워넣는 메서드
        
            document.getElementById("name").value = this.name
            document.getElementById("nickname").value = ""
            if (this.gender == "male") {
                document.getElementById("male").checked = true
            }
            if (this.gender == "female") {
                document.getElementById("female").checked = true
            }
            // document.getElementById("profileImg").value = this.gender
            document.getElementById("birth").value = this.birth
        },

        getRandNick() { //백에서 랜덤 닉네임 받아오기
            axios ({
                url: "http://localhost:8080/getrandnick",
                method: "get"
            }).then((response) => {
                document.getElementById("nickname").value = response.data
            })
        },

        signUp() { // Create member
            
            var genderVal = ""
            if (document.getElementById("male").checked == true) {
                genderVal = true
            }
            if (document.getElementById("female").checked == true) {
                genderVal = true
            }

            axios ({
                url: "http://localhost:8080/member",
                method: "post",
                headers: {
                    'Authorization': 'Bearer ' + localStorage.AccessToken,
                    'oauthPlatform': localStorage.oauthPlatform
                },
                data: {
                    oauthId: this.oauthId,
                    oauthPlatform: this.oauthPlatform,
                    name: document.getElementById("name").value,
                    profileImg: document.getElementById("profileImg").value,
                    profession: document.getElementById("profession").value,
                    nickname: document.getElementById("nickname").value,
                    birth: document.getElementById("birth").value,
                    gender: genderVal,
                    signatureColor: document.getElementById("signatureColor").value,
                    refreshToken: this.RefreshToken
                }
            }).then((response) => {
                console.log(response)
                if (response.status == 200) {
                    router.push("/redirect")    
                }
                else {
                    router.push("/404")
                }
                
            })
        }
    }
}
</script>

<style scoped>
    #InfoInputBody {
        margin-left: 10%;
    }

    #getRandNickButton {
        border: none;
        background-color: black;
    }
</style>
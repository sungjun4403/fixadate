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
        <select>
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

export default {
    name: "InfoInput",
    props: ['oauthId', 'oauthPlatform', 'name', 'gender', 'profileImg', 'birth', 'AccessToken', 'RefreshToken'],
    setup() {
        
    },

    mounted() {
        this.fillInfo()
    },

    methods: {
        fillInfo() {
        
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

        getRandNick() {
            axios ({
                url: "http://localhost:8080/getrandnick",
                method: "get"
            }).then((response) => {
                document.getElementById("nickname").value = response.data
            })
        },

        signUp() {
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
                    'Authorization' : 'Bearer ' + ""
                },
                data: {
                    oauthId: this.oauthId,
                    oauthPlatform: this.oauthPlatform,
                    refreshToken: "",
                    name: document.getElementById("name").value,
                    profileImg: this.profileImg,
                    nickname: document.getElementById("nickname").value,
                    birth: document.getElementById("birth").value,
                    gender: genderVal,
                    signatureColor: ""
                }
            }).then((response) => {
                console.log(response)
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
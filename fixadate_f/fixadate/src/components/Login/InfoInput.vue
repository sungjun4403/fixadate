<template>
    <div id="InfoInputBody">
        <h2>Input</h2>

        <input id="nickname" placeholder="nickname" size="20"> 
        <button id="getRandNickButton" @click="getRandNick()">🎲</button> <br><br>

        <input id="name" placeholder="name" size="10"> <br><br>
        
        gender
        <input type="checkbox"><input type="checkbox"> <br><br>

        age
        <input id="age" placeholder="name" size="10"> <br><br>

        profession
        <select>
            <option>== select profession ==</option>
            <optgroup label="Student">
                <option>middleschool</option>
                <option>highschool</option>
                <option>University</option>
            </optgroup>
            <optgroup label="직장인">
                <option>디자인</option>
                <option>IT/Tech</option>
                <option>교육</option>
            </optgroup>
        </select>



    </div>
</template>

<script>
import axios from 'axios'

export default {
    setup() {
        
    },

    beforMount() {
        fillInfo()
    },

    methods: {
        fillInfo() {
            axios ({
                url: "http://localhost:8080/",
                method: ""
            }).then((response) => {
                document.getElementById("name").value = response.data
                document.getElementById("nickname").value = response.data
                document.getElementById("profileImg").value = response.data
                //gender if
                document.getElementById("age").value = response.data
                document.getElementById("nickname").value = response.data 
            })
        },

        getRandNick() {
            axios ({
                url: "http://localhost:8080/getrandnick",
                method: "get"
            }).then((response) => {
                document.getElementById("nickname").value = response.data
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
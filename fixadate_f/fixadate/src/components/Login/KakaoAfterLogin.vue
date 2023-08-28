<template>
    <div>
        KAKAOAAKAAKAKKAK
        <button @click="issueToken()">doihjsk</button>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    setup() {
        
    },
    mounted() {
        this.extractUserInfo()
    },
     
    methods: {
        extractUserInfo() {
            var code = document.location.href.split("?")[1]
            
            axios ({
                url: "http://localhost:8080/api/kakao/login?" + code,
                method: "get"
            }).then((response) => {
                console.log(response.data)
            })
        },
    }
}
</script>

<style scoped>

</style>
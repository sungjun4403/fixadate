<template>
    <div>
        NAVER AFTERLOGIN
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
            
            console.log(code)
            axios ({
                url: "http://localhost:8080/api/naver/login?" + code,
                method: "get"
            }).then((response) => {
                console.log(response.data)
            })
        }
    }
}

</script>

<style scoped>

</style>
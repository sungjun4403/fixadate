<template>
    <div>
        redirecting (kakao)
    </div>
</template>

<script>
import axios from 'axios'
import router from '../../router'
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
                // console.log(response.data)
                router.push({
                    name: "InfoInput",
                    params: {
                        info: response.data,
                        name: "",
                        gender: "",
                        profileImg: "",
                        birth: ""
                    }
                })


            })
        },
    }
    
}
</script>

<style scoped>

</style>
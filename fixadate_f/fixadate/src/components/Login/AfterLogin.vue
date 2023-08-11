<template>
    <div>
        AFTERLOGIN
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
            var url = document.location.href
            url = url.split("/")
            url = url[3].split("?")
            var code = url[1]
            
            console.log(code)
            axios ({
                url: "http://localhost:8080//api/v1/oauth2/google?" + code,
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
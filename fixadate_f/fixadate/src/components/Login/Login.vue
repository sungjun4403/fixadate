<template>
    <div>
        <button @click="getGoogleLoginUrl()">
            GOOGLE LOGIN
        </button>        
    </div>
</template>

<script>
import axios from 'axios'
export default {
    setup() {
        
    },
    methods: {
        getGoogleLoginUrl() {
            axios({
                url: "http://localhost:8080/api/v1/oauth2/google",
                method: "post"
            }).then((response) => {
                document.location.href = response.data
            })
        }
    }
}
</script>

<style scoped>

</style>
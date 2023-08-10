<template>
    <div>
        <div>
            <input id="name"><br>
            <input id="groupColor"><br>
            <input id="description"><br>
            <button @click="addGroup();">add group</button>
        </div>
        <div id="GroupList">
            dsadasdas
        </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    setup() {
        
    },

    Mounted() {
        LoadAllGroupsByMember()
    },

    methods: {
        addGroup() {
            var name = document.getElementById("name").value
            var groupColor = document.getElementById("groupColor").value
            var description = document.getElementById("description").value

            axios({
                url: 'http://localhost:8080/group',
                method: 'post',
                data: {
                    name: name,
                    groupColor: groupColor,
                    description: description
                }
            }).then((response) => {
                document.getElementById("name").value = ''
                document.getElementById("groupColor").value = ''
                document.getElementById("description").value = ''
                this.LoadAllGroupsByMember()
            })
        },

        LoadAllGroupsByMember() {
            axios({
                url: 'http://localhost:8080/group/1',
                method: 'get',
            }).then((response) => {
                document.getElementById("GroupList").value = 'GOUPRROURPORUP'
            })
        }
    }
}
</script>

<style scoped>

</style>
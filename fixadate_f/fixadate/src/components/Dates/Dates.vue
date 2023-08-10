<template>
    <div>
        <div>
            <input id="name"><br>
            <input id="groupColor"><br>
            <input id="description"><br>
            <button @click="addGroup();">add group</button>
            <button @click="LoadAllGroupsByMember();">view group</button>
        </div>
        <div id="GroupList">
        </div>
            <div v-for="group in groups" :key="group.id">
                {{ group.name }} <br>
                {{ group.groupColor }} <br>
                {{ group.description }} <br>
            </div>
    </div>
</template>

<script>
import axios from 'axios'
import { ref } from '@vue/reactivity';
export default {
    setup() {
        const groups = ref([])

        return { groups }
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
            this.groups = []
            axios({
                url: 'http://localhost:8080/group/1',
                method: 'get',
            }).then((response) => {
                response.data.forEach(element => {
                    this.groups.push(element)
                });
            })
        }
    }
}
</script>

<style scoped>

</style>
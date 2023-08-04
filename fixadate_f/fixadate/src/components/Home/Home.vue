<template>
    <div id='Home'>
        <div id='CalMenu'>

            <router-link to="/adate">
                <div class='CalItem' id='Adate'>
                    <p>Adate</p>
                </div>
            </router-link>

            <router-link to="/dates">   
                <div class='CalItem' id='Dates'>
                    <p>Dates</p>
                </div>
            </router-link>

            <router-link to="/appointment">
                <div class='CalItem' id='Appointment'>
                    <p>Appointment</p>
                </div>
            </router-link>
        </div>


        <div id='Widgets'>
            <div class='Widget' id='AppleCalanderWidget'>
                AppleCalanderWidget
            </div>

            <div class='Widget' id='Notes'>
                <p>Notes</p>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    setup() {
        document.title = 'fixadate | Home'
    },
}
</script>

<style scoped>
    #Home {
        display: flex;
        font-family: 'Roboto', sans-serif;
        
    }
    #CalMenu {
        text-align: center;
        flex: 1;
        width: 50%;
    }
    #Widgets{
        flex: 1;
        width: 50%;
        /* float: right; */
    }

    .CalItem {
        margin-left: 13%;
        margin-right: 13%;
        
        padding-top: 2%;
        padding-bottom: 2%;
        background-color: rgba(80, 80, 80, 1);
        border-radius: 13px;
        font-size: small;
    }

    .Widget {        
        font-size: larger;
    }


    #Adate {
        margin-top: 10%;
    }
    #Dates {
        margin-top: 20%;
    }

    #Appointment {
        margin-top: 20%;
    }

    #Notes {
        text-align: center;
    }
</style>


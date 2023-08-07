<template>
    <div id='Home'>
        <div id='CalMenu'>

            <router-link to="/adate">
                <img id="Pin" width="16" src="../../assets/images/Pin.png">
                <div class='CalItem' id='Adate'>
                    <p>Adate</p>
                </div>
            </router-link>

            <router-link to="/dates">   
                <img id="Pin1" width="16" src="../../assets/images/Pin.png">
                <div class='CalItem' id='Dates'>
                    <p>Dates</p>
                </div>
            </router-link>

            <router-link to="/appointment">
                <img id="Pin1" width="16" src="../../assets/images/Pin.png">
                <div class='CalItem' id='Appointment'>
                    <p>Appointment</p>
                </div>
            </router-link>
        </div>


        <div id='Widgets'>
            <div class='Widget' id='AppleCalanderWidget'>
                Appl Cal
            </div>

            <div class='Widget' id='Notes'>
                <img width="119" src="../../assets/images/ClipBoard.png">
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
        margin-top: 4%;
        
    }
    #CalMenu {
        text-align: center;
        flex: 1;
        width: 50%;
    }
    #Widgets{
        flex: 1;
        width: 50%;
        text-align: center;
        align-items: center;
        /* float: right; */
    }

    .CalItem {
        margin-left: 9%;
        margin-right: 9%;
        
        padding-top: 6%;
        padding-bottom: 6%;

        background-color: rgba(80, 80, 80, 1);
        border-radius: 13px;
        font-size: small;
    }

    .Widget {        
        font-size: larger;
        flex: 1;
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
        margin-top: 15%;
        text-align: center;
    }

    #Pin {
        margin-bottom: -25px;
    }

    #Pin1 {
        margin-bottom: -39px;
    }

    #AppleCalanderWidget {
        margin-top: 8%;
        flex: 1;
        display: inline-block;
        width: 114px;
        height: 114px;
        border-radius: 18px;
        
        background-color: rgba(28,28,30,255);
    }

 
</style>


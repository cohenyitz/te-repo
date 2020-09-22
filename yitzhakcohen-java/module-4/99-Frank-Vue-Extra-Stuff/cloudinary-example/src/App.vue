<!-- eslint-disable -->
<template>
  <div id="app">
    <div class="container">
      <div class="logo">
         <img id="logoimg" alt="logo image" src="./assets/logo.jpg" />
      </div>
      <div class="photodrop">
       <upload-photo />
     </div>
    </div>
  </div>
</template>
<script>
/* eslint-disable */
import UploadPhoto from "@/components/UploadPhoto"
export default {
  components : {
    UploadPhoto
  }
}
</script>
<style scoped>

.logoimg {
  width: 20px;
  margin: 0 auto;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>

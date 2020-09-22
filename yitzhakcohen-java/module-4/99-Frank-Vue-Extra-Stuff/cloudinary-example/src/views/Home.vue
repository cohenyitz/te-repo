<template>
  <div class="home">
    <UploadPhoto msg="Upload a Photo to Frank's Cloudinary Account" />
  </div>
</template>

<script>
// @ is an alias to /src
import UploadPhoto from "@/components/UploadPhoto.vue";

export default {
  name: "Home",
  components: {
    UploadPhoto
  }
};
</script>

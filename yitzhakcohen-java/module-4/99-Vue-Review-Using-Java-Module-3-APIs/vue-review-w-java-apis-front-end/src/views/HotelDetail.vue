<!-- Used when a hotel is clicked from the Home page             -->
<!-- Cause the HotelDetail.vue compnonent to be added to the DOM -->
<template>
  <div>
    <hotel-detail />    <!-- include the hotelDetail -->
  </div>
</template>
<script>
import HotelDetail from "@/components/HotelDetail";
export default {
  components: {
    HotelDetail
  }
};
</script>
<style scoped>

</style>
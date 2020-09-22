<!-- Used when a hotel is clicked from the Home page         -->
<!-- Cause the HotelDetail.vue component to added to the DOM -->
<template>
    <div>
       <hotel-detail />  <!-- include the HotelDetail component -->
    </div>
</template>
<script>
import HotelDetail from "@/components/HotelDetail"
export default {
    components: {
        HotelDetail
    }
}
</script>
<style scoped>

</style>
<template>
<div>
<h1>Add Review</h1>
<add-review />  <!-- include the AddReview.vue component -->
</div>
</template>
<script>
import AddReview from '@/components/AddReview'  // Give us access to AddReview component

export default {
    components: {
        AddReview
    }
}
</script>
<style scoped>


</style>
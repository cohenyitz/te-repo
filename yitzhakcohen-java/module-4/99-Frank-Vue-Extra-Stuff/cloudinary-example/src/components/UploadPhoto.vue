<!----------------------------------------------------------------------------------------------------'=
This code contains everything you need to store an image into a Cloudinary account 

Before you use it:

    1. You must sign up for a free Cloudinary account: www.cloudinary.com 
       No credit card is needed to open a free account. 
       There is a limit to the number of Cloudinary credits you can use in a month on the free account.
       The max is 25 credits on the free plan. 
       1 Credit = 1,000 Transformations OR 1 GB Storage OR 1 GB Bandwidth.  
       You should be able to get through the capstone with a free account. 

    2. Note or copy somewhere the following information from your Cloudinary account Dashboard:

        a. Your cloud-name. (you will use this in the URL when loading images)
        b. Your Cloudinary API key (You will specify this in form data you send to Cloudinary)
        c. The Secure Delivery URL sample.  You will find this if you more... in the Dashoard
           and then the down arrow next to the Secure Delivery URL shown it should look 
           something like this: https://res.cloudinary.com/your-cloud-name/image/upload/sample.jpg

    3. You need to generate an upload preset in Cloudinary in order to upload an image.

        To generate an upload preset:

            a. Login to your Cloudinary account. 
            b. Click on the settings icon in the right side of the page.
            c. Click the "Upload" choice on the nav bar in the settings page
            d. Scroll down until you see the "Upload Presets" section on the left.
            e. In the about the middle of the screen click the "Add Upload Presets" link
            f. In the "Add Upload Presets" page:<template>
                  i. Note / Copy the upload preset name that is generated (you will need it!)
                 ii. Change the "Signing mode" to "unsigned" using the drop-down
                iii. Put the name of the folder in Cloudinary you want your images stored
                        if the folder does not exist it will create it for you
                 iv. Click the "Save" button on the top of the screen

    4. You will need a plug-in called Vue-DropZone.  You can get it at: 
            https://rowanwins.github.io/vue-dropzone/docs/dist/#/installation
 
        Vue-DropZone gives you instant drag and drop and data uploads. 
        This very difficult to do on your own.
        Better to let it be done by a third party library that integrates with Cloudinary.

  The images are actually stored on an image hosting service (e.g. Cloudinary).
  This component posts the image to Cloudinary using a 3rd party called dropzone.
  The sharePhoto() method POSTS a new Post with the hosted imageUrl and the caption that the user provides.
  The URL of the image in Cloudinary is returned from sharePhoto(). 
  Save this URL and use it when you want to reference the image.

    There are several TODO notations in the code indicating where you need to make changes
--------------------------------------------------------------------------------------------------->

<template>
  <!-- eslint-disable --> <!-- This disables annoying eslink warning messages in the html       -->
    <!-- This is the dropzone component that will give a place to drop the image to be uploaded -->
    <!-- there are two custom events the component listens for:                                 -->
    <!--       the vdropzone-sending event which is fired when dropzone is sending an image     -->
    <!--       the vdropzone-success event which is fired when dropzone upload is successful    -->
    <vue-dropzone
        id="dropzone"
        class="mt-3"
        v-bind:options="dropzoneOptions"
        v-on:vdropzone-sending="addFormData"
        v-on:vdropzone-success="getSuccess"
        :useCustomDropzoneOptions="true"
    ></vue-dropzone>
</template>

<script>
/* eslint-disable */
import vue2Dropzone from "vue2-dropzone";
import "vue2-dropzone/dist/vue2Dropzone.min.css";

export default {
    name: "upload-photo",
    components: {
        vueDropzone: vue2Dropzone
    },
    data(){
        return {
            //-------------------------------------------------------------------------------------
            // TODO: substitute your actual Cloudinary cloud-name where indicated in the URL
            //-------------------------------------------------------------------------------------
            dropzoneOptions: {
                url: "https://api.cloudinary.com/v1_1/dkhepixjf/image/upload",  
                thumbnailWidth: 250,
                thumbnailHeight: 250,
                maxFilesize: 2.0,
                acceptedFiles: ".jpg, .jpeg, .png, .gif",
                uploadMultiple: false,
                addRemoveLinks: true,
                dictDefaultMessage: 'Drop files here to upload. </br> Alternatively, click to select a file for upload.',                
            },      
        }
    },
    methods:{
        /******************************************************************************************
         * The addFormData method is called when vdropzone-sending event is fired
         * it adds additional headers to the request
         ******************************************************************************************/
        //--------------------------------------------------------------------------------------------
        // TODO: substitute your actual Cloudinary api-key where indicated in the following code
        // TODO: substitute your actual Cloudinary upload preset where indicated in the following code
        //----------------------------------------------------------------------------==---------------   
        addFormData(file, xhr, formData) {           
            formData.append("api_key", "395925421569991");                // substitute your api key
            formData.append("upload_preset", "bq0mkaov");   // substitute your upload preset
            formData.append("timestamp", (Date.now() / 1000) | 0);
            formData.append("tags", "vue-app");
        },
         /******************************************************************************************
         * The getSuccess method is called when vdropzone-success event is fired
         ******************************************************************************************/
        getSuccess(file, response) {
            const imgUrl = response.secure_url;   // store the url for the uploaded image
            this.$emit("image-upload", imgUrl);   // fire custom event with image url in someone cares
        },
    }
}
</script>


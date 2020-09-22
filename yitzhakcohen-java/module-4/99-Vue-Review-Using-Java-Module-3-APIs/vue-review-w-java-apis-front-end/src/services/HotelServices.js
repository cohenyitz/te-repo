/* eslint-disable */
import axios from 'axios';

const hotelAPI = axios.create({   // create an axios object for 
  baseURL: "http://localhost:8080"  // this server(Java API server)
});

export default {

  getHotels() {
    return hotelAPI.get('/hotels'); // call our API with the /hotels path
                                    //    the API will return all hotels
  },
  getHotel(id) {
    return hotelAPI.get(`/hotels/${id}`);
  }
};

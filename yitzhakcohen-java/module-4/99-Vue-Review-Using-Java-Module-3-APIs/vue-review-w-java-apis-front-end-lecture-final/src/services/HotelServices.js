import axios from 'axios';

const hotelAPI = axios.create({     // create an axios object for 
  baseURL: "http://localhost:8080"  //    this server (Java API server)
});

export default {

  getHotels() {       // A function defined in our service
    return hotelAPI.get('/hotels');  // Call our API server with the /hotels path
  },                                  //      the API will return all the hotels

  getHotel(id)  {
    return hotelAPI.get(`/hotels/${id}`);
  }
}

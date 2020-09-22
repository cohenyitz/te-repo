// This contain JavaScript methods called from various places 
// functione that are shred by many apps

// axios is an API framework to API calls from JavaScript
import axios from 'axios';   // Access axios stuff

 // use axios for our json server
const http = axios.create({          // define a variable to hold axios object
  baseURL: "http://localhost:3000"   //    passing the server URL we want to use -                                     
});

export default {

  // API class are asyncronous calls - once the call is started your program continues
  // normal functions are syncronous calls - program does not continue until function return
  // If you care about what's returned from the API call you must wait until the call completes

  // API calls issue a 'promise' back to you when you start them
  // The promise, I'll let you know when I am done
  // There is no way of knowing how long it will take the server to receive the HTTP request,
  //                  process it and send back the response
  //  axios get() wants a string containing the URL path to send to the server


  // function to return all the data from the server defined to axios at the /boards path
  getBoards() {                   // getBoards returns immediately after sending call to server with a promise
    return http.get('/boards');   // axios HTTP GET using path /boards - return the HTTP response data
  },

  getCards(boardID) {            // Retrieve all the Cards for a board given the boardID
    return http.get(`/boards/${boardID}`)  // note `` around the URL - due to it have EL expression (interpolation)
  },

  getCard(boardID, cardID) {     // Retrieve on card given the boardID and cardID
    return http.get(`/boards/${boardID}`)  // get all cards for a board - note `` around the URL - due to it have EL expression (interpolation)
           .then((response) => {           // when the call is done pass the response to a function
      const cards = response.data.cards;            // Copy response array to an array in our program
      return cards.find(card => card.id == cardID); // return the card that matches cardID passed
    })
  }

}

// This contains JavaScript methods called from various places
// functions that are shared by many apps

// axios is an API framework to API calls from JavaScript
import axios from 'axios';              // Access axios stuff

// use axios for our json server
const http = axios.create({             // define a variable to hold axios object
  baseURL: "http://localhost:3000"      //    passing the server URL we want to use
});

export default {

  // API class are asyncronous calls - once the call is started your program continues
  // normal functions are syncronous calls - program does not continue until function returns
  // If you care about about what's returned from the API call you must wait until the call completes
  
  // API calls issue a 'promise' back to you when you start them
  // The promise, I'll let you know when I am done 
  // There is no way of knowing how long it will take the server to receive the HTTP request,
  //              process it and send us back the response

  // function to return all the data from the server defined to axios at the /boards path
  getBoards() {                         // getBoards returns immediately after sending call to server with a promise
    return http.get('/boards');         // axios HTTP GET using path /boards - return the HTTP response data
  },

  getCards(boardID) {                   // Retrieve all the Cards for a board given the boardID
    return http.get(`/boards/${boardID}`)//  note `` around the URL - due to it have EL expression
  },

  getCard(boardID, cardID) {
    return http.get(`/boards/${boardID}`).then((response) => {
      const cards = response.data.cards;
      return cards.find(card => card.id == cardID);
    })
  }

}

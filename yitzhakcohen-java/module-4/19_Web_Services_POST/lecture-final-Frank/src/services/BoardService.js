import axios from 'axios';          // Access axios stuff

const http = axios.create({         // Define an object to interact with axios                           
  baseURL: "http://localhost:3000"  //      amd give it the base API server path
});

export default {

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)  // HTTP GET to server using path /cards/a-card-id
  },
  // POST requires the data to added to data source on the server
  //      the data can be the name of a JavaScript object - card in example below
  //   or the data can be JSON object { name : "Frank",
  //                                    job  : "Instructor"
  //                                  }
  //      any data sent to the server should be a complete object (ie all properties included)
  addCard(card) {
    return http.post('/cards', card);   // HTTP POST to server using path /cards
  },                                    //     the card object contains the data to added to server
  
  // PUT requires the data to added to data source on the server
  //      the data can be the name of a JavaScript object - card in example below
  //   or the data can be JSON object { name : "Frank",
  //                                    job  : "Instructor"
  //                                  }
  //      any data sent to the server should be a complete object (ie all properties included)
  //      the standard is provide all data in te object sent with the PUT not just the properties that changed
  //          some servers replace the entire object in it's Data Store on a PUT instead of just updating changes
  updateCard(card) {
    return http.put(`/cards/${card.id}`, card); // HTTP PUT to server using path /cards/a-card-id 
                                                //     the card object contains the data to updated on server
  },

  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`);  // HTTP DELETE to server using path /cards/a-card-id
  },

// Add a service to add a board to the server data store
  addBoard(aBoard) {   // receive the board to be added
    return http.post('/boards', aBoard);  // Call the API with the /boards path and the board ot be added
  },
  // Add a service to delete a board to the server data store
  deleteBoard(aBoardID) {   // receive the board to be added
    return http.delete(`/boards/${aBoardID}`);  // Call the API with the /boards path and the boardID to be deleted
  }
}

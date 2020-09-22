import axios from 'axios';            // Access axios stuff

const http = axios.create({           // Define an object to interact with axios 
  baseURL: "http://localhost:3000"    //    and give it the base API server path
});

export default {

  getBoards() {
    return http.get('/boards');
  },

  getCards(boardID) {
    return http.get(`/boards/${boardID}`)
  },

  getCard(cardID) {
    return http.get(`/cards/${cardID}`)         // HTTP GET to sever using path /cards/a-card-id
  },
  // POST requires the data to be added to data source on the server 
  //      the data can be the name of a JavaScript Object  --card in example below
  //      or the data can be a JSON object that you code { name: 'Frank',
  //                                                       job:  'instructor'
  //                                                      }
  //      and data sent to the server should be a complete object(ie all properties included)
  addCard(card) {
    return http.post('/cards', card);           // HTTP POST to server using path /cards
                                                //     the card object contains the data to be added on server
  },
  // PUT requires the data to be added to data source on the server 
  //      the data can be the name of a JavaScript Object  --card in example below
  //      or the data can be a JSON object that you code { name: 'Frank',
  //                                                       job:  'instructor'
  //                                                      }
  //      and data sent to the server should be a complete object(ie all properties included)
  //      the standard is to provide all data in the object sent with the PUT not just the properties that changed
  //            some servers replace the entire object in it's Data Store on a PUT, instead of just updating the changes
  updateCard(card) {
    return http.put(`/cards/${card.id}`, card);  // HTTP PUT to server using path /cards/a-card-id
                                                 //     the card object contains the data to be updated on server
  },

  deleteCard(cardID) {
    return http.delete(`/cards/${cardID}`);      // HTTP DELETE to server using path /cards/a-card-id
  },

  // Add a service to add a board to the server data store 
  addBoard(aBoard) {  // receive the board to be added
    return http.post('/boards', aBoard);   // call the API with the /boards path and the board to be added
  },
  // Add a service to delete a board to the server data store 
  deleteBoard(aBoardID) {  // receive the board to be added
    return http.delete(`/boards'/${aBoardID}`);   // call the API with the /boards path and the board to be added
  },
}

/***************************************************
 * Add click even to each li in page
 ***************************************************/
/*
 const items = document.querySelectorAll("li");
items.forEach(item => {
  item.addEventListener("click", event => {
    console.log(item.innerText);
    event.target.style.backgroundColor = event.target.innerText;
  });
});
*/
/***************************************************
 * Add click even to ul in page
 ***************************************************/

const colors = document.getElementById("colors");
// Adding the eventListener to the parent of the li items
colors.addEventListener("click", event => {
  if (event.target.nodeName.toLowerCase() === "li") {
    event.target.style.backgroundColor = event.target.innerText;
  }
});

function addOrange() {
	const orange = document.createElement('li');
	orange.innerText = 'Orange';
	colors.appendChild(orange);
}

document.addEventListener('DOMContentLoaded', () => {
	const button = document.getElementById('btnAddOrange');
	button.addEventListener('click', addOrange);
});
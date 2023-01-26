const col = document.querySelectorAll(".col");
const jsonFile = '[{ "title": "Grün","description": "Gurke","id":1},{"title": "Rot", "description": "Erdbeere","id":2},{ "title": "Braun","description": "Kartoffel","id":3},{"title": "Gelb","description": "Paprika","id":4}]';

const files = JSON.parse(jsonFile);
const details = files.map((singleFile) => {
   return(
    `<div class="card-body card">
    <img src="https://via.placeholder.com/250x150" class="card-img-top" alt="...">
    <h5 class="card-title">${singleFile.title}</h5>
    <p class="card-text">${singleFile.description}</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>`   )
});


for(let i = 0; i < files.length; i++){
    col[i].innerHTML = details[i];
}


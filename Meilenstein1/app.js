import products from './products.json' assert { type: 'json' };
const cardWrapper = document.querySelector(".appendDiv");

const details = products.map((item) => {
   return(
    ` <div class="col">
    <div class="card-body">
      <img src=${item.image} class="card-img-top object-fit w-100" style="width:250px; height:150px" alt="...">
      <h5 class="card-title">${item.title}</h5>
      <p class="card-text">${item.description}</p>
      <a href="#" class="btn btn-primary">Go somewhere</a>
    </div>
  </div>`
 
  )
});

for(let i = 0; i < products.length; i++){
   let cardBox = document.createElement("div");
   cardBox.classList.add("card");
   cardBox.classList.add("cardWrapper");
   cardBox.innerHTML = details[i];
   cardWrapper.append(cardBox);
}


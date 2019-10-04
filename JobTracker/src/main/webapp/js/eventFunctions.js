window.addEventListener('load', function(e) {
  console.log('document loaded');
  init();
});

function init() {
  document.filmForm.lookup.addEventListener('click', function(event) {
    event.preventDefault();
    var userId = document.filmForm.userId.value;
    if (!isNaN(userId) && userId > 0) {
      getAppsByUserId(userId);
    }
  })
}
//USE RELATIVE URL
function getAppsByUserId(userId) {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8090/api/applications/'+userId, true);
	xhr.onreadystatechange = function() {
	  console.log(xhr.readyState + " " + xhr.status + " " + xhr.responseText);
	if ( xhr.readyState === 4) {
	  if ( xhr.status < 400){
	    console.log('Success');
	    	var apps = JSON.parse(xhr.responseText); //turn string to object
	    	displayApps(apps);
	    	console.log(apps);
	    	
	  } else {
	    console.log('Failure');
	  }
	}
	};
	xhr.send(null);
	
  // TODO:
  // * Use XMLHttpRequest to perform a GET request to "api/films/"
  //   with the filmId appended.
  // * On success, if a response was received parse the film data
  //   and pass the film object to displayFilm().
  // * On failure, or if no response text was received, put "Film not found" 
  //   in the filmData div.
}

function displayApps(apps) {
	console.log(apps);
	var dataDiv = document.getElementById('appData');
	dataDiv.textContent = '';
  for(let i = 0;i <  apps.length; i++){
	  var ul = document.createElement('ul');
	  var liTitle = document.createElement('li');
	  var liLink = document.createElement('li');
	  var liId = document.createElement('li');
	  dataDiv.appendChild(ul);
	  ul.appendChild(liId);
	  liId.textContent = apps[i].id;
	  ul.appendChild(liTitle);
	  liTitle.textContent = apps[i].title;
	  ul.appendChild(liLink);
	  var linkText = document.createElement("a");
	  linkText.href = apps[i].link;
	  linkText.textContent = "link";
	  linkText.target="_blank";
	  liLink.appendChild(linkText);
	  console.log(apps[i].link);
	  
  }
  // TODO:
  // * Create and append elements to the data div to display:
  // * Film title (h1) and description (blockquote).
  // * Rating, release year, and length as an unordered list.
}
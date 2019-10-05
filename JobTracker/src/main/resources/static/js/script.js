window.addEventListener('load', function(e) {
  console.log('document loaded');
  init();
  addAppForm();
  updateApp();
  wordInit();
  deleteApp();
});
function wordInit() {
	  document.searchUsa.lookup.addEventListener('click', function(event) {
	    event.preventDefault();
	    var searchKey = document.searchUsa.searchKey.value;
	    if (searchKey !== null) {
	      
	    searchByKeyword(searchKey);

	    }
	  })
	}



function init() {
  document.filmForm.lookup.addEventListener('click', function(event) {
    event.preventDefault();
    var userId = document.filmForm.userId.value;
    if (!isNaN(userId) && userId > 0) {
      getAppsByUserId(userId);
    

    }
  })
}
function updateApp() {
	  document.updateappUser.lookup.addEventListener('click', function(event) {
	    event.preventDefault();
	    var userId = document.updateappUser.userId.value;
	    var appId = document.updateappUser.appId.value;
	    if (!isNaN(userId) && userId > 0) {
	      populateForm(userId, appId);
	      updateAppActual(userId, appId);
	      console.log(userId,appId);
	    }
	  })
	}
function deleteApp() {
	document.deleteappUser.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var userId = document.deleteappUser.userId.value;
		var appId = document.deleteappUser.appId.value;
		if (!isNaN(userId) && userId > 0) {
			deleteAppActual(userId, appId);
			console.log(userId);
			console.log(appId);
		}
	})
}
function addAppForm() {
	document.appcreateForm.submit.addEventListener('click', function(event) {
		event.preventDefault();
		var form = event.target.parentElement;
		console.log(form);
		var id = form.user.value;
		 var newApp ={
				  title : form.title.value,
				  link: form.link.value,
				  contactName: form.contactName.value,
				  contactNotes: form.contactNotes.value,
				  additionalNotes: form.additionalNotes.value,
				  status: form.status.value
				  
				  }
		 console.log(newApp);
				 
		 if (newApp !== null) {
			 postApp(newApp, id);
		 }
				});
	}
function populateForm(userId, appId){
	
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8090/api/application/'+appId, true);
	xhr.onreadystatechange = function() {
	  console.log(xhr.readyState + " " + xhr.status + " " + xhr.responseText);
	if ( xhr.readyState === 4) {
	  if ( xhr.status < 400){
	    console.log('Success');
	    	var app = JSON.parse(xhr.responseText); //turn string to object
	    
	    	console.log(app);
	    	updateApp(app, userId, appId);
	    	var form = document.updateAppForm;
	    	form.title.value = app.title;
	    	form.link.value = app.link
	    	form.contactName.value = app.contactName
	    	form.contactNotes.value = app.contactNotes
	    	form.additionalNotes.value = app.additionalNotes
	    	form.status.value = app.status
	    	console.log(form);
	  } else {
	    console.log('Failure');
	  }
	}
	};
	xhr.send(null);
	
	
}


function updateAppActual(userId, appId){
	 document.updateAppForm.submit.addEventListener('click', function(event) {
		    event.preventDefault();
		    var form = event.target.parentElement;
		
		    var xhr = new XMLHttpRequest();
			xhr.open('PUT', 'http://localhost:8090/api/'+userId+'/applications/'+appId, true);

			xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

			xhr.onreadystatechange = function() {
			  if (xhr.readyState === 4 ) {
			    if ( xhr.status == 200 || xhr.status == 201 ) { // Ok or Created
			      var data = JSON.parse(xhr.responseText);
			      console.log(data);
			    }
			    else {
			      console.log("PUT request failed.");
			      console.error(xhr.status + ': ' + xhr.responseText);
			    }
			  }
			};

			var upApp ={
					  title : form.title.value,
					  link: form.link.value,
					  contactName: form.contactName.value,
					  contactNotes: form.contactNotes.value,
					  additionalNotes: form.additionalNotes.value,
					  status: form.status.value
					  
					  }
			var userObjectJson = JSON.stringify(upApp); // Convert JS object to JSON string

			xhr.send(userObjectJson);
		    
		    
		  })
		}

function postApp(newApp, id){
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'http://localhost:8090/api/applications/'+id, true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
	  if (xhr.readyState === 4 ) {
	    if ( xhr.status == 200 || xhr.status == 201 ) { // Ok or Created
	      var data = JSON.parse(xhr.responseText);
	      console.log(data);
	    }
	    else {
	      console.log("POST request failed.");
	      console.error(xhr.status + ': ' + xhr.responseText);
	    }
	  }
	};


	var userObjectJson = JSON.stringify(newApp); // Convert JS object to JSON string

	xhr.send(userObjectJson);
	
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

function searchByKeyword(searchKey){
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8090/api/applications/search/'+searchKey, true);
	xhr.onreadystatechange = function() {
	  console.log(xhr.readyState + " " + xhr.status + " " + xhr.responseText);
	if ( xhr.readyState === 4) {
	  if ( xhr.status < 400){
	    console.log('Success');
	    	var found = JSON.parse(xhr.responseText); //turn string to object
	    	displayApps(found);
	    	
	  } else {
	    console.log('Failure');
	  }
	}
	};
	xhr.send(null);
}

function deleteAppActual(userId, appId){
	var xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'http://localhost:8090/api/'+userId+'/applications/'+appId, true);
	xhr.onreadystatechange = function() {
	  console.log(xhr.readyState + " " + xhr.status + " " + xhr.responseText);
	if ( xhr.readyState === 4) {
	  if ( xhr.status < 400){
	    console.log('Success');
	    	
	  } else {
	    console.log('Failure');
	  }
	}
	};
	xhr.send(null);
}

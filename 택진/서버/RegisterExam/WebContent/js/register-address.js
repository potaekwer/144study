

var address = {};

window.onload = function(){
	address.event.addEvent();
	document.getElementById("zipCode1").focus();
	console.log("Asdf");
};

address.event = {
		
		clickInputButton : function(){
			var zipCode1 = document.getElementById("zipCode1").value,
			zipCode2 = document.getElementById("zipCode2").value,
			address = document.getElementById("address").value;
			
			window.opener.setAddress(zipCode1,zipCode2, address);
			window.close();
			
		},
		
		addEvent : function(){
			console.log("asd");
			var parent = window.opener.register.event;
			document.getElementById("divZipCode").addEventListener("keypress", parent.keypressForNumber);
			document.getElementById("divZipCode").addEventListener("keyup", parent.keyupForNumber);
			document.getElementById("inputBtn").addEventListener("click", this.clickInputButton);
		}
}
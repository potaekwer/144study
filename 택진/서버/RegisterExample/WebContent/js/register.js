/**
 * 
 */

//전역변수 선언

var register = {};

window.onload = function(){
	register.event.addEvent();  //이벤트는 원래 있던건가부내
	document.getElementById("name").focus();
};

register.event = {
//		숫자만 입력 체크
		keyPressForNumber: function(e){
			if(e.keycode < 48 || e.keycode > 57){
				e.returnValue = false;
				
//				이벤트 전파를 중지
				e.preventDefault();
				e.stopImmediatePropagation();
			}
		},
		
//		숫자외 replace(복사 붙여넣기 방지)
		keyupForNumber : function(e){
			var target = e.target;
			target.value = target.value.replace(/[^0-9]/g,''); // 정규표현식 사용
		},
		
//		비밀번호 일치 확인
		checkPassword : function(e){
			var password = document.getElementById("password").value;
			var passwordCheck = document.getElementById("passwordCheck").value;
			var txtCheckPw = document.getElementById("txtCheckPw");
			
			if(password === passwordCheck){
				txtCheckPw.style.color = "green";
				txtCheckPw.innerHTML = "비밀번호 일치";
			}else{
				txtCheckPw.style.color = "red";
				txtCheckPw.innerHTML = "비밀번호 불일치";
			}
		},
		
//		email 도메인 변경
		changeEmailDomain : function(e){
//			직접 입력 선택시 텍스트 박스 출력
			var directEmail = document.getElementById("emailDirect");
			if(e.target.value === "direct"){
				directEmail.style.display = "block";
			}else{
				directEmail.style.display = "none";
			}
		},
		
		
//		주소 입력 팝업
		clickAddressBtn : function(){
			window.open("search-address-pop.html", "searchAddressPop", "width=650, height = 200");
		},
		
//		회원가입 버튼 클릭
		clickRegisterBtn : function(e){
//			유효성 검사
			if(register.validate()){
				
//				정보 출력
				var message = "다음의 정보로 회원가입 완료\n";
				for(key in register.result){
					message += register.result[key] + "\n";
				}
				alert(message);
				
				
				document.getElementById("memberForm").submit(); // 통과한 맴버폼은 제출해라
			}
		},
		
		
		
		addEvent : function(){
			
			document.getElementById("searchAddressBtn").onclick = this.clickAddressBtn;
			document.getElementById("registerBtn").onclick = this.clickRegisterBtn;
			
			document.getElementById("emailDomain").onchange = this.changeEmailDomain;
			
			document.getElementById("password").onchange = this.checkPassword;
			document.getElementById("passwordCheck").onchange = this.checkPassword;
			
			document.getElementById("divPhoneNumber").onkeypress = this.keypressForNumber;
			document.getElementById("divPhoneNumber").onkeyup = this.keyupForNumber;
		}
	
		

};


// 회원 가입 결과 객체
register.result = {
		name : "이름",
		id : "아이디",
		email : "이메일",
		phone : "핸드폰",
		address : "주소"
};

//		회원가입 멤버 정보 유효성 체크
register.validate = function(){
	var name = function(){
		var target = document.getElementById("name");
		if(!target || !target.value.trim()){
			target.focus();
			alert("이름을 적어 주세요.");
			return false;
		}
		
		register.result.name += target.value.trim();
		return true;
	},
		
		
	id = function(){
		var target = document.getElementById("id")
		if(!target || !target.value.trim()){
			target.focus();
			alert("ID을 적어 주세요.");
			return false;
		}
		
		register.result.id += target.value.trim();
		return true;
	},
	
	password = function() {
		var password = document.getElementById("password");
		var passwordCheck = document.getElementById("passwordCheck");
		
		if(!password || !password.value.trim()){
			password.focus();
			alert("비밀번호 입력해 주세요");
			return false;
		}else if(!passwordCheck || !passwordCheck.value.trim()){
			passwordCheck.focus();
			alert("비밀번호 확인을 입력해 주새요");
			return false;
		}else if(password.value !== passwordCheck.value){
			passwordCheck.focus();
			alert("비밀번호 같지 않음");
			return false;
		}
		return true;
	},
	
	email = function(){
		var email = document.getElementById("email");
//		다이렉트이면 직접 입력 텍스트값 가져오기
		var emailDomain = (document.getElementById("emailDomain").value ==="direct")?
				document.getElementById("emailDirect") : document.getElementById("emailDomain");
				
		if(!email || !email.value.trim()){
			email.focus();
			alert("이메일을 입력해 주세요");
			return false;
		}else if(!emailDomain || !emailDomain.value.trim()){
			emailDomain.focus();
			alert("이메일 도메인을 입력해 주세요");
			return false;
		}
		
		register.result.email += email.value.trim() + "@" + emailDomain.value.trim();
		return true;
	},
	
	phone = function(){
		var phoneNumber1 = document.getElementById("phoneNumber1"),
		phoneNumber2 = document.getElementById("phoneNumber2"),
		phoneNumber3 = document.getElementById("phoneNumber3");
		
		
		if(!phoneNumber1 || !phoneNumber1.value.trim()){
			phoneNumber1.focus();
			alert("핸드폰 번호 입력해 주세요");
			return false;
		}else if(!phoneNumber2 || !phoneNumber2.value.trim()){
			phoneNumber1.focus();
			alert("핸드폰 번호 입력해 주세요");
			return false;
		}else if(!phoneNumber3 || !phoneNumber3.value.trim()){
			phoneNumber3.focus();
			alert("핸드폰 번호 입력해 주세요");
			return false;
		}
		register.result.phone += phoneNumber1.value.trim() + "-" + phoneNumber2.value.trim() + "-" + phoneNumber3.value.trim();
		return true;
	},
	
	address = function(){
		var zipCode1 = document.getElementById("zipCode1"),
		zipCode2 = document.getElementById("zipCode2"),
		address = document.getElementById("address"),
		detailAddress = document.getElementById("detailAddress");
		
		if(!zipCode1 || !zipCode1.value.trim()){
			zipCode1.focus();
			alert("우편번호 입력");
			return false;
		}else if(!zipCode2 || !zipCode2.value.trim()){
			zipCode2.focus();
			alert("우편번호 입력");
			return false;
		}else if(!address|| !address.value.trim()){
			address.focus();
			alert("주소 입력");
			return false;
		}else if(!detailAddress || !detailAddress.value.trim()){
			detailAddress.focus();
			alert("세부 주소 입력");
			return false;
		}
		register.result.address += zipCode1.value.trim() + "-" + zipCode2.value.trim() 
		+ " " + address.value.trim() + " " + detailAddress.value.trim();
		return true;
	};
	
	return function check(){
		if(!name()){
			return false;
		}else if(!id()){
			return false;
		}else if(!password()){
			return false;
		}else if(!email()){
			return false;
		}else if(!phone()){
			return false;
		}else if(!address()){
			return false;
		}
		return true;
	}();
	
};

var setAddress = function(zipCode1, zipCode2, address){
	document.getElementById("zipCode1").value = zipCode1;
	document.getElementById("zipCode2").value = zipCode2;
	document.getElementById("address").value = address;
}











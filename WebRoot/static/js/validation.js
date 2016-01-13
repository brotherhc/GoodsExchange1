var form_reg={
	email:		/^([a-z0-9][\w\.]*@[a-z0-9\-]+(\.[a-z]{2,4}){1,2})$/,
	cn_name:	/^([\u4e00-\u9fa5]{2,8})$/,
	zip_code:	/^([1-9]\d{5})$/,
	pass:		/^(.{4,32})$/,
	pass2:		/^(.{4,32})$/,
	isNum:      /^[1-9][\d\.]+$/,
	phone:      /^1[3|4|5|8][0-9]\d{4,8}$/,
	passwordStrong: /^(?![a-zA-z]+$)(?!\d+$)(?![!@#$%^&*]+$)(?![a-zA-z\d]+$)(?![a-zA-z!@#$%^&*]+$)(?![\d!@#$%^&*]+$)[a-zA-Z\d!@#$%^&*]+$/,
	passwordMiddle: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/
};	

function oCheck(num,tag){
	if(!form_reg[tag].test(num)){
		return false;
	}else{
		return true;	
	}
};
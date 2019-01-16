function validate() {
	var form = document.querySelector('#frm');
	var btn = form.querySelector('.validBtn');
	var fields = form.querySelectorAll('.field');

	var regExpForEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
	var regExpForPasswrd = /[0-9a-zA-Z_]{3,}/;

	var wrongInput = [];
	var j = 0;
	if(!regExpForEmail.exec(fields[0].value)) {
		wrongInput[j++] = fields[0].value;
	}
	if(!regExpForPasswrd.exec(fields[1].value)) {
		wrongInput[j++] = fields[1].value;
	}

	if(wrongInput.length != 0) {
		alert("Введенные Вами данные не корректны..");
	}
	else {
		alert('Валидация прошла успешно!');
	}
}
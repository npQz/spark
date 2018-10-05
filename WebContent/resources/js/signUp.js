/* chk sign up */

function chkSignUp() {
  var form = document.signUpForm;
  var email = document.signUpForm.email;
  var _emailCmt = document.getElementById('emailCmt');
  var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
  var pw = document.signUpForm.pw;
  var _pwCmt = document.getElementById('pwCmt');
  var pw_re = document.signUpForm.pw_re;
  var _pw_re_Cmt = document.getElementById('pw_reCmt');
  var age = document.signUpForm.age;
  var _ageCmt = document.getElementById('ageCmt');
  var gender = document.signUpForm.gender;
  var _genderCmt = document.getElementById('genderCmt');

  _emailCmt.innerHTML = '';
  _pwCmt.innerHTML = '';
  _pw_re_Cmt.innerHTML = '';
  _ageCmt.innerHTML = '';
  _genderCmt.innerHTML = '';

  if (email.value === "") {
    _emailCmt.innerHTML = "이메일을 입력해주세요";
    email.focus();
    return false;

  } else if (email.value.indexOf(" ") >= 0) {
    _emailCmt.innerHTML = "빈 칸을 채워주세요";
    email.focus();
    return false;

  } else if (!re.test(email.value)) {
    _emailCmt.innerHTML = "올바른 이메일 주소를 입력해 주세요";
    email.focus();
    return false;

  } else if (email.value.length < 3) {
    _emailCmt.innerHTML = "3글자 이상 입력해주세요";
    email.focus();
    return false;

  } else if (pw.value === "") {
    _pwCmt.innerHTML = "비밀번호를 입력해주세요";
    pw.focus();
    return false;

  } else if (pw.value.indexOf(" ") >= 0) {
    _pwCmt.innerHTML = "빈 칸을 채워주세요";
    pw.focus();
    return false;

  } else if (pw.value.length < 4 || pw.value.length > 12) {
    _pwCmt.innerHTML = "4글자에서 12글자 사이를 입력해주세요";
    pw.focus();
    return false;

  } else if (pw_re.value === "") {
    _pw_re_Cmt.innerHTML = "비밀번호를 입력해주세요";
    pw_re.focus();
    return false;

  } else if (pw_re.value.indexOf(" ") >= 0) {
    _pw_re_Cmt.innerHTML = "빈 칸을 채워주세요";
    pw_re.focus();
    return false;

  } else if (pw_re.value.length < 4 || pw_re.value.length > 12) {
    _pw_re_Cmt.innerHTML = "4글자에서 12글자 사이를 입력해주세요";
    pw_re.focus();
    return false;

  } else if (pw.value !== pw_re.value) {
    _pw_re_Cmt.innerHTML = "비밀 번호를 일치시켜 주세요";
    pw_re.focus();
    return false;

  } else if (age.value === "") {
    _ageCmt.innerHTML = "나이를 입력해주세요";
    age.focus();
    return false;

  } else if (parseInt(age.value) < 0 || parseInt(age.value) > 150) {
    _ageCmt.innerHTML = "0부터 150 사이의 값을 입력해주세요";
    age.focus();
    return false;

  } else if (gender.value === "") {
    _genderCmt.innerHTML = "성별을 입력해주세요";
    age.focus();
    return false;

  } else {
    form.submit();

  }

}
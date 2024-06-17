//------------------------------------------------------------------------------------------------------------------


var id = document.querySelector('#id');

var pw1 = document.querySelector('#pw1');
var pwMsg = document.querySelector('#alertTxt');
var pwImg1 = document.querySelector('#pw1_img1');

var pw2 = document.querySelector('#pw2');
var pwImg2 = document.querySelector('#pw2_img1');
var pwMsgArea = document.querySelector('.state_pass');

var userName = document.querySelector('#userName');
//var yy = document.querySelector('#yy');
//var mm = document.querySelector('#mm');
//var dd = document.querySelector('#dd');

var Nickname = document.querySelector('#userNickname');

var birthDay = document.querySelector('#birthDay');

var gender = document.querySelector('#gender');

var email = document.querySelector('#email');

var mobile = document.querySelector('#mobile');

var signUpNation = document.querySelector('#signUpNation');

var signUpCity = document.querySelector('#signUpCity');

var userAdd  = document.querySelector('#userAdd');

var error = document.querySelectorAll('.error_next_box');



/*이벤트 핸들러 연결*/


id.addEventListener("focusout", checkId);
pw1.addEventListener("focusout", checkPw);
pw2.addEventListener("focusout", comparePw);
userName.addEventListener("focusout", checkName);
Nickname.addEventListener("focusout", checkNickname);
birthDay.addEventListener("focusout", checkbirthDay);
email.addEventListener("focusout", isEmailCorrect);
mobile.addEventListener("focusout", checkPhoneNum);
signUpNation.addEventListener("focusout", issignUpNation);
signUpCity.addEventListener("focusout", issignUpCity);
userAdd.addEventListener("focusout", isuserAdd);




/*콜백 함수*/


function checkId() {
    var idPattern = /[a-zA-Z0-9_-]{5,20}/;
    if(id.value === "") {
        error[0].innerHTML = "필수 정보입니다.";
        error[0].style.display = "block";
    } else if(!idPattern.test(id.value)) {
        error[0].innerHTML = "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.";
        error[0].style.display = "block";
    } else {
        error[0].innerHTML = "멋진 아이디네요!";
        error[0].style.color = "#08A600";
        error[0].style.display = "block";
    }
}

function checkPw() {
    var pwPattern = /[a-zA-Z0-9~!@#$%^&*()_+|<>?:{}]{8,16}/;
    if(pw1.value === "") {
        error[1].innerHTML = "필수 정보입니다.";
        error[1].style.display = "block";
    } else if(!pwPattern.test(pw1.value)) {
        error[1].innerHTML = "8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.";
        pwMsg.innerHTML = "사용불가";
        pwMsgArea.style.paddingRight = "93px";
        error[1].style.display = "block";

        pwMsg.style.display = "block";
        pwImg1.src = "m_icon_not_use.png";
    } else {
        error[1].style.display = "none";
        pwMsg.innerHTML = "안전";
        pwMsg.style.display = "block";
        pwMsg.style.color = "#03c75a";
        pwImg1.src = "m_icon_safe.png";
    }
}

function comparePw() {
    if(pw2.value === pw1.value) {
        error[2].style.display = "none";
    } else if(pw2.value !== pw1.value) {
        error[2].innerHTML = "비밀번호가 일치하지 않습니다.";
        error[2].style.display = "block";
    }

    if(pw2.value === "") {
        error[2].innerHTML = "필수 정보입니다.";
        error[2].style.display = "block";
    }
}

function checkName() {
    var namePattern = /[a-zA-Z가-힣]/;
    if(userName.value === "") {
        error[3].innerHTML = "필수 정보입니다.";
        error[3].style.display = "block";
    } else if(!namePattern.test(userName.value) || userName.value.indexOf(" ") > -1) {
        error[3].innerHTML = "한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)";
        error[3].style.display = "block";
    } else {
        error[3].style.display = "none";
    }
}


function checkNickname() {
    if(userNickname.value === "") {
        error[4].innerHTML = "필수 정보입니다.";
        error[4].style.display = "block";
    } else {
        error[4].style.display = "none";
    }
}

function checkbirthDay() {
    if(birthday.value === "") {
        error[5].innerHTML = "필수 정보입니다.";
        error[5].style.display = "block";
    } else {
        error[5].style.display = "none";
    }
}

// function checkgender() {
//     if(gender.value === "") {
//         error[6].innerHTML = "필수 정보입니다.";
//         error[6].style.display = "block";
//     } else {
//         error[6].style.display = "none";
//     }
// }


function isEmailCorrect() {
    var emailPattern = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/;

    if(email.value === ""){
        error[6].innerHTML = "필수 정보입니다.";
        error[6].style.display = "block";
    }
     else if(!emailPattern.test(email.value)) {
         error[6].innerHTML = "형식에 맞지 않는 이메일입니다.";
         error[6].style.display = "block";
     }
    else {
        error[6].style.display = "none";
    }

}

function checkPhoneNum() {
    var isPhoneNum = /([01]{2})([01679]{1})([0-9]{3,4})([0-9]{4})/;

    if(mobile.value === "") {
        error[7].innerHTML = "필수 정보입니다.";
        error[7].style.display = "block";
    } else if(!isPhoneNum.test(mobile.value)) {
        error[7].innerHTML = "형식에 맞지 않는 번호입니다.";
        error[7].style.display = "block";
    } else {
        error[7].style.display = "none";
    }


}

function issignUpNation() {
    if(signUpNation.value === "") {
        error[8].innerHTML = "필수 정보입니다.";
        error[8].style.display = "block";
    } else {
        error[8].style.display = "none";
    }
}

function issignUpCity() {
    if(signUpCity.value === "") {
        error[9].innerHTML = "필수 정보입니다.";
        error[9].style.display = "block";
    } else {
        error[9].style.display = "none";
    }
}

function isuserAdd() {
      if(userAdd.value === "") {
        error[10].innerHTML = "필수 정보입니다.";
        error[10].style.display = "block";
    } else {
        error[10].style.display = "none";
    }
}





//--------------------------------------------------------------------------------------------------
          function toggle(source) {
                      checkboxes = document.getElementsByClassName('join_check');
                      for (var i = 0; i < checkboxes.length; i++) {
                          checkboxes[i].checked = source.checked;
                      }
                  }

                  function checkSelectAll() {
                      var selectAll = document.getElementById('join_check_All');
                      var checkboxes = document.getElementsByClassName('join_check');
                      var allChecked = true;
                      for (var i = 0; i < checkboxes.length; i++) {
                          if (!checkboxes[i].checked) {
                              allChecked = false;
                              break;
                          }
                      }
                      selectAll.checked = allChecked;
                  }
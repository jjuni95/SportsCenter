const login_refused = () => {
    window.alert("아이디와 비밀번호를 확인해주세요.");
}

document.querySelector("#login-form").addEventListener("submit", login_refused);

let inputFields = document.querySelectorAll('#login-form input');

inputFields.forEach(inputField => {
    inputField.addEventListener('mouseover', function() {
        inputField.focus();
    });
});

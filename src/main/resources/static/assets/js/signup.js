const date_input = document.querySelector("#sign-up-date");
const submit_btn = document.querySelector("#sign-up-submit");
    
date_input.value = new Date().toISOString().substring(0, 10);

const check_username = () => {
    window.alert("사용가능한 아이디입니다.");
}

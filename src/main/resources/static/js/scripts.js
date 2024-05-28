function changeImage(name, newSrc) {
    var img = document.getElementById(name);
    if (img) {
        img.src = newSrc;
    }
}

function restoreImage(name, originalSrc) {
    var img = document.getElementById(name);
    if (img) {
        img.src = originalSrc;
    }
}

function showOverlay(overlayId, windowId) {
    document.getElementById(overlayId).style.display = "block";
    document.getElementById(windowId).style.display = "block";
}

function hideOverlay(overlayId, windowId) {
    document.getElementById(overlayId).style.display = "none";
    document.getElementById(windowId).style.display = "none";
}

function validateInput(inputId) {
    var input = document.getElementById(inputId).value;
    if (input.trim() === "") {
        alert("Input is null.");
        return false;
    }
    return true;
}

function showTab(tabName) {
    var loginTab = document.getElementById('LoginTab');
    var signUpTab = document.getElementById('SignUpTab');
    var loginForm = document.getElementById('loginForm');
    var signUpForm = document.getElementById('signUpForm');

    if (tabName === 'login') {
        loginTab.classList.add('active');
        signUpTab.classList.remove('active');
        loginForm.classList.add('active');
        signUpForm.classList.remove('active');
        loginForm.classList.remove('signup-background');
        signUpForm.classList.remove('signup-background');
    } else {
        loginTab.classList.remove('active');
        signUpTab.classList.add('active');
        loginForm.classList.remove('active');
        signUpForm.classList.add('active');
        loginForm.classList.remove('signup-background');
        signUpForm.classList.add('signup-background');
    }
}


document.getElementById("support-btn").addEventListener("click",
    () => showOverlay("overlay", "popup-window"));
document.getElementById("overlay").addEventListener("click",
    () => hideOverlay("overlay", "popup-window"));
document.getElementById("send-button").addEventListener("click",
    () => hideOverlay("overlay", "popup-window"));

document.getElementById("user-btn1").addEventListener("click",
    () => showOverlay("overlay-user", "popup-login-window"));
document.getElementById("overlay-user").addEventListener("click",
    () => hideOverlay("overlay-user", "popup-login-window"));


window.onload = function () {
    document.getElementById("LoginTab").classList.add("active");
};
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

document.getElementById("support-btn").addEventListener("click",
    () => showOverlay("overlay-support", "popup-window"));
document.getElementById("overlay-support").addEventListener("click",
    () => hideOverlay("overlay-support", "popup-window"));
document.getElementById("send-button").addEventListener("click",
    () => hideOverlay("overlay-support", "popup-window"));

document.getElementById("user-btn").addEventListener("click",
        () => showOverlay("overlay-user", "popup-login-window"));
document.getElementById("overlay-user").addEventListener("click",
    () => hideOverlay("overlay-user", "popup-login-window"));
document.getElementById("confirm-button").addEventListener("click",
    () => hideOverlay("overlay-user", "popup-login-window"));

document.getElementById('confirm-button').addEventListener('click', function() {
    const login = document.querySelector('.login-form.email input').value;
    const password = document.querySelector('.login-form.password input').value;

    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ login, password })
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                console.log('Login successful!');
                window.location.href = 'user.html';
            } else {
                console.log('Login failed:', data.message);
            }
        })
        .catch(error => {
            console.error('Error during login:', error);
        });
});
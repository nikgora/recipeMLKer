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

function showOverlay() {
    document.getElementById("overlay").style.display = "block";
    document.getElementById("popup-window").style.display = "block";
}

function hideOverlay() {
    document.getElementById("overlay").style.display = "none";
    document.getElementById("popup-window").style.display = "none";
}

document.getElementById("support-btn").addEventListener("click", showOverlay);
document.getElementById("overlay").addEventListener("click", hideOverlay);
document.getElementById("send-button").addEventListener("click", hideOverlay);
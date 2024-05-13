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

//support button
document.getElementById("support-btn").addEventListener("click",
    () => showOverlay("overlay-support", "popup-window"));
document.getElementById("overlay-support").addEventListener("click",
    () => hideOverlay("overlay-support", "popup-window"));
document.getElementById("send-button").addEventListener("click",
    () => hideOverlay("overlay-support", "popup-window"));

//create a new list
document.getElementById("createList-btn").addEventListener("click", function() {
    showOverlay("overlay-list", "list-field-popup-window");
});
document.getElementById("confirm-list-btn").addEventListener("click", function() {
    hideOverlay("overlay-list", "list-field-popup-window");
});
document.getElementById("overlay-list").addEventListener("click", function() {
    hideOverlay("overlay-list", "list-field-popup-window");
});

//user login
document.getElementById("user-btn1").addEventListener("click",
    () => showOverlay("overlay-user", "popup-login-window"));
document.getElementById("overlay-user").addEventListener("click",
    () => hideOverlay("overlay-user", "popup-login-window"));



const container = document.getElementById('recipeContainer');

recipes.forEach((recipe, index) => {
    const field = document.createElement('div');
    field.classList.add('smallerField', 'smallerField-down' + (index + 1));

    container.appendChild(field);
});



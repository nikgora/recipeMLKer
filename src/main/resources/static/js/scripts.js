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
    () => showOverlay("overlay", "popup-window"));
document.getElementById("overlay").addEventListener("click",
    () => hideOverlay("overlay", "popup-window"));
document.getElementById("send-button").addEventListener("click",
    () => hideOverlay("overlay", "popup-window"));

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

// Отримуємо елементи
const dropDownIcon = document.querySelector('.DropDownIcon');
const elementsToToggle = document.querySelectorAll('.substance, .mDIcon, .saladI, .pastryI, .dessertI, .smoothieI, .snackI, .fish, .sauceI');
const timeI = document.querySelector('.timeI');

// Додаємо обробник подій для кліка на DropDownIcon
dropDownIcon.addEventListener('click', function() {
    // Змінюємо видимість елементів при кліку
    elementsToToggle.forEach(element => {
        element.classList.toggle('hidden');
    });

    // Зсуваємо наступний елемент вниз
    if (elementsToToggle[0].classList.contains('hidden')) {
        timeI.style.marginTop = '20px'; // Задаємо менший відступ, коли елементи виїхали
    } else {
        timeI.style.marginTop = '60px'; // Задаємо більший відступ, коли елементи ховаються
    }
});

// Отримуємо елементи
const dropDownIcons = document.querySelectorAll('.DropDownIcon');

// Додаємо обробник подій для кожного DropDownIcon
dropDownIcons.forEach(dropDownIcon => {
    dropDownIcon.addEventListener('click', function() {
        // Знаходимо батьківський елемент li
        const listItem = this.closest('li');

        // Знаходимо елемент toggleBlock в межах батьківського li
        const toggleBlock = listItem.querySelector('.toggleBlock');

        // Змінюємо видимість блоку та тексту при кліку
        toggleBlock.classList.toggle('hidden');

        // Знаходимо елемент timeI в межах батьківського li
        const timeI = listItem.querySelector('.timeI');

        // Змінюємо відступ timeI в залежності від видимості toggleBlock
        timeI.style.marginTop = toggleBlock.classList.contains('hidden') ? '20px' : '60px';
    });
});

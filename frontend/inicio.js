document.querySelectorAll('.modal-trigger').forEach(trigger => {
    trigger.addEventListener('click', function(e) {
        e.preventDefault();
        const modalId = this.getAttribute('data-modal');
        document.getElementById(modalId).style.display = 'block';
        document.body.style.overflow = 'hidden'; // Desactiva el scroll
    });
});

document.querySelectorAll('.close').forEach(closeBtn => {
    closeBtn.addEventListener('click', function() {
        this.parentElement.parentElement.style.display = 'none';
        document.body.style.overflow = 'auto'; // Reactiva el scroll
    });
});

window.onclick = function(event) {
    if (event.target.classList.contains('modal')) {
        event.target.style.display = 'none';
        document.body.style.overflow = 'auto'; // Reactiva el scroll
    }
}



let sumenu = document.getElementById("sumenu");
function toggeMenu() {
    sumenu.classList.toggle("open-menu");
}

// Función para actualizar el valor del precio
function updatePrice(value) {
    document.getElementById('precioValor').textContent = 'S/ ' + value;
}

  
  

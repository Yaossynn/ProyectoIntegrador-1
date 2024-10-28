const envolver = document.querySelector('.envolver');
const loginLink = document.querySelector('.loginlink');
const registroLink = document.querySelector('.registrolink');
const btnlogin = document.querySelector('.btnlogin');
const btnclose = document.querySelector('.icono-cerrar');

registroLink.addEventListener('click', ()=> {
    envolver.classList.add('active')
})

loginLink.addEventListener('click', ()=> {
    envolver.classList.remove('active')
})  

btnlogin.addEventListener('click', ()=> {
    envolver.classList.add('active-login')
})  

btnclose.addEventListener('click', ()=> {
    envolver.classList.remove('active-login')
})  


/*-------------------------*/

function abrirModal(modalId) {
    document.getElementById(modalId).style.display = "block";
}

function cerrarModal(modalId) {
    document.getElementById(modalId).style.display = "none";
}

// Cerrar el modal si se hace clic fuera de él
window.onclick = function(event) {
    const modals = ['modalInicio', 'modalNosotros', 'modalServicios', 'modalContactos'];
    modals.forEach(modalId => {
        const modal = document.getElementById(modalId);
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });
}
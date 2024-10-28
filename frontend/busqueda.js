// Función para actualizar el valor del precio en pantalla
function updatePrice(value) {
    document.getElementById("precioValor").textContent = `S/ ${value}`;
}

// Función para aplicar los filtros
function aplicarFiltros() {
    const reembolsableChecked = document.getElementById("reembolsableCheck").checked;
    const postergableChecked = document.getElementById("postergableCheck").checked;
    const precioMaximo = parseInt(document.getElementById("precioRange").value, 10);
    const empresaNombre = document.getElementById("empresaInput").value.toLowerCase();

    // Selecciona todas las tarjetas
    const cards = document.querySelectorAll(".col-md-12.card");

    // Itera sobre cada tarjeta y verifica si cumple con los filtros
    cards.forEach(card => {
        const esReembolsable = card.getAttribute("data-reembolsable") === "true";
        const esPostergable = card.getAttribute("data-postergable") === "true";
        const precio = parseInt(card.getAttribute("data-precio"), 10);
        const empresa = card.getAttribute("data-empresa").toLowerCase();

        // Condición para mostrar la tarjeta
        const cumpleReembolsable = !reembolsableChecked || esReembolsable;
        const cumplePostergable = !postergableChecked || esPostergable;
        const cumplePrecio = precio <= precioMaximo;
        const cumpleEmpresa = empresa.includes(empresaNombre);

        if (cumpleReembolsable && cumplePostergable && cumplePrecio && cumpleEmpresa) {
            card.style.display = "block";
        } else {
            card.style.display = "none";
        }
    });
}

// Event listener para aplicar los filtros al hacer clic en el botón "Aplicar Filtros"
document.addEventListener("DOMContentLoaded", function() {
    document.querySelector(".btn.btn-danger").addEventListener("click", aplicarFiltros);
});

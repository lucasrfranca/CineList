document.addEventListener('DOMContentLoaded', function() {
    
    var modal = document.getElementById("modal-cadastro-filme");
    var btnAbrir = document.querySelector(".btn-primary-action");
    var btnFechar = document.querySelector(".close-button");

    if (modal && btnAbrir && btnFechar) {
        
        btnAbrir.addEventListener('click', function(event) {
            event.preventDefault();
            modal.style.display = "flex";
        });
        
        btnFechar.addEventListener('click', function() {
            modal.style.display = "none";
        });
        
        window.addEventListener('click', function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        });
    } else {
        console.error("Erro: Um ou mais elementos do modal não foram encontrados no DOM.");
    }
});
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

document.addEventListener('DOMContentLoaded', function() {
    const botoesExcluir = document.querySelectorAll('.excluir-btn');

    botoesExcluir.forEach(botao => {
        botao.addEventListener('click', function(event) {
            
            event.preventDefault(); 
            
            const id = this.getAttribute('data-id');
            const titulo = this.getAttribute('data-titulo');
            const confirmado = confirm('Tem certeza que deseja excluir o filme: ' + titulo + '?');
            
            if (confirmado) {
                window.location.href = this.href; 
            }
        });
    });
});

document.addEventListener('DOMContentLoaded', function() {
    
    const modal = document.getElementById('modal-cadastro-filme');
    const form = document.getElementById('form-filme');
    const modalTitle = document.getElementById('modal-title');
    const btnSubmit = document.getElementById('btn-submit');
    const closeButton = document.querySelector('.close-button');
    const btnNovoFilme = document.querySelector('.btn-primary-action');
    const campos = {
        id: document.getElementById('filme-id'),
        titulo: document.getElementById('titulo'),
        ano: document.getElementById('ano'),
        diretor: document.getElementById('diretor'),
        posterUrl: document.getElementById('poster-url'),
        nota: document.getElementById('nota')
    };

    btnNovoFilme.addEventListener('click', function(event) {
        event.preventDefault(); 
        
        form.reset(); 
        campos.id.value = '';
        
        modalTitle.textContent = 'Cadastrar Novo Filme';
        btnSubmit.textContent = 'Salvar';
        modal.style.display = 'flex';
    });
    
    document.querySelectorAll('.editar-btn').forEach(button => {
        button.addEventListener('click', function(event) {
            event.preventDefault();
            
            const card = this.closest('.filme-card');
            
            campos.id.value = card.dataset.id;
            campos.titulo.value = card.dataset.titulo;
            campos.ano.value = card.dataset.ano;
            campos.diretor.value = card.dataset.diretor;
            campos.posterUrl.value = card.dataset.poster;
            campos.nota.value = card.dataset.nota;
            
            modalTitle.textContent = 'Editar Filme: ' + card.dataset.titulo;
            btnSubmit.textContent = 'Editar';
            modal.style.display = 'flex';
        });
    });

    closeButton.addEventListener('click', function() {
        modal.style.display = 'none';
    });

    window.addEventListener('click', function(event) {
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    });
});
function selecionaElemento(elemento, seletor = "id") {
    switch (seletor) {
        case "id":
            return document.querySelector(`#${elemento}`);
        case "classe":
            return document.querySelector(`.${elemento}`);
    }
}
function tamanho(campo) {
    return campo.length
}

function adicionaClasse(elemento, classe) {
    return elemento.classList.add(classe)
}

function removeClasse(elemento, classe) {
    return elemento.classList.remove(classe)
}

function existeClasse(elemento, classe) {
    return elemento.classList.contains(classe)
}

function adicionaTexto(elemento, texto) {
    return elemento.innerText = texto
}

function removeTexto(elemento) {
    return elemento.innerText = ''
}





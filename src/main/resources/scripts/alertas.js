let limparTimer = null;

function limparMensagem(elemento, classes, delay = 5000) {
    if (limparTimer) clearTimeout(limparTimer);

    limparTimer = setTimeout(() => {
        for (const classe of classes) {
            removeClasse(elemento, classe);
        }
        removeTexto(elemento);
        limparTimer = null;
    }, delay);
}

function mostraAlerta(elemento, texto, classes, delay) {
    elemento.textContent = texto;
    for (const classe of classes) {
        adicionaClasse(elemento, classe);
    }
    limparMensagem(elemento, classes, delay);
}
function criarMensagem(elemento, texto, classes) {
    for (const classe of classes) {
        adicionaClasse(elemento, classe)
    }
    adicionaTexto(elemento, texto)
    limparMensagem(elemento, classes)
}

function limparMensagem(elemento, classes) {
    setTimeout(
        () => {
            for (const classe of classes) {
                removeClasse(elemento, classe)
            }
            removeTexto(elemento)
        }, 10000)
}
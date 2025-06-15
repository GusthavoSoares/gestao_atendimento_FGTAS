class Atendimento {
    #nomeAtendente;
    #formaAtendimento;
    #perfilAtendido;
    #nomeAtendido;
    #contato;
    #documento;
    #tipoAtendimento;

    criar(dados) {
        const {
            nomeAtendente,
            formaAtendimento,
            perfilAtendido,
            nomeAtendido,
            contato,
            documento,
            tipoAtendimento } = dados

        this.#nomeAtendente = nomeAtendente;
        this.#formaAtendimento = formaAtendimento;
        this.#perfilAtendido = perfilAtendido;
        this.#nomeAtendido = nomeAtendido;
        this.#contato = contato;
        this.#documento = documento;
        this.#tipoAtendimento = tipoAtendimento;
    }
    gerarResumo(container) {
        container.innerHTML = `
        <p>Atendente: ${this.#nomeAtendente.value}</p>
        <p>Forma de Atendimento: ${this.#formaAtendimento.value}</p>
        <p>Perfil do atendido: ${this.#perfilAtendido.value}</p>
        <p>Nome do atendido: ${this.#nomeAtendido.value}</p>
        <p>Contato: ${this.#contato.value}</p>
        <p>Documento: ${this.#documento.value}</p>
        <p>Tipo de atendimento: ${this.#tipoAtendimento.value}</p>
        `
            ;
    }

}
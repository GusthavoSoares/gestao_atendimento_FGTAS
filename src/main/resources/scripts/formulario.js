const formAtendimento = selecionaElemento("formularioAtend");
const alertaDocumento = selecionaElemento("alertaDocumento");

const nomeAtendente = selecionaElemento("nomeAtendente");
const formaAtendimento = selecionaElemento("formaAtendimento");
const perfilAtendido = selecionaElemento("perfilAtendido");
const nomeAtendido = selecionaElemento("nomeAtendido");
const contato = selecionaElemento("contatoAtendido");
const documento = selecionaElemento("documentoAtend");
const tipoAtendimento = selecionaElemento("tipoAtendimento");

const dadosAtendimento = selecionaElemento("dadosAtendimento")

formAtendimento.addEventListener("submit", (e) => {
    e.preventDefault();
    validaDocumento(documento.value, alertaDocumento);
    dados = {
        nomeAtendente: nomeAtendente,
        formaAtendimento: formaAtendimento,
        perfilAtendido: perfilAtendido,
        nomeAtendido: nomeAtendido,
        contato: contato,
        documento: documento,
        tipoAtendimento: tipoAtendimento
    }
    atendimento = new Atendimento()
    atendimento.criar(dados)
    atendimento.gerarResumo(dadosAtendimento)
});

documento.addEventListener("input", () => {
    documento.value = documento.value.replace(/\D/g, "");
});

documento.addEventListener("blur", () => {
    validaDocumento(documento.value, alertaDocumento);
});
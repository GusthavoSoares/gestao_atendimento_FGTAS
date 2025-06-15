const formAtendimento = selecionaElemento("formularioAtend");
const documento = selecionaElemento("documentoAtend")
const alertaDocumento = selecionaElemento("alertaDocumento")

formAtendimento.addEventListener("submit", (elemento) => {
    elemento.preventDefault();
});

documento.addEventListener("input", () => {
    //Remove dígitos que não forem numéricos
    documento.value = documento.value.replace(/\D/g, "")
    validaDocumento(documento.value, alertaDocumento)
})


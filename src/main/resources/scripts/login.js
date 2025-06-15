const formLogin = selecionaElemento("loginForm")
const cpfLogin = selecionaElemento("loginCPF")
const alertaCPF = selecionaElemento("loginAlerta")

formLogin.addEventListener("submit", (elemento) => {
    elemento.preventDefault();
});

cpfLogin.addEventListener("input", () => {
    //Remove dígitos que não forem numéricos
    cpfLogin.value = cpfLogin.value.replace(/\D/g, "")
    validaDocumento(cpfLogin.value, alertaCPF)
})
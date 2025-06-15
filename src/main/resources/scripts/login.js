const formLogin = selecionaElemento("loginForm");
const cpfLogin = selecionaElemento("loginCPF");
const alertaCPF = selecionaElemento("loginAlerta");
const btnLogin = selecionaElemento("btnLogin");

formLogin.addEventListener("submit", (elemento) => {
    elemento.preventDefault();
    window.location.href = "formulario.html"
});

cpfLogin.addEventListener("input", () => {
    //Remove dígitos que não forem numéricos
    cpfLogin.value = cpfLogin.value.replace(/\D/g, "")

});

cpfLogin.addEventListener("blur", () => {
    validaDocumento(cpfLogin.value, alertaCPF);
});
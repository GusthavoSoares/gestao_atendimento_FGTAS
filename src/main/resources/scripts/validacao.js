const classesSucesso = ["alert", "alert-success"]
const classesFracasso = ["alert", "alert-danger"]


function validarCPF(cpf) {
    cpf = cpf.replace(/\D+/g, '');
    if (cpf.length !== 11 || /^([0-9])\1{10}$/.test(cpf)) return false;
    let soma = 0, resto;
    for (let i = 1; i <= 9; i++) soma += parseInt(cpf.substring(i - 1, i)) * (11 - i);
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11) resto = 0;
    if (resto !== parseInt(cpf.substring(9, 10))) return false;
    soma = 0;
    for (let i = 1; i <= 10; i++) soma += parseInt(cpf.substring(i - 1, i)) * (12 - i);
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11) resto = 0;
    return resto === parseInt(cpf.substring(10, 11));
}


function validarCNPJ(cnpj) {
    cnpj = cnpj.replace(/\D+/g, '');
    if (cnpj.length !== 14 || /^([0-9])\1{13}$/.test(cnpj)) return false;
    const pesos1 = [5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2];
    const pesos2 = [6].concat(pesos1);
    let soma = 0, resto;
    for (let i = 0; i < 12; i++) soma += parseInt(cnpj.charAt(i)) * pesos1[i];
    resto = soma % 11;
    resto = resto < 2 ? 0 : 11 - resto;
    if (resto !== parseInt(cnpj.charAt(12))) return false;
    soma = 0;
    for (let i = 0; i < 13; i++) soma += parseInt(cnpj.charAt(i)) * pesos2[i];
    resto = soma % 11;
    resto = resto < 2 ? 0 : 11 - resto;
    return resto === parseInt(cnpj.charAt(13));
}

function validaDocumento(documento, campoAlerta) {
    const tamanhoDoc = tamanho(documento);
    if (tamanhoDoc === 14) {
        if (!validarCNPJ(documento)) {
            if (existeClasse(campoAlerta, 'alert-success')) removeClasse(campoAlerta, 'alert-success');
            return criarMensagem(campoAlerta, "CNPJ inválido!", classesFracasso);
        }
        if (existeClasse(campoAlerta, 'alert-danger')) {
            removeClasse(campoAlerta, 'alert-danger');
        }
        criarMensagem(campoAlerta, "CNPJ válido!", classesSucesso);
    }
    else if (tamanhoDoc === 11) {
        if (!validarCPF(documento)) {
            if (existeClasse(campoAlerta, 'alert-success')) removeClasse(campoAlerta, 'alert-success');
            return criarMensagem(campoAlerta, "CPF inválido!", classesFracasso);
        }
        if (existeClasse(campoAlerta, 'alert-danger')) {
            removeClasse(campoAlerta, 'alert-danger');
        }
        criarMensagem(campoAlerta, "CPF válido!", classesSucesso);
    }
    else if (tamanhoDoc === 0) {
        if (existeClasse(campoAlerta, 'alert-sucess')) {
            removeClasse(campoAlerta, 'alert-success');
        }
        criarMensagem(campoAlerta, "Insira apenas números!", classesFracasso);
    } else {
        if (existeClasse(campoAlerta, 'alert-success')) {
            removeClasse(campoAlerta, 'alert-success');
        }
        criarMensagem(campoAlerta, "Documento inválido!", classesFracasso);
    }
}

#  Automação de Testes — Gestão de Atendimentos FGTAS


---

## 📌 Sobre o Projeto

Este repositório contém um projeto voltado para a **automação de testes** da aplicação de **Gestão de Atendimentos da FGTAS** (Fundação Gaúcha do Trabalho e Ação Social). O objetivo principal é garantir a **qualidade**, **confiabilidade** e **eficiência** do sistema por meio de testes automatizados robustos e reutilizáveis.

> 🔎 Projeto desenvolvido inteiramente na **IDE IntelliJ IDEA** com **Java**, **JUnit**, e **Selenium**.

---

##  1. Introdução

Atualmente, a empresa ABC utiliza o Google Forms para registrar os atendimentos realizados pelos setores. No entanto, essa ferramenta não oferece um bom controle nem organização das informações.

Por isso, foi desenvolvido um sistema próprio, onde os atendimentos podem ser registrados de forma mais segura, prática e organizada. Nele, o usuário faz login com senha e escolhe o tipo de atendimento (presencial, WhatsApp, ligação, etc.) e o perfil do atendido (empregador, trabalhador, setor, etc.). O formulário se adapta conforme o perfil, exibindo apenas os campos relevantes.

Validações como CPF e CNPJ também foram implementadas para evitar erros no preenchimento.

---

##  2. Objetivo dos Testes

O objetivo dos testes propostos é garantir que as **funcionalidades essenciais do sistema** estejam funcionando corretamente, desde a autenticação até o registro e validação dos dados.

Através de testes **unitários** e **end-to-end**, busca-se:

- Identificar falhas
- Validar regras de negócio (ex: CPF/CNPJ)
- Assegurar confiabilidade para o uso real pelos colaboradores

---

## ✅ 3. Casos de Teste

| ID   | Nome do Teste                      | Tipo       | Cenário                                     | Entrada        | Resultado Esperado                     |
|------|------------------------------------|------------|---------------------------------------------|----------------|----------------------------------------|
| CT01 | Login com CPF válido               | Unitário   | Usuário preenche CPF correto                | CPF válido     | Mensagem: "CPF válido!"                |
| CT02 | Login com CPF inválido            | Unitário   | Usuário preenche CPF incorreto              | CPF inválido   | Mensagem: "CPF inválido!"              |
| CT03 | Cadastro de atendimento com sucesso | End-to-End | Registro completo com dados corretos        | Todos os campos preenchidos | Cadastro realizado com sucesso       |
| CT04 | Cadastro com CPF inválido         | Unitário   | Campo CPF preenchido incorretamente         | CPF inválido   | Mensagem: "CPF inválido"               |
| CT05 | Cadastro com CNPJ inválido        | Unitário   | Campo CNPJ preenchido incorretamente        | CNPJ inválido  | Mensagem: "CNPJ inválido"              |

---

🤝 Colaboradores
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Rangel202">
        <img src="https://github.com/user-attachments/assets/ec332b51-90fd-4579-a683-95c0d7ab4505" width="100px" alt="Foto do Gabriel Rangel"/><br>
        <sub><b>Gabriel Rangel</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/GusthavoSoares">
        <img src="https://github.com/user-attachments/assets/5f93c288-4139-414f-96b7-027a1a0d6416" width="100px" alt="Foto do Gusthavo Soares"/><br>
        <sub><b>Gusthavo Soares</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/miguellessa">
        <img src="https://github.com/user-attachments/assets/e37eef0f-d235-4c94-ba70-2598d326f49f" width="100px" alt="Foto do Miguel Lessa"/><br>
        <sub><b>Miguel Lessa</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/RianBPadilha">
        <img src="https://github.com/user-attachments/assets/82813c24-cbd7-46ea-9497-04d5c1a48e2a" width="100px" alt="Foto do Rian Padilha"/><br>
        <sub><b>Rian Padilha</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/BernardoLencina">
        <img src="https://github.com/user-attachments/assets/28a2e974-d823-4d67-a34f-6792e3ec4830" width="100px" alt="Foto do Bernardo Lencina"/><br>
        <sub><b>Bernardo Lencina</b></sub>
      </a>
    </td>
  </tr>
</table>


package interfaces;

public interface IntAtendimentoPage {
    void open();

    void setNomeAtendente(String nome);

    void selectFormaAtendimento(String forma);

    void selectPerfilAtendido(String perfil);

    void setNomeAtendido(String nome);

    void setContato(String contato);

    void setDocumento(String documento);

    void selectTipoAtendimento(String tipo);

    void submitForm();

    String getAlertaDocumento();

    String getResumo();
}

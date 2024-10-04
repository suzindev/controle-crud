package br.com.suzintech.controle.commom;

public enum Constants {

    REGISTRO_SALVO("Registro salvo com sucesso!"),
    REGISTRO_ATUALIZADO("Registro atualizado com sucesso!"),
    REGISTRO_DELETADO("Registro deletado com sucesso!"),
    REGISTRO_NAO_ENCONTRADO("Registro não encontrado!");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

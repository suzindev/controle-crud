package br.com.suzintech.controle.commom;

public interface Adapter<ORIGEM, DESTINO> {

    DESTINO from(ORIGEM obj);
}

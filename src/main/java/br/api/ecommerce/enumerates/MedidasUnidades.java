package br.api.ecommerce.enumerates;

import lombok.Getter;

@Getter
public enum MedidasUnidades {

    KG("kg"),
    PRATO("prato"),
    UNIDADE("u");

    private final String value;
    MedidasUnidades(String value) {
        this.value = value;
    }
}

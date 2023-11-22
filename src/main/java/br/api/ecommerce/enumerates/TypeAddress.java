package br.api.ecommerce.enumerates;

import lombok.Getter;

@Getter
public enum TypeAddress {

    PRINCIPAL("principal"),
    SECUNDARIO("secundario");

    private final String value;

    TypeAddress(String value) {
        this.value = value;
    }

}

package br.api.ecommerce.enumerates;

import lombok.Getter;

@Getter
public enum Secao {

    SALGADOS("salgados"),
    SANDUICHES("sanduiches"),
    PORCOES("porcoes"),
    BEBIDAS("bebidas"),
    SOBREMESA("sobremesas"),
    MASSAS("massas"),
    COMBOS("combos");

    private final String value;
    Secao(String value) {
        this.value = value;
    }
}

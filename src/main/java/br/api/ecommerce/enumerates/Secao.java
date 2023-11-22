package br.api.ecommerce.enumerates;

public enum Secao {

    SALGADOS("salgados"),
    SANDUICHES("sanduiches"),
    PORCOES("porcoes"),
    BEBIDAS("bebidas"),
    SOBREMESA("sobremesas"),
    COMBOS("combos");
    private String value;
    Secao(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}

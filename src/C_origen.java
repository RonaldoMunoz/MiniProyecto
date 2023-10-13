import java.util.ArrayList;

public enum C_origen {
    ANDALUCIA("Andalucia"),
    BUGALAGRANDE("Bugalagrande"),
    EL_CERRITO("El cerrito"), 
    GINEBRA("Ginebra"), 
    GUACARI("Guacari"), 
    BUGA("Buga"),
    RIOFRIO("Rio frio"), 
    TRUJILLO("Trujillo"), 
    CALIMA("Calima"), 
    DARIEN("Darien"), 
    RESTREPO("Restrepo"), 
    SAN_PEDRO("San pedro"),
    TULUA("Tulua"), YOTOCO("Yotoco"), EL_AGUILA("El aguila"), ALCALA("Alcala"), ANSERMANUEVO("Ansermanuevo"), ARGELIA("Argelia"), EL_CAIRO("El cairo"), LA_UNION("La union"), LA_VICTORIA("La victoria"), ULLOA("Ulloa"), BOLIVAR("Bolivar"), CARTAGO("Cartago"),
    EL_DOVIO("El dovio"), OBANDO("Obando"), ROLDANILLO("Roldanillo"), TORO("Toro"), VERSALLES("Versalles"), ZARZAL("Zarzal"), 
    BUENAVENTURA("Buenaventura"), CAICEDONIA("Caicedonia"), SEVILLA("Sevilla"), CALI("Cali"), CANDELARIA("Candelaria"), PALMIRA("Palmira"),
    DAGUA("Dagua"), FLORIDA("Florida"), JAMUNDI("Jamundi"), LA_CUMBRE("La cumbre"), PRADERA("Pradera"), VIJES("Vijes"), YUMBO("Yumbo");
    
    private String name;

    C_origen(String name) {
        this.name = name;
    }

    public String displayNameEnum() {
        return this.name;
    }    
}
import java.util.ArrayList;

public enum Partido_p {
    LA_FUERZA_DE_LA_PAZ("La Fuerza de la Paz"),
    MOVIMIENTO_FUERZA_CIUDADANA("Movimiento fuerza ciudadano"),
    NUEVA_FUERZA_DEMOCRATICA("Nueva fuerza democratica"),
    CREEMOS("Creemos"),
    GENTE_EN_MOVIMIENTO("Gente en movimiento"),
    EL_TRABAJO_DE_COLOMBIA("El trabajo de colombia"),
    PARTIDO_DEMOCRATA_COLOMBIANO("Partido democrata colombiano"),
    PARTIDO_LIBERAL_COLOMBIANO("Partido liberal colombiano"),
    PARTIDO_CONSERVADOR_COLOMBIANO("Partido conservador colombiano"),
    PARTIDO_CAMBIO_RADICAL("Partido cambio radical"),
    PARTIDO_ALIANZA_VERDE("Partido alianza verde"),
    AICO("AICO"),
    PARTIDO_ALIANZA_SOCIAL_INDEPENDIENTE_ASI("Partido alianza social independiente ASI"),
    MIRA("MIRA"),
    PARTIDO_DE_LA_U("Partido de la U"),
    PARTIDO_POLO_DEMOCRATICO_ALTERNATIVO("Paritdo polo democratico alternativo"),
    PARTIDO_UNION_PATRIOTICA_UP("Partido union patriotica UP")
    ,PARTIDO_CENTRO_DEMOCRATICO("Partido Centro Democratico"),
    MAIS("MAIS");


    private String name;

    Partido_p(String name) {
        this.name = name;
    }

    public String displayNameEnum() {
        return this.name;
    }    
}


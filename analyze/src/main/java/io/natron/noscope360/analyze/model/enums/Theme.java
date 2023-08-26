package io.natron.noscope360.analyze.model.enums;

public enum Theme {
    BIODIVERSITY(Dimension.ENVIRONMENT, "Biodiversität bezeichnet die Vielfalt von Leben in all seinen Formen, " +
            "einschließlich der genetischen Vielfalt, Artenvielfalt und Ökosystemvielfalt; sie ist zentraler Bestandteil " +
            "des SDG 15: \"Leben an Land\"."),
    CLIMATE(Dimension.ENVIRONMENT, "Das Klima beschreibt die langfristigen Wetterbedingungen in einem Gebiet; " +
            "es ist zentraler Bestandteil des SDG 13: \"Maßnahmen zum Klimaschutz\"."),
    ENERGY(Dimension.ENVIRONMENT, "Energie bezieht sich auf die Kapazität eines Systems, Arbeit zu verrichten; " +
            "sie ist zentraler Bestandteil des SDG 7: \"Bezahlbare und saubere Energie\"."),
    AIR(Dimension.ENVIRONMENT, "Luft ist das gasförmige Gemisch, das die Erdatmosphäre bildet und für das " +
            "Leben essentiell ist; sie ist in Bezug auf die Luftqualität mit dem SDG 3 (Gesundheit und Wohlergehen) und " +
            "dem SDG 11 (Nachhaltige Städte und Gemeinden) verknüpft."),
    WATER(Dimension.ENVIRONMENT, "Wasser ist eine lebenswichtige, farb- und geruchlose Flüssigkeit, die Ozeane, " +
            "Seen und Flüsse bildet; es ist eng mit dem SDG 6 (Sauberes Wasser und Sanitärversorgung) verbunden."),
    SOIL(Dimension.ENVIRONMENT, "Boden ist die obere Schicht der Erdkruste, in der Pflanzen wachsen; er ist " +
            "eng mit dem SDG 15 (Leben an Land) und indirekt mit dem SDG 2 (Kein Hunger) verknüpft."),
    SUSTAINABLE_CONSUMPTION(Dimension.ENVIRONMENT, "Nachhaltiger Konsum bezeichnet den Gebrauch von Gütern und " +
            "Dienstleistungen, die den Bedarf der Gegenwart decken, ohne die Bedürfnisse zukünftiger Generationen zu " +
            "gefährden; er ist direkt mit dem SDG 12 (Verantwortungsvolle Konsum- und Produktionsmuster) verknüpft."),
    SUPPLY_AND_SERVICE(Dimension.SOCIAL, "Versorgung und Dienstleistung beziehen sich auf die Bereitstellung " +
            "und Nutzung von Waren und Serviceangeboten; obwohl dies thematisch verschiedene SDGs berühren kann, steht " +
            "es besonders im Zusammenhang mit SDG 9 (Industrie, Innovation und Infrastruktur) und SDG 12 " +
            "(Verantwortungsvolle Konsum- und Produktionsmuster)."),
    HEALTH(Dimension.SOCIAL, "Gesundheit bezieht sich auf den Zustand des vollständigen körperlichen, " +
            "geistigen und sozialen Wohlbefindens eines Individuums; sie ist direkt mit dem SDG 3 (Gesundheit und " +
            "Wohlergehen) verknüpft."),
    HOUSING_SUPPLY_AND_SPATIAL_DEVELOPMENT(Dimension.SOCIAL, "Wohnungsversorgung und räumliche Entwicklung " +
            "betreffen die Bereitstellung von Wohnraum und die Gestaltung von Lebensräumen; dies steht in direktem " +
            "Zusammenhang mit dem SDG 11 (Nachhaltige Städte und Gemeinden)."),
    SAFETY(Dimension.SOCIAL, "Sicherheit bezieht sich auf den Schutz von Personen vor Gefahren und Risiken; " +
            "sie ist eng mit dem SDG 16 (Frieden, Gerechtigkeit und starke Institutionen) verknüpft."),
    SOCIAL_SUPPORT_AND_SOLIDARITY(Dimension.SOCIAL, "Soziale Unterstützung und Solidarität beziehen sich auf " +
            "die gegenseitige Hilfe und das Gemeinschaftsgefühl unter Menschen; dies steht in direktem Zusammenhang mit " +
            "dem SDG 10 (Weniger Ungleichheiten) und SDG 1 (Keine Armut)."),
    EQUALITY_AND_INTEGRATION(Dimension.SOCIAL, "Gleichberechtigung und Integration betreffen die " +
            "gleichberechtigte Behandlung und Einbindung aller Menschen unabhängig von ihrem Hintergrund; dies steht in " +
            "direktem Zusammenhang mit dem SDG 5 (Geschlechtergleichheit) und SDG 10 (Weniger Ungleichheiten)."),
    LEISURE_SPORT_AND_CULTURAL_ACTIVITIES(Dimension.SOCIAL, "Freizeit, Sport und kulturelle Aktivitäten " +
            "beziehen sich auf nichtberufliche Aktivitäten, die zur Erholung, Unterhaltung und kulturellen Bildung " +
            "dienen; während sie nicht direkt einem spezifischen SDG zugeordnet sind, können sie Aspekte des SDG 3 " +
            "(Gesundheit und Wohlergehen) und SDG 11 (Nachhaltige Städte und Gemeinden) berühren."),
    MOBILITY_AND_ACCESSIBILITY(Dimension.SOCIAL, "Mobilität und Zugänglichkeit beziehen sich auf die Fähigkeit " +
            "von Personen, sich fortzubewegen und Zugang zu Orten und Dienstleistungen zu haben; dies steht in direktem " +
            "Zusammenhang mit dem SDG 11 (Nachhaltige Städte und Gemeinden) und SDG 9 (Industrie, Innovation und Infrastruktur)."),
    EDUCATION(Dimension.SOCIAL, "Bildung bezieht sich auf den Prozess des Lehrens und Lernens, um Wissen und " +
            "Fähigkeiten zu erwerben; sie ist direkt mit dem SDG 4 (Hochwertige Bildung) verknüpft."),
    INCOME_AND_LIVING_COST(Dimension.ECONOMY, "Einkommen und Lebenshaltungskosten betreffen das erhaltene Geld " +
            "und die Ausgaben für den täglichen Bedarf; dies steht in direktem Zusammenhang mit dem SDG 1 (Keine Armut) " +
            "und SDG 8 (Menschenwürdige Arbeit und Wirtschaftswachstum)."),
    EMPLOYMENT_AND_JOBS(Dimension.ECONOMY, "Beschäftigung und Jobs beziehen sich auf das Angebot und die " +
            "Inanspruchnahme von Arbeitsmöglichkeiten; sie stehen in direktem Zusammenhang mit dem SDG 8 (Menschenwürdige " +
            "Arbeit und Wirtschaftswachstum)."),
    PROFESSIONALS(Dimension.ECONOMY, "Fachleute sind Personen, die aufgrund ihrer Ausbildung und Erfahrung in " +
            "einem bestimmten Beruf oder Fachgebiet spezialisiert sind; während dies nicht direkt einem spezifischen SDG " +
            "zugeordnet ist, kann es Aspekte des SDG 4 (Hochwertige Bildung) und SDG 8 (Menschenwürdige Arbeit und " +
            "Wirtschaftswachstum) berühren."),
    ECONOMIC_RESILIENCE(Dimension.ECONOMY, "Wirtschaftliche Resilienz bezieht sich auf die Fähigkeit einer " +
            "Wirtschaft, Störungen zu absorbieren und sich von wirtschaftlichen Schocks zu erholen; sie steht in " +
            "Verbindung mit dem SDG 8 (Menschenwürdige Arbeit und Wirtschaftswachstum) und SDG 9 (Industrie, Innovation " +
            "und Infrastruktur)."),
    INNOVATION(Dimension.ECONOMY, "Innovation bezieht sich auf die Einführung neuer Ideen, Produkte oder " +
            "Verfahren; sie steht in direktem Zusammenhang mit dem SDG 9 (Industrie, Innovation und Infrastruktur)."),
    FINANCIAL_ATTRACTIVENESS_FOR_BUSINESSES(Dimension.ECONOMY, "Finanzielle Attraktivität für Unternehmen " +
            "bezieht sich auf die Anziehungskraft eines Ortes oder Marktes in Bezug auf wirtschaftliche Chancen und " +
            "Investitionsrenditen; während es nicht direkt einem spezifischen SDG zugeordnet ist, kann es Aspekte von " +
            "SDG 8 (Menschenwürdige Arbeit und Wirtschaftswachstum) und SDG 9 (Industrie, Innovation und Infrastruktur) berühren.");

    private final Dimension dimension;
    private final String description;

    Theme(Dimension dimension, String description) {
        this.dimension = dimension;
        this.description = description;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public String getDescription() {
        return description;
    }
}

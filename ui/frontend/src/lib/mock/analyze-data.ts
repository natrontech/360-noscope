import type { ApiMunicipalitiesResponse, ApiMunicipalitiesStatsResponse, ApiMunicipalityDetailsResponse, ApiSurveyDetailsResponse, ApiSurveysResponse, ApiSurveysStatsResponse } from "$lib/types/analyze-data";

// ApiMunicipalitiesResponse
export const apiMunicipalitiesResponse: ApiMunicipalitiesResponse = {
    municipalities: [
        {
            id: "1",
            name: "Zürich",
            region: "Zürich",
            canton: "Zürich",
            district: "Zürich",
            avgQuantitativeRating: 7,
            avgQualitativeRating: 6,
        },
        {
            id: "2",
            name: "Genf",
            region: "Genf",
            canton: "Genf",
            district: "Genf",
            avgQuantitativeRating: 6,
            avgQualitativeRating: 7,
        },
        {
            id: "3",
            name: "Basel",
            region: "Basel-Stadt",
            canton: "Basel-Stadt",
            district: "Basel-Stadt",
            avgQuantitativeRating: 6.5,
            avgQualitativeRating: 6.5,
        },
        {
            id: "4",
            name: "Bern",
            region: "Bern",
            canton: "Bern",
            district: "Bern",
            avgQuantitativeRating: 8,
            avgQualitativeRating: 7.5,
        },
    ],
};

// ApiMunicipalitiesStatsResponse
export const apiMunicipalitiesStatsResponse: ApiMunicipalitiesStatsResponse = {
    municipalitiesStats: {
        totalMunicipalities: 2222,
        avgQuantitativeRating: 6.5,
        avgQualitativeRating: 6.5,
    },
};

// ApiMunicipalityDetailsResponse
export const apiMunicipalityDetailsResponse: ApiMunicipalityDetailsResponse = {
    municipalityDetails: {
        id: "4",
        name: "Bern",
        region: "Bern",
        canton: "Bern",
        district: "Bern",
        quantitativeData: [
            {
                dimension: "Sicherheit",
                themes: [
                    {
                        name: "Kriminalität",
                        indicators: [
                            {
                                name: "Diebstahl",
                                rating: 7,
                            },
                        ],
                    },
                ],
            },
        ],
        qualitativeData: [
            {
                dimension: "Gesundheit",
                themes: [
                    {
                        name: "Mentale Gesundheit",
                        indicators: [
                            {
                                name: "Depression",
                                rating: 6,
                            },
                        ],
                    },
                ],
            },
        ],
    },
};

// ApiSurveysResponse
export const apiSurveysResponse: ApiSurveysResponse = {
    surveys: [
        {
            id: "1",
            name: "Schweizer Gesundheitsumfrage 2023",
            totalParticipatingMunicipalities: 5,
            avgQualitativeRating: 6,
        },
        {
            id: "2",
            name: "Schweizer Sicherheitsumfrage 2023",
            totalParticipatingMunicipalities: 6,
            avgQualitativeRating: 6.5,
        },
        {
            id: "3",
            name: "Bern Umweltumfrage 2023",
            totalParticipatingMunicipalities: 3,
            avgQualitativeRating: 7,
        },
    ],
};

// ApiSurveysStatsResponse
export const apiSurveysStatsResponse: ApiSurveysStatsResponse = {
    surveysStats: {
        totalSurveys: 10,
        avgSurveysPerDay: 0.5,
        avgQualitativeRating: 6.5,
    },
};

// ApiSurveyDetailsResponse
export const apiSurveyDetailsResponse: ApiSurveyDetailsResponse = {
    surveyDetails: {
        id: "3",
        name: "Bern Umweltumfrage 2023",
        questions: [
            {
                id: "3",
                name: "Frage3",
                description: "Beschreibung3",
                dimension: "Umwelt",
                theme: "Nachhaltigkeit",
                indicator: "Recycling",
            },
        ],
        quantitativeData: [
            {
                dimension: "Umwelt",
                themes: [
                    {
                        name: "Nachhaltigkeit",
                        indicators: [
                            {
                                name: "Recycling",
                                rating: 8,
                            },
                        ],
                    },
                ],
            },
        ],
        participatingMunicipalities: [
            {
                id: "4",
                name: "Bern",
                region: "Bern",
                canton: "Bern",
                district: "Bern",
                avgQuantitativeRating: 8,
                avgQualitativeRating: 7.5,
            },
        ],
    },
};

export interface Municipality {
    id: string;
    name: string;
    region: string;
    canton: string;
    district: string;
    avgQuantitativeRating: number;
    avgQualitativeRating: number;
}

export interface MunicipalitiesStats {
    totalMunicipalities: number;
    avgQuantitativeRating: number;
    avgQualitativeRating: number;
}

export interface Survey {
    id: string;
    name: string;
    totalParticipatingMunicipalities: number;
    avgQualitativeRating: number;
}

export interface SurveyStats {
    totalSurveys: number;
    avgSurveysPerDay: number;
    avgQualitativeRating: number;
}

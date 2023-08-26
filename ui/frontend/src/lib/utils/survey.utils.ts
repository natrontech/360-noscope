import type { SurveyQuestionsResponse, SurveysResponse } from "$lib/pocketbase/generated-types";
import type { QuestionType } from "$lib/types/generic";

export function getQuestions(survey: SurveysResponse): SurveyQuestionsResponse[] {
    // ToDo how to access correctly?
    // @ts-ignore
    return survey.expand.survey_questions;
}

export function getQuestionType(question: SurveyQuestionsResponse): QuestionType {
    // ToDo how to access correctly?
    // @ts-ignore
    return question.expand.survey_question_type.name;
}

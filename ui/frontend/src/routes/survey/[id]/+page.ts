import type { PageLoad } from "./$types";
import { client } from "$lib/pocketbase";
import toast from "svelte-french-toast";
import type {
    SurveysResponse,
    SurveyQuestionsResponse,
    SurveyParticipantsResponse, MunicipalitiesResponse
} from '$lib/pocketbase/generated-types';
import {
    getQuestionDomain,
    getQuestionIndicator,
    getQuestions,
    getQuestionTheme,
    getQuestionType
} from '$lib/utils/survey.utils';
import type { QuestionUi } from "$lib/types/generic";
import { goto } from '$app/navigation';
export const load: PageLoad = async ({ params }) => {
    const { id } = params;

    try {
        const participant: SurveyParticipantsResponse = await client.collection("survey_participants").getOne(id);
        const municipality: MunicipalitiesResponse = await client.collection("municipalities").getOne(participant.municipality);
        const survey: SurveysResponse = await client.collection("surveys").getOne(participant.survey, {
            expand: "survey_questions.survey_indicator.survey_theme.survey_dimension,survey_questions.survey_question_type"});

        const questions: QuestionUi[] = getQuestions(survey).map(
            (question: SurveyQuestionsResponse) => {
                const type = getQuestionType(question);
                const indicator = getQuestionIndicator(question);
                const theme = getQuestionTheme(question);
                const dimension = getQuestionDomain(question);
                return {
                    questionId: question.id,
                    question: question.question,
                    type, indicator:
                    indicator.name,
                    theme: theme.name,
                    dimension: dimension.name,
                    answer: 0
                };
            }
        );

        return { survey, questions, municipality, participant, id };
    } catch (error) {
        toast.error("Error: Umfrage existiert nicht");
        goto(`/error/500`)
    }
};

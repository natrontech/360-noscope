import type { PageLoad } from "./$types";
import { client } from "$lib/pocketbase";
import toast from "svelte-french-toast";
import type { SurveysResponse, SurveyQuestionsResponse } from "$lib/pocketbase/generated-types";
import { getQuestions, getQuestionType } from "$lib/utils/survey.utils";
import type { QuestionUi } from "$lib/types/generic";
export const load: PageLoad = async ({ params }) => {
    const { hash } = params;

    try {
        const survey: SurveysResponse = await client.collection("surveys").getOne(hash, {
            expand: "survey_questions.survey_indicator.survey_theme,survey_questions.survey_question_type"
        });
        const questions: QuestionUi[] = getQuestions(survey).map(
            (question: SurveyQuestionsResponse) => {
                const type = getQuestionType(question);
                const answer = type === "bool" ? false : null;
                return { questionId: question.id, question: question.question, type, answer };
            }
        );

        toast.success("Umfrage geladen");
        return { survey, questions, hash };
    } catch (error) {
        toast.error("Error: Umfrage existiert nicht");
    }
};

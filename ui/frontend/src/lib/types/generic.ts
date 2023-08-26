export type QuestionType = "number" | "bool";

export type QuestionUi = {
    questionId: string;
    question: string;
    type: QuestionType;
    answer: number | boolean | null;
};

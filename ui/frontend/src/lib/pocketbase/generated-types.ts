/**
* This file was @generated using pocketbase-typegen
*/

export enum Collections {
	Hooks = "hooks",
	Municipalities = "municipalities",
	SurveyDimensions = "survey_dimensions",
	SurveyIndicators = "survey_indicators",
	SurveyParticipants = "survey_participants",
	SurveyQuestionTypes = "survey_question_types",
	SurveyQuestions = "survey_questions",
	SurveyThemes = "survey_themes",
	Surveys = "surveys",
	Users = "users",
}

// Alias types for improved usability
export type IsoDateString = string
export type RecordIdString = string
export type HTMLString = string

// System fields
export type BaseSystemFields<T = never> = {
	id: RecordIdString
	created: IsoDateString
	updated: IsoDateString
	collectionId: string
	collectionName: Collections
	expand?: T
}

export type AuthSystemFields<T = never> = {
	email: string
	emailVisibility: boolean
	username: string
	verified: boolean
} & BaseSystemFields<T>

// Record types for each collection

export enum HooksEventOptions {
	"insert" = "insert",
	"update" = "update",
	"delete" = "delete",
}

export enum HooksActionTypeOptions {
	"command" = "command",
	"email" = "email",
	"post" = "post",
}
export type HooksRecord = {
	collection: string
	event: HooksEventOptions
	action_type: HooksActionTypeOptions
	action: string
	action_params?: string
	expands?: string
	disabled?: boolean
}

export type MunicipalitiesRecord = {
	name?: string
	plz?: number
	last_submit_datetime?: IsoDateString
	can_submit?: boolean
}

export type SurveyDimensionsRecord = {
	name?: string
}

export type SurveyIndicatorsRecord = {
	name?: string
	survey_theme: RecordIdString
}

export type SurveyParticipantsRecord = {
	municipality?: RecordIdString
	survey?: RecordIdString
	canSubmit?: boolean
}

export type SurveyQuestionTypesRecord = {
	name: string
}

export type SurveyQuestionsRecord = {
	question?: string
	survey_indicator: RecordIdString
	survey_question_type: RecordIdString
}

export type SurveyThemesRecord = {
	name?: string
	survey_dimension: RecordIdString
}

export type SurveysRecord = {
	name?: string
	survey_questions: RecordIdString[]
}

export type UsersRecord = {
	name?: string
	avatar?: string
}

// Response types include system fields and match responses from the PocketBase API
export type HooksResponse = Required<HooksRecord> & BaseSystemFields
export type MunicipalitiesResponse = Required<MunicipalitiesRecord> & BaseSystemFields
export type SurveyDimensionsResponse = Required<SurveyDimensionsRecord> & BaseSystemFields
export type SurveyIndicatorsResponse<Texpand = unknown> = Required<SurveyIndicatorsRecord> & BaseSystemFields<Texpand>
export type SurveyParticipantsResponse<Texpand = unknown> = Required<SurveyParticipantsRecord> & BaseSystemFields<Texpand>
export type SurveyQuestionTypesResponse = Required<SurveyQuestionTypesRecord> & BaseSystemFields
export type SurveyQuestionsResponse<Texpand = unknown> = Required<SurveyQuestionsRecord> & BaseSystemFields<Texpand>
export type SurveyThemesResponse<Texpand = unknown> = Required<SurveyThemesRecord> & BaseSystemFields<Texpand>
export type SurveysResponse<Texpand = unknown> = Required<SurveysRecord> & BaseSystemFields<Texpand>
export type UsersResponse = Required<UsersRecord> & AuthSystemFields

// Types containing all Records and Responses, useful for creating typing helper functions

export type CollectionRecords = {
	hooks: HooksRecord
	municipalities: MunicipalitiesRecord
	survey_dimensions: SurveyDimensionsRecord
	survey_indicators: SurveyIndicatorsRecord
	survey_participants: SurveyParticipantsRecord
	survey_question_types: SurveyQuestionTypesRecord
	survey_questions: SurveyQuestionsRecord
	survey_themes: SurveyThemesRecord
	surveys: SurveysRecord
	users: UsersRecord
}

export type CollectionResponses = {
	hooks: HooksResponse
	municipalities: MunicipalitiesResponse
	survey_dimensions: SurveyDimensionsResponse
	survey_indicators: SurveyIndicatorsResponse
	survey_participants: SurveyParticipantsResponse
	survey_question_types: SurveyQuestionTypesResponse
	survey_questions: SurveyQuestionsResponse
	survey_themes: SurveyThemesResponse
	surveys: SurveysResponse
	users: UsersResponse
}

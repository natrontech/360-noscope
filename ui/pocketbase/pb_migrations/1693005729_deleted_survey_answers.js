/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db);
  const collection = dao.findCollectionByNameOrId("7xt54dutngjwvwi");

  return dao.deleteCollection(collection);
}, (db) => {
  const collection = new Collection({
    "id": "7xt54dutngjwvwi",
    "created": "2023-08-25 21:27:54.066Z",
    "updated": "2023-08-25 21:27:54.066Z",
    "name": "survey_answers",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "bxhjn4my",
        "name": "answer",
        "type": "text",
        "required": false,
        "unique": false,
        "options": {
          "min": null,
          "max": null,
          "pattern": ""
        }
      },
      {
        "system": false,
        "id": "husc4sjp",
        "name": "survey_question",
        "type": "relation",
        "required": true,
        "unique": false,
        "options": {
          "collectionId": "c7sleimfvzr945h",
          "cascadeDelete": false,
          "minSelect": null,
          "maxSelect": 1,
          "displayFields": [
            "question"
          ]
        }
      }
    ],
    "indexes": [],
    "listRule": "",
    "viewRule": "",
    "createRule": "",
    "updateRule": "",
    "deleteRule": "",
    "options": {}
  });

  return Dao(db).saveCollection(collection);
})

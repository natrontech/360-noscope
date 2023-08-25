/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "34dlekin9dmaq2c",
    "created": "2023-08-25 21:23:45.487Z",
    "updated": "2023-08-25 21:23:45.487Z",
    "name": "survey_question_types",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "eqlflyq3",
        "name": "name",
        "type": "text",
        "required": true,
        "unique": false,
        "options": {
          "min": null,
          "max": null,
          "pattern": ""
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
}, (db) => {
  const dao = new Dao(db);
  const collection = dao.findCollectionByNameOrId("34dlekin9dmaq2c");

  return dao.deleteCollection(collection);
})

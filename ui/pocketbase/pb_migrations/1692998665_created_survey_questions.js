/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "c7sleimfvzr945h",
    "created": "2023-08-25 21:24:25.907Z",
    "updated": "2023-08-25 21:24:25.907Z",
    "name": "survey_questions",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "i14xuqyc",
        "name": "question",
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
        "id": "ezayb4md",
        "name": "survey_indicator",
        "type": "relation",
        "required": true,
        "unique": false,
        "options": {
          "collectionId": "y64f61b5yzjx4ux",
          "cascadeDelete": false,
          "minSelect": null,
          "maxSelect": 1,
          "displayFields": [
            "name"
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
}, (db) => {
  const dao = new Dao(db);
  const collection = dao.findCollectionByNameOrId("c7sleimfvzr945h");

  return dao.deleteCollection(collection);
})

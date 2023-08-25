/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "xpkiw672rqvll38",
    "created": "2023-08-25 21:29:01.658Z",
    "updated": "2023-08-25 21:29:01.658Z",
    "name": "surveys",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "uf28dbns",
        "name": "name",
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
        "id": "strtnyxp",
        "name": "survey_questions",
        "type": "relation",
        "required": true,
        "unique": false,
        "options": {
          "collectionId": "c7sleimfvzr945h",
          "cascadeDelete": false,
          "minSelect": null,
          "maxSelect": null,
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
}, (db) => {
  const dao = new Dao(db);
  const collection = dao.findCollectionByNameOrId("xpkiw672rqvll38");

  return dao.deleteCollection(collection);
})

/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "bwie9os6imabhy5",
    "created": "2023-08-25 21:30:59.732Z",
    "updated": "2023-08-25 21:30:59.732Z",
    "name": "survey_fills",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "gkvlyqbs",
        "name": "email",
        "type": "email",
        "required": false,
        "unique": false,
        "options": {
          "exceptDomains": null,
          "onlyDomains": null
        }
      },
      {
        "system": false,
        "id": "gvshjoqe",
        "name": "address",
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
        "id": "t1esk3qc",
        "name": "survey",
        "type": "relation",
        "required": true,
        "unique": false,
        "options": {
          "collectionId": "xpkiw672rqvll38",
          "cascadeDelete": false,
          "minSelect": null,
          "maxSelect": null,
          "displayFields": [
            "name"
          ]
        }
      },
      {
        "system": false,
        "id": "7xnxvplw",
        "name": "survey_answers",
        "type": "relation",
        "required": false,
        "unique": false,
        "options": {
          "collectionId": "7xt54dutngjwvwi",
          "cascadeDelete": false,
          "minSelect": null,
          "maxSelect": null,
          "displayFields": []
        }
      }
    ],
    "indexes": [],
    "listRule": null,
    "viewRule": null,
    "createRule": null,
    "updateRule": null,
    "deleteRule": null,
    "options": {}
  });

  return Dao(db).saveCollection(collection);
}, (db) => {
  const dao = new Dao(db);
  const collection = dao.findCollectionByNameOrId("bwie9os6imabhy5");

  return dao.deleteCollection(collection);
})

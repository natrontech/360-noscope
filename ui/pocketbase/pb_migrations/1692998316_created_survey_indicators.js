/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "y64f61b5yzjx4ux",
    "created": "2023-08-25 21:18:36.446Z",
    "updated": "2023-08-25 21:18:36.446Z",
    "name": "survey_indicators",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "uigzbkk8",
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
        "id": "lsatkgsc",
        "name": "survey_theme",
        "type": "relation",
        "required": true,
        "unique": false,
        "options": {
          "collectionId": "8i6r2p35uyqgieh",
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
  const collection = dao.findCollectionByNameOrId("y64f61b5yzjx4ux");

  return dao.deleteCollection(collection);
})

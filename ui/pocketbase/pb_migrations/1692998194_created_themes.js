/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "8i6r2p35uyqgieh",
    "created": "2023-08-25 21:16:34.341Z",
    "updated": "2023-08-25 21:16:34.341Z",
    "name": "themes",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "swd3y1nw",
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
        "id": "yneqc5sq",
        "name": "dimension",
        "type": "relation",
        "required": true,
        "unique": false,
        "options": {
          "collectionId": "pva9n2ith8u53ko",
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
  const collection = dao.findCollectionByNameOrId("8i6r2p35uyqgieh");

  return dao.deleteCollection(collection);
})

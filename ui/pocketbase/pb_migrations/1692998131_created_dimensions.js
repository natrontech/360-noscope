/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "pva9n2ith8u53ko",
    "created": "2023-08-25 21:15:31.888Z",
    "updated": "2023-08-25 21:15:31.888Z",
    "name": "dimensions",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "gyjjl2z0",
        "name": "name",
        "type": "text",
        "required": false,
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
  const collection = dao.findCollectionByNameOrId("pva9n2ith8u53ko");

  return dao.deleteCollection(collection);
})

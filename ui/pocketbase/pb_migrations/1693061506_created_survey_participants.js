/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "y0fh4d9e503808d",
    "created": "2023-08-26 14:51:46.078Z",
    "updated": "2023-08-26 14:51:46.078Z",
    "name": "survey_participants",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "c9cbhq2d",
        "name": "municipality",
        "type": "relation",
        "required": false,
        "unique": false,
        "options": {
          "collectionId": "svn6nbxcg50j8ds",
          "cascadeDelete": false,
          "minSelect": null,
          "maxSelect": 1,
          "displayFields": []
        }
      },
      {
        "system": false,
        "id": "hvg6pkcn",
        "name": "survey",
        "type": "relation",
        "required": false,
        "unique": false,
        "options": {
          "collectionId": "xpkiw672rqvll38",
          "cascadeDelete": false,
          "minSelect": null,
          "maxSelect": 1,
          "displayFields": []
        }
      },
      {
        "system": false,
        "id": "ekit4xhw",
        "name": "canSubmit",
        "type": "bool",
        "required": false,
        "unique": false,
        "options": {}
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
  const collection = dao.findCollectionByNameOrId("y0fh4d9e503808d");

  return dao.deleteCollection(collection);
})

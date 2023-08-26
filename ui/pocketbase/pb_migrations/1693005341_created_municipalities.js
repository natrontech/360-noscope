/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const collection = new Collection({
    "id": "svn6nbxcg50j8ds",
    "created": "2023-08-25 23:15:41.187Z",
    "updated": "2023-08-25 23:15:41.187Z",
    "name": "municipalities",
    "type": "base",
    "system": false,
    "schema": [
      {
        "system": false,
        "id": "ip8x30lt",
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
        "id": "auq2odfw",
        "name": "plz",
        "type": "number",
        "required": false,
        "unique": false,
        "options": {
          "min": null,
          "max": null
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
  const collection = dao.findCollectionByNameOrId("svn6nbxcg50j8ds");

  return dao.deleteCollection(collection);
})

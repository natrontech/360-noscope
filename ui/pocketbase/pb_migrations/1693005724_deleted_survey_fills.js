/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db);
  const collection = dao.findCollectionByNameOrId("bwie9os6imabhy5");

  return dao.deleteCollection(collection);
}, (db) => {
  const collection = new Collection({
    "id": "bwie9os6imabhy5",
    "created": "2023-08-25 21:30:59.732Z",
    "updated": "2023-08-25 23:21:38.134Z",
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
        "id": "mxkw5q0n",
        "name": "municipality",
        "type": "relation",
        "required": true,
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
        "id": "t1esk3qc",
        "name": "survey",
        "type": "relation",
        "required": true,
        "unique": false,
        "options": {
          "collectionId": "xpkiw672rqvll38",
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
})

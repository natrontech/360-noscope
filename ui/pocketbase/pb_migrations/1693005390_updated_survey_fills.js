/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("bwie9os6imabhy5")

  // add
  collection.schema.addField(new SchemaField({
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
  }))

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("bwie9os6imabhy5")

  // remove
  collection.schema.removeField("mxkw5q0n")

  return dao.saveCollection(collection)
})

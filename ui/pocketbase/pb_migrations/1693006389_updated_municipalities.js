/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("svn6nbxcg50j8ds")

  // add
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "oigwhlew",
    "name": "can_submit",
    "type": "bool",
    "required": false,
    "unique": false,
    "options": {}
  }))

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("svn6nbxcg50j8ds")

  // remove
  collection.schema.removeField("oigwhlew")

  return dao.saveCollection(collection)
})

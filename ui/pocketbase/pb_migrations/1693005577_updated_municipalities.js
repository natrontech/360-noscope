/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("svn6nbxcg50j8ds")

  // add
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "phnydhlk",
    "name": "last_submit_datetime",
    "type": "date",
    "required": false,
    "unique": false,
    "options": {
      "min": "",
      "max": ""
    }
  }))

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("svn6nbxcg50j8ds")

  // remove
  collection.schema.removeField("phnydhlk")

  return dao.saveCollection(collection)
})

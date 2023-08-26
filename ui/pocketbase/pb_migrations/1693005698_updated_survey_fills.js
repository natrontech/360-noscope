/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("bwie9os6imabhy5")

  // remove
  collection.schema.removeField("7xnxvplw")

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("bwie9os6imabhy5")

  // add
  collection.schema.addField(new SchemaField({
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
  }))

  return dao.saveCollection(collection)
})

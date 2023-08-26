/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("c7sleimfvzr945h")

  // add
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "hrnj38xi",
    "name": "survey_question_type",
    "type": "relation",
    "required": true,
    "unique": false,
    "options": {
      "collectionId": "34dlekin9dmaq2c",
      "cascadeDelete": false,
      "minSelect": null,
      "maxSelect": 1,
      "displayFields": [
        "name"
      ]
    }
  }))

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("c7sleimfvzr945h")

  // remove
  collection.schema.removeField("hrnj38xi")

  return dao.saveCollection(collection)
})

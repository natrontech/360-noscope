/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("8i6r2p35uyqgieh")

  collection.name = "survey_themes"

  // update
  collection.schema.addField(new SchemaField({
    "system": false,
    "id": "yneqc5sq",
    "name": "survey_dimension",
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
  }))

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("8i6r2p35uyqgieh")

  collection.name = "themes"

  // update
  collection.schema.addField(new SchemaField({
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
  }))

  return dao.saveCollection(collection)
})

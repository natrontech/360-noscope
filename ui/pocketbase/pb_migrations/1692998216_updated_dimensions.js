/// <reference path="../pb_data/types.d.ts" />
migrate((db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("pva9n2ith8u53ko")

  collection.name = "survey_dimensions"

  return dao.saveCollection(collection)
}, (db) => {
  const dao = new Dao(db)
  const collection = dao.findCollectionByNameOrId("pva9n2ith8u53ko")

  collection.name = "dimensions"

  return dao.saveCollection(collection)
})

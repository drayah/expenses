(ns wallchart.expenses.utils.entity-test
  (:require [wallchart.expenses.utils.entity :as sut]
            [midje.sweet :refer :all]))

(facts "when generating an entity id"
  (fact "it returns a valid uuid"
    (sut/generate-entity-id) => uuid?))

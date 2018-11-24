(ns wallchart.expenses.utils.entity
  (:import [java.util UUID]))

(defn generate-entity-id []
  (UUID/randomUUID))

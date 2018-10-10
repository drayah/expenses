(ns wallchart.expenses.domain.account
  (:import [java.util UUID]))

(defn- random-uuid []
  (UUID/randomUUID))

(defn create-account [name]
  {:id (random-uuid)
   :name name
   :transactions []})

(defn create-transaction [date amount category]
  {:id (random-uuid)
   :date date
   :amount amount
   :category category})

(defn add-transaction [account transaction])

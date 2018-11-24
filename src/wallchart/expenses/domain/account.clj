(ns wallchart.expenses.domain.account)

(defn create-account [generate-id name]
  {:id           (generate-id)
   :name         name
   :transactions []})

(defn create-transaction [generate-id date amount category]
  {:id       (generate-id)
   :date     date
   :amount   amount
   :category category})

(defn add-transaction [account transaction]
  (let [transactions (:transactions account)]
    (->> (conj transactions transaction)
         (assoc account :transactions))))

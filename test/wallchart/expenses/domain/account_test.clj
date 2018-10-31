(ns wallchart.expenses.domain.account-test
  (:require [wallchart.expenses.domain.account :as sut]
            [clj-time.core :as t]
            [midje.sweet :refer :all]))

(facts "when creating a new account"
  (fact "it returns new account data"
    (sut/create-account "My account") => (just {:id uuid?
                                                :name "My account"
                                                :transactions []})))

(facts "when creating a new transaction"
  (fact "it returns new transaction data"
    (let [some-day (t/date-time 2018 11 01)]
      (sut/create-transaction some-day -100M :restaurant) => (just {:id uuid?
                                                                    :date some-day
                                                                    :amount -100M
                                                                    :category :restaurant}))))

(facts "when adding a transaction to an account"
  (fact "it adds transaction data to the account"
    (let [test-account (sut/create-account "some account")
          test-transaction (sut/create-transaction (t/date-time 2018 01 01) -50M :groceries)
          updated-account (sut/add-transaction test-account test-transaction)]
      (:transactions updated-account) => [])))

(ns expenses.core-test
  (:require [expectations :refer :all]
            [expenses.core :refer :all]))

; verify that we correctly calculate
; real returns given a nominal return
; and inflation
(expect 0 (real-return 1 1))
(expect 1 (real-return 1 0))
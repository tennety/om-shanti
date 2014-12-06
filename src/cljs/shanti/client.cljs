(ns shanti.client
  (:require [clojure.browser.repl :as repl]))

(defn ^:export start-client []
  (repl/connect "http://localhost:9000/repl"))

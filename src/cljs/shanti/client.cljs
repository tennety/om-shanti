(ns shanti.client
  (:require [clojure.browser.repl :as repl]
            [shanti.core :as s]))

(def slides
  [{:title "A Bird's Eye View of ClojureScript"
    :body "###You don't *have* to write JavaScript!"}
   {:title "Motivation"
    :body "Birding"
    :notes "Talk about why"}])

(defn ^:export start []
  (repl/connect "http://localhost:9000/repl")
  (s/start slides))

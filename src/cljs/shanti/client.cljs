(ns shanti.client
  (:require [clojure.browser.repl :as repl]
            [shanti.core :as s]))

(def slides
  [{:title "ClojureScript!"
    :body "How 'bout dem apples"}
   {:title "Slide 2"
    :body "Caden"}])

(defn ^:export start []
  (repl/connect "http://localhost:9000/repl")
  (s/start slides))

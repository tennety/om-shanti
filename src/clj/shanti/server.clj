(ns shanti.server
  (:require [ring.adapter.jetty :as jetty]
            [compojure.route :as route]))

(defn start-server []
  (jetty/run-jetty
    (route/resources "/")
    {:port 3000 :join? false}))

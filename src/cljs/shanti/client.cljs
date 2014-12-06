(ns shanti.client
  (:require [clojure.browser.repl :as repl]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(def model (atom {}))

(def slides [{:title "ClojureScript!" :body "How 'bout dem apples"} {:title "Slide 2"}])

(defn slide [model owner]
  (reify
    om/IRender
    (render [_]
      (dom/section #js {:className "slide"}
        (dom/h2 nil (:title model))
        (dom/div nil (:body model))))))

(defn app [model owner]
  (reify
    om/IRender
    (render [_]
      (apply dom/div #js {:className "content"}
        (om/build-all slide slides)))))

(defn ^:export start []
  (om/root app model {:target (.getElementById js/document "main")})
  (repl/connect "http://localhost:9000/repl"))

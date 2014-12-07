(ns shanti.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(def model (atom {:index 0
                  :slides []}))

(defn next-slide [e model f]
  (let [slides (:slides @model)
        current-pos (:index @model)
        upcoming-pos (f current-pos)]
    (.preventDefault e)
    (when (get slides upcoming-pos)
      (om/transact! model :index f))))

(defn slide [model owner]
  (reify
    om/IRender
    (render [_]
      (dom/section #js {:className "slide"}
        (dom/h1 #js {} (:title model))
        (dom/div #js {} (:body model))))))

(defn app [model owner]
  (reify
    om/IRender
    (render [_]
      (dom/div #js {:className "content"}
         (om/build slide ((:slides model) (:index model)))
         (dom/div #js {:className "control"}
            (dom/a #js {:href ""
                        :onClick #(next-slide % model dec)} "←")
            (dom/a #js {:href ""
                        :onClick #(next-slide % model inc)} "→"))))))

(defn ^:export start [slides]
  (swap! model assoc :slides slides)
  (om/root app model {:target (.getElementById js/document "main") :shared slides}))

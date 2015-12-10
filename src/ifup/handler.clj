(ns ifup.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clojure.tools.logging :as l]
            [clojure.string :as s]))

(defroutes app-routes
  (GET "/" {:keys [remote-addr headers] :as request}
       (let [x-forwarded-for (get headers "x-forwarded-for")]
         (if (empty? x-forwarded-for)
           remote-addr
           (first (s/split x-forwarded-for #",")))))
  (route/not-found "Hello World"))

(def app
  (wrap-defaults app-routes site-defaults))

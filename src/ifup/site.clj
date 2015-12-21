(ns ifup.site
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clojure.tools.logging :as l]
            [clojure.string :as s]))

(defroutes site-routes
  (GET "/" {:keys [remote-addr headers] :as request}
       (let [x-forwarded-for (get headers "x-forwarded-for")]
         (if (empty? x-forwarded-for)
           remote-addr
           (first (s/split x-forwarded-for #",")))))
  (route/not-found "Hello World"))

(def site
  (wrap-defaults site-routes site-defaults))

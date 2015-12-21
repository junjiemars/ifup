(ns ifup.api
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [ring.util.response :refer [response]]))

(defroutes api-routes
  (context "/api"[]
           (GET "/" request
                (response [{:op "ip"}]))))


(def api (handler/api api-routes))



(ns ifup.boot
  (:require [clojure.tools.logging :as l]
            [compojure.core :refer [routes]]
            [ifup.api :refer :all]
            [ifup.site :refer :all]))


(def app (routes api site))

(ns ifup.site-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [ifup.site :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (site (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body "localhost,")))))

  (testing "not-found route"
    (let [response (site (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))

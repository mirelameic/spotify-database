(ns spotify-database.core
  (:import [java.util Base64])
  (:require [clj-http.client :as http]
            [clojure.data.json :as json])
            (:gen-class))

(def client-id (System/getProperty "SPOTIFY_CLIENT_ID"))
(def client-secret (System/getProperty "SPOTIFY_CLIENT_SECRET"))

(def url "https://accounts.spotify.com/api/token")

(def headers {:Authorization (->> (str client-id ":" client-secret)
                                   (.getBytes)
                                   (.encode (Base64/getEncoder))
                                   (String.)
                                   (str "Basic "))
              :Content-Type "application/x-www-form-urlencoded"})

(def payload {:grant_type "client_credentials"})

(defn token-request []
  (http/post url {:debug false
                  :debug-body false
                  :form-params payload
                  :headers headers}))

(defn request-token! []
  (try (let [response (token-request)
             token (:access_token 
                    (json/read-str
                     (:body response)
                     :key-fn keyword))]
         (println "Token:" token))
       (catch Exception e
         (println "token-request error: " e))))

(ns spotify-database.auth
  (:import [java.util Base64])
  (:require [clj-http.client :as http]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.data.json :as json]
            [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [spotify-database.credentials :as creds])
  (:gen-class))

(creds/set-credentials)
(def client-id (System/getProperty "SPOTIFY_CLIENT_ID"))
(def client-secret (System/getProperty "SPOTIFY_CLIENT_SECRET"))
(def redirect-uri "http://localhost:8080/callback")
(def auth-url "https://accounts.spotify.com/authorize")
(def token-url "https://accounts.spotify.com/api/token")

(def scopes "playlist-read-private")

(defn build-auth-url []
  (str auth-url "?client_id=" client-id
       "&response_type=code"
       "&redirect_uri=" (java.net.URLEncoder/encode redirect-uri "UTF-8")
       "&scope=" (java.net.URLEncoder/encode scopes "UTF-8")))

(defn redirect-to-auth []
  (println "Authorization link:")
  (println (build-auth-url)))

(redirect-to-auth)

;; (defn handle-callback [req]
;;   (let [code (get-in req [:params :code])]
;;     (if code
;;       (do
;;         (println "Código de autorização recebido: " code)
;;         (request-access-token! code))  ;; Chame uma função que fará o request do token
;;       (println "Nenhum código de autorização foi fornecido!"))))

;; (defroutes app
;;   (GET "/callback" req (handle-callback req))
;;   (route/not-found "Not Found"))

;; (defn start-server []
;;   (jetty/run-jetty app {:port 8080 :join? false}))

;; (defn request-access-token! [auth-code]
;;   (let [headers {:Authorization (str "Basic " (->> (str client-id ":" client-secret)
;;                                                    (.getBytes)
;;                                                    (.encode (Base64/getEncoder))
;;                                                    (String.)))
;;                  :Content-Type "application/x-www-form-urlencoded"}
;;         payload {:grant_type "authorization_code"
;;                  :code auth-code
;;                  :redirect_uri redirect-uri}]
;;     (try
;;       (let [response (http/post token-url {:form-params payload :headers headers})
;;             body (json/read-str (:body response) :key-fn keyword)
;;             access-token (:access_token body)]
;;         (println "Access Token: " access-token)
;;         access-token)
;;       (catch Exception e
;;         (println "Erro ao obter o token: " e)))))

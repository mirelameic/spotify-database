(ns spotify-database.playlist
  (:require [clj-http.client :as http])
  (:gen-class))

(def url "https://api.spotify.com/v1/me/playlists")

(defn get-playlists [token] 
    (http/get url {:headers {:Authorization (str "Bearer " token)}}))

(defn request-playlists! [token]
  (try (let [response (get-playlists token)]
         (println "Response:" response)
         response)
       (catch Exception e
         (println "playlists-request error: " e))))
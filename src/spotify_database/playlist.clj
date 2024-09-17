(ns spotify-database.playlist
  (:require [clj-http.client :as http])
  (:gen-class))

(def playlist-url "https://api.spotify.com/v1/me/playlists")

(defn get-playlists [token]
  (let [headers {:Authorization (str "Bearer " token)}]
    (http/get playlist-url {:headers headers
                            :as :json})))
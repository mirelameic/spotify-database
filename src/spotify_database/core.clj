(ns spotify-database.core
  (:require [spotify-database.token :as token]
            [spotify-database.playlist :as playlist])
  (:gen-class))

(def token (token/request-token!))

(def playlists (playlist/get-playlists token))
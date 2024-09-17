# spotify-database <img src="image.png" alt="Texto alternativo" width="45" />

## overview

This Clojure project aims to interact with the Spotify API to retrieve and store information about playlists and musics.

## getting started

To use this project, follow these steps:

1. **Set up spotify developer account**
   - Obtain a client ID and client secret by creating a Spotify Developer account and registering a new application.

2. **Configure project**
   - System properties can be set in the REPL using:
    ```clojure
    (System/setProperty "SPOTIFY_CLIENT_ID" "your_client_id_here")
    (System/setProperty "SPOTIFY_CLIENT_SECRET" "your_client_secret_here")
    ```
    - The client ID and client secret are then accessed in the code as follows:
    ```clojure
    (def client-id (System/getProperty "SPOTIFY_CLIENT_ID"))
    (def client-secret (System/getProperty "SPOTIFY_CLIENT_SECRET"))
    ```

## project structure

- **credentials.clj**
  - To run this project, it is necessary to create a namespace called `credentials`, wich will have a function `set-credentials` that setProperty for your specific cliend-id and client-secret (as demonstrated above).

- **token.clj**
  - The Spotify API requires authentication via the client credentials grant type. The client ID and client secret are provided and used to obtain an access token.
  - The `token-request` function sends a POST request to the Spotify Authorization API to obtain an access token.
  - The `request-token!` function attempts to retrieve the access token and prints it. In case of an error, it prints an error message.

- **playlist.clj**
  - This namespace will search for all the playlists in this user's spotify.

## dependencies

- [clj-http](https://github.com/dakrone/clj-http): Library for making HTTP requests.
- [clojure.data.json](https://github.com/clojure/data.json): Library for reading and writing JSON.

## future steps

The project is in its early stages and currently only handles authentication. Future steps may include:

- Implementing functions to interact with the Spotify API to retrieve information about user playlists and tracks.
- Storing retrieved data in a local database or file for future use.

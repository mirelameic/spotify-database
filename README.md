# spotify-database

## overview

This Clojure project aims to interact with the Spotify API to retrieve and store information about my playlists and musics.

## project structure

The project consists of a namespace (`spotify-database.core`) containing functions to handle the Spotify API authentication. Here's a brief overview of the current implementation:

- **Client Credentials:**
  - The Spotify API requires authentication via the client credentials grant type. The client ID and client secret are provided and used to obtain an access token.
  - The `token-request` function sends a POST request to the Spotify Authorization API to obtain an access token.
  - The `request-token!` function attempts to retrieve the access token and prints it. In case of an error, it prints an error message.

## getting started

To use this project, follow these steps:

1. **Set up Spotify Developer Account:**
   - Obtain a client ID and client secret by creating a Spotify Developer account and registering a new application.

2. **Configure Project:**
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

3. **Run the Project:**
   - Execute the `request-token!` function to obtain an access token from the Spotify API.

## dependencies

- [clj-http](https://github.com/dakrone/clj-http): A Clojure HTTP library for making HTTP requests.
- [clojure.data.json](https://github.com/clojure/data.json): A Clojure library for reading and writing JSON.

## future steps

The project is in its early stages and currently only handles authentication. Future steps may include:

- Implementing functions to interact with the Spotify API to retrieve information about user playlists and tracks.
- Storing retrieved data in a local database or file for future use.

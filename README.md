# spotify-database <img src="image.png" alt="Texto alternativo" width="45" />

## overview

This Clojure project aims to interact with the Spotify API to retrieve and store information about playlists and musics.

## getting started

To use this project, follow these steps:

1. **Set up spotify developer account**
   - Obtain a client ID and client secret by creating a Spotify Developer account and registering a new application.

2. **Configure project**
   - To run this project, it is necessary to create a namespace called `credentials.clj`, wich will have a function called `set-credentials` that setProperty for your specific cliend-id and client-secret:
    ```clojure
    (ns spotify-database.credentials)

    (defn set-credentials []
      (System/setProperty "SPOTIFY_CLIENT_SECRET" "[your-client-secret]")
      (System/setProperty "SPOTIFY_CLIENT_ID" "[your-client-id]"))
    ```

## project structure
- **core.clj**  
  This namespace will be responsible to make the project work, running the principal functions in a automatic way.

- **playlist.clj**  
  This namespace will search for all the playlists in this user's spotify.
  
- **auth.clj**  
  To access user information, such as their playlists, it is necessary to obtain permission directly from the user (in this case, yourself). This is done through an OAuth authentication process, where the user grants access to the application.

- **token.clj**  
  To access other public information, it only is necessary to obtain authentication via the client credentials grant type. The client ID and client secret are provided and used to obtain an access token.

  - The `token-request` function sends a POST request to the Spotify Authorization API to obtain an access token.
  - The `request-token!` function attempts to retrieve the access token and prints it. In case of an error, it prints an error message.

## dependencies

- [clj-http](https://github.com/dakrone/clj-http): Library for making HTTP requests.
- [clojure.data.json](https://github.com/clojure/data.json): Library for reading and writing JSON.

## future steps

The project is in its early stages and currently only handles authentication. Future steps include:

- Implementing functions to interact with the Spotify API to retrieve information about user playlists and tracks.
- Storing retrieved data in a local database or file for future use.

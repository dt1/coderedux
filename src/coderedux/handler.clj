(ns coderedux.handler
  (:use compojure.core
        hiccup.core
        hiccup.page
        hiccup.element
        ring.adapter.jetty)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [coderedux.common :as common]
            [coderedux.articles :as articles]

            [coderedux.musictheory.cofone :as cofone]
            [coderedux.musictheory.coftwo :as coftwo]
            [coderedux.musictheory.chordsone :as chords-one]
            [coderedux.musictheory.resources :as mt-resources]
            [coderedux.musictheory.keysig :as keysig]

            [coderedux.generalinfo :as general]
            [coderedux.pokerbots :as bots]
            [coderedux.postgresql.badapples :as pg-apple]
            [coderedux.postgresql.iucte :as iucte]
            [coderedux.postgresql.resources :as pg-resources]
            [coderedux.quitting.quitting :as quitting]
            [coderedux.books.sicp :as books-sicp])
  (:gen-class))

(defn home-page []
  (common/layout
   "Home"
   (general/front-page)))

(defn about []
  (common/layout
   "About"
   (general/about)))

(defn contact []
  (common/layout
   "Contact"
   (general/contact)))

(defn cof-one []
  (common/layout
   "Circle of Fifths Part 1"
   (cofone/circle-of-fifths-part-one)))

(defn cof-two []
  (common/layout
   "Circle of Fifths Part 2"
   (coftwo/circle-of-fifths-part-two)))

(defn chord-one []
  (common/layout
   "Chords Part 1"
   (chords-one/chords-part-one)))

(defn keysig []
  (common/layout
   "Music Reading (part 1): Key Signatures"
   (keysig/keysig)))

(defn music-theory []
  (common/layout
   "Music Theory"
   (articles/music-theory-article-list)))

(defn music-theory-resources []
  (common/layout
   "Music Theory Resources"
   (mt-resources/music-theory-resources)))

(defn cof-redirect []
  (common/layout
   "Redirect, Please"
   "hello"))

(defn on-clojure-main []
  (common/layout
   "on clojure articles"
  (articles/on-clojure))) 

(defn poker-bots-main []
  (common/layout
   "About Poker Bots" 
   (bots/about-bots)))

(defn lizzie []
  (common/layout
   "Play Lizzie"
   (bots/play-lizzie)))

(defn postgresql-bad-apples []
  (common/layout
   "Upsert; A Few Bad Apples"
   (pg-apple/article)))

(defn postgresql-cte []
  (common/layout
   "Insert / Update CTEs"
   (iucte/article)))

(defn postgresql-resources []
  (common/layout
   "PostgreSQL Resources"
   (pg-resources/article)))

(defn on-postgresql []
  (common/layout
   "On PostgreSQL"
   (pg-apple/blank)))

(defn book-reviews []
  (common/layout
   "Book Reviews"
   (pg-apple/blank)))

(defn book-reviews-sicp []
  (common/layout
   "SICP"
   (books-sicp/article)))

(defn quitting []
  (common/layout
   "quitting"
   (quitting/article)))

(defroutes book-reviews-routes
  (GET "/sicp" [] (book-reviews-sicp)))

(defroutes music-theory-routes 
  (GET "/circle-of-fifths-part-one" [] (cof-one))
  (GET "/circle-of-fifths-part-two" [] (cof-two))
  (GET "/chords-part-one" [] (chord-one))
  (GET "/music-reading-part-one-key-signatures" [] (keysig))
  (GET "/resources" [] (music-theory-resources)))

(defroutes bot-routes
  (GET "/play-lizzie" [] (lizzie)))

(defroutes postgresql-routes
  (GET "/upsert-bad-apples" [] (postgresql-bad-apples))
  (GET "/insert-update-cte" [] (postgresql-cte))
  (GET "/resources" [] (postgresql-resources)))

(defroutes app-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about))
  (GET "/contact" [] (contact))
  (GET "/quitting" [] (quitting))
  (GET "/music-theory" [] (music-theory))
  (context "/music-theory" [] music-theory-routes)

  (GET "/circle-of-fifths-part-one" [] (cof-redirect))

  (GET "/on-postgresql" [] (on-postgresql))
  (context "/on-postgresql" [] postgresql-routes)

  (GET "/book-reviews" [] (book-reviews))
  (context "/book-reviews" [] book-reviews-routes)

  (GET "/poker-bots" [] (poker-bots-main))
  (context "/poker-bots" [] bot-routes)

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn start [port]
  (run-jetty app {:port port :join? false}))

(defn -main []
  ;; (let [port (Integer/parseInt 
  ;;             (or (System/getenv "PORT")
                  ;;"8080"))]
    (start 2222));;)

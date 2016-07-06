(ns coderedux.articles
  (:use hiccup.element 
        hiccup.core))

(defn four-oh-four []
  [:article.large-9.columns
  [:p "I moved a few urls around to make navigation a little easier. Sorry if htis created an inconvenience:"
   [:ul
    [:li (link-to "/music-theory/circle-of-fifths-part-one" "Circle of Fifths: Part One") ]
    [:li (link-to "/music-theory/circle-of-fifths-part-two" "Circle of Fifths: Part Two")]
    [:li (link-to "/music-theory/resources" "Resources")]]]])

(defn music-theory-article-list []
  [:article.large-9.columns
  [:h2 "Music Theory for (non)Musicians and (non)Programmers"]
  [:ul
   [:li (link-to "/music-theory/circle-of-fifths-part-one" "Circle of Fifths: Part One") ]
   [:li (link-to "/music-theory/circle-of-fifths-part-two" "Circle of Fifths: Part Two")]
   [:li (link-to "/music-theory/resources" "Resources")]]])

(defn on-clojure []
  [:article
  [:h1 "On Clojure / Articles"]
  [:h2 (link-to "/on-clojure/building-dynamic-form-in-clojure") "Building Dynamic Form Pages in Clojure"]])
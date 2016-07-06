(ns coderedux.common
  (:use hiccup.page
        hiccup.element
        hiccup.core))

(defn google-analytics []
  (javascript-tag "

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36565273-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();"))

(defn create-side-nav []
  [:nav.medium-3.columns
   [:h3 "Music Theory:"]
   [:ul
    [:li (link-to "/music-theory/circle-of-fifths-part-one" "Circle of Fifths: Part One") ]
    [:li (link-to "/music-theory/circle-of-fifths-part-two" "Circle of Fifths: Part Two")]
    [:li (link-to "/music-theory/chords-part-one" "Building Chords: Part One")]
    [:li (link-to "/music-theory/resources" "Resources")]]

   [:h3 "Poker Bots"]
   [:ul
    [:li (link-to "/poker-bots/play-lizzie" "Lizzie | Limit Hold'em")]]

   [:h3 "On PostgreSQL"]
   [:ul
    [:li (link-to "/on-postgresql/upsert-bad-apples" "On Upsert; A Few Bad Apples")]
    [:li (link-to "/on-postgresql/insert-update-cte" "My Favorite PostgreSQL Feature: Insert / Update CTEs")]
    [:li (link-to "/on-postgresql/resources" "Resources")]]

   [:h3 "Book Reviews"]
   [:ul
    [:li (link-to "/book-reviews/sicp" "Structure & Interpretation of Computer Programs") ]]])

(defn top-stuff []
  [:div.large
   [:div.row.medium-12.columns
    [:h1 (link-to "/" "{:Code Redux}")]
    [:div#topNav.column
     (link-to "/" "Home")
     (link-to "/about" "About")
     (link-to "/contact" "Contact")]]])

;; (defn layout [title & content]
;;   (html5
;;    [:head
;;     [:title "{:Code Redux} | " title]
;;     (include-css "/css/foundation.min.css")
;;     (include-css "/css/main.css")
;;     (include-css "/css/bots.css")
;;     (google-analytics)]
;;    [:body
;;     [:section.main
;;      (top-stuff)
;;      [:div.row
;;       (create-side-nav)
;;       content]]]))

(defn layout [title & content]
  (html5
   [:head
    [:title "{:Code Redux} | " title]
    [:link
     {:href
      "http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css",
      :rel "stylesheet"}]
    [:script
     {:src "//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.2.0/highlight.min.js"}]
    (include-css "/css/main.css")
    (include-css "/css/bots.css")
    (google-analytics)]
   [:body
    (top-stuff)
    [:div.row
     (create-side-nav)
     [:div.medium-9.columns
      [:div.blog-post
       content]]]
    [:script "hljs.initHighlightingOnLoad();"]]))
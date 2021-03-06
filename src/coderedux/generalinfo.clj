(ns coderedux.generalinfo
  (:use hiccup.element 
        hiccup.core))

(defn about []
  [:article.large-9.columns
   [:p "{:Code Redux} is a programming blog written by David Toomey"]
   [:p "{:Code Redux} is written in Clojure although it is really a glorified HTML site with no database."]

   [:p  [:b "Who is David?"]]
   [:p.notes "I live in Austin, TX, silently working on my projects and working the open mic circuit when my guitar isn't sounding like a fog horn. Yes, I'm available for work."]

   [:p  [:b "Other Projects:"]]
   [:p.notes [:a {:href "https://itemhut.com/"} "ItemHut"] [:span " Open Source Inventory, CRM, Order Management System."]]
   [:p.notes [:a {:href "https://github.com/dt1"} "My github"] " -- You can find the code for limit heads up poker bots, Item Hut, and coderedux.com."]
   [:p  [:b "Can I use the code from the Music Theory Articles?"]]
   [:p.notes "Yes. The code is free to use as you please. If you really need a license, consider it under the WTFPL."]

   [:p  [:b "Can I create a guest article on {:Code Redux}?"]]
   [:p.notes "Yes, I would be happy to post articles on any programming topic or any topic that is related to the articles here, as long as it meets the quality standards found on this site."]

   [:p [:b "Advertise on {:Code Redux}:"]]
   [:p.notes "If you'd like to advertise on {:Code Redux}, feel free to contact me at dbtoomey@gmail.com"]])

(defn front-page []
  [:article
  [:h2 "Current Series:"]
  [:h3 "Music Theory for (non)Musicians and (non)Programmers"]
  [:p "In this series, we attempt to derive and encode all of music theory. The programming languages used are Python3 and Clojure."]
  [:h3 (link-to "music-theory/circle-of-fifths-part-one" "The Circle of Fifths, Part One")]
  [:p.notes "Derivation of the Major Keys found on the Circle of Fifths."]
  [:h3 (link-to "music-theory/circle-of-fifths-part-two" "The Circle of Fifths, Part Two")]
  [:p.notes "Derivation of the Minor Keys found on the Circle of Fifths."]
  [:h3 (link-to "music-theory/chords-part-one" "Building Chords, Part One")]
  [:p.notes "Introduction to building chords using the the Circle of Fifths"]
   [:h3 (link-to "music-theory/resources" "Extra Resources")]])
  

(defn contact []
  [:article
  [:p "I love reading feedback and ideas to improve this site. Please feel free to send me an email:"]
  [:p "Name: David Toomey"]
  [:p "Email: dbtoomey@gmail.com"]])

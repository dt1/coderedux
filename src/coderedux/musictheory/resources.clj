(ns coderedux.musictheory.resources
  (:use hiccup.element 
        hiccup.core))

(defn music-theory-resources []
  [:article.large-9.columns
   [:h2 "Music Theory Resources:"]
   [:p "A few resources those who study music or music theory may be interested in:"]
   
   [:p [:b "Knowledge:"]]
   [:p.notes [:a {:href "http://online-musical-scales.com/"}  "Online Musical Scales"]]
   [:p.notes "To learn more about tuning and how it may not follow the Circle of Fifths as one would expect, search \"meantone\" to find many excellent articles. I don't have any one particular article I like more than others. Just be prepared for some fairly technical articles. "]
   [:p [:b "Programming:"]]
   [:p.notes [:a {:href "http://skillsmatter.com/podcast/home/functional-composition"} "Chris Ford presents \"Function Composition\" using Clojure. "]]
   
   [:p [:b "Entertaining / Thought-Provoking:"]]
   [:p.notes [:a {:href "http://www.everythingisaremix.info/watch-the-series/"} "Everything is a Remix"]]
   [:p.notes [:a {:href "http://www.youtube.com/watch?v=JdxkVQy7QLM"} "Rob Paravonian's Rant Against Pachabel"]]
   [:p.notes [:a {:href "http://www.ted.com/talks/benjamin_zander_on_music_and_passion.html"} "Benjamin Zander: The Transformative Power of Classical Music"]]

   [:p [:b "Books:"]]
   [:p.notes [:a {:href "http://amzn.to/29gd5xW"} "The AB Guide to Music Theory Vol 1 by Eric Taylor"]]
   [:p.notes [:a {:href "http://amzn.to/29vyXLe"} "The AB Guide to Music Theory Vol 2 by Eric Taylor"]]
   [:p.notes [:a {:href "http://amzn.to/29gdArH"} "Solo Guitar Playing - Book 1, 4th Edition by Frederick Noad"] " (Not exactly music theory, 
but it is the best book on learning guitar notation that I'm aware of)"]
   [:p.notes [:a {:href "http://amzn.to/29sTbUy"} "Piano Playing: With Piano Questions Answered by Josef Hoffman"]]])
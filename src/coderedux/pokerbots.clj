(ns coderedux.pokerbots
  (:use hiccup.core 
        hiccup.page))

(defn about-bots []
  [:article
   [:h2 "Lizzie"]])

(defn play-lizzie []
  [:article.large-9.columns
   [:div.poka
  (include-js "/js/lizzie.js")
    [:img {:src "/img/lizzie.png" :class "lizzie"}]

    [:div.table
     [:div.bot-info
      [:div#bot-cards]
      [:div "Lizzie"]
      [:div#bot-stack]
      [:div#bot-action]
      [:div#bot-bet]]

     [:div#bot-button]
     [:div#street]
     [:div#cards]
     [:div#pot.pot]]
    
    [:div#player-button]
    [:div.hero-info
     [:div "Hero"]
     [:div#player-cards]
     [:div#player-stack]
     [:div#player-bet]
     [:div#button-field]
     [:div#player-action]]

    [:div#dealer-talk]]])



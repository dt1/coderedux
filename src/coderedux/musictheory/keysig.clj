(ns coderedux.musictheory.keysig
  (:use hiccup.element 
        hiccup.core))

(defn keysig []
  [:article.large-9.columns
   [:h5 "Music Theory for (Non)Musicians and (Non)Programmers"]

   [:h3 "Music Reading (part 1): Key Signatures"]

   [:p "To make sense of the Circle of Fifths and how it relates to music in general, this article is going to more visual and there will be no code. It is important, though, to understand the basics of notation before getting into the further topics."]

   [:p.notes [:b "The G Clef, or, Treble Clef"]]

   (image "/img/keysig/gclef.png")

   [:p "The G Clef is called the \"G Clef\" because the circular part wraps around the line that denotes the note \"G.\" "]

   (image "/img/keysig/gclef-gnote.png")

   [:p "With that knowledge, we can figure out the rest of the notes:"]

   (image "/img/keysig/gclef-allnotes.png")

   [:p "In music notation, this the note B:"]

   (image "/img/keysig/bnote.png")

   [:p "When we add an accidental, or, \"sharp sign\" (#) in this case, we sharpen a note. This is F#:"]
   
   (image "/img/keysig/fsharp.png")

   [:p "Examine this passage. The notes are D, E, F#, D, E, F#."]

   (image "/img/keysig/silly-passage.png")

   ])
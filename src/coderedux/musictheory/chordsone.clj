(ns coderedux.musictheory.chordsone
  (:use hiccup.element 
        hiccup.core))

(defn chords-part-one []
  [:article.large-9.columns
   [:h5 "Music Theory for (Non)Musicians and (Non)Programmers"]

  [:h3 "Building Chords, Part One"]

  [:p "In Circle of Fifths, Part Two, I made the argument that the Circle is a good starting point in understanding how chords are created and structured. This part will serve as a brief overview of how this can be done. Unfortunately, I can't show the real beauty of chords without getting into how to read music notation. I'll begin covering this in the next section, so this section will serve as a launching pad for further ideas."]

  [:p "Colloquially, when a guitarist or pianist speaks about playing chords, she may say say: “The chords for his song is G, C, D Minor.” This isn't a good enough description for us, so I have to introduce some terminology:"]

  [:p.notes [:b "Chords: "] "Playing 3 or more notes in unison (at the same time). I'm going to be a tad bit more sloppy with this definition and use “chord” when I'm describing the action of playing 2 or more notes in unison, but keep in mind that if you search for the definition, you'll see some definitions specify three or more, or you'll see definitions that say \"generally, 3 or more.\" "]

  [:p "As you can see, the colloquial version of “chord” could raise some ambiguity. In general, when musicians say “The chords for his song is G, C, D Minor,” they are referring to a specific kind of chord called a triad. According to Wikipedia:"]

  [:p.notes [:b "Triad: "] "A three-note chord that can be stacked in thirds."] 

  [:p "That is an incredibly concise – and perfect – definition, but it may not be useful without defining a \"third.\" "]

  [:p "Let's begin by examining the C Scale:"] 

  [:p.notes "C D E F G A B"]

  [:p "The root of the C scale is C. And the third of C is E. The third of E is G:"]

  [:pre.notes
   "
C D E F G A B
1   3   5"]
  
  [:p "So, a triad is 3rd stacked on top of a third stacked on top of the root. It is much easier to think of this as a \"root\" (or 1st ) with a 3rd and a 5th piled on top. In the case of the C triad: C (1st), E (3rd), G (5th). This illustration of the C Major Chord expresses the concept of \"stacking thirds\" more than my words can describe:"]

  (image "/img/cMajorChord.png")

  [:p "So, lets look at a few more easy examples. Suppose we want to know what notes are in the D Major triad."]

  [:p.notes "First, we look towards the Circle of Fifths and see the keys that it provides:"]

  [:p.notes "We pull up D Major:"]

  [:p.notes "And we find the 1st, 3rd, and 5th:"]

  [:pre.notes "
D E F# G A B C#
1   3    5
"]
  

  [:p "So the D Major triad is: D F# A"]

  [:p "If you read Circle of Fifths Parts One and Two, this code shouldn't be any mystery to you. For those who have not read those articles, the following code generates the keys and scales along the Circle of Fifths. There are a few keys, such as Cb Major, that are not defined along the Circle, so we are tossing back None for those keys."]

  (link-to "#moreChords" "Skip the Scary Code")

  [:p "For those who have followed along, this is basically the same code found in Part Two, except cleaned up a bit: "]


  [:p "After building up code that can output the values of the Circle of Fifths, we can now use this code as a nice abstraction tool for generating chords and scales."]

  [:pre.notes "SHARP_NOTES = ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B']
FLAT_NOTES = ['C', 'Db', 'D', 'Eb', 'E', 'F', 'Gb', 'G', 'Ab', 'A', 'Bb', 'B']
MAJOR_STEPS = [2, 2, 1, 2, 2, 2, 1]
MINOR_STEPS = [2, 1, 2, 2, 1, 2, 2]
 
def letterShift(notes, letter):
        pos = notes.index(letter)
        return notes[pos:] + notes[:pos]

def major():
        return MAJOR_STEPS

def minor():
        return MINOR_STEPS

def litmus(notes):
        newStr = ''
        for i in notes:
                newStr += i.replace('#', '')
        return len(set(notes)) == len(set(newStr))

def createList(seedList, key):
        indice = 0
        returnList = []
        for i in key:
                returnList.append(seedList[indice])
                indice += i
        return returnList

def toFlat(seedList):
        returnList = seedList 
        toFlats = [('Ab', 'G#'), ('Bb', 'A#'), ('Cb','B#'), 
                   ('Db','C#'), ('Eb', 'D#'), ('Gb', 'F#')]
        for i in toFlats:
                 returnList = [i[0] if note==i[1] else note for note in returnList]
        return returnList

def toFlatOrSharp(seedList):
        returnList = ['E#' if note=='F' else note for note in seedList] 
        returnList = ['B#' if note=='C' else note for note in returnList]
        return returnList

def makeKey(letter, key):
        if letter not in SHARP_NOTES and letter not in FLAT_NOTES:
                return None
        if 'b' not in letter:
                returnList = createList(letterShift(SHARP_NOTES, letter), key)
        else: 
                returnList = createList(letterShift(FLAT_NOTES, letter), key)
        if litmus(returnList) == False:
                returnList = toFlatOrSharp(returnList)
        if litmus(returnList) == True:
                return returnList
        if key == major():
                return toFlat(createList(letterShift(SHARP_NOTES, letter), key))
        if key == minor():
                return toFlat(createList(letterShift(SHARP_NOTES, letter), key))
"]

  [:p "And here is the code that will let us create a triad:"]

  [:pre.notes "def triad(letter, key):
        chord = makeKey(letter, key)
        if chord == None:
                return 'Sorry, {0} does not have a key.'.format(letter)
        returnList = []
        for i in range(0, 5, 2):
                returnList.append(chord[i])
        return returnList"] 

  [:p "And you call it like so: "]
  
  [:pre.notes ">>> triad('C#', minor())
['C#', 'E', 'G#']

>>> triad('Cb', major())
'Sorry, Cb does not have a key.'
"]


[:h3 [:a {:name "moreChords"} ""]  "Sevenths and Ninths"]

[:p.notes [:b "Quick Note to the non-programmers: "] "From this point forward, there will be some code snippets mixed in with the writing. They are all very short, so they shouldn't be too distracting. "]

[:p "With the definition of triad out of the way, we can examine some more basic chords. Let's look at the 7th Chords now. In general, you may see the chord writing as C7, which is \"C Major Seventh,\" or Cm7, which is  \"C Minor 7th.\" "]

[:p "Going back to the C major key, we stack another third on top of the fifth, or simply count to 7: "] 

[:pre.notes "
C D E F G A B
1   3   5   7"]

[:p "And visually, the chords are neatly stacked in the notation:"]

(image "/img/cMajorSevenChord.png")

[:hr]

[:p.notes [:b "Code:"] "Here's some code for the Seventh Chords:" ]



[:pre.notes "
def seventh(letter, key):
        chord = makeKey(letter, key)
        returnList = []
        for i in range(0, 7, 2):
                returnList.append(chord[i])
        return returnList"]
[:hr]
[:p "And then we can look at the 9ths, which are derived in a similar fashion, except that we technically can't count to 9 since there are only 7 notes. We can just repeat the notes and count to 9:"] 

[:pre.notes "
C D E F G A B C D E F G A B
1   3   5   7   9"]

[:hr]

[:p.notes [:b "Code:"] "Here's some code for the Ninth Chords:" ]


[:pre.notes "
def ninth(letter, key):
        chord = makeKey(letter, key)
        chord *= 2
        returnList = []
        for i in range(0, 9, 2):
                returnList.append(chord[i])
        return returnList"]

[:hr]

[:p "I'm going to stop here. You could continue this process and create 11ths and 13ths if you feel inclined, but I'd rather touch on this stuff later, stray away from Jazz, and head over AC/DC Land. "]

[:h3 "Power Chords"]

[:p "Anyone who listens to Rock 'n Roll either knows the power chord by name or knows the power chord by their gut. By the strict definition that a chord must be 3 or more notes, a power chord is considered by some to not be a chord, but rather a dyad."]

[:p.notes [:b "Dyad: "] "Playing 2 notes in unison. There are other terms that can be used to describe a dyad, which I'll leave up to your research. I kind of like this word, so I'll use it."] 

[:p "In general, a power chord is called a \"fifth,\", such as \"C Fifth\" or written as C5. The other common power chord is the \"third,\" commonly written as C3."] 

[:p "C5 is distinct because it is NOT a stack of thirds. It is commonly derived as such:"] 

[:pre.notes "
C D E F G A B
1       5 "
 ] 


[:p "C5 is often appended with the root again, so musicians may either play C5 as CG or CGC."]

[:p "C3 follows a similar convention: A C3 is CE."] 

[:hr]



[:p.notes [:b "Code: "] "This is some code for the fifths:"]

[:pre.notes "
def third(letter, key):
        chord = makeKey(letter, key)
        returnList = []
        for i in range(0, 3, 2):
                returnList.append(chord[i])
        return returnList"]


[:p.notes [:b "Code: "] "This is some code for the fifths:"]

[:pre.notes "
def fifth(letter, key):
        chord = makeKey(letter, key)
        print(chord)
        returnList = []
        returnList.append(chord[0])
        returnList.append(chord[4])
        return returnList"]
[:hr] 

[:h3 "Final Thoughts"] 

[:p "That completes our whirlwind tour of building chords. There are many other kinds of chords we'll get into after I touch on reading staff notation, but this should present the basic building blocks you'd need to create many of your own chords. Remember to return to the Circle of Fifths for guidance on creating  chords."]])
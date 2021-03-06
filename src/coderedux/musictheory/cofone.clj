(ns coderedux.musictheory.cofone
  (:use hiccup.element 
        hiccup.core))

(defn circle-of-fifths-part-one []
  [:article.large-9.columns
   [:h5 "Music Theory for (Non)Musicians and (Non)Programmers"]

   [:h3 "The Circle of Fifths, Part One"]

   [:p [:b "Introduction: "] "The goal of this series to learn how to derive and encode all of music theory. While this is partly a programmer-centric series, you don't have to understand a single line of code to understand what is happening here."]
   
   [:p.notes [:b "About the Code: "] "The code is written in Python, but anyone
who can program should be able to get the idea of what is happening.
For the Pythonistas reading this: I'm not attempting to get a Turing
Award or win points for elegance. I'm only looking for simplicity and
easy to understand."]
   
   [:p "Before we get started, we have to make sure we have a few terms straight:"]

   [:p.notes [:b "Note: "] "A note is a single letter that represents a sound. If I play a C note, I am  playing one individual note. This definition will be expanded on in later articles, but for right now, just consider a note one single sound. You may have been exposed to basic singing lessons in grade school choir. A note would be singing \"Doe\" and stopping there."]

   [:p.notes [:b "Scale: "] "A scale is a group of notes. Going back to the grade school choir example, a scale would be singing the entire Solf&#232;ge: \"Do, Re, Mi, Fa, Sol, La, Ti, Do\""]

   [:p.notes [:b "Keys: "] "I use the word 'Keys' often in this article. For the purpose of this article 'keys' is interchangeable with 'scales.' It is useful to get used to both words. We'll distinguish the meanings in a later article."]

   [:h2 "Deriving The Circle of Fifths: The Major Keys"]

   [:p "Many  books or lessons begin by starting with the Circle of Fifths. The Circle of Fifths is important because it represents the very foundation of many ideas in music theory, but nearly without fail, the missing exercise is the derivation of the Circle. How would anyone be able to learn the power of the Circle if she doesn't know how to derive it? I believe the answer to this question is \"she cannot\" and I think you will agree with me by the time you are finished reading this article."]

   [:p "In this article, I will show you how to derive the major scales of the Circle of Fifths. I won't do the minor scales today because this article will be too long and I don't want anyone begging for TL;DR, which I refuse to do. The next article will derive the minor keys. However, if you work through this article, you'll probably be able to derive the minor keys yourself."]

   [:h3 "Postulates"]

   [:p "For those who have worked through high school geometry, you'll remember that there were a few postulates created by Euclid which were used to derive all of Euclidean Geometry. For those who don't know or remember what a postulate is:"
    [:dl
     [:dt [:b "Postulate"]]
     [:dd "&sect; to assume or claim as true, existent, or necessary"]
     [:dd "&sect; depend upon or start from the postulate of"]
     [:dd "&sect; to assume as a postulate or axiom (as in logic or mathematics)" ]]
    "In order to begin the derivation of the Circle of Fifths, and all of music theory, some things have to be taken for granted as true."]

   [:p.notes [:b "Note: "] "I am being a tad irresponsible by stating we are deriving all of music theory. To be clear, our focus is strictly on modern Western music. The history of our current theory is fascinating and I'll get into this in another article. If you're so inclined, you can research this yourself."]

   [:p "Let's start by creating the postulates ourselves. Here is a picture of a few piano keys with their names: "]

   (image "/img/pianoWithFlats.png")

   [:p "I'm using a piano because it is the easiest illustration of the layout of the notes. For those who are not pianists, fear not. I'm a guitarist and I can't even play \"Mary Had a Little Lamb\" on the piano."]

   [:p "If you look at the black keys, you'll see that each of them have two names: sharps and flats. The notes go in ascending order from C to B, then start over again. If you were to extend the piano to its full 88 keys, the pattern would repeat itself. Each sharp note is to the right of the natural note, and each flat note is to the left of the natural note. Right now, we don't need the flat notes. We'll come back to them later, I promise, but to make the first step of the project as easy as possible, we'll remove the flat notes:"]

   (image "/img/pianoWithNoFlats.png")

   [:p "Let me point out another interesting thing before continuing on. Take note how the C note is always to the left of two black keys, and the F is to the left of three black keys. This pattern will allow us to generalize the patterns needed to create the Circle of Fifths."]

   [:p.notes [:b "Postulate Number One: "] "The key of C Major is all the white keys of the piano."]

   [:p "I started the piano on the C note. This is not an accident or random decision. The Key of C Major is the foundation of music theory because it is the easiest to play, the easiest to see, and it reveals a pattern that allows the next  postulate to make sense."]

   [:p.notes [:b "Postulate Number Two: "] "If there is a black key between two neighboring natural notes, the distance between the natural notes is one Step. If there is no black key between two neighboring  natural notes, the distance between the natural notes is one Half Step."]

   [:p "Lets refer back to the piano. If we consider the notes in the key of C Major, we'll see that the Half Step only exists between B &amp; C and E &amp; F. The distance between all of the other keys is One Step. We can use this fact to understand the next postulate:"]

   [:p.notes [:b "Postulate Number Three: "] "The pattern of the C Major scale can be used to derive " [:i "all "] "of the major scales."]

   [:p "The pattern starts at C and ends at C, giving us Step - Step - Half Step - Step - Step - Step - Half Step:"]

   (image "/img/keyPattern.png")

   [:h3 "Generating the Major Keys"]

   [:p [:b "Step One: "] "With our postulates in place, we can begin generating the major keys. Start by grabbing a sheet of paper. It would probably help to use a lined sheet of paper and writing on it sideways so you can keep the notes lined up."]

   [:p [:b "Step Two: "] "On the top of the paper, write the pattern we established: S, S, H, S, S, S, H"]

   [:p [:b "Step Three: "] "Under the pattern, write all of the notes, starting at C, two times: C C# D D# E F F#  G G# A A# B C C# D D# E F F# G G# A A# B C"]

   [:p [:b "Step Four: "] "Down the left, side, write all the notes, starting at C, and ending at B."]

   [:p [:b "Step Five: "] "Create one extra column called \"Sharps\""]

   [:p "To get you started, you should have something that looks like this, but I'll leave you to complete the grid:"]

   (image "/img/cof1step5.png")
   
   [:p [:b "Step Six: "] "Following the pattern, write the generated keys. This should get you started:"]

      (image "/img/cof1step6.png")

   [:p "Now we're going to do a bit of programming. If you are a non-programmer: " (link-to "#analyzing" "Skip the Scary Code") " If you are a programmer, I would strongly suggest doing the pencil-and-paper work before diving into the code. There is something revealing about this process and it's important you pay attention."]


   [:h2 "Coding the Major Scales, Part One"]

   [:p "So far, we have the natural and sharp notes along with a simple algorithm we'd like to use to generate the sharp notes found in the keys along with the count of the sharp notes in each key."]

   [:p "I'm using Python 3.x. I'm going to start by creating a list of notes and make it a global variable:"]

   [:code "SHARP_NOTES = ['c', 'c#', 'd', 'd#', 'e', 'f', 'f#', 'g', 'g#', 'a', 'a#', 'b']
"]

   [:p "We want to create a way to generate the keys as we need them, so let's begin by creating a function that will allow us to test the key of C and create the rest of the keys. In order to prevent out-of-index errors, we need a function to shift the letters. letterShift takes SHARP_NOTES and \"rotates\" them:"]
   [:pre.notes "
SHARP_NOTES = ['c', 'c#', 'd', 'd#', 'e', 'f', 'f#', 'g', 'g#', 'a', 'a#', 'b']

def letterShift(note):
        pos = SHARP_NOTES.index(note)
        return SHARP_NOTES[pos:] + SHARP_NOTES[:pos]

def majorAlgo(note):
    seedList  = letterShift(note)
    newList = []
    newString = ''
    for i in range(0, 5, 2):
        newList.append(seedList[i])
    for i in range(5, 12, 2):
        newList.append(seedList [i])
    for i in newList:
        newString += i + ' ' 
    return newString"]

   [:p "Now we can call majorAlgo with individual note calls and generate each key:"]

   [:pre.notes "
>>> majorAlgo('c')
'c d e f g a b '
>>> majorAlgo('d')
'd e f# g a b c# '
>>> majorAlgo('e')
'e f# g# a b c# d# '"]

   [:p "But we still have to type in each note and manually count all the sharps. That sounds boring, so let's have the computer do it instead:"]

   [:pre.notes [:code "
SHARP_NOTES = ['c', 'c#', 'd', 'd#', 'e', 'f', 'f#', 'g', 'g#', 'a', 'a#', 'b']

def letterShift(note):
        pos = SHARP_NOTES.index(note)
        return SHARP_NOTES[pos:] + SHARP_NOTES[:pos]


def majorAlgo(note):
    seedList  = letterShift(note)
    newList = []
    newString = ''
    for i in range(0, 5, 2):
        newList.append(seedList[i])
    for i in range(5, 12, 2):
        newList.append(seedList [i])
    for i in newList:
        newString += i + ' ' 
    return newString

for notes in SHARP_NOTES:
    print (notes + ':\t ' + majorAlgo(notes) + '\t' +  str(majorAlgo(notes).count('#')))
"]]

   [:p "For some reason, the tab-stops are showing up as large gaps. In my program, I am using the tab escape character. Regardless, here is the output:
"]
   [:pre.notes "
 c:	 c d e f g a b   	0
c#:	 c# d# f f# g# a# c 	5
d:	 d e f# g a b c# 	2
d#:	 d# f g g# a# c d 	3
e:	 e f# g# a b c# d# 	4
f:	 f g a a# c d e 	1
f#:	 f# g# a# b c# d# f 	5
g:	 g a b c d e f# 	1
g#:	 g# a# c c# d# f g 	4
a:	 a b c# d e f# g# 	3
a#:	 a# c d d# f g a 	2
b:	 b c# d# e f# g# a# 	5
"]

   [:h3 [:a {:name "analyzing"} ""]  "Analyzing the Generated Keys"]

   [:p "If you wrote out the major keys, you may have began to notice some strange things happening, and if something didn't feel right, that is perfectly okay for now. Don't worry, something isn't supposed to feel right, and we'll get to fixing that in a minute. But first, let's take a look at the output generated by the program I wrote. Please compare what you have and be sure you ended up with the same answers. If you did not, try to see where your mistake(s) are and figure out what may have went wrong. It is easy to make mistakes writing mistakes in this. When I did this the first time, I ended up with crossed out lines, letters out of order, and missing keys. So, if you made a mistake, don't feel bad. I promise that this exercise is worth the effort."]

   [:p "The output:"]
   [:pre.notes "
c:	 c d e f g a b  	0
c#:	 c# d# f f# g# a# c 	5
d:	 d e f# g a b c# 	2
d#:	 d# f g g# a# c d 	3
e:	 e f# g# a b c# d# 	4
f:	 f g a a# c d e 	1
f#:	 f# g# a# b c# d# f 	5
g:	 g a b c d e f# 	1
g#:	 g# a# c c# d# f g 	4
a:	 a b c# d e f# g# 	3
a#:	 a# c d d# f g a 	2
b:	 b c# d# e f# g# a# 	5
"]

   [:p "The first thing I notice is that C is the only key that has 0 sharps. So, I'll write that at the top of the Circle of Fifths:"]

   (image "/img/cCircle.png")

   [:p "Now I have a question and you may have been thinking this too: " [:i "Shouldn't all of the notes show up in each key?"]]

   [:p "Look at the key of G#: " [:i "g# a# c c# d# f g"] ". Why does it have C and C# in there? This isn't supposed to happen, and we'll have to be clever in a moment, but for right now, let's look at the keys that turned out as expected and put them into numerical order:"]

   [:pre.notes "
c:	 c d e f g a b  	0
g:	 g a b c d e f# 	1
d:	 d e f# g a b c# 	2
a:	 a b c# d e f# g# 	3
e:	 e f# g# a b c# d# 	4
b:	 b c# d# e f# g# a# 	5"]

   [:p "G comes up first with one sharp: F#"]
   [:p "D comes up second with two sharps: F#, C#"]
   [:p "A comes up third with three sharps: F#, C#, G#"]

   [:p.notes [:b "A pattern emerges:"]]
   [:ol.notes
    [:li "With each new key, one extra sharp is added, as expected"]
    [:li "The sharps from the previous key is maintained"]
    [:li "The new sharp is one Half Step below the letter of the new key."]]

   [:p "With the pattern emerging, we don't even have to look at the key of E to know that it will turn out to be F#, C#, G#, D#. This pattern will continue on. The wonderful thing here is that once you understand the Circle of Fifths, at least to this point, you can see how it becomes an excellent memorization tool. By using nothing more than a pencil and paper, a bit of math, and not knowing how to read music at all, the Circle of Fifths has already generated the first 6 notes."]

[:p "The Fifth Note of the C Major Scale is indeed G, the Fifth Note of the  G Major Scale is D, the Fifth Note of D Major is A. This pattern will continue all around the Circle of Fifths."]

   (image "/img/bCircle.png")

   [:p "Now we're almost half done. With C, G, D, A, E, B out of the way, let's see what's left:"]

   [:pre.notes "
c#:	 c# d# f f# g# a# c 	5
d#:	 d# f g g# a# c d 	3
f:	 f g a a# c d e 	1
f#:	 f# g# a# b c# d# f 	5
g#:	 g# a# c c# d# f g 	4
a#:	 a# c d d# f g a 	2"]

   [:p "Now we have to do a little bit of thinking and look at the situation. We know that B has 5 sharps, and we have counted from 0 sharps. This means that we would want to find a key with 6 sharps now. If we look at the numbers, we can see that there are no contenders... or is there?"]

   [:p.notes [:b "Q: "] "Is it possible to 'add' sharps to any of these keys? Is it possible to automagically convert some of these notes without breaking the integrity of the keys?"]
   [:p.notes [:b "A: "] "Yes, if we consider the idea that the integrity of these keys are already broken, then we can now ask if it is possible to 'fix' the keys that are left."]

   [:p "Then let's do it:"]

   [:p "Chew on this fact for a moment: There is nothing in Music Theory that states neighboring notes separated by Half Steps can't be sharpened or flattened. This means that E can actually become E#, effectively becoming F. B can also become B#, effectively becoming C. This can happen despite the fact that there is no key on the piano explicitly representing B# or E#. The only goal is to be sure that each key reads A B C D E F G."]

   [:p "With the above knowledge,  we can add one or two sharps to the scales to find scales that have 6 and 7 sharps. There are only two keys where this is possible, since they both have 5 sharps listed: C# and F#. So, let's see what happens:"]

   [:p.notes [:b "C# is C# D# F F# G# A# C. "] "If we convert the extra C to B# (we can't change C# because the Key of C# must have C# somewhere in it), we end up with C# D# E# F# G# A# B# for a total of 7 sharps."]
   [:p.notes [:b "F# is F# G# A# B C# D# F "] "We do have an extra F, so why not turn that into E#, which gives us F# G# A# B C# D# E# for a total of 6 sharps."]

   [:p "And notice now how all of the patterns we've seen so far have been maintained. One sharp has been added, each key keeps all the sharps from the previous keys, and the new sharp is one note below the new key's named note. And yes, the fifth of B is F# and the fifth of F# is C#."]

   [:p "Let's see our progress:"]

   (image "/img/majorCircle.png")

   [:p "Let's see what we have left:"]
   [:pre.notes "
d#:	 d# f g g# a# c d 	3
f:	 f g a a# c d e 	1
g#:	 g# a# c c# d# f g 	4
a#:	 a# c d d# f g a 	2"]

   [:p "If we look at what we have so far, we can see that the fifth of C is G. Is it possible that G# is the fifth of C# as well? To test this theory, why not use the same technique we just used?"]

   [:p.notes [:b "G# is G# A# C C# D# F G"] " Let's go through this step-by-step:"]
   [:ol.notes
    [:li "G# A# B# C# D# F G: Looks good so far."]
    [:li "G# A# B# C# D# E# ???: Uh oh. What happened?"]]

   [:p "We're stuck. We can't create an F## note (for this purpose, bear with me), so what are we supposed to do? Remember those flats I told you not to worry about? Now may be a good time to worry about them. So let's look at the piano again:"]

   
   (image "/img/pianoWithFlats.png")

   [:p "What would happen if we decided to make all of these sharps flat so that we have instead of the Key of G# Major, we create  Ab Major? The new scale is: "  [:b "Ab Bb C Db Eb F G"] ". And lo and behold, our new Scale has all the letters with 4 flats."]

   [:p "The Circle of Fifths shows that the fifth Note of the A Major Scale is E. Perhaps the Fifth Note of Ab Major is Eb? To test this, we can look at D# and convert it to Eb so we end up with " [:b "Eb F G Ab Bb C D"] " which amazingly, has 3 flats."]

   [:p "We can now suspect that  Bb must be the fifth of Eb now, which it is. But what about F? Should it be converted to a flat as well? No! F still exists in the key of F even after converting A# to Bb, so the key of F Major has one flat in it. Now we have enough to make the  Circle of Fifths \"Full Circe\":"]

   
   (image "/img/almostCircle.png")

   [:p.notes [:b "A New Pattern: "] "Earlier, we learned that there was a distinct pattern of where the next sharp will be in the next Major key, but what about where the next flat appears? This is actually easier. The Key of F major gains Bb, which is right next to F in the Circle. Likewise, Bb keeps Bb and adds Eb, which, once again, is right next door to Bb in the Circle."]

   [:p "We're not quite done yet, but we can complete the Circle. We know the key of C# has 7 sharps. Shouldn't there be a key that has 7 flats? The Circle of Fifths is supposed to show the relationship between all scales and all the notes."]

   [:p "But we currently have 12 notes and 12 scales, which suggests we are done. Despite this fact, there are still some relationships we'd like to show. We have yet to discover the Flat Scales with 5, 6, and 7 flats. Fortunately, this part is easily done with a bit of common sense. We know that Ab has 4 flats, so perhaps to the right of it, there is room for a key with 5 flats. C# is already occupying that spot, right? Yes it is, but we know from our prior exercises that C# is equivalent to Db. We can also look at A Major on the right side of the circle and see that D Major sits next to it, so there are two pieces of evidence that lets us know that Db should sit next to Ab. It turns out that Db does in fact have 5 flats. We can also do the same process for Gb, which shares a spot with F#, and Cb, which shares a Spot with B:
 "]
   (image "/img/completeMajorCircle.png")])
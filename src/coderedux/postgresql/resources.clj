(ns coderedux.postgresql.resources
  (:use hiccup.element 
        hiccup.core))

(defn article []
  [:article.large-9.columns
   [:h3 "PostgreSQL and SQL Resources"]
   
   [:h4 "Books:"]
   [:hr]
   [:h5 "PostgreSQL Server Programming"]
   [:p [:a {:href "http://amzn.to/25ajjbn"} "Buy PostgreSQL Server Programming"]]
  [:p "A good primer on working with PL/pgSQL, \"untrusted languages\", and C. Though I disagree with many parts of it, I do think it covers a decent amount of material and it is well-presented."]

   [:hr]

   [:h5 "PostgreSQL 9.0 High Performance"]
   [:p [:a {:href "http://amzn.to/1R9KYjj"} "Buy PostgreSQL 9.0 High Performance"]]

   [:p "A little dated but full of valuable information. The best \"explaining explain\" you will find anywhere, which makes this book worth the price alone."]

   [:hr]

   [:h5 "SQL Antipatterns"]
   [:p [:a {:href "http://amzn.to/1VlAGld"} "Buy SQL Antipatterns"]]

   [:p "A more thorough review of this book is coming down the pipeline. This book was the book that finally made me \"get\" SQL. I highly recommend this book to anyone looking to take their next step in SQL and database design thinking."]
   [:hr]

   [:h5 "7 Databases in 7 Weeks"]
   [:p [:a {:href "http://amzn.to/22pbqzV"} "Buy 7 Databases in 7 Weeks"]]

   [:p "The first chapter deals with PostgreSQL's text searching capabilities and other interesting topics. The other chapters cover Riak, HBase, MongoDB, CouchDB, Neo4j, and Redis, which is a good mix of technologies for comparison and contrast. There is a reason this book is so highly recommended: it is well-written, accurate, and full of interesting tidbits you may have difficulty finding elsewhere."]

   [:hr]
   [:h4 "Websites:"]

   [:p [:a {:href "http://postgresweekly.com/"} "Postgres Weekly"]]

   [:p "A newsletter that comes to your inbox every week. There is always going to be one or two articles worth reading."]])
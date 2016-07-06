(ns coderedux.postgresql.iucte
  (:use hiccup.element 
        hiccup.core))

(defn article []
  [:article.large-9.columns
   [:h3 "My Favorite PostgreSQL Feature:"]

   [:h3 "Insert / Update CTEs"]

   [:p "In general, I'm not a huge fan of using CTEs, but like all things SQL, measure, measure, measure before dismissing query approaches out of hand. This article isn't about CTE performance [1]; this article is about using a feature for CTEs I find powerful and convenient, with the goal of making my application as a whole faster and transaction-safe."]

   [:p "We are given this terrible schema design:"]

   [:pre.sql "create table fruits (
	fruit_id serial primary key,
	fruit_name varchar
);

create table fruit_prices (
	fruit_id int primary key,
	fruit_price numeric,
	foreign key (fruit_id)
	references fruits (fruit_id)
);

"]

   [:p "and now we would like to use code to update the price of an apple:"]

   [:pre.sql "import mydb as db

def update_fruit_price(ft, price):
    items = db.select_fruit_id(ft)
    ## returns [(1, 'apple'), (2, 'orange')]
    for f in fruits:
        if 'apple' == f[1]:
            db.set_new_fruit_price(f[0], price)
        
update_fruit_price('apple', .50)

"]

   [:p "There are two round-trips here, and as written, this is not transaction-safe. To make this one round-trip and make this transaction-safe, one approach is creating a temp table and doing an update."]

   [:pre.sql "create temp table fts as 
select fruit_id from fruits
where fruit_name = 'apple';

update fruit_prices
set fruit_price = .50
where fruit_id in (select fruit_id
		      from fts);

drop table fts;

"]

   [:p "Our system is making one round-trip and it is transaction-safe. Let's try this as a CTE:"]

   [:pre.sql "with fts (fruit_id)
	as (select fruit_id
	    from fruits
	    where fruit_name = 'apple')
update fruit_prices
set fruit_price = .50
where fruit_id = (select fruit_id
		     from fts);

"]

   [:p "That's the general idea of a CTE. For a more complex example, suppose we are adding in kiwi and setting the price to .25. For this, we can use an insert CTE:"]

   [:pre.sql "with fts (fruit_id) as
	(insert into fruits (fruit_name)
	 values ('kiwi')
	 returning fruit_id)
insert into fruit_prices (fruit_id, fruit_price)
select fruit_id, .25
from fts;

select *
from fruits
join fruit_prices
using (fruit_id);

>>>
1; apple ; 0.45
2; orange; 0.45
3; kiwi ;0.25

"]

   [:p "Suppose now we want to make apple and kiwi plural and we want to increase the price of apples and kiwis by .10. We can use an update CTE for this:"]

   [:pre.sql "with fts (fruit_id) as
	(update fruits
	 set fruit_name = fruit_name || 's'
	 where fruit_name in ('apple', 'kiwi')
	 returning fruit_id)
update fruit_prices
set fruit_price = fruit_price + .10
where fruit_id in (select fruit_id
		      from fts);

select *
from fruits
join fruit_prices
using (fruit_id);


>>>
2; orange; 0.45
1; apples; 0.55
3; kiwis; 0.35

"]

   [:p "CTEs look unusual and a bit intimidating at first, but once you get a handle on them, they quickly become powerful tools that reduce the work your entire system has to do. This is, at best, a surface-level treatment of update / insert CTEs. As always, read the docs [2]."]

   [:p "[1] " [:a {:href "http://blog.2ndquadrant.com/postgresql-ctes-are-optimization-fences/"} "PostgreSQL’s CTEs are optimisation fences"]]

      [:p "[2] " [:a {:href "http://www.postgresql.org/docs/current/static/queries-with.html"} "WITH Queries (Common Table Expressions)"]]])
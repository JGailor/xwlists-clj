# xwlists-clj

This is a port of the X-Wing Miniatures List Juggler site (http://lists.starwarsclubhouse.com/)
that is developed by @lhayhurst at https://github.com/lhayhurst/xwlists from the original
python/flask code to Clojure. This isn't meant to replace his original code base or site, it's
purely a side project for me to work on a web application using Clojure.

I use his site all the time for researching the current meta for X-Wing Miniatures.  It's a great
resource for anyone interested in the community or playing X-Wing.

This is also an effort at working with a somewhat bare-bones set of Clojure
libraries for building webapps instead of relying on a framework like Luminus.
That's not a knock across Luminus or frameworks but an attempt to work with
simpler tools and explore what patterns emerge.

## Getting Started
Clone the repository locally

```%> git clone ```

Add the appropriate configuration for your database

``` %> cd xwlists-clj```

``` %> cp resources/config.edn.example resources/config.edn```

Install the dependencies with Leiningen using

```%> lein deps```

Go get the database from List Juggler

```%> wget http://starwarsclubhouse.com/static/prod.sql```

Load the database locally, which wil be dependent on your chosen implementation.
@lhayhurst uses Mysql, so I went with that as well and used the execellent "Sequel Pro"
tool available on OS X to load the database.

Run the application

```%> lein run```

Open the site in your local browser ```http://localhost:8080/```

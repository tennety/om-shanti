(defproject shanti "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [org.clojure/clojurescript "0.0-2371"]
                 [om "0.8.0-beta2"]
                 [markdown-clj "0.9.58"]]
  :plugins [[lein-cljsbuild "1.0.3"]]
  :source-paths ["src/clj"]
  :cljsbuild
    {:builds
     {:dev
      {:source-paths ["src/cljs"],
       :compiler
       {:output-dir "resources/public/javascript",
        :output-to "resources/public/javascript/client-dev.js",
        :source-map "resources/public/javascript/client-dev.js.map"
        :optimizations :whitespace
        :preamble ["react/react.js"]
        :pretty-print true }}}})

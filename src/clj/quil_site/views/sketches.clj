(ns quil-site.views.sketches
  (:require [quil-site.views.page :refer [page]]
            [hiccup.page :as p]))

(defn sketch-page [id]
  (page {:tab :create
         :type :sketch
         :container-class "container-fluid"
         :title (str "Quil " id)
         :css-files ["/css/codemirror-5.12.css"
                     "/css/codemirror-5.12-lint.css"]
         :js-files ["/js/codemirror-5.12-clojure_lint_matchbrackets_closebrackets.js"
                    "/js/editor.js"]}

        [:div.btn-group
         [:button#send.btn.btn-primary "Run"]
         [:button#reset.btn "Reset"]
         [:button#hide.btn.disabled "Hide"]
         [:button#share.btn "Share"]]

        [:div#content
         [:div#source-content
          [:div
           [:textarea#source
            {:data-sketch-id id}]]]
         [:div#result-content
          {:style "width: 0px;"}
          [:iframe {:src "/iframe.html"
                    :width "0"
                    :height "0"}]]]))

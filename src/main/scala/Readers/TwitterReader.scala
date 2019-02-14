package Readers

import twitter4j.Query

object TwitterReader {

    def defineQuery(params:String*) : String={
        val queryLine = params.reduceLeft((x,y) => {"("+x+") OR ("+y+")"})
        return queryLine
    }

    def readStatuses(queryComponents: String*) = {

        val tf = Builders.TwitterBuilder.buildTwitterFactory
        val queryString = defineQuery(queryComponents:_*)
        val statuses = tf.getInstance().search(new Query(queryString)).getTweets
        println(statuses)

    }
}

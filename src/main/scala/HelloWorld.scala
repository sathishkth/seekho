import org.apache.spark.SparkContext
//sathish - git test 2nd time commit
object HelloWorld {

        def main(args: Array[String]): Unit = {
        val sc = new SparkContext("local[*]", "persistdemo");


        // Create RDD
        val rdd = sc.parallelize(1 to 10000000)

        // Calculate the sum of all elements in the RDD without persisting
        val sum1 = rdd.reduce(_ + _)
        println("Sum of RDD without persisting: " + sum1)

        // Calculate the sum of all elements in the RDD after persisting
        rdd.persist()
        val sum2 = rdd.reduce(_ + _)
        println("Sum of RDD with persisting: " + sum2)

        // Unpersist RDD from memory
        rdd.unpersist()

        scala.io.StdIn.readLine()
      }
}

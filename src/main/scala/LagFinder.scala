import kafka.admin.ConsumerGroupCommand.ConsumerGroupCommandOptions
import kafka.admin.ConsumerGroupCommand.KafkaConsumerGroupService
import scalaj.http._
import scala.util.parsing.json._
import com.typesafe.config.ConfigFactory

object LagFinder {
  def main(args: Array[String]): Unit = {
//    val baseConfig: Array[String] = Array("--bootstrap-server", "localhost:9092")
//    val hola = new KafkaConsumerGroupService(new ConsumerGroupCommandOptions(baseConfig))
//    val (state, assignments) = hola.describeGroup()
    //println(hola.describeGroup())
    val conf = ConfigFactory.load()
    //val
    val response: HttpResponse[String] = Http("http://localhost:8000/v2/kafka/local/consumer/my-group/status").asString
    println(response.body)
    val parsed = JSON.parseFull(response.body)
    val holaString: Boolean = parsed contains "error"
    println(holaString)

  }

}

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class Komonstro {
    val logger = LoggerFactory.getLogger(javaClass)

    fun execute(chunk: MutableList<String>) {
        runBlocking {
            chunk.forEach() {
                launch(Dispatchers.Default) {
                    callAPI(it)
                }
            }
        }

        Thread.sleep(1000)
    }

    fun callAPI(cbk: String) {
        logger.info("Calling API for: $cbk")

        val response = khttp.get("http://httpstat.us/200?sleep=${(1..5).shuffled().first()}000")

        if (response.statusCode == 200) {

        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(File("/Users/isaac.lopes/Workspaces/coroutines/src/main/resources/myids"))
    var chunk: MutableList<String> = ArrayList()

    while (scanner.hasNextLine()) {
        chunk.add(scanner.nextLine())
        if (chunk.size < 5 && scanner.hasNextLine()) continue

        Komonstro().execute(chunk)
        chunk.clear()
    }
}
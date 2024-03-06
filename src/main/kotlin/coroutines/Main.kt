package coroutines

import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext


//@Composable
//fun mainUi() = application {
//    Window(
//        onCloseRequest = {},
//        title = "Compose for Desktop",
//        state = rememberWindowState(width = 300.dp, height = 300.dp)
//    ) {
//        MaterialTheme {
//
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.fillMaxSize()
//                    .height(200.dp)
//                    .padding(10.dp)
//            ) {
//                Text("Hello world")
//            }
//        }
//    }
//
//}

fun main() {
    val c = CoroutineContext(name = "First")

    println()
}
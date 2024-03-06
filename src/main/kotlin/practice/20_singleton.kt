package practice

fun main() {

}

class DataBase private constructor() {
    companion object {
        @Volatile
        private var instance: DataBase? = null
        fun newInstance() = instance ?: DataBase().also { instance = it }


        fun newInstanceSync(): DataBase = instance ?: synchronized(this) {
            instance ?: DataBase().also { instance = it }
        }
    }
}
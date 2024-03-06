package practice

class Company(
    name: String?
) {

    val name: String

    init {
        if (name.isNullOrBlank())
            throw IllegalArgumentException("Name must not be null or blank.")

        this.name = name
    }

    class Builder {
        private var name: String? = null

        fun setName(name: String) = apply {
            this.name = name
        }

        fun build(): Company {
            return Company(name)
        }
    }
}

fun main() {
    val company: Company = Company.Builder()
        .setName("Bharath")
        .build()
}
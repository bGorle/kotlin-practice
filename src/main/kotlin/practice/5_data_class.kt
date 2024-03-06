package practice

class Address(val address: String)
data class Person(
    val name: String,
    val age: Int,
    val phone: String,
    val address: Address? = null
)

fun main() {
    val p1 = Person("Bharath", 32, "123456",  Address("Hello"))
    val p2 = p1.copy()
    println(p1.name.hashCode() * 31 + p1.age.hashCode() * 31 + p1.phone.hashCode() * 31 + p1.address.hashCode() * 31)
    println(p1 == p2)
    println(p1.hashCode())
    println(p2.hashCode())
    println(p1)
}

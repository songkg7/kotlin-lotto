package view

class StubInput(private val input: String) : Input {
    override fun read() = input
}
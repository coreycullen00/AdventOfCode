package advent2024

class Utils {
    companion object{
        const val INPUT = "advent2024/input"
        internal fun getInput(name: String) = "$INPUT/$name"
        internal fun getTestInput(name: String) = "$INPUT/test/$name"
    }
}

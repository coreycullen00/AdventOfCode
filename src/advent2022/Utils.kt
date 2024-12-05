package advent2022

class Utils {
    companion object{
        private const val INPUT = "advent2022/input"
        internal fun getInput(name: String) = "$INPUT/$name"
        internal fun getTestInput(name: String) = "${INPUT}/test/$name"
    }
}

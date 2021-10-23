import java.util.Arrays

fun main(args: Array<String>){

    val sortin = QuickSort();

    val ascendOrder = arrayOf(14, 3, 7, 20, 1, 9)
    val descendOrder = arrayOf(4.5, 3.0, 9.0, 8.4, 7.2, 6.1, 20.5, 5.1)
    val ascendName = arrayOf("John 42", "Carey 45", "Ben 49", "Zadi 41", "Kay 39", "Tay 42")
    val descendScore = arrayOf("John 42", "Carey 45", "Ben 49", "Zadi 41", "Kay 39", "Tay 42")

    //sorting ascendOrder
    printArray(ascendOrder)
    sortin.quickSort(ascendOrder, 0, ascendOrder.size-1, object: Split{
        override fun <T> split(a: Array<T>) {
            printArray(a)
        }
    })

    println()

    printArray(descendOrder)
    sortin.quickSort(descendOrder, 0, descendOrder.size-1, object:Split{
        override fun <T> split(a: Array<T>) {
            for(i in 0..(a.size-1)/2){
                var temp = a[i]
                a[i] = a[a.size-1-i]
                a[a.size-1-i] = temp
            }
            printArray(a)
        }
    })

    println()

    printArray(ascendName)
    sortin.quickSort(ascendName, 0, ascendName.size-1, object : Split{
        override fun <T> split(a: Array<T>) {
            printArray(a)
        }
    })

    println()

    printArray(descendScore)
    sortin.quickSort(descendScore, 0, descendScore.size-1, object: Split{
        override fun <T> split(a: Array<T>) {
            for(i in 0..a.size-1){
                for(j in i..a.size-1){
                    if(getNum(a[i].toString()) < getNum(a[j].toString())){
                        var temp = a[i]
                        a[i] = a[j]
                        a[j] = temp
                    }
                }
            }
            printArray(a)
        }
    })
}

fun <T> printArray(a:Array<T>) {
    for(i in 0.. a.size-1){
        print(""+ a[i] + ", ")
    }
    println()
}

fun getNum(s: String): Int{
    var n: String = s.substring(s.length-2, s.length)
    val num: Int = Integer.parseInt(n)
    return num
}

class QuickSort{
    fun <T> quickSort(a: Array<T>, low: Int, high: Int, action: Split){
        a.sort();
        action.split(a)
    }
}

interface Split{
    fun <T> split(a: Array<T>)
}
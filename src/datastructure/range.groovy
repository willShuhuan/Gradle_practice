package datastructure


/**
 * @author DSH
 * @date 2020/3/23
 * @description 范围学习
 */
def range = 1..10
println range[0]
println range.contains(10)
println range.from//起始值
println range.to//终止值

/**
 * 遍历
 */
range.each { println it}
for (i in range){
    println i
}

def getGrade(Number number){
    def result
    switch (number){
        case 0..<60:
            result = "${number}分，不及格"
            break
        case 60..70:
            result = "${number}分，及格"
            break
        case 70..80:
            result = "${number}分，良好"
            break
        case 80..100 :
            result = "${number}分，优秀"
            break
    }
}
println getGrade(75)

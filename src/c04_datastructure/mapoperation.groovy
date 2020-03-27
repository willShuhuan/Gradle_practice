package c04_datastructure

/**
 * @author DSH
 * @date 2020/3/23
 * @description map操作详解
 */
def students = [
        1:[number:'01',name:'Bob',score:55,sex:'male'],
        2:[number:'02',name:'Johnny',score:62,sex:'female'],
        3:[number:'03',name:'Claire',score:73,sex:'female'],
        4:[number:'03',name:'Amy',score:66,sex:'male']
]
/**
 * 遍历
 */
students.each {def student ->
    println "the key is ${student.key},"+
            "the value is ${student.value}"
}
//带索引的遍历
students.eachWithIndex{  def student, int index ->
    println "index is ${index} "+
            "the key is ${student.key},"+
            "the value is ${student.value}"
}
//直接遍历key，value值
students.each {key,value ->
    println "the key is ${key},"+
            "the value is ${value}"
}
println '-------------'

/**
 * 查找
 */
//找到第一个及格的仔
def entry = students.find {def student ->
    return student.value.score >= 60}
println entry
//找到所有及格的仔
def entrys = students.findAll {def student ->
    return student.value.score >= 60}
println entrys
//统计 输出及格的男生个数
def count = students.count {def student ->
    return student.value.score >= 60 && student.value.sex =='male'
}
println count//1
//过滤 输出所有及格的人的名字
def names = students.findAll { def student ->
    student.value.score >= 60
}.collect {//过滤出名字
    return it.value.name
}
println names.toListString()//[Johnny, Claire, Amy]

//分组，将不及格和及格的人进行分组
def group = students.groupBy {
    def student ->
        return student.value.score >= 60 ? '及格':'不及格'
}
//[不及格:[1:[number:01, name:Bob, score:55, sex:male]],
// 及格:[2:[number:02, name:Johnny, score:62, sex:female], 3:[number:03, name:Claire, score:73, sex:female], 4:[number:03, name:Amy, score:66, sex:male]]]
println group.toMapString()
println '-------------------'
/**
 * 排序
 */
//将学生由分数从低到高排序
def sort = students.sort{
    def student1,def student2 ->
        Number score1 = student1.value.score
        Number score2 = student2.value.score
        return score1==score2?0:score1<score2?-1:1
}
println sort.toMapString()


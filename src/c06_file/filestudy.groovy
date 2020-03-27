package c06_file

/**
 * @author DSH
 * @date 2020/3/24
 * @description 文件处理
*/
def file = new File('../../Gradle_practice.iml')
//遍历文件内容
file.eachLine {line ->
    println line
}
//groovy getText获取文件内容
def txt = file.getText()
println txt
//返回的是一个list
def result = file.readLines()
println result
//reader 读取文件部分内容
def reader = file.withReader {reader->
    char[] buffer = new char[100]
    reader.read(buffer)
    return buffer
}
println reader

//reader和writer拷贝文件
def copyResult = copy('../../Gradle_practice.iml','../../Gradle_practice_copy.iml')
println copyResult
def copy(String sourcePath ,String desPath){
    try {
        //首先创建目标文件
        def desFile = new File(desPath)
        if (!desFile.exists()){
            desFile.createNewFile()
        }
        //todo 判断源文件是否存在
        //开始copy
        new File(sourcePath).withReader {reader ->
            def lines = reader.readLines()
            desFile.withWriter {writer ->
                lines.each {line->
                    writer.append(line+'\r\n')
                }
            }
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}
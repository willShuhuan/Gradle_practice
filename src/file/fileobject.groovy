package file


/**
 * @author DSH
 * @date 2020/3/24
 * @description 对象文件读写
 */

def saveObject (Object object,String path){
    try {
        //首先创建目标文件
        def desFile = new File(path)
        if (!desFile.exists()){
            desFile.createNewFile()
        }
        desFile.withObjectOutputStream {out ->
            out.writeObject(object)
        }
        return true
    } catch (Exception e) {
        e.printStackTrace()
    }
    return false
}

def readObject(String path){
    def obj = null
    try {
        def file = new File(path)
        if (file == null||!file.exists())return null
        //从文件中读取对象
        file.withObjectInputStream {input ->
            obj = input.readObject()
        }
    } catch (Exception e) {
        e.printStackTrace()
    }
    return obj
}
//写对象
def person = new Person(name:'Android',age:26)
saveObject(person,'../../person.bin')
//读对象
def result = (Person)readObject('../../person.bin')
println "the name is ${result.name} and the age is ${result.age}"//the name is Android and the age is 26

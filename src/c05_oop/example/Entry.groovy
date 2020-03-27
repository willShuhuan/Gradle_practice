package c05_oop.example

/**
 * @author DSH
 * @date 2020/3/23
 * @description 模拟程序入口
 */
class Entry {
    static void main(String[] args) {
        println '一个应用程序正在启动...'
        //初始化
        AppliactionManager.init()
        println '应用程序初始化完成'
        def person = PersonManager.createPerson( 'groovy',6)
        println "new person name is ${person.name},age is ${person.age}"
        //输出 new person name is groovy,age is 6
    }
}

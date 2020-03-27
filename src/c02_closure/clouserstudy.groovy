package c02_closure

/**
 * @author DSH
 * @date 2020/3/21
 * @description 闭包学习
 */
//闭包参数
def clouser = { String name ,int age->
    println "Hello ${name},age is ${age}"
}
//clouser.call()//hello null
clouser("groovy",29)//Hello groovy,age is 29

//每一个闭包都有一个默认参数it
def clouser2 = {
    println "2 Hello ${it}"
}
clouser2('Groovy')//2 Hello Groovy

//方法返回值
def clouser3 = { String name ->
    return  "3 Hello ${name}"
}
println clouser3('groovy')//3 Hello groovy

//也是有返回值的 返回null
def clouser4 = { String name ->
    println  "4 Hello ${name}"
}
println clouser4('groovy')//null
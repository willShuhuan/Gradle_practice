package c01_variable

/**
 * @author DSH
 * @date 2020/3/21
 * @description 字符串学习
 */

//一个单引号，无格式字符串，需要字符串拼接，转义字符等指定格式
def name = 'a single string'
println name.class //class java.lang.String

//三个单引号
def thupleName = '''three single string'''
println thupleName.class //class java.lang.String

//三个单引号，直接指定格式，无需 + "" 拼接
def thupleName2 = '''line one
line two
line three
'''
println thupleName2

//双引号定义字符串   可扩展字符串
def doubleName = "this is a common String"
println(doubleName.class)//class java.lang.String
def name2 = "Android"
//如果是可扩展字符串，类型变为GString
def sayHello = "Hello：${name2}"
println( sayHello )//Hello：Android
println( sayHello.class ) // class org.codehaus.groovy.runtime.GStringImpl

def sum = "THE sum of 2 and 3 equals ${2+3}"//可扩展做任意的表达式
println(sum) //THE sum of 2 and 3 equals 5

//传入了GString   接收参数为String，无需像java一样转型
def result = echo(sum)
println(result)//class java.lang.String
println(result.class)//class java.lang.String
String echo(String messagse){
    return messagse
}

//---------------------字符串方法--------------------------
def str = "groovy"
//填充
//center（） 对字符串的填充
println(str.center(8,'a'))//agroovya 两边填充a
println str.padLeft(8,'a')//aagroovy  左边填充a
println str.padRight(8,'a')//groovyaa  右边填充a
//比较
def str2 = "Hello"
println str > str2//unicode 编码比较 true
//索引
println str[0]//g
println str[0..1]//gr
//减法
def str3 = "Hello groovy"
println str3.minus(str2)//groovy
//等同于'-'操作符
println str3 - str2
//逆向操作
println  str.reverse()
//首字母大写
println str.capitalize()
//判断是否是数字类型的字符串
println str.isNumber()
//转化类型
def strBoolean = '1'
println strBoolean.toBoolean()//true
def strLong = '1'
println strLong.isLong()
strLong.toLong()
def strDouble = '1'
println strDouble.isDouble()
strDouble.toDouble()


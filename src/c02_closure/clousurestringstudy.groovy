package c02_closure

/**
 * @author DSH
 * @date 2020/3/23
 * @description 字符串与闭包结合使用
 */

String str = 'the 2 and  3 is 5'
//1 each 遍历
str.each {
    //每个字符串增加一倍
    String temp -> print temp.multiply(2)//tthhee  22  aanndd  tthhee  33  iiss  55
}
println ''
//2 find 查找符合条件的第一个
def findstr = str.find{
    String s -> s.isNumber()
}
println findstr//2
//3 findAll 查找符合条件的集合
def list = str.findAll{
    String s -> s.isNumber()
}
println list.toListString()//[2, 3, 5]
//4 判断字符串中是否包含数字
def result = str.any{
    String s -> s.isNumber()
}
println result//true
//5 判断是否string中每一位都是数字
println str.every {String s -> s.isNumber()}//false
//6 输出字符串转大写的字符串集合
def upList = str.collect{
    it.toUpperCase()
}
println upList//[T, H, E,  , 2,  , A, N, D,  , T, H, E,  , 3,  , I, S,  , 5]
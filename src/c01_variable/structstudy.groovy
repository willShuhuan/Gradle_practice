package c01_variable

/**
 * @author DSH
 * @date 2020/3/21
 * @description 逻辑控制
 */

//groovy 中的switch case 可以是任何类型
def x = 1.23
def result
//switch (x){
switch (x.class){
    case 'foo':
        result = 'found foo'
        break
    case 'bar':
        result = 'bar'
        break
    case [4,5,6,'inlist']://列表
        result = 'list'
        break
    case 12..30://范围
        result = 'range'
        break
    case Integer:
        result = 'integer'
        break
    case BigDecimal:
        result = 'big decimal'
        break
    default:result = 'default'
}
println result//big decimal

//对范围的for循环
def sum = 0
for (i in 0..9){
    sum += i;
}
println sum

//对list 的循环
for (i in [1,2,3,4,5,6,7,8,9]){
    sum += i
}
//对map的循环
for (i in ['lili':1,'luck':2,'xiaoming':2]){
    sum += i.value
}

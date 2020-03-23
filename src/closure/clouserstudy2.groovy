package closure

/**
 * @author DSH
 * @date 2020/3/23
 * @description 闭包的使用
 */
int x = fab(5);
println x
//求指定number的阶乘
int fab(int number){
    int result = 1
    1.upto(number,{num -> result *= num})
    return result
}

int fab2(int number){
    int result = 1
//    number.downto(1,{num -> result *= num})
    //闭包放在括号内和括号外的效果是一致的
    number.downto(1){
         num -> result *= num
    }
    result result;
}

int y = cal(101)
println y
//求和 1到100
int cal(int number){
    int result = 0;
    number.times{
        num ->result += num
    }
    return result
}
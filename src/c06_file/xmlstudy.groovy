package c06_file

/**
 * @author DSH
 * @date 2020/3/24
 * @description xml操作
*/
final String xml = '''
                    <breakfast_menu>
                        <food>
                            <name id ="100">Belgian Waffles</name>
                            <price>$5.95</price>
                            <calories>900</calories>
                        </food>
                        <food>
                            <name id ="101">Strawberry Belgian Waffles</name>
                            <price>$7.95</price>
                            <calories>900</calories>
                        </food>
                    </breakfast_menu>
                    '''
//开始解析此xml数据
def xmlSluper = new XmlSlurper()
def menu = xmlSluper.parseText(xml)
//通过.text()调用节点值
println menu.food[0].name.text()//Belgian Waffles
//通过@调用节点属性值
println menu.food[0].name.@id//100

def list = []
menu.each{ foods ->
    //下面开始对食物进行遍历
    foods.food.each { food->
        list.add(food.name.text())
    }
}
println list //[Belgian Waffles, Strawberry Belgian Waffles]

//深度遍历
def foods = menu.depthFirst().findAll{food ->
    return food.calories.text()=='900'
}
println foods//[Belgian Waffles$5.95900, Strawberry Belgian Waffles$7.95900]
//广度遍历
def names = menu.children().findAll {node ->
    node.name()== 'food'&& node.name.@id.text().contains ('10')
}.collect{node ->
    return node.name.text()
}
println names//[Belgian Waffles, Strawberry Belgian Waffles]

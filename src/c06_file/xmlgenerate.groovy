package c06_file

import groovy.xml.MarkupBuilder

/**
 * @author DSH
 * @date 2020/3/24
 * @description 生成xml
 */

/**
 * 手写生成xml
 */
def sw = new StringWriter()
def xmlBuilder = new MarkupBuilder(sw) //用来生成xml数据的核心类
//根节点langs创建成功
xmlBuilder.langs(type:'current',count:'3',mainstream:'true') {
    //第一个language节点
    language(flavor:'static',version:'1.8','Java'){
        age('16')
    }
    language(flavor:'dynamic',version:'1.6','Groovy')
    language(flavor:'dynamic',version:'1.9','JavaScript')
}
println sw
println '-----------------'
/**
 * 实体转xml
 */
def langs = new Langs()
xmlBuilder.langs(type:langs.type,count:langs.count,mainstream: langs.mainstream){
    langs.languages.each {lang ->
        language(flavor:lang.flavor,version:lang.version,value:lang.value)
    }
}
println sw
//对应xml中langs节点
class Langs{
    String type = 'current'
    int count = 3
    boolean mainstream = true
    def languages = [new Language(flavor:'static',version:'1.8',value:'Java'),
                     new Language(flavor:'dynamic',version:'1.6',value:'Groovy'),
                     new Language(flavor:'dynamic',version:'1.9',value:'JavaScript')]
}
//对应xml中language节点
class Language{
    String flavor
    String version
    String value
}




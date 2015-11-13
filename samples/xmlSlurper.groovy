import groovy.util.XmlParser
def text = '''
    <list>
        <technology>
            <name>Groovy</name>
        </technology>
        <test>ttt</test>
        <options>
            <item weight="1">c2cpayment</item>
            <item weight="1">newitem</item>
            <item weight="1">has_listprice</item>
            <item weight="1">storeitem</item>
            <item weight="1">reserveprice</item>
            <item weight="1">fixprice</item>
        </options>
    </list>
'''

def list = new XmlSlurper().parseText(text)

list.'*'.find { node ->
  println(node.name())
}

list.options.item.any{ it == "123" }

list.options.item.each {
  println ">${it}"
}

println "= ${list.options.item[0]}"

println "============="

def n = '''
    <list>
    </list>
'''

def node = new XmlSlurper().parseText(n)
assert node == ""
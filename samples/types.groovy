def a = "123"

def c = a as String
println "${c.getClass().getName()}, value: ${c}"
println "index=0, ${a.charAt(0)}"
println "index=1, ${a.charAt(1)}"

println "====================="

def b = a as Integer
println "${b.getClass().getName()}, value: ${b}"

println "====================="

char ch = 'c'
println "${ch.getClass().getName()}, value: ${ch}"

def m = [
                int  : 1,
                float: 1.1,
                boolean: true,
                string: "1",
                "array of string": ["string1", "string2"]
        ]
println "${m.getClass().getName()}, value: ${m}"
println "${m.int.getClass().getName()}, value: ${m.int}"
println "${m.string.getClass().getName()}, value: ${m.string}"
println "${m.boolean.getClass().getName()}, value: ${m.boolean}"
println "${m.float.getClass().getName()}, value: ${m.float}"

m.remove('int')
println "${m.getClass().getName()}, value: ${m}"

def mm = m.collect { k,v->
v
}

println "${mm.getClass().getName()}, value: ${mm}"
println "${m.values().getClass().getName()}, value: ${m.values()}"

def ll = m.values() as List
println "${ll.getClass().getName()}, value: ${ll}"
package support

import groovy.transform.*

@Canonical
class Node {
    def attr
    def value
}

@Canonical
class Document {
    Node description = new Node(value: "質地:棉質 100% 實物拍攝 !! 100% 放心購買 ! !")
    Node ip = new Node(value: "760174879")
}

@Canonical
class VespaFeeder {
    def documents = [new Document()]

    void addDocument(Document doc) {
        documents << doc
    }
}

@Canonical
class FeederDocumentBuilder {
    def vespaFeeder = new VespaFeeder()

    def pogoToXml(object) {
        def writer = new StringWriter()
        def root = new groovy.xml.MarkupBuilder(writer)
        root."${object.getClass().simpleName.toLowerCase()}" {
            for (i in 0..object.documents.size() - 1) {
                "${object.documents[i].getClass().simpleName.toLowerCase()}" {
                    object.documents[i].getClass().declaredFields.grep { !it.synthetic }.name.each { def name ->
                        "${name}"(object.documents[i]."${name}".value)
                    }
                }
            }
        }
        writer.toString()
    }

    def build() {
        return pogoToXml(vespaFeeder)
    }

    def addDocument(Document doc) {
        vespaFeeder.addDocument(doc)
        this
    }
}

def fdb = new FeederDocumentBuilder()
        .addDocument(new Document(description: new Node(value: 'test')))
        .build()
println "fdb: \n${fdb}"


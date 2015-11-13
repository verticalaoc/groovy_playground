@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')
import groovyx.net.http.RESTClient
import groovyx.net.http.HttpResponseException
import static groovyx.net.http.ContentType.*

def db = "tonydt_test"
def table = "rnr_test"
def record = "r3"

setRecord(
        db,
        table,
        record,
        [
                fields: [
                        [
                                name : "ff3",
                                value: 1
                        ]
                ]
        ])

setRecord(
        db,
        table,
        record,
        [
                fields: [
                        [
                                name     : "ff3",
                                increment: 3
                        ]
                ]
        ])

setRecord(
        db,
        table,
        record,
        [
                fields: [
                        [
                                name     : "ff3",
                                increment: -1
                        ]
                ]
        ])

println getRecord(db, table, record)

//println orderedScan(db, table, record)
//deleteRecord(db, table, record)
//println getRecord(db, table, record)


private def getRecord(db, table, record) {
    host = "http://gamma-bcp1792.dht.yahoo.com:4080/"
    this.getRecord(host, db, table, record)
}

private def getRecord(host, db, table, record) {
    def client = new RESTClient(host)
    client.contentType = JSON
    try {
        r = client.get(path: "/v2/databases/${db}/tables/${table}/records/${record}")
        return r.data
    } catch (HttpResponseException e) {
        error_log(e)
    }
}

private void error_log(HttpResponseException e) {
    r = e.response
    println("Success: $r.success")
    println("Status:  $r.status")
    println("Reason:  $r.statusLine.reasonPhrase")
}

private void setRecord(db, table, record, data) {
    host = "http://gamma-bcp1792.dht.yahoo.com:4080/"
    this.setRecord(host, db, table, record, data);
}

private void setRecord(host, db, table, record, data) {
    try {
        def client = new RESTClient(host)
        client.post(
                path: "/v2/databases/${db}/tables/${table}/records/${record}",
                requestContentType: JSON,
                body: data
        )
    } catch (HttpResponseException e) {
        error_log(e)
    }
}

private void replaceRecord(db, table, record, data) {
    host = "http://gamma-bcp1792.dht.yahoo.com:4080/"
    this.replaceRecord(host, db, table, record, data);
}

private void replaceRecord(host, db, table, record, data) {
    try {
        def client = new RESTClient(host)
        client.put(
                path: "/v2/databases/${db}/tables/${table}/records/${record}",
                requestContentType: JSON,
                body: data
        )
    } catch (HttpResponseException e) {
        error_log(e)
    }
}

private void deleteRecord(db, table, record) {
    host = "http://gamma-bcp1792.dht.yahoo.com:4080/"
    this.deleteRecord(host, db, table, record);
}

private void deleteRecord(host, db, table, record) {
    try {
        def client = new RESTClient(host)
        client.delete(
                path: "/v2/databases/${db}/tables/${table}/records/${record}",
        )
    } catch (HttpResponseException e) {
        error_log(e)
    }
}


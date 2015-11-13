@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')
import groovyx.net.http.RESTClient

def base = 'https://issues.apache.org/jira/rest/api/latest/'
def jira = new RESTClient(base)
jira.get(path: 'issue/GROOVY-5999') { resp, json ->
  assert resp.status == 200
  json.fields.with {
    assert summary == "Make @Delegate work with @DelegatesTo"
    assert fixVersions.name == ['2.1.1']
    assert resolutiondate.startsWith('2013-02-14')
  }
}
r = jira.get(path: 'issue/GROOVY-5999')
println r.data.getClass().getName()
//println r.data.toString()


import static groovyx.net.http.ContentType.*
def client = new RESTClient("http://restmirror.appspot.com/")
client.contentType = JSON
resp = client.post(
                path: '/',
                body: [
                        id       : 'de305d54-75b4-431b-adb2-eb6b9e546014',
                        createdTs: '2015-08-02T21:50:49Z'
                ]
        )
        
println resp.getClass().getName()
println resp.status
println resp.data
println resp.data.id



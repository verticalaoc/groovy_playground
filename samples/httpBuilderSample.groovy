@Grapes(
    @Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.6')
)

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.*
def httpBuilder = new HTTPBuilder('http://restmirror.appspot.com/')
//httpBuilder.contentType = JSON
postBody = '{"abc","123"}'
(resp,reader) = httpBuilder.post(
  path: '/123', 
  body: postBody,
  requestContentType: JSON) { resp, reader ->
     [resp, reader]
  }
println resp.getClass().getName()
println resp.status

println reader.getClass().getName()
println reader.toString()

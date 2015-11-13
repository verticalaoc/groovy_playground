String fileContents = new File('/Users/tonydt/git/verticalaoc/groovy_playground/restClient/keyword').getText('UTF-8')
(fileContents.split() as Set).each{
    f = new File('token.txt')
    f.append("${it}\n")
    
    f2 = new File('token2.txt')
    f3 = new File('token3.txt')
    f4 = new File('token4.txt')
    f5 = new File('token5.txt')
    
    f2.append(it[0])
    f2.append("\n")
    
}


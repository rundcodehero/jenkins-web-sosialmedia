/* groovylint-disable FactoryMethodName, LineLength */
def testEnv() {
    sh 'docker --version'
    sh 'php --version'
}

/* groovylint-disable-next-line MethodReturnTypeRequired, NoDef */
def buildImage() {
    echo 'building sosmed image..'
    withCredentials [usernamePassword(credentialsID: 'hub-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]
        sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
}
buildImage
def pushImage() {
    /* groovylint-disable-next-line DuplicateMapLiteral, DuplicateStringLiteral */
    withCredentials [usernamePassword(credentialsID: 'hub-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]
      sh "echo $PASS | docker login -u $USER --password-stdin"
      sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

return this

/* groovylint-disable FactoryMethodName, LineLength */
import jenkins.model.*
jenkins = Jenkins.instance

def testEnv() {
    sh 'docker --version'
    sh 'php --version'
}


def buildImage() {
    echo 'building sosmed image..'
    withCredentials [usernamePassword(credentialsID: 'hub-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]
        sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
}

def pushImage() {
    /* groovylint-disable-next-line DuplicateMapLiteral, DuplicateStringLiteral */
      sh "echo $PASS | docker login -u $USER --password-stdin"
      sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

return this

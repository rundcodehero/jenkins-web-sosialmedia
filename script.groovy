def testEnv() {
    sh 'docker --version'
    sh 'php --version'
}

def buildImage() {
    /* groovylint-disable-next-line LineLength */
    withCredentials {[usernamePassword (credentialsID: 'hub-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]}
        sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

def pushImage() {
      sh "echo $PASS | docker login -u $USER --password-stdin"
      sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

return this
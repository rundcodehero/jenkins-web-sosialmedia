def testEnv() {
    sh 'docker --version'
}

def buildImage() {
    sh "echo 'lets build Docker Image'"
    sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
}

def pushImage() {
    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
    sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

return this

def testEnv() {
    sh 'docker --version'
    sh 'php --version'
}

def buildImage() {
        sh 'sudo usermod -aG docker $USER'
        sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
        sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
        sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

def pushImage() {
      sh "echo $PASS | docker login -u $USER --password-stdin"
      sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

return this
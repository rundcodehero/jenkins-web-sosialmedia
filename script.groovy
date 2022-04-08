def testEnv() {
    sh 'docker --version'
    sh 'php --version'
}

def pushImage() {
      sh "echo $PASS | docker login -u $USER --password-stdin"
      sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

return this

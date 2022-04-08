def testEnv() {
    docker --version
    php --version
}

def buildImage() {
    echo "building sosmed image.."
      sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
     
}

def pushImage () {
    withCredentials [usernamePassword(credentialsID: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]
      sh "echo $PASS | docker login -u $USER --password-stdin"
      sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}
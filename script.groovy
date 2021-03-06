def testEnv() {
    sh 'docker --version'
 }

def buildImage() {
    sh "echo 'lets BUILD Docker Image'"
    sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
    sh 'docker stop sosmed && docker rm sosmed'
    sh 'docker rmi $(docker images --filter "dangling=true" -q)'
}

def pushImage() {
    /* groovylint-disable-next-line LineLength */
    sh "echo 'lets PUSH Docker Image'"
    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
    sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

def runImage () {
    sh "echo 'lets TEST RUN Image'"
    sh 'docker run -dit -p 8000:80 --name sosmed rundcode/jenkins-sosialmedia:v1.0'
}

return this
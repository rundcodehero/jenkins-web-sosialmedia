def testEnv() {
    sh 'docker --version'
}

def buildImage() {
    sh "echo 'lets build Docker Image'"
    sh "docker tag rundcode/jenkins-sosialmedia:v1.0 
    sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
}

def pushImage() {
    sh 'echo $dockerLogin_PSW | docker login -u $dockerLogin_USR --password-stdin'
    sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

def runImage () {
    sh 'docker rm -f sosmed'
    sh "docker run -dit -p 8000:80 --name sosmed rundcode/jenkins-sosialmedia:v1.0"

return this

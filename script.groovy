def testEnv() {
    sh 'docker --version'
    sh 'kubectl version'
}

def buildImage() {
    sh "echo 'lets build Docker Image'"
    sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
    sh 'docker rmi $(docker images --filter "dangling=true" -q)'
}

def pushImage() {
    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
    sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

def pushImage2() {
    /* groovylint-disable-next-line LineLength */
    withCredentials([usernamePassword(credentialsId: 'hub-docker-repo', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          sh "echo ${env.dockerHubPassword} | docker login -u ${env.dockerHubUser} --password-stdin"
          sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
}

def runImage() {
    sh 'docker stop sosmed'
    sh 'docker rm sosmed'
    sh 'docker run -dit -p 8000:80 --name sosmed rundcode/jenkins-sosialmedia:v1.0'
}

return this

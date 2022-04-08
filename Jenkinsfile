pipeline{
    agent{
        label "node"
    }
    stages{
        stage("Test environment"){
            steps{
               docker --version
               php --version
            }   
        }
    }
    stages{
        stage("build Docker"){
            steps{
                script {
                  withCredentials [usernamePassword(credentialsID: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]
                    sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push rundcode/jenkins-sosialmedia:v1.0'
                }
               
            }   
        }
    }
     stages{
        stage("push to hub.docker"){
            steps{
               echo " push to repository rundcode/sosmed-jenkins:latest"
            }   
        }
    }
}

def gv
pipeline{
    agent any
    stages{
        stage("init"){
            steps{
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("test-Environment"){
            steps{
                echo"hallo"
            }   
        }
        stage("build-Image"){
            steps{
                script { 
                    withCredentials {[usernamePassword (credentialsID: 'hub-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]}
                        sh 'docker build -t rundcode/jenkins-sosialmedia:v1.0 .'
                } 
            }   
        }
        stage("push-Image"){
            steps{
                script {
                    gv.pushImage ()
                }
            }   
        }
    }
}